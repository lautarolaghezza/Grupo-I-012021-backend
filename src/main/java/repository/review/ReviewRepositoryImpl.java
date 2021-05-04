package repository.review;

import exceptions.ReviewHasBeenAddedException;
import lombok.SneakyThrows;
import mapper.ReviewRowMapper;
import model.reviews.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReviewRepositoryImpl implements  ReviewRepository{

    List<Review> reviews;

    NamedParameterJdbcTemplate template;

    public ReviewRepositoryImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }


    public ReviewRepositoryImpl() {
        this.reviews = new ArrayList<>();
    }

    @Override
    public List<Review> getReviews() {
        return template.query("select * from reviews", new ReviewRowMapper());

    }

    @Override
    public List<Review> getReviews(String tittle_tconst) {
        return reviews.stream()
                .filter( r -> r.getTittle_tconst().equalsIgnoreCase(tittle_tconst))
                .collect(Collectors
                .toList());
    }

    @SneakyThrows
    @Override
    public void addReview(Review review) {
        List<Review> reviews = this.getReviews();
        boolean isAdded = this.reviews.stream().anyMatch(r -> r.getTittle_tconst().equalsIgnoreCase(review.getTittle_tconst()) &&
                                                                r.getUserId().equals(review.getUserId()));
        if (isAdded) throw new ReviewHasBeenAddedException();

        final String sql = "INSERT INTO reviews(title_tconst, rating, language," +
                "resume, date, extended_text, user_id) values" +
                "(:title_tconst,:rating,:language,:resume,:date,:extended_text,:user_id)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("title_tconst", review.getTittle_tconst())
                .addValue("rating", review.getRating())
                .addValue("language", review.getLanguage())
                .addValue("resume", review.getResume())
                .addValue("date", review.getDate())
                .addValue("extended_text", review.getExtendedText())
                .addValue("user_id", review.getUserId());
        template.update(sql,param,holder);
    }
}

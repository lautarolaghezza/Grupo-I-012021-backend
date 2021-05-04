package mapper;

import model.reviews.Review;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review> {

    @Override
    public Review mapRow(ResultSet rs, int arg1) throws SQLException {
        Review review = new Review();
        review.setReview_id(rs.getLong("review_id"));
        review.setTittle_tconst(rs.getString("title_tconst"));
        review.setRating(rs.getFloat("rating"));
        review.setResume(rs.getString("resume"));
        review.setLanguage(rs.getString("language"));
        review.setDate(rs.getDate("date").toLocalDate());
        review.setExtendedText(rs.getString("extended_text"));
        review.setUserId(rs.getLong("user_id"));
        return review;
    }

}

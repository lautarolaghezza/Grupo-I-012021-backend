package model.filter;

import lombok.Getter;
import model.reviews.Review;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public final class LanguageFilter extends Filter{

    private final String language;

    public LanguageFilter(String language) {
        this.language = language;
    }

    @Override
    public List<Review> doFilter(List<Review> reviews) {
        return reviews
                .stream()
                .filter( r -> r.getLanguage().equalsIgnoreCase(this.language))
                .collect(Collectors.toList());
    }
}

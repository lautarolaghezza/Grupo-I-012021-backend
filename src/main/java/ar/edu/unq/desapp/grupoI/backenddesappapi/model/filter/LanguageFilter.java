package ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;


import java.util.List;
import java.util.stream.Collectors;

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

    public String getLanguage() {
        return language;
    }
}

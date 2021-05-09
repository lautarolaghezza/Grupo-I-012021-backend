package ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;


import java.util.List;
import java.util.stream.Collectors;

public final class LanguageFilter extends Filter{

    private final String language;

    public LanguageFilter(String language) {
        this.language = language.toLowerCase();
    }

    @Override
    public List<Review> doFilter(List<Review> reviews, List<UserAbs> userAbsList) {
        return reviews
                .stream()
                .filter( r -> r.getLanguage().equalsIgnoreCase(this.language))
                .collect(Collectors.toList());
    }

    public String getLanguage() {
        return language;
    }
}

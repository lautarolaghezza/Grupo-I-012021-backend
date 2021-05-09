package ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;


import java.util.List;

public abstract class Filter {


    public Filter() {
    }

    public abstract List<Review> doFilter(List<Review> reviews, List<UserAbs> userAbsList);


}

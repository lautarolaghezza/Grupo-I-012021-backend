package ar.edu.unq.desapp.grupoi.backenddesappapi.model.filter;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.reviews.Review;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import lombok.Getter;


import java.util.List;
@Getter
public abstract class Filter {
    protected String type;
    protected  String value;

    public Filter(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public Filter() {
    }

    public abstract List<Review> doFilter(List<Review> reviews, List<UserAbs> userAbsList);


}

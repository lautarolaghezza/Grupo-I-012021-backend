package model.filter;

import lombok.Getter;
import model.reviews.Review;

import java.util.List;

@Getter
public abstract class Filter {


    public Filter() {
    }

    public abstract List<Review> doFilter(List<Review> reviews);
}

package service.reviewService;

import exceptions.ReviewsNotFoundException;
import exceptions.filterNoExistException;
import lombok.Getter;
import model.Filter;
import model.reviews.PublicReview;
import model.reviews.Review;
import model.user.CommonUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Getter
public class ReviewServiceImpl implements ReviewService {
    private final List<Review> serviceReviews;

    public ReviewServiceImpl(List<Review> serviceReviews) {
        this.serviceReviews = serviceReviews;
    }

    @Override
    public List<Review> getReviews(int tittle_id) {
        int count = 0;
        List<Review> result = new ArrayList<>();
        while(count < serviceReviews.size()){
            Review currentReview = serviceReviews.get(count);
            if(currentReview.getTittle_id() == tittle_id){
                result.add(currentReview);
            }
            count++;
        }
        if(result.size() > 0){
            return result;
        }else{
            throw new ReviewsNotFoundException();
        }
    }

    @Override
    public List<Review> getReviewsWithFilter(List<Filter> filters) {
        List<Review> result = serviceReviews;
        for ( Filter filter :  filters) {
            result = joinFilterReviews(result, applyFilter(filter));
        }
        return result;
    }
    public List<Review> joinFilterReviews(List<Review> reviews, List<Review> filteredReviews){
        List<Review> result = new ArrayList<>();
        for (Review filteredReview : filteredReviews) {
            if(reviews.contains(filteredReview)){
                result.add(filteredReview);
            }
        }
        return result;
    }

    private List<Review> applyFilter(Filter filter) {
        switch (filter.getType()){
            case PLATFORM:
                return platformFilter(filter.getFilter_name(),serviceReviews);
            case TYPE_USER:
                return type_User_Filter(filter.getFilter_name(),serviceReviews);
            case SPOILER_ALERT:
                return spoiler_alert_Filter(filter.getFilter_name());
            case LANGUAGE:
                return language_Filter(filter.getFilter_name());
            case LOCATION:
                return location_Filter(filter.getFilter_name());
            default: throw new filterNoExistException();
        }
    }

    private List<Review> location_Filter(String location) {
        List<Review> result = new ArrayList<>();

        for (Review review : serviceReviews) {
            if(((CommonUser) (review.getUser())).getLocation().equalsIgnoreCase(location)){
                result.add(review);
            }
        }
        return result;
    }

    private List<Review> language_Filter(String language) {
        List<Review> result = new ArrayList<>();
        for ( Review review : serviceReviews) {
            if(review.getLanguage().equalsIgnoreCase(language)){
                result.add(review);
            }
        }
        return result;
    }


    private List<Review> spoiler_alert_Filter(String filterName) {
        List<Review> result = new ArrayList<>();
        for ( Review review : serviceReviews) {
            boolean is_Spoiler_Alert = ((PublicReview) review).isSpoiler_Alert();
            String is_Spoiler_Alert_String;
            if(is_Spoiler_Alert){
                is_Spoiler_Alert_String = "TRUE";
            }else{
                is_Spoiler_Alert_String = "FALSE";
            }
            if(is_Spoiler_Alert_String.equalsIgnoreCase(filterName)) result.add(review);
        }
        return result;

    }

    private List<Review> type_User_Filter(String type_user, List<Review> reviews) {
        List<Review> result = new ArrayList<>();
        for ( Review review : reviews) {
            if((review.getUser().getType_user().toString()).equalsIgnoreCase(type_user)){
                result.add(review);
            }
        }
        return result;

    }

    private List<Review> platformFilter(String platform, List<Review> reviews) {
        List<Review> result = new ArrayList<>();
        for ( Review review : reviews) {
            if(review.getUser().getPlatform().toString().equalsIgnoreCase(platform)){
                result.add(review);
            }
        }
        return result;
    }

    @Override
    public List<Review> orderByRatingAsc(List<Review> reviews) {
        reviews.sort(Comparator.comparing(Review::getRating));
        return reviews;
    }

    @Override
    public List<Review> orderByRatingDesc(List<Review> reviews) {
        reviews.sort(Comparator.comparing(Review::getRating));
        Collections.reverse(reviews);
        return reviews;
    }

    @Override
    public List<Review> orderByDateAsc(List<Review> reviews) {
        reviews.sort(Comparator.comparing(Review::getDate));
        return reviews;
    }

    @Override
    public List<Review> orderByDateDesc(List<Review> reviews) {
        reviews.sort(Comparator.comparing(Review::getDate));
        Collections.reverse(reviews);
        return reviews;
    }

    @Override
    public void addReview(CommonUser user, PublicReview review) {
        Review createdReview = user.createReview(review.getTittle_id(),
                review.getResume(),
                review.getExtendedText(),
                review.getRating(),
                review.getDate(),
                review.getLanguage(),
                review.isSpoiler_Alert());
        this.serviceReviews.add(createdReview);
    }
}

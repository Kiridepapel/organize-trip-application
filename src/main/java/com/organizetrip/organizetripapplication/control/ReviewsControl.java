package com.organizetrip.organizetripapplication.control;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.organizetrip.organizetripapplication.classes.Review;
import com.organizetrip.organizetripapplication.logic.ReviewsLogic;

public class ReviewsControl {
    private ReviewsLogic reviewsLogic;

    public ReviewsControl() {
        reviewsLogic = new ReviewsLogic();
    }

    public List<Review> getReviews() {
        return reviewsLogic.getReviews();
    }

    public void addReview(String name, int rating, String comment) {
        String imgUrl = "/assets/images/unknown.png"; // Default image
        LocalDateTime now = LocalDateTime.now();
    
        // Formatea la fecha y hora usando DateTimeFormatter
        String date = now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String time = now.format(DateTimeFormatter.ofPattern("HH:mm"));

        Review review = Review.builder()
            .imgUrl(imgUrl)
            .name(name)
            .comment(comment)
            .rating(rating)
            .date(date)
            .time(time)
            .build();
        
        reviewsLogic.addReview(review);
    }
}

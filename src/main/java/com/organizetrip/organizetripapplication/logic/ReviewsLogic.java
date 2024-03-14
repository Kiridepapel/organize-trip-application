package com.organizetrip.organizetripapplication.logic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.organizetrip.organizetripapplication.classes.Review;

public class ReviewsLogic {
    private final String filePath = "reviews.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Review> getReviews() {
        File file = new File(filePath);
        if (file.exists()) {
            try {
                return mapper.readValue(file, new TypeReference<List<Review>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    public void addReview(Review review) {
        List<Review> reviews = getReviews();
        reviews.add(review);
        writeReviewsToFile(reviews);
    }

    private void writeReviewsToFile(List<Review> reviews) {
        try {
            mapper.writeValue(new File(filePath), reviews);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

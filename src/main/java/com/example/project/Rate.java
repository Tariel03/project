package com.example.project;

public class Rate {


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getComplain() {
        return complain;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }

    public Rate(String rating, String review) {
        this.rating = rating;
        this.review = review;
    }

    private String rating;
    private String review;
    private String complain;
}

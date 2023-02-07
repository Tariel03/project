package com.example.project;

public class Tariff {

    private String name;
    private String price;
    private String internet;
    private String duration;
    private String calls;
    public Tariff(String name, String price, String internet, String duration, String calls) {
        this.name = name;
        this.price = price;
        this.internet = internet;
        this.duration = duration;
        this.calls = calls;
    }

    public Tariff() {
    }

    public Tariff(String calls) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        internet = internet;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCalls() {
        return calls;
    }

    public void setCalls(String calls) {
        this.calls = calls;
    }


}

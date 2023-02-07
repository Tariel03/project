package com.example.project;

public class complain {
    private String reason;
    private String complaint;

    public complain(String reason, String complaint) {
        this.reason = reason;
        this.complaint = complaint;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}

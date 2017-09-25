package com.technocracy.app.aavartan.Schedule.Model.Data;


public class Schedule {

    private String id;
    private String eventName;
    private String time;
    private String venue;
    private String imageUrl;

    public Schedule(String id, String eventName, String time, String venue, String imageUrl) {
        this.id = id;
        this.eventName = eventName;
        this.time = time;
        this.venue = venue;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getTime() {
        return time;
    }

    public String getVenue() {
        return venue;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
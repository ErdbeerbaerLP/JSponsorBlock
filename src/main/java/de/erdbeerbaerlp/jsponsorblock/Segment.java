package de.erdbeerbaerlp.jsponsorblock;

public class Segment {
    public String UUID;
    public String category;
    public int locked;
    public int votes;
    public String description;
    /**
     * Duration of video when submission occurred (to be used to determine when a submission is out of date). 0 when unknown. +- 1 second
     */
    public float videoDuration;
    float[] segment;
    public float getSegmentStart(){
        return segment[0];
    }
    public float getSegmentEnd(){
        return segment[1];
    }
    public Category getCategory() {
        return Category.valueOf(category.toUpperCase());
    }
}

package dtos;

import java.util.Random;

public class Call {
    public static final int MIN_TIME_DURATION = 5;
    public static final int MAX_TIME_DURATION = 10;
    private int duration;
    private String description;

    public Call(String descripcion){
        duration = new Random().nextInt(MAX_TIME_DURATION - MIN_TIME_DURATION + 1) + MIN_TIME_DURATION;
        this.description = descripcion;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

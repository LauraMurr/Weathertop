package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
    public String title;
    public double latitude;
    public double longitude;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    public Reading latestReading;


    public Station(String title, double latitude, double longitude) {
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void updateLatestReading() {
        if (readings.size() > 0) {
            this.latestReading = readings.get(readings.size() - 1);
            String windDirectionDescription = degreesToDirection(latestReading.windDirection);
            System.out.println("Wind direction: " + windDirectionDescription);
        } else {
            System.out.println("No readings found");
        }
    }
    public static String degreesToDirection(double degrees) {
        String direction;
        double degreeRange = 360 / 16;
        if (degrees >= 0 && degrees < degreeRange) {
            direction = "North";
        } else if (degrees >= degreeRange && degrees < degreeRange * 3) {
            direction = "Northeast";
        } else if (degrees >= degreeRange * 3 && degrees < degreeRange * 5) {
            direction = "East";
        } else if (degrees >= degreeRange * 5 && degrees < degreeRange * 7) {
            direction = "Southeast";
        } else if (degrees >= degreeRange * 7 && degrees < degreeRange * 9) {
            direction = "South";
        } else if (degrees >= degreeRange * 9 && degrees < degreeRange * 11) {
            direction = "Southwest";
        } else if (degrees >= degreeRange * 11 && degrees < degreeRange * 13) {
            direction = "West";
        } else if (degrees >= degreeRange * 13 && degrees < degreeRange * 15) {
            direction = "Northwest";
        } else {
            direction = "N/A";
        }
        return direction;
    }

}
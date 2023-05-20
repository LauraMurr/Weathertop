package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


import play.db.jpa.Model;

@Entity
public class Reading extends Model {
    public int code;
    public float temp;
    public float wind;
    public int pressure;

    public double windDirection;
    public String windDirectionDescription;

    @ManyToOne
    public Station station;

    public Reading(int code, float temp, float wind, double windDirection, int pressure )
    {
        this.code = code;
        this.temp = temp;
        this.wind = wind;
        this.windDirection = windDirection;
        this.pressure = pressure;
        this.windDirectionDescription = windDirectionDescription;

    }


    public double getWindChill() {
        double windChill = 13.12 + 0.6215 - 11.37 * Math.pow(wind, 0.16) + 0.3965 * temp * Math.pow(wind, 0.16);
        return windChill;
    }


}
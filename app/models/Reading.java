package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model
{
    public int code;
    public float temp;
    public float wind;
    public int pressure;

    public Reading(int code, float temp, float wind, int pressure)
    {
        this.code = code;
        this.temp = temp;
        this.wind = wind;
        this.pressure = pressure;
    }
}
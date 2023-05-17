package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Station extends Model
{
    public String title;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    public Reading latestReading;


    public Station(String title)
    {

        this.title = title;
    }

    public void updateLatestReading() {
        if(readings.size() > 0) {
           this.latestReading = readings.get(readings.size() - 1);
        }
    }
}

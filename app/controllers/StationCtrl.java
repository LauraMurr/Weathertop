package controllers;
import java.util.List;
import java.util.ArrayList;
import models.Station;
import models.Reading;
import play.mvc.Controller;


public class StationCtrl extends Controller
{

    public static void index(Long id)
    {
        Station station = Station.findById(id);
        List<Station> stations = new ArrayList<>();
        stations.add(station);
        station.updateLatestReading();
        render("station.html", stations);
    }

    public static void addReading(Long id,int code, float temp, float wind, double windDirection, int pressure) {

        Station station = Station.findById(id);
        String windDirectionDescription = Station.degreesToDirection(windDirection);
        Reading reading = new Reading(code, temp, wind, windDirection, pressure);
        station.readings.add(reading);
        station.save();
        redirect("/stations/" + station.id);
    }

    public static void addStation(String title, double latitude, double longitude) {
        Station station = new Station(title, latitude, longitude);
        station.save();
        redirect("/dashboard");
    }

}

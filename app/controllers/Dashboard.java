package controllers;

import java.util.List;

import models.Station;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Admin");

    List<Station> stations = Station.findAll();
    for(Station station : stations) {
      station.updateLatestReading();
    }
    render ("dashboard.html", stations);
  }
}


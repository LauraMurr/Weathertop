package controllers;

import java.util.List;

import models.Member;
import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Admin");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = member.stations;
/*  List<Station> stations = Station.findAll();
    for(Station station : stations) {
      station.updateLatestReading();
    }  */
    render ("dashboard.html", stations);
  }
  public static void addStation (String title, double latitude, double longitude)
  {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station (title, latitude, longitude);
    member.stations.add(station);
    member.save();
//    station.save();
    Logger.info("Adding Station" + title);
    redirect ("/dashboard");
  }

 /* public static void deleteReading(Long id, Long readingid)
  {
    Member member = Member.findById(id);
    Reading reading = Reading.findById(readingid);
    member.reading.remove(reading);
    member.save();
    reading.delete();
    Logger.info("Deleting " + reading);
    redirect("/dashboard");
  } */

}


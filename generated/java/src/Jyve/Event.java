package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Event {
  public String name;
  public Date date;
  public Number time;
  public Venue venue;
  public Band band;
  public Organizer organizer;

  public void cg_init_Event_1(
      final String iName,
      final Date iDate,
      final Number iTime,
      final Venue iVenue,
      final Band iBand,
      final Organizer iOrganizer) {

    name = iName;
    date = iDate;
    time = iTime;
    venue = iVenue;
    band = iBand;
    organizer = iOrganizer;
    return;
  }

  public Event(
      final String iName,
      final Date iDate,
      final Number iTime,
      final Venue iVenue,
      final Band iBand,
      final Organizer iOrganizer) {

    cg_init_Event_1(iName, iDate, iTime, iVenue, iBand, iOrganizer);
  }

  public void SetDate(final Date iDate) {

    date = iDate;
  }

  public void SetTime(final Number iTime) {

    time = iTime;
  }

  public void SetVenue(final Venue iVenue) {

    venue = iVenue;
  }

  public void SetBand(final Band iBand) {

    band = iBand;
  }

  public Event() {}

  public String toString() {

    return "Event{"
        + "name := "
        + Utils.toString(name)
        + ", date := "
        + Utils.toString(date)
        + ", time := "
        + Utils.toString(time)
        + ", venue := "
        + Utils.toString(venue)
        + ", band := "
        + Utils.toString(band)
        + ", organizer := "
        + Utils.toString(organizer)
        + "}";
  }
}

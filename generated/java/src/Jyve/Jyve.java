package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Jyve {
  public VDMMap venues = MapUtil.map();
  public VDMMap bands = MapUtil.map();
  public VDMMap events = MapUtil.map();
  public VDMMap artists = MapUtil.map();
  public VDMMap organizers = MapUtil.map();
  public VDMMap fans = MapUtil.map();
  public VDMSet calendar = SetUtil.set();

  public void AddArtist(final Artist iArtist) {

    artists = MapUtil.munion(Utils.copy(artists), MapUtil.map(new Maplet(iArtist.name, iArtist)));
  }

  public Artist GetArtistByName(final String iName) {

    return ((Artist) Utils.get(artists, iName));
  }

  public VDMSet GetArtistList() {

    return MapUtil.rng(Utils.copy(artists));
  }

  public void AddOrganizer(final Organizer iOrganizer) {

    organizers =
        MapUtil.munion(
            Utils.copy(organizers), MapUtil.map(new Maplet(iOrganizer.name, iOrganizer)));
  }

  public Organizer GetOrganizerByName(final String iName) {

    return ((Organizer) Utils.get(organizers, iName));
  }

  public VDMSet GetOrganizerList() {

    return MapUtil.rng(Utils.copy(organizers));
  }

  public void AddFan(final Fan iFan) {

    fans = MapUtil.munion(Utils.copy(fans), MapUtil.map(new Maplet(iFan.name, iFan)));
  }

  public Fan GetFanByName(final String iName) {

    return ((Fan) Utils.get(fans, iName));
  }

  public VDMSet GetFanlist() {

    return MapUtil.rng(Utils.copy(fans));
  }

  public void AddVenue(final Venue iVenue) {

    venues = MapUtil.munion(Utils.copy(venues), MapUtil.map(new Maplet(iVenue.name, iVenue)));
  }

  public Venue GetVenueByName(final String iName) {

    return ((Venue) Utils.get(venues, iName));
  }

  public VDMSet GetVenueList() {

    return MapUtil.rng(Utils.copy(venues));
  }

  public void AddBand(final Band iBand) {

    bands = MapUtil.munion(Utils.copy(bands), MapUtil.map(new Maplet(iBand.name, iBand)));
  }

  public Band GetBandByName(final String iName) {

    return ((Band) Utils.get(bands, iName));
  }

  public VDMSet GetBandList() {

    return MapUtil.rng(Utils.copy(bands));
  }

  public void AddArtistToBand(final String iBand, final String iArtist) {

    ((Band) Utils.get(bands, iBand)).AddArtist(GetArtistByName(iArtist));
  }

  public Boolean AddEvent(final Event iEvent) {

    Boolean free = true;
    for (Iterator iterator_1 = MapUtil.rng(Utils.copy(events)).iterator(); iterator_1.hasNext(); ) {
      Event event = (Event) iterator_1.next();
      Boolean orResult_1 = false;

      Boolean andResult_16 = false;

      if (Utils.equals(iEvent.date.day, event.date.day)) {
        Boolean andResult_17 = false;

        if (Utils.equals(iEvent.date.month, event.date.month)) {
          Boolean andResult_18 = false;

          if (Utils.equals(iEvent.date.year, event.date.year)) {
            Boolean andResult_19 = false;

            if (Utils.equals(iEvent.time, event.time)) {
              if (Utils.equals(iEvent.venue, event.venue)) {
                andResult_19 = true;
              }
            }

            if (andResult_19) {
              andResult_18 = true;
            }
          }

          if (andResult_18) {
            andResult_17 = true;
          }
        }

        if (andResult_17) {
          andResult_16 = true;
        }
      }

      if (andResult_16) {
        orResult_1 = true;
      } else {
        Boolean orResult_2 = false;

        if (iEvent.time.longValue() < iEvent.venue.openingTime.longValue()) {
          orResult_2 = true;
        } else {
          orResult_2 = iEvent.time.longValue() > iEvent.venue.closingTime.longValue();
        }

        orResult_1 = orResult_2;
      }

      if (orResult_1) {
        free = false;
      }
    }
    if (free) {
      events = MapUtil.munion(Utils.copy(events), MapUtil.map(new Maplet(iEvent.name, iEvent)));
      return true;
    }

    return false;
  }

  public VDMSet GetEventList() {

    return MapUtil.rng(Utils.copy(events));
  }

  public Event GetEventByName(final String iName) {

    return ((Event) Utils.get(events, iName));
  }

  public VDMSet GetEventsByDate(final Number iDay, final Number iMonth, final Number iYear) {

    VDMSet eventSet = SetUtil.set();
    for (Iterator iterator_2 = MapUtil.rng(Utils.copy(events)).iterator(); iterator_2.hasNext(); ) {
      Event event = (Event) iterator_2.next();
      Boolean andResult_20 = false;

      if (Utils.equals(event.date.day, iDay)) {
        Boolean andResult_21 = false;

        if (Utils.equals(event.date.month, iMonth)) {
          if (Utils.equals(event.date.year, iYear)) {
            andResult_21 = true;
          }
        }

        if (andResult_21) {
          andResult_20 = true;
        }
      }

      if (andResult_20) {
        eventSet = SetUtil.union(Utils.copy(eventSet), SetUtil.set(event));
      }
    }
    return Utils.copy(eventSet);
  }

  public void CancelEvent(final String iName) {

    Event event = GetEventByName(iName);
    for (Iterator iterator_3 = MapUtil.rng(Utils.copy(artists)).iterator();
        iterator_3.hasNext();
        ) {
      Artist artist = (Artist) iterator_3.next();
      for (Iterator iterator_4 = artist.events.iterator(); iterator_4.hasNext(); ) {
        Event e = (Event) iterator_4.next();
        if (Utils.equals(e, event)) {
          artist.RemoveEvent(event);
        }
      }
    }
    for (Iterator iterator_5 = MapUtil.rng(Utils.copy(organizers)).iterator();
        iterator_5.hasNext();
        ) {
      Organizer organizer = (Organizer) iterator_5.next();
      for (Iterator iterator_6 = organizer.events.iterator(); iterator_6.hasNext(); ) {
        Event e = (Event) iterator_6.next();
        if (Utils.equals(e, event)) {
          organizer.RemoveEvent(event);
        }
      }
    }
    for (Iterator iterator_7 = MapUtil.rng(Utils.copy(fans)).iterator(); iterator_7.hasNext(); ) {
      Fan fan = (Fan) iterator_7.next();
      for (Iterator iterator_8 = fan.events.iterator(); iterator_8.hasNext(); ) {
        Event e = (Event) iterator_8.next();
        if (Utils.equals(e, event)) {
          fan.RemoveEvent(event);
        }
      }
    }
    events = MapUtil.domResBy(SetUtil.set(iName), Utils.copy(events));
  }

  public void AttendEvent(final String iUser, final String iEvent) {

    Event event = GetEventByName(iEvent);
    if (MapUtil.dom(MapUtil.domResTo(SetUtil.set(iUser), Utils.copy(artists))).size() > 0L) {
      ((Artist) Utils.get(artists, iUser)).AddEvent(event);
    } else if (MapUtil.dom(MapUtil.domResTo(SetUtil.set(iUser), Utils.copy(organizers))).size()
        > 0L) {
      ((Organizer) Utils.get(organizers, iUser)).AddEvent(event);
    } else {
      ((Fan) Utils.get(fans, iUser)).AddEvent(event);
    }
  }

  public void CancelAttendEvent(final String iUser, final String iEvent) {

    Event event = GetEventByName(iEvent);
    if (MapUtil.dom(MapUtil.domResTo(SetUtil.set(iUser), Utils.copy(artists))).size() > 0L) {
      ((Artist) Utils.get(artists, iUser)).RemoveEvent(event);
    } else if (MapUtil.dom(MapUtil.domResTo(SetUtil.set(iUser), Utils.copy(organizers))).size()
        > 0L) {
      ((Organizer) Utils.get(organizers, iUser)).RemoveEvent(event);
    } else {
      ((Fan) Utils.get(fans, iUser)).RemoveEvent(event);
    }
  }

  public Jyve() {}

  public String toString() {

    return "Jyve{"
        + "venues := "
        + Utils.toString(venues)
        + ", bands := "
        + Utils.toString(bands)
        + ", events := "
        + Utils.toString(events)
        + ", artists := "
        + Utils.toString(artists)
        + ", organizers := "
        + Utils.toString(organizers)
        + ", fans := "
        + Utils.toString(fans)
        + ", calendar := "
        + Utils.toString(calendar)
        + "}";
  }
}

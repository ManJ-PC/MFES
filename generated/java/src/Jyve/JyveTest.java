package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class JyveTest extends MyTestCase {
  public static void Run() {

    JyveTest jyveTest = new JyveTest();
    IO.print("TestUsers -> ");
    jyveTest.TestUsers();
    IO.println("Success");
    IO.print("TestVenues -> ");
    jyveTest.TestVenues();
    IO.println("Success");
    IO.print("TestBands -> ");
    jyveTest.TestBands();
    IO.println("Success");
    IO.print("TestEvents -> ");
    jyveTest.TestEvents();
    IO.println("Success");
  }

  public void TestUsers() {

    Jyve jyve = new Jyve();
    Artist art1 = new Artist("art1", "art1_desc", 546345633L, "art1@mail", "road 1", "guitar");
    Artist art2 = new Artist("art2", "art2_desc", 345367990L, "art2@mail", "road 1", "singer");
    Artist art3 = new Artist("art3", "art3_desc", 546345633L, "art3@mail", "road 2", "drums");
    Organizer org1 = new Organizer("org1", "org1_desc", 567038459L, "org1@mail", "st1");
    Organizer org2 = new Organizer("org2", "org2_desc", 234234456L, "org2@mail", "st1");
    Organizer org3 = new Organizer("org3", "org3_desc", 987564345L, "org3@mail", "road 2");
    Fan fan1 = new Fan("fan1", "fan1_desc", 245235789L, "fan1@mail", "road 1");
    Fan fan2 = new Fan("fan2", "fan2_desc", 345435678L, "fan2@mail", "st2");
    Fan fan3 = new Fan("fan3", "fan3_desc", 98765673L, "fan3@mail", "st1");
    jyve.AddArtist(art1);
    jyve.AddArtist(art2);
    jyve.AddArtist(art3);
    jyve.AddOrganizer(org1);
    jyve.AddOrganizer(org2);
    jyve.AddOrganizer(org3);
    jyve.AddFan(fan1);
    jyve.AddFan(fan2);
    jyve.AddFan(fan3);
    assertEqual(MapUtil.rng(jyve.artists).size(), 3L);
    assertEqual(jyve.GetArtistByName("art3"), art3);
    assertEqual(MapUtil.rng(jyve.organizers).size(), 3L);
    assertEqual(jyve.GetOrganizerByName("org2"), org2);
    assertEqual(MapUtil.rng(jyve.fans).size(), 3L);
    assertEqual(jyve.GetFanByName("fan3"), fan3);
  }

  public void TestVenues() {

    Jyve jyve = new Jyve();
    Venue venue1 = new Venue("venue1", "st1", 500L, 7L, 0L);
    Venue venue2 = new Venue("venue2", "st1", 5000L, 7L, 23L);
    jyve.AddVenue(venue2);
    jyve.AddVenue(venue1);
    assertEqual(MapUtil.rng(jyve.venues).size(), 2L);
    assertEqual(jyve.GetVenueByName("venue2"), venue2);
  }

  public void TestBands() {

    Jyve jyve = new Jyve();
    Artist art1 = new Artist("art1", "art1_desc", 546345633L, "art1@mail", "road 1", "guitar");
    Artist art2 = new Artist("art2", "art2_desc", 345367990L, "art2@mail", "road 1", "singer");
    Artist art3 = new Artist("art3", "art3_desc", 546345633L, "art3@mail", "road 2", "drums");
    Band band1 =
        new Band(
            "band1", SetUtil.set(art1, art2), "genre1", new Date(11L, 12L, 2016L), "band1_desc");
    Band band2 = new Band("band2", "genre1", new Date(1L, 1L, 2018L), "band2_desc");
    jyve.AddArtist(art1);
    jyve.AddArtist(art2);
    jyve.AddArtist(art3);
    jyve.AddBand(band1);
    jyve.AddBand(band2);
    jyve.AddArtistToBand("band1", "art3");
    jyve.AddArtistToBand("band2", "art1");
    jyve.AddArtistToBand("band2", "art3");
    assertEqual(jyve.GetBandByName("band1").artists, SetUtil.set(art1, art2, art3));
    assertEqual(jyve.GetBandByName("band2").artists, SetUtil.set(art1, art3));
  }

  public void TestEvents() {

    Jyve jyve = new Jyve();
    Artist art1 = new Artist("art1", "art1_desc", 546345633L, "art1@mail", "road 1", "guitar");
    Artist art2 = new Artist("art2", "art2_desc", 345367990L, "art2@mail", "road 1", "singer");
    Artist art3 = new Artist("art3", "art3_desc", 546345633L, "art3@mail", "road 2", "drums");
    Organizer org1 = new Organizer("org1", "org1_desc", 567038459L, "org1@mail", "st1");
    Organizer org2 = new Organizer("org2", "org2_desc", 234234456L, "org2@mail", "st1");
    Organizer org3 = new Organizer("org3", "org3_desc", 987564345L, "org3@mail", "road 2");
    Fan fan1 = new Fan("fan1", "fan1_desc", 245235789L, "fan1@mail", "road 1");
    Fan fan2 = new Fan("fan2", "fan2_desc", 345435678L, "fan2@mail", "st2");
    Fan fan3 = new Fan("fan3", "fan3_desc", 98765673L, "fan3@mail", "st1");
    Band band1 =
        new Band(
            "band1", SetUtil.set(art1, art2), "genre1", new Date(11L, 12L, 2016L), "band1_desc");
    Band band2 =
        new Band(
            "band2",
            SetUtil.set(art1, art2, art3),
            "genre1",
            new Date(1L, 1L, 2018L),
            "band2_desc");
    Venue venue1 = new Venue("venue1", "st1", 500L, 10L, 24L);
    Event event1 = new Event("event1", new Date(12L, 1L, 2017L), 18L, venue1, band1, org1);
    Event event2 = new Event("event2", new Date(19L, 3L, 2017L), 20L, venue1, band2, org1);
    Event event3 = new Event("event3", new Date(23L, 6L, 2016L), 9L, venue1, band1, org1);
    Event event4 = new Event("event4", new Date(12L, 1L, 2017L), 18L, venue1, band1, org1);
    jyve.AddArtist(art1);
    jyve.AddArtist(art2);
    jyve.AddArtist(art3);
    jyve.AddOrganizer(org1);
    jyve.AddOrganizer(org2);
    jyve.AddOrganizer(org3);
    jyve.AddFan(fan1);
    jyve.AddFan(fan2);
    jyve.AddFan(fan3);
    jyve.AddBand(band1);
    jyve.AddBand(band2);
    assertEqual(true, jyve.AddEvent(event1));
    assertEqual(true, jyve.AddEvent(event2));
    assertEqual(false, jyve.AddEvent(event3));
    assertEqual(false, jyve.AddEvent(event4));
    assertEqual(MapUtil.rng(jyve.events), SetUtil.set(event1, event2));
    assertEqual(jyve.GetEventsByDate(12L, 1L, 2017L), SetUtil.set(event1));
    assertEqual(jyve.GetEventsByDate(12L, 2L, 2017L), SetUtil.set());
    jyve.AttendEvent("fan1", "event1");
    jyve.AttendEvent("art1", "event1");
    jyve.AttendEvent("fan1", "event2");
    jyve.AttendEvent("fan2", "event2");
    jyve.AttendEvent("org1", "event1");
    jyve.AttendEvent("org1", "event2");
    assertEqual(jyve.GetArtistByName("art1").events.size(), 1L);
    assertEqual(jyve.GetFanByName("fan1").events.size(), 2L);
    assertEqual(jyve.GetFanByName("fan2").events.size(), 1L);
    jyve.CancelAttendEvent("fan1", "event1");
    assertEqual(jyve.GetFanByName("fan1").events.size(), 1L);
    jyve.CancelEvent("event2");
    assertEqual(jyve.GetArtistByName("art1").events.size(), 1L);
    assertEqual(jyve.GetFanByName("fan1").events.size(), 0L);
    assertEqual(jyve.GetFanByName("fan2").events.size(), 0L);
    assertEqual(jyve.GetFanByName("org1").events.size(), 2L);
  }

  public JyveTest() {}

  public String toString() {

    return "JyveTest{}";
  }
}

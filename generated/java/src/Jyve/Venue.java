package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Venue {
  public String name;
  public String address;
  public Number capacity;
  public Number openingTime;
  public Number closingTime;

  public void cg_init_Venue_1(
      final String iname,
      final String iaddress,
      final Number icapacity,
      final Number iopeningTime,
      final Number iclosingTime) {

    name = iname;
    address = iaddress;
    capacity = icapacity;
    openingTime = iopeningTime;
    closingTime = iclosingTime;
    return;
  }

  public Venue(
      final String iname,
      final String iaddress,
      final Number icapacity,
      final Number iopeningTime,
      final Number iclosingTime) {

    cg_init_Venue_1(iname, iaddress, icapacity, iopeningTime, iclosingTime);
  }

  public Venue() {}

  public String toString() {

    return "Venue{"
        + "name := "
        + Utils.toString(name)
        + ", address := "
        + Utils.toString(address)
        + ", capacity := "
        + Utils.toString(capacity)
        + ", openingTime := "
        + Utils.toString(openingTime)
        + ", closingTime := "
        + Utils.toString(closingTime)
        + "}";
  }
}

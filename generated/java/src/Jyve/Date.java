package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Date {
  public Number day;
  public Number month;
  public Number year;

  public void cg_init_Date_1(final Number iDay, final Number iMonth, final Number iYear) {

    day = iDay;
    month = iMonth;
    year = iYear;
    return;
  }

  public Date(final Number iDay, final Number iMonth, final Number iYear) {

    cg_init_Date_1(iDay, iMonth, iYear);
  }

  public Date() {}

  public String toString() {

    return "Date{"
        + "day := "
        + Utils.toString(day)
        + ", month := "
        + Utils.toString(month)
        + ", year := "
        + Utils.toString(year)
        + "}";
  }
}

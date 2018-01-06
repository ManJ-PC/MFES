package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Artist extends User {
  public String instrument;

  public void cg_init_Artist_1(
      final String iName,
      final String iProfileDescription,
      final Number iPhone,
      final String iMail,
      final String iAddress,
      final String iInstrument) {

    name = iName;
    profileDescription = iProfileDescription;
    phone = iPhone;
    mail = iMail;
    address = iAddress;
    events = SetUtil.set();
    instrument = iInstrument;
    return;
  }

  public Artist(
      final String iName,
      final String iProfileDescription,
      final Number iPhone,
      final String iMail,
      final String iAddress,
      final String iInstrument) {

    cg_init_Artist_1(iName, iProfileDescription, iPhone, iMail, iAddress, iInstrument);
  }

  public Artist() {}

  public String toString() {

    return "Artist{" + "instrument := " + Utils.toString(instrument) + "}";
  }
}

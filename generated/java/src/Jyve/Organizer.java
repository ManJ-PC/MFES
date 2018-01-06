package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Organizer extends User {
  public void cg_init_Organizer_1(
      final String iName,
      final String iProfileDescription,
      final Number iPhone,
      final String iMail,
      final String iAddress) {

    name = iName;
    profileDescription = iProfileDescription;
    phone = iPhone;
    mail = iMail;
    address = iAddress;
    events = SetUtil.set();
    return;
  }

  public Organizer(
      final String iName,
      final String iProfileDescription,
      final Number iPhone,
      final String iMail,
      final String iAddress) {

    cg_init_Organizer_1(iName, iProfileDescription, iPhone, iMail, iAddress);
  }

  public Organizer() {}

  public String toString() {

    return "Organizer{}";
  }
}

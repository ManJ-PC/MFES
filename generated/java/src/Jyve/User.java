package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class User {
  public String name;
  public String profileDescription;
  public Number phone;
  public String mail;
  public String address;
  public VDMSet events;

  public void cg_init_User_1(
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

  public User(
      final String iName,
      final String iProfileDescription,
      final Number iPhone,
      final String iMail,
      final String iAddress) {

    cg_init_User_1(iName, iProfileDescription, iPhone, iMail, iAddress);
  }

  public void AddEvent(final Event iEvent) {

    events = SetUtil.union(Utils.copy(events), SetUtil.set(iEvent));
  }

  public void RemoveEvent(final Event iEvent) {

    events = SetUtil.diff(Utils.copy(events), SetUtil.set(iEvent));
  }

  public User() {}

  public String toString() {

    return "User{"
        + "name := "
        + Utils.toString(name)
        + ", profileDescription := "
        + Utils.toString(profileDescription)
        + ", phone := "
        + Utils.toString(phone)
        + ", mail := "
        + Utils.toString(mail)
        + ", address := "
        + Utils.toString(address)
        + ", events := "
        + Utils.toString(events)
        + "}";
  }
}

package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Band {
  public String name;
  public VDMSet artists;
  public String genre;
  public Date foundation;
  public String description;

  public void cg_init_Band_2(
      final String iName, final String iGenre, final Date iFoundation, final String iDescription) {

    name = iName;
    artists = SetUtil.set();
    genre = iGenre;
    foundation = iFoundation;
    description = iDescription;
    return;
  }

  public void cg_init_Band_1(
      final String iName,
      final VDMSet iArtists,
      final String iGenre,
      final Date iFoundation,
      final String iDescription) {

    name = iName;
    artists = Utils.copy(iArtists);
    genre = iGenre;
    foundation = iFoundation;
    description = iDescription;
    return;
  }

  public Band(
      final String iName,
      final VDMSet iArtists,
      final String iGenre,
      final Date iFoundation,
      final String iDescription) {

    cg_init_Band_1(iName, Utils.copy(iArtists), iGenre, iFoundation, iDescription);
  }

  public Band(
      final String iName, final String iGenre, final Date iFoundation, final String iDescription) {

    cg_init_Band_2(iName, iGenre, iFoundation, iDescription);
  }

  public void AddArtist(final Artist iArtist) {

    artists = SetUtil.union(Utils.copy(artists), SetUtil.set(iArtist));
  }

  public void RemoveArtist(final Artist iArtist) {

    artists = SetUtil.diff(Utils.copy(artists), SetUtil.set(iArtist));
  }

  public Band() {}

  public String toString() {

    return "Band{"
        + "name := "
        + Utils.toString(name)
        + ", artists := "
        + Utils.toString(artists)
        + ", genre := "
        + Utils.toString(genre)
        + ", foundation := "
        + Utils.toString(foundation)
        + ", description := "
        + Utils.toString(description)
        + "}";
  }
}

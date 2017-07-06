package main.java.model;

/**
 * Created by mattias on 2017-07-04.
 */
public final class Card {
  private final Suite suite;
  private final Rank rank;

  public Card(Suite suite, Rank rank) {
    this.suite = suite;
    this.rank = rank;
  }

  public Suite getSuite() {
    return suite;
  }

  public Rank getRank() {
    return rank;
  }

  @Override
  public String toString() {
    return String.format("%s of %s", getRank(), getSuite());
  }
}

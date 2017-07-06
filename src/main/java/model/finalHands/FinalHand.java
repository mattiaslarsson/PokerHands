package main.java.model.finalHands;

import main.java.model.Rank;

/**
 * Created by mattias on 2017-07-04.
 */
public abstract class FinalHand implements ValuableHand {
  private int rank;

  public FinalHand(int rank) {
    this.rank = rank;
  }

  public FinalHand() {}

  public int getRank() {
    return rank;
  }

  public String getName() {
    return Rank.values()[rank-2].name();
  }

  public String[] getNames(int rank1, int rank2) {
    return new String[] {Rank.values()[rank1-2].name(), Rank.values()[rank2-2].name()};
  }
}

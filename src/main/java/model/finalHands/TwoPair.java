package main.java.model.finalHands;

/**
 * Created by mattias on 2017-07-04.
 */
public class TwoPair extends FinalHand implements ValuableHand {
  private final int VALUE = 2;

  int rank1, rank2;

  public TwoPair(int rank1, int rank2) {
    this.rank1 = rank1;
    this.rank2 = rank2;
  }

  @Override
  public String toString() {
    return (String.format("Two Pairs of %s's and %s's",
        super.getNames(rank1, rank2)[0], super.getNames(rank1, rank2)[1]));
  }

  @Override
  public int getValue() {
    return VALUE;
  }
}

package main.java.model.finalHands;

/**
 * Created by mattias on 2017-07-06.
 */
public class FullHouse extends FinalHand implements ValuableHand {
  private final int VALUE = 6;
  private int rank1, rank2;

  public FullHouse(int rank1, int rank2) {
    this.rank1 = rank1;
    this.rank2 = rank2;
  }

  public int[] getRanks() {
    return new int[] {rank1, rank2};
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("Full House of %s's and %s's",
        super.getNames(rank1, rank2)[0], super.getNames(rank1, rank2)[1]));
    return sb.toString();
  }

  @Override
  public int getValue() {
    return VALUE;
  }
}

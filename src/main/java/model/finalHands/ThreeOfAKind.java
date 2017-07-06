package main.java.model.finalHands;

/**
 * Created by mattias on 2017-07-05.
 */
public class ThreeOfAKind extends FinalHand implements ValuableHand {

  private final int VALUE = 3;

  public ThreeOfAKind(int rank) {
    super(rank);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Three of a kind of ").append(super.getName()).append("'s");
    return sb.toString();
  }

  @Override
  public int getValue() {
    return VALUE;
  }
}

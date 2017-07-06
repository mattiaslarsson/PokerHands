package main.java.model.finalHands;


/**
 * Created by mattias on 2017-07-04.
 */
public class OnePair extends FinalHand implements ValuableHand {

  private final int VALUE = 1;

  public OnePair(int rank) {
    super(rank);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("One Pair of ").append(super.getName()).append("'s");
    return sb.toString();
  }

  @Override
  public int getValue() {
    return VALUE;
  }
}

package main.java.model.comparators;

import main.java.model.finalHands.ValuableHand;

import java.util.Comparator;

/**
 * Created by mattias on 2017-07-06.
 */
public class HandComparator implements Comparator<ValuableHand> {
  @Override
  public int compare(ValuableHand o1, ValuableHand o2) {
    return o1.getValue() - o2.getValue();
  }
}

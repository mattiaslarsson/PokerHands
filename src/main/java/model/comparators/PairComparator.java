package main.java.model.comparators;

import main.java.model.finalHands.OnePair;

import java.util.Comparator;

/**
 * Created by mattias on 2017-07-06.
 */
public class PairComparator implements Comparator<OnePair> {

  @Override
  public int compare(OnePair o1, OnePair o2) {
    return o2.getRank() - o1.getRank();
  }
}

package main.java.model.comparators;

import main.java.model.Card;

import java.util.Comparator;

/**
 * Created by mattias on 2017-07-04.
 */
public class RankComparator implements Comparator<Card> {

  @Override
  public int compare(Card o1, Card o2) {
    return o1.getRank().getValue() - o2.getRank().getValue();
  }

}

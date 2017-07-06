package main.java.model.predicates;

import main.java.model.Card;

import java.util.function.BiPredicate;

/**
 * Created by mattias on 2017-07-06.
 */
public class HandChecker {

  public static BiPredicate<Card, Card> pair = (x, y) -> x.getRank().getValue() == y.getRank().getValue();
}

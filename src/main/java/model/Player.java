package main.java.model;

import main.java.exceptions.DeckNotInitializedException;
import main.java.exceptions.HandTooBigException;

import java.util.stream.Stream;

/**
 * Created by mattias on 2017-07-04.
 */
public class Player {
  private Hand hand;

  public Player() {
    hand = new Hand(2);
  }

  public Stream<Card> getHand() {
    return hand.getCards();
  }

  public void drawCard() throws HandTooBigException, DeckNotInitializedException {
    hand.drawCard();
  }
}

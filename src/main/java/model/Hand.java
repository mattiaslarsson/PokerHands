package main.java.model;

import main.java.exceptions.DeckNotInitializedException;
import main.java.exceptions.HandTooBigException;

import java.util.HashSet;
import java.util.stream.Stream;

/**
 * Created by mattias on 2017-07-04.
 */
public class Hand {
  private HashSet<Card> currentHand;
  private int capacity;

  public Hand(int capacity) {
    this.capacity = capacity;
    currentHand = new HashSet<>(capacity);
  }

  public void drawCard() throws HandTooBigException, DeckNotInitializedException {
    if (currentHand.size() == capacity) {
      throw new HandTooBigException(String.format("main.java.model.Player already has maximum amount of cards (%d)", capacity));
    } else {
      currentHand.add(Deck.draw());
    }
  }

  public Stream<Card> getCards() {
    return currentHand.stream();
  }
}

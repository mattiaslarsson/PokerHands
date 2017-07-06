package main.java.model;

import main.java.exceptions.DeckNotInitializedException;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by mattias on 2017-07-04.
 */
public final class Deck {
  private static ArrayList<Card> deck;

  private Deck() {
  }

  public static Stream<Card> getDeck() throws DeckNotInitializedException {
    return isInitialized() ? deck.stream() : null;
  }

  public static void initDeck() {
    deck = new ArrayList<>();
    for (Rank rank : Rank.values()) {
      for (Suite suite : Suite.values()) {
        deck.add(new Card(suite, rank));
      }
    }
  }

  public static void shuffle() throws DeckNotInitializedException {
    if (isInitialized())
      Collections.shuffle(deck);
  }

  public static Card draw() throws DeckNotInitializedException {
    return isInitialized() ? deck.remove(0) : null;
  }

  private static boolean isInitialized() throws DeckNotInitializedException {
    if (deck == null) {
      throw new DeckNotInitializedException();
    }
    return true;
  }
}

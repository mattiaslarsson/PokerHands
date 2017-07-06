package main.java.exceptions;

/**
 * Created by mattias on 2017-07-04.
 */
public class DeckNotInitializedException extends Exception {

  public DeckNotInitializedException() {
    super("main.java.model.Deck not initialized");
  }
}

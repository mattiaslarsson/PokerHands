package main.java;

import main.java.exceptions.DeckNotInitializedException;
import main.java.exceptions.HandTooBigException;
import main.java.model.Deck;
import main.java.model.Hand;
import main.java.model.Player;

/**
 * Created by mattias on 2017-07-04.
 */
public class Main {
  public static void main(String[] args) throws DeckNotInitializedException, HandTooBigException {
    Deck.initDeck();
    Deck.shuffle();
    Player p1 = new Player();
    p1.drawCard();
    p1.drawCard();
    Hand flop = new Hand(3);
    for (int i = 0; i < 3; i++) {
      flop.drawCard();
    }
    Hand turn = new Hand(1);
    turn.drawCard();
    Hand river = new Hand(1);
    river.drawCard();

    Calculator.calculate(p1, flop, turn, river);
  }
}

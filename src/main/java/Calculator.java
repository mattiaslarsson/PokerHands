package main.java;

import main.java.model.*;
import main.java.model.comparators.HandComparator;
import main.java.model.comparators.PairComparator;
import main.java.model.comparators.RankComparator;
import main.java.model.finalHands.*;
import main.java.model.predicates.HandChecker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mattias on 2017-07-04.
 */
public final class Calculator {
  private static ArrayList<Card> handToCalculate;
  private static ArrayList<FinalHand> possibleHands;

  public static void calculate(Player player, Hand flop, Hand turn, Hand river) {
    handToCalculate = new ArrayList<>();
    possibleHands = new ArrayList<>();

    player.getHand().forEach(card -> handToCalculate.add(new Card(card.getSuite(), card.getRank())));
    flop.getCards().forEach(card -> handToCalculate.add(new Card(card.getSuite(), card.getRank())));
    turn.getCards().forEach(card -> handToCalculate.add(new Card(card.getSuite(), card.getRank())));
    river.getCards().forEach(card -> handToCalculate.add(new Card(card.getSuite(), card.getRank())));

    System.out.println("-- Hand to calculate --");
    handToCalculate.forEach(System.out::println);

    System.out.println("--- Sorted ---");
    handToCalculate.sort(new RankComparator());
    handToCalculate.forEach(System.out::println);

    // Check pairs, Three Of a kind and Four Of a Kind
    ArrayList<ThreeOfAKind> toks = new ArrayList<>(); // List of three of a kind's
    ArrayList<FourOfAKind> foks = new ArrayList<>(); // List of four of a kind's
    for (Card card : handToCalculate) {
      toks.clear();
      foks.clear();
      int i = handToCalculate.indexOf(card) + 1;
      if (i == handToCalculate.size()) {
        break;
      }
      // Check if current card and the next one makes a pair
      if (HandChecker.pair.test(card, handToCalculate.get(i))) {
        // If we already has a pair of that rank it makes a three of a kind
        possibleHands.stream()
            .filter(hand -> hand instanceof OnePair)
            .forEach(onePair -> {
              OnePair oP = (OnePair) onePair;
              if (oP.getRank() == card.getRank().getValue()) {
                toks.add(new ThreeOfAKind(card.getRank().getValue()));
              }
            });
        // And if we have a three of a kind it makes a four of a kind
        possibleHands.stream()
            .filter(hand -> hand instanceof ThreeOfAKind)
            .forEach(threeOfAKind -> {
              ThreeOfAKind tok = (ThreeOfAKind) threeOfAKind;
              if (tok.getRank() == card.getRank().getValue()) {
                foks.add(new FourOfAKind(card.getRank().getValue()));
              }
            });
        // Check what hand to insert
        if (toks.isEmpty() && foks.isEmpty()) {
          possibleHands.add(new OnePair(card.getRank().getValue()));
        } else if (foks.isEmpty()) {
          possibleHands.add(toks.get(0));
          toks.remove(toks.get(0));
        } else {
          possibleHands.add(foks.get(0));
          foks.remove(foks.get(0));
        }
      }
    }

    // Clean up the list of hands
    System.out.println("-- Cleaning --");
    for (int i = possibleHands.size() - 1; i > 0; i--) {
      if (possibleHands.get(i) instanceof FourOfAKind && possibleHands.get(i).getRank() ==
          possibleHands.get(i - 1).getRank()) {
        possibleHands.remove(i - 1);
      } else if (possibleHands.get(i) instanceof ThreeOfAKind && possibleHands.get(i).getRank() ==
          possibleHands.get(i - 1).getRank()) {
        possibleHands.remove(i - 1);
        if (i == 1)
          break;
      }
    }

    // Check for fullhouse
    for (int i = possibleHands.size() - 1; i > 0; i--) {
      if (possibleHands.get(i) instanceof ThreeOfAKind && possibleHands.get(i - 1) instanceof OnePair ||
          possibleHands.get(i) instanceof OnePair && possibleHands.get(i - 1) instanceof ThreeOfAKind) {
        int rank1 = possibleHands.get(i).getRank();
        int rank2 = possibleHands.get(i - 1).getRank();
        possibleHands.clear();
        possibleHands.add(new FullHouse(rank1, rank2));
      }
    }

    // Check for two pairs
    List<OnePair> pairs = new ArrayList<>();
    possibleHands.forEach(hand -> {
      if (hand instanceof OnePair) {
        pairs.add((OnePair) hand);
      }
    });

    if (pairs.size() > 1) {
      pairs.sort(new PairComparator());
      int rank1 = pairs.get(pairs.size() - 1).getRank();
      int rank2 = pairs.get(pairs.size() - 2).getRank();
      possibleHands.clear();
      possibleHands.add(new TwoPair(rank1, rank2));
    }

    // Sort the list of hands and remove the least valuable
    possibleHands.sort(new HandComparator());
    if (possibleHands.size() > 1) {
      for (int i = possibleHands.size() - 2; i >= 0; i--) {
        possibleHands.remove(i);
      }
    }
    possibleHands.forEach(System.out::println);
  }
}

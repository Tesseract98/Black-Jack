package com.company;

import java.util.Random;

public class Deck {

    private Card[] cards = new Card[52];

    public Deck() {
        fillInDeck();
    }

    private void fillInDeck() {
       int i = 0;
       for (Value value : Value.values()) {
           for (Suit suit : Suit.values()) {
              cards[i] = new Card(suit, value);
              i++;
           }
       }
        shuffleDeck(cards);
    }

    private void shuffleDeck(Card[] cards) {
        Random r = new Random();

        for(int i = 0; i < 1000; i++) {
            int i1 = r.nextInt(52);
            int i2 = r.nextInt(52);
            swap(cards, i1, i2);
        }
    }

    private void swap(Card[] cards, int i1, int i2) {
        Card temp = null;

        temp = cards[i1];
        cards[i1] = cards[i2];
        cards[i2] = temp;
    }

    public Card[] getCards() {
        return cards;
    }
}

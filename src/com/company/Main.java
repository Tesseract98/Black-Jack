package com.company;

import java.util.Scanner;

public class Main {

//    public class Indexing {
//        private byte index = 51;
//
//        public void indexMinus(){
//            index--;
//            if(index < 0){
//                Main.deck = new Deck();
//                Main.cards = Main.deck.getCards();
//                index = 51;
//            }
//        }
//
//        public byte getIndex() {
//            return index;
//        }
//    }

    private static Deck deck = new Deck();
    private static Card[] cards = new Card[51];

    public static void main(String[] args) {
//        Deck deck = new Deck();
//        for (Card card : deck.getCards()) {
//            System.out.println(card.getValue() + " of " + card.getSuit());
//        }

        class Indexing {
            private byte index = 51;

            public void indexMinus(){
                index--;
                if(index < 0){
                    deck = new Deck();
                    cards = Main.deck.getCards();
                    index = 51;
                }
            }

            public byte getIndex() {
                return index;
            }
        }
        System.out.println("Hello in our game Black Jack!");
        System.out.println("Press 's' - to show cards, 'e' - to exit");
        System.out.println("For getting a card press 'g'");
        Scanner sc = new Scanner(System.in);
        String strVar = sc.nextLine();
        Player player1 = new Player();
        Croupier croupier = new Croupier();
        cards = deck.getCards();
        int counter = 0;
        Indexing index = new Indexing();
        while(!strVar.equals("e")) {
            switch (strVar){
                case "g":
                    System.out.println(cards[index.getIndex()].getValue() + " of " + cards[index.getIndex()].getSuit());
                    player1.setCount(cards[index.getIndex()].getValue().getCost());
                    counter++;
                    index.indexMinus();
                break;
                case "s":
                    System.out.println(player1.getCount() + "\n");
                    for (int i = 0; i < counter; i++){
                        System.out.println(cards[index.getIndex()].getValue() + " of " + cards[index.getIndex()].getSuit());
                        croupier.setCount(cards[index.getIndex()].getValue().getCost());
                        index.indexMinus();
                    }
                    System.out.println(croupier.getCount() + "\n");
                    int cGC = croupier.getCount();
                    int pGC = player1.getCount();
                    if(cGC > pGC && cGC < 22 || (cGC < pGC && cGC < 22 && pGC > 21)){
                        System.out.println("Croupier wins");
                        croupier.setWins();
                    }
                    else if(cGC < pGC && pGC < 22 || (cGC > pGC && pGC < 22 && cGC > 21)){
                        System.out.println("Player wins");
                        player1.setWins();
                    }
                    else{
                        System.out.println("Croupier wins");
                        croupier.setWins();
                    }
                player1.setCountNull();
                croupier.setCountNull();
                counter = 0;
                break;
                default:
                    System.out.println("You enter the wrong symbol");
            }
            strVar = sc.nextLine();
        }
        sc.close();
        System.out.println();
        System.out.println("Player wins: " + player1.getWins());
        System.out.println("Croupier wins: " + croupier.getWins());
    }
}
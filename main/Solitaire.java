package main;

/**
 * 
 * David Eyrich - Personal
 * 
 * Solitaire, by Dave: an app
 * 
 * To run package: 'javac *.java -d .' -> java main
 * 
 */

import java.util.*;

public class Solitaire {
    public Card[] initializeDeck(int size) {
        // init all possible nums and suits
        int[] nums = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        char[] suits = { 'H', 'D', 'S', 'C' };

        // deck of cards
        Card[] deck = new Card[size];
        int num = 0, suit = 0;
        for (int i = 0; i < deck.length; i++) {
            if (num >= nums.length) {
                num = 0;
                suit++;
            }
            deck[i] = new Card(nums[num++], suits[suit], false);
        }
        return deck;
    }

    public Card[] randomizeDeck(Card[] deck) {
        // Obtain random ints from 0 to deck.length
        int deckSize = deck.length;
        List<Integer> randSeeds = new ArrayList<>();
        while (randSeeds.size() < deckSize) {
            int temp = (int) Math.floor(Math.random() * 52 + 0);
            if (!randSeeds.contains(temp)) {
                randSeeds.add(temp);
            }
        }
        // Verify randomization
        // for (int i = 0; i < deckSize; i++)
        // System.out.print(randSeeds.get(i) + " ");
        // System.out.println();

        // Declare an array of cards to store the new deck
        Card[] newDeck = new Card[deckSize];
        for (int i = 0; i < deckSize; i++) {
            newDeck[randSeeds.get(i)] = deck[i];
        }

        return newDeck;
    }

    public Card[][] newGame(Card[] deck) {
        int deckSize = deck.length;
        int deckPtr = 0;

        // 2D array of cards:
        // [7 main rows + 4 aces + 1 extra pile][26 empty slots (with extra pile)]
        Card[][] board = new Card[deckSize / 2][7 + 4 + 1];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Card();
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = i; j < board[0].length - 5; j++) {
                if (i == j) {
                    deck[deckPtr].faceUp = true;
                    board[i][j] = deck[deckPtr++];
                } else {
                    board[i][j] = deck[deckPtr++];
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (deckPtr < deckSize)
                board[i][board[0].length - 1] = deck[deckPtr++];
            else
                break;
        }

        return board;
    }

    public void printDeck(Card[] deck) {
        for (Card card : deck) {
            card.whichCardLong();
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Solitaire game = new Solitaire();

        // the deck of cards to be used
        Card[] deck = game.initializeDeck(52);

        // Verify deck randomization
        // System.out.println("Default deck:");
        // game.printDeck(deck);
        // System.out.println("Random deck:");
        // game.printDeck(game.randomizeDeck(deck));

        // Populate board with new randomized deck of cards
        Card[][] board = game.newGame(game.randomizeDeck(deck));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j].whichCardShort();
            }
            System.out.println();
        }
    }
}
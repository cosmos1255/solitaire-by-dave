package main;

/**
 * 
 * David Eyrich - Personal
 * 
 * Solitaire, by Dave: an app
 * 
 */

public class Solitaire {
    public static void main(String[] args) {

        // initializes all possible numbers and suits
        int[] nums = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        char[] suits = { 'H', 'D', 'S', 'C' };

        // the deck of cards to be used
        Card[] deck = new Card[52];
        int num = 0, suit = 0;
        for (int i = 0; i < deck.length; i++) {
            if (num >= nums.length) {
                num = 0;
                suit++;
            }
            deck[i] = new Card(nums[num++], suits[suit], false);
        }
        // Verify input:
        for (Card c : deck) {
            c.whichCard();
        }

    }
}
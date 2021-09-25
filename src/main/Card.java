package main;

public class Card {
    char suit = 0;
    int value = 0;
    boolean color; // true == black, false == red
    boolean visible = false;
    boolean sorted = false;
    Card(char suit, int value) {
        this.suit = suit;
        this.value = value;
        color = suit != 'd' && suit != 'h';
    }

    // A card becomes visible
    void flipOver() {
        this.visible = !this.visible;
    }

    // if this card is a part of a sorted sequence
    void isSorted() {
        this.sorted = true;
    }

    // if this card is removed from a sorted sequence
    // OR
    // added to the aces
    void unSorted() {
        this.sorted = false;
    }
}

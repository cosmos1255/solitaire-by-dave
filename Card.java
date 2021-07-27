/**
 * David Eyrich - Personal
 * 
 * Card class creation
 */

class Card {
    int num;
    char suit;
    char color;
    boolean faceUp;

    public Card(int num, char suit, boolean faceUp) {
        this.num = num;
        this.suit = suit;
        this.faceUp = faceUp;
        if (suit == 'H' || suit == 'D') {
            this.color = 'R';
        } else {
            this.color = 'B';
        }
    }

    void whichCard() {
        String suitStr = "";
        String[] faceCards = { "Jack", "Queen", "King", "Ace" };
        switch (this.suit) {
            case 'H':
                suitStr = "Hearts";
                break;
            case 'D':
                suitStr = "Diamonds";
                break;
            case 'S':
                suitStr = "Spades";
                break;
            case 'C':
                suitStr = "Clubs";
                break;
        }
        System.out.println((num <= 10 ? num : faceCards[(num % 10) - 1]) + " of " + suitStr + ". "
                + ((faceUp) ? "Face up." : "Face down."));
    }

    void flipOver() {
        if (this.faceUp) {
            this.faceUp = false;
        } else {
            this.faceUp = true;
        }
    }
}

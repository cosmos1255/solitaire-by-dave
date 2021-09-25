package main;

import java.util.*;

public class Board {
    final int board_size_x = 7;
    final int board_size_y = 21;
    final int aces_size_x = 4;
    final int aces_size_y = Solitaire.deck_size / 4;
    Card[][] mainBoard = new Card[board_size_x][board_size_y];
    Card[][] aces = new Card[aces_size_x][aces_size_y];

    // create methods

    // 1. add cards to mainBoard
    // 2. move cards from mainBoard to aces
    // 2a. move cards from aces to mainBoard
    // 3. move cards between indices on mainBoard


}

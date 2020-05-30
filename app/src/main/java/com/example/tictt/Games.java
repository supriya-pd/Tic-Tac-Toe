package com.example.tictt;

public class Games { //
    private char[] gridElements;
    private char currentPlayer;
    private boolean isGameEnded;

    public Games() {
        gridElements = new char[9];
        newGame();
    }

    public boolean isGameEnded() {
        return isGameEnded;

    }

    public char play(int x, int y) {
        if (!isGameEnded && gridElements[3 * y + x] == '\u0000') {
            gridElements[3 * y + x] = currentPlayer;
            changePlayer();
        }
        return checkEnd();
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X' ? 'O' : 'X');
    }

    public char elements(int x, int y) {
        return gridElements[3 * y + x];
    }

    public void newGame() {
        for (int i = 0; i < gridElements.length; i++) {
            gridElements[i] = '\u0000';
        }
        currentPlayer = 'X';
        isGameEnded = false;

    }

    public char checkEnd() {
        for (int i = 0; i < 3; i++) {
            if (elements(i, 0) != '\u0000' && elements(i, 0) == elements(i, 1) && elements(i, 1) == elements(i, 2)) {
                isGameEnded = true;
                return elements(i, 0);
            }
            if (elements(0, i) != '\u0000' && elements(0, i) == elements(1, i) && elements(1, i) == elements(2, i)) {
                isGameEnded = true;
                return elements(0, i);
            }

        }

        if (elements(0, 0) != '\u0000' && elements(0, 0) == elements(1, 1) && elements(1, 1) == elements(2, 2)) {
            isGameEnded = true;
            return elements(0, 0);

        }

        if (elements(2, 0) != '\u0000' && elements(2, 0) == elements(1, 1) && elements(1, 1) == elements(0, 2)) {
            isGameEnded = true;
            return elements(2, 0);

        }
        for (int i = 0; i < 9; i++) {
            if (gridElements[i] == '\u0000')
                return '\u0000';
        }
        return 'D';

    }
}
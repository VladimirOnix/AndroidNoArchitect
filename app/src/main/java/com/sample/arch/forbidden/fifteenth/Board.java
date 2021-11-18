package com.sample.arch.forbidden.fifteenth;

public class Board {

    private BoardItem[][] mBoard;

    public Board(int width, int height) throws Exception {
        if (width <= 0) {
            throw new Exception("Board width should be positive integer value");
        }
        if (height <= 0) {
            throw new Exception("Board height should be positive integer value");
        }
        mBoard = new BoardItem[width + 2][height + 2];
        init();
    }

    public void init() {
        initCanvas();
        initBoard();
    }

    private void initCanvas() {
        for (int i = 0; i < mBoard.length; i++) {
            for (int j = 0; j < mBoard[0].length; j++) {
                mBoard[i][j] = new BoardItem().corner();
            }
        }
    }

    private void initBoard() {
        int startNumber = 1;
        int endNumber = getSizeInCells();
        for (int i = 1; i < mBoard.length - 1; i++) {
            for (int j = 1; j < mBoard[0].length - 1; j++) {
                if (startNumber != endNumber) {
                    mBoard[j][i] = new BoardItem().filled(startNumber);
                } else {
                    mBoard[j][i] = new BoardItem().empty();
                    return;
                }
                startNumber++;
            }
        }
    }


    private int getSizeInCells() {
        return (mBoard.length - 2) * (mBoard[0].length - 2);
    }

    private int getWidth() {
        return mBoard[0].length - 2;
    }

    private int getHeight() {
        return mBoard.length - 2;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (int i = 0; i < mBoard.length; i++) {
            for (int j = 0; j < mBoard[0].length; j++) {
                builder.append(mBoard[j][i].toString());
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}


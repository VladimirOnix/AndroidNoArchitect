package com.sample.arch.forbidden.fifteenth;

public class BoardItem {
    public static int NONE = -1;

    private BoardItemType mType;
    private int mNumber;

    public BoardItem(BoardItemType type, int number) {
        mType = type;
        mNumber = number;
    }

    public BoardItem() {
        this(BoardItemType.EMPTY, NONE);
    }

    public BoardItem filled(int value) {
        mType = BoardItemType.FILLED;
        mNumber = value;
        return this;
    }

    public BoardItem corner() {
        mType = BoardItemType.CORNER;
        mNumber = NONE;
        return this;
    }

    public BoardItem empty() {
        mType = BoardItemType.EMPTY;
        mNumber = NONE;
        return this;
    }

    public BoardItemType getType() {
        return mType;
    }

    public void setType(BoardItemType type) {
        mType = type;
    }

    public int getNumber() {
        return mNumber;
    }

    public void setNumber(int number) {
        mNumber = number;
    }

    public String toString() {
        switch (mType) {
            case EMPTY:
                return " ";
            case FILLED:
                return String.format("%01X", mNumber);
            case CORNER:
                return "+";
        }
        return "";
    }
}

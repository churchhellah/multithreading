package org.threads.game;

public interface PlayBoard {
    void closeNumber(int number);
    boolean isAllNumbersOnRowAreClosed();
    boolean isAllNumbersOnCardClosed();
}
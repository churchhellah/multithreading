package org.threads.game.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayBoardImplTest {
    private PlayBoardImpl playBoard;

    @BeforeEach
    public void setUp() {
        playBoard = new PlayBoardImpl();
    }

    @Test
    void testCardGeneration() {
        int[][] card = playBoard.getCard();

        Assertions.assertEquals(3, card.length);

        for (int[] row : card) {
            Assertions.assertEquals(9, row.length);
            int count = 0;
            for (int number : row) {
                if (number != 0) {
                    count++;
                }
            }
            Assertions.assertEquals(5, count);
        }
    }

    @Test
    void testCloseNumber() {
        int numberToClose = playBoard.getCard()[0][0];
        playBoard.closeNumber(numberToClose);

        int[][] card = playBoard.getCard();
        boolean isClosed = false;
        for (int[] row : card) {
            for (int number : row) {
                if (number == -1) {
                    isClosed = true;
                }
            }
            Assertions.assertTrue(isClosed);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void testIsAllNumbersOnRowAreClosed(int rowId) {
        // У только что созданной карточки все числа в строке должны быть открыты
        Assertions.assertFalse(playBoard.isAllNumbersOnRowAreClosed());

        int[][] card = playBoard.getCard();
        int[] row = card[rowId];

        for (int number : row) {
            if (number != 0) {
                playBoard.closeNumber(number);
            }
        }
        playBoard.printCard();
        Assertions.assertTrue(playBoard.isAllNumbersOnRowAreClosed());
    }

    @Test
    void testIsAllNumbersOnCardClosed() {
        // У только что созданной карточки все числа должны быть открыты
        Assertions.assertFalse(playBoard.isAllNumbersOnCardClosed());

        for (int[] row : playBoard.getCard()) { // Закрываем все числа в карточке
            for (int number : row) {
                if (number != 0) {
                    playBoard.closeNumber(number);
                }
            }
        }
        playBoard.printCard();
        Assertions.assertTrue(playBoard.isAllNumbersOnCardClosed());
    }

    @Test
    void testPrintCard() {
        // Проверяем, что метод printCard не вызывает исключений
        Assertions.assertDoesNotThrow(() -> playBoard.printCard());
    }
}

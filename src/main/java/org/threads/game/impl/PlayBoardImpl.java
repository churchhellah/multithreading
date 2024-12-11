package org.threads.game.impl;

import lombok.Getter;
import org.threads.game.PlayBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
В игре принимают участие 90 бочонков. На каждом из бочонков нанесен его номер.
Все бочонки кладутся в специальный непрозрачный мешок и перед началом игры перемешиваются.

Игровая карточка состоит из трёх строк, в каждой из них по девять клеток, пять из которых занимают числа.
Пустые клетки для игры не предназначены.
Числа на одной карточке не могут повторяться.
При желании можно расположить числа на карточке в порядке возрастания (для удобства игрока).
 */
public class PlayBoardImpl implements PlayBoard {
    private final int ROWS = 3;
    private final int COLUMNS = 9;
    private final int NUMBERS_PER_ROW = 5;
    @Getter
    private final int[][] card = new int[ROWS][COLUMNS];

    public PlayBoardImpl() {
        generateCard();
    }

    private void generateCard() {
        // Создаем List и наполняем его числами от 1 до 90
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 90; i++) {
            numbers.add(i);
        }
        // Перемешиваем числа в List'е,
        // чтобы в PlayBoard они попадали в рандомном порядке
        Collections.shuffle(numbers);

        for (int row = 0; row < ROWS; row++) {
            // Выбираем случайные столбцы
            // в которых должны быть числа
            List<Integer> selectedColumns = new ArrayList<>();
            // Пока в строке заполнено до 5 столбцов
            while (selectedColumns.size() < NUMBERS_PER_ROW) {
                // Генерируем случайный столбец в диапазоне от 0 до 8
                int column = (int) (Math.random() * COLUMNS);
                // Если полученный случайный столбец еще не добавлен
                // то добавляем кго
                if (!selectedColumns.contains(column)) {
                    selectedColumns.add(column);
                }
            }
            // Сортируем полученные для карточки числа в порядке возрастания
            Collections.sort(selectedColumns);

            for (int col : selectedColumns) {
                // Берём число из перемешанного списка
                card[row][col] = numbers.remove(0);
            }
        }
    }

    @Override
    public void closeNumber(int number) {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j] == number) {
                    card[i][j] = -1;
                }
            }
        }
    }

    @Override
    public boolean isAllNumbersOnRowAreClosed() {
        int count = 0;
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j] == -1) {
                    count++;
                }
            }
            if (count == NUMBERS_PER_ROW) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isAllNumbersOnCardClosed() {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j] != -1 && card[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printCard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (card[row][col] == 0) {
                    System.out.print("     "); // Пустая клетка
                }
                else if (card[row][col] == -1) {
                    System.out.printf("%4s ", "[X]"); // Закрытая клетка
                }
                else {
                    System.out.printf("%4d ", card[row][col]); // Число
                }
            }
            System.out.println();
        }
    }
}
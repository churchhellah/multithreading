package org.threads.game.impl;

import org.threads.game.LottoKegs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
В игре принимают участие 90 бочонков. На каждом из бочонков нанесен его номер.
Все бочонки кладутся в специальный непрозрачный мешок и перед началом игры перемешиваются.
 */

public class LottoKegsImpl implements LottoKegs {
    private static LottoKegsImpl instance;
    private List<Integer> kegs;

    private LottoKegsImpl() {
        // Наполняем kegs числами от 1 до 90
        kegs = new ArrayList<>();
        for (int i = 1; i <= 90; i++) {
            kegs.add(i);
        }
        // Перемешиваем числа в List'е,
        // чтобы в kegs они попадали в рандомном порядке
        Collections.shuffle(kegs);
    }

    public static synchronized LottoKegsImpl getInstance() {
        if (instance == null) {
            instance = new LottoKegsImpl();
        }
        return instance;
    }

    // Получаем номер рандомного бочонка из мешка
    @Override
    public int getLottoKegNumber() {
        return kegs.remove((int) Math.random() * kegs.size());
    }
}

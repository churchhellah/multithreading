package org.threads.game.impl;

import org.threads.game.GameMaster;

/*
Ведущий достаёт из мешка один из бочонков.
 */

public class GameMasterImpl implements GameMaster {
    private LottoKegsImpl lottoKegs = LottoKegsImpl.getInstance();

    @Override
    public int getLottoKeg() {
        return lottoKegs.getLottoKegNumber();
    }
}

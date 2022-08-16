package com.money.repository.impl;

import com.money.repository.IChangerMoneyRepository;
import org.springframework.stereotype.Service;

@Service
public class ChangerMoneyRepository implements IChangerMoneyRepository {
    private final int RATE = 23000;
    @Override
    public int changerMoney(int usd) {
        int vnd = usd * RATE;
        return vnd;
    }
}

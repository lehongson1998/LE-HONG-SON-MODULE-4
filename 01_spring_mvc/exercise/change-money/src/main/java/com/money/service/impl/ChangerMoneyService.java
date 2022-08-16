package com.money.service.impl;

import com.money.repository.IChangerMoneyRepository;
import com.money.repository.impl.ChangerMoneyRepository;
import com.money.service.IChangerMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangerMoneyService implements IChangerMoneyService {

    @Autowired
    private IChangerMoneyRepository changerMoneyRepository;
    @Override
    public int changerMoney(int usd) {
        return changerMoneyRepository.changerMoney(usd);
    }
}

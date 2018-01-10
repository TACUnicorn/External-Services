package com.external.bank.service;

import com.external.bank.mapper.BankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    @Autowired
    private BankMapper bankMapper;

    @Transactional
    public void change(String fromAcount, String toAcount, Float sum){

        bankMapper.reduceBalance(fromAcount, sum);
        bankMapper.addBalance(toAcount, sum);

    }

    public Float getBalance(String id){
        return bankMapper.getBalance(id);
    }
}

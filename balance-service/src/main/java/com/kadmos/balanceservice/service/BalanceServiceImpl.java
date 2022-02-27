package com.kadmos.balanceservice.service;

import com.kadmos.balanceservice.controller.dto.BalanceDTO;
import com.kadmos.balanceservice.model.AccountMaster;
import com.kadmos.balanceservice.repo.BalanceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import java.util.Optional;

@Service
public class BalanceServiceImpl implements BalanceService {
    private final BalanceRepository balanceRepository;

    public BalanceServiceImpl(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AccountMaster> findById(String id) {
        return balanceRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public AccountMaster update(String accountId, BalanceDTO entity) throws Exception {
        AccountMaster item = balanceRepository.findById(accountId).orElseThrow(Exception::new);
        item.setAmount(item.getAmount() + entity.getAmountChange());
        return balanceRepository.save(item);
    }
}

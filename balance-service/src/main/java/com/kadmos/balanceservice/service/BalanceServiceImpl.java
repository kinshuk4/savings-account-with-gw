package com.kadmos.balanceservice.service;

import com.kadmos.balanceservice.controller.dto.BalanceDTO;
import com.kadmos.balanceservice.exception.AccountNotFound;
import com.kadmos.balanceservice.exception.InsufficientBalanceException;
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
    public AccountMaster update(String accountId, BalanceDTO entity) throws AccountNotFound, InsufficientBalanceException {
        AccountMaster accountMaster = balanceRepository.findById(accountId).orElseThrow(AccountNotFound::new);
        if (entity.getAmount() < 0 && Math.abs(entity.getAmount()) > accountMaster.getBalance()){
            throw new InsufficientBalanceException();
        }

        accountMaster.setBalance(accountMaster.getBalance() + entity.getAmount());
        return balanceRepository.save(accountMaster);
    }
}

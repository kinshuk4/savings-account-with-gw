package com.kadmos.balanceservice.service;

import com.kadmos.balanceservice.controller.dto.BalanceDTO;
import com.kadmos.balanceservice.model.AccountMaster;
import com.kadmos.balanceservice.repo.BalanceRepository;

import java.util.Optional;

public interface BalanceService {
    Optional<AccountMaster> findById(String id);
    AccountMaster update(String accountId, BalanceDTO entity) throws Exception;
}

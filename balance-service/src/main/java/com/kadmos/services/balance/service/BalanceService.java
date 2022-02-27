package com.kadmos.services.balance.service;

import com.kadmos.services.balance.controller.dto.BalanceDTO;
import com.kadmos.services.balance.model.AccountMaster;

import java.util.Optional;

public interface BalanceService {
    Optional<AccountMaster> findById(String id);
    AccountMaster update(String accountId, BalanceDTO entity) throws Exception;
}

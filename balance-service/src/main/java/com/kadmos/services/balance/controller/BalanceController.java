package com.kadmos.services.balance.controller;

import com.kadmos.services.balance.controller.dto.BalanceDTO;
import com.kadmos.services.balance.model.AccountMaster;
import com.kadmos.services.balance.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

// TODO: can use mapper for DTO to model and vice versa
@RestController
public class BalanceController {
    private final BalanceService balanceService;

    @Value("${ACCOUNT_ID}")
    private String accountId;

    @Autowired
    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/balance")
    public AccountMaster getBalanceForAccount() throws Exception {
        return balanceService.findById(accountId).orElseThrow(Exception::new);
    }

    @PostMapping("/balance")
    public AccountMaster updateBalance(@RequestBody BalanceDTO balanceDTO) throws Exception {
        return balanceService.update(accountId, balanceDTO);
    }
}

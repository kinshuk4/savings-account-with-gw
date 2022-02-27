package com.kadmos.services.balance.controller;

import com.kadmos.services.balance.controller.dto.BalanceDTO;
import com.kadmos.services.balance.model.AccountMaster;
import com.kadmos.services.balance.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// TODO: can use mapper for DTO to model and vice versa
@RestController
public class BalanceController {
    private final BalanceService balanceService;

    @Autowired
    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/savings/{accountId}/balance")
    public BalanceDTO getBalanceForAccount(@PathVariable("accountId") String accountId) throws Exception {
        AccountMaster accountMaster = balanceService.findById(accountId).orElseThrow(Exception::new);
        return new BalanceDTO(accountMaster.getBalance());
    }

    @PostMapping("/savings/{accountId}/balance")
    public BalanceDTO updateBalance(@PathVariable("accountId") String accountId, @RequestBody BalanceDTO balanceDTO) throws Exception {
        AccountMaster accountMaster = balanceService.update(accountId, balanceDTO);
        return new BalanceDTO(accountMaster.getBalance());
    }
}

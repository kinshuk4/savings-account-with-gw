package com.kadmos.services.balance.repo;

import com.kadmos.services.balance.model.AccountMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<AccountMaster, String> {

}

package com.kadmos.balanceservice.repo;

import com.kadmos.balanceservice.model.AccountMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<AccountMaster, String> {

}

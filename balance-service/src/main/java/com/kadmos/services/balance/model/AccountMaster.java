package com.kadmos.services.balance.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountMaster {
    private static final long serialVersionUID = 1L;

    @Id
    private String accountId;
    private double balance;
}

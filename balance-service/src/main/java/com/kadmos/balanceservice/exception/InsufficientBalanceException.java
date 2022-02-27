package com.kadmos.balanceservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "insufficient balance in account")
public class InsufficientBalanceException extends RuntimeException {
}

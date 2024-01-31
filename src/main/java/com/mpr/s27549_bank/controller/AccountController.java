package com.mpr.s27549_bank.controller;

import com.mpr.s27549_bank.exception.ValidationException;
import com.mpr.s27549_bank.model.Account;
import com.mpr.s27549_bank.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;
    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        try {
            List<Account> allAccounts = accountService.getAllAccounts();
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(allAccounts);
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }

    //http://localhost:8080/account/{id}
    @GetMapping
    public ResponseEntity<Account> getAccountByParam(@RequestParam(required = true) Integer id) {
        try {
            Account account = accountService.getById(id);
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(account);
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }

    //http://localhost:8080/account?id={id}
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountByPathVariable(@PathVariable Integer id) {
        try {
            Account account = accountService.getById(id);
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(account);
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        try {
            Account createdAccount = accountService.create(account);
            return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(createdAccount);
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).build();
        }
    }


}

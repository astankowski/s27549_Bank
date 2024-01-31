package com.mpr.s27549_bank.controller;

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
        List<Account> allAccounts = accountService.getAllAccounts();

        return ResponseEntity.ok(allAccounts);
    }

    //http://localhost:8080/account/{id}
    @GetMapping
    public ResponseEntity<Account> getAccountByParam(@RequestParam(required = true) Integer id) {
        Account account = accountService.getById(id);

        return ResponseEntity.ok(account);
    }

    //http://localhost:8080/account?id={id}
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountByPathVariable(@PathVariable Integer id) {
        Account account = accountService.getById(id);

        return ResponseEntity.ok(account);
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.create(account);;

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(createdAccount);
    }


}

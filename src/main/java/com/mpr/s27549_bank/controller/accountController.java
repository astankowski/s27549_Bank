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
public class accountController {
    private AccountService accountService;
    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> allAccounts = accountService.getAllAccounts();

        return ResponseEntity.ok(allAccounts);
    }

    @GetMapping
    public ResponseEntity<Account> getAccountByParam(@RequestParam(required = false) Integer id) {
        Account account = accountService.getById(id);

        return ResponseEntity.ok(account);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountByPathVariable(@PathVariable Integer id) {
        Account account = accountService.getById(id);

        return ResponseEntity.ok(account);
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = null;
        createdAccount = accountService.create(account);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(createdAccount);

//        try {
//            createdAccount = accountService.create(account);
//            return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(createdAccount);
//        } catch (HttpClientErrorException e){
//            return ResponseEntity.badRequest().build();
//        }
    }


}

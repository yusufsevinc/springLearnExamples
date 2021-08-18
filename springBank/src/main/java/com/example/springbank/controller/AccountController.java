package com.example.springbank.controller;

import com.example.springbank.dto.AccountDto;
import com.example.springbank.dto.CreateAccountRequest;
import com.example.springbank.dto.UpdateAccountRequest;
import com.example.springbank.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable  String id){
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountRequest createAccountRequest){
        return ResponseEntity.ok(accountService.createAccount(createAccountRequest));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable String id ,@RequestBody UpdateAccountRequest request){
        return ResponseEntity.ok(accountService.updateAccount(id,request));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping(value = "/withdraw/{id}/{amount}")
    public ResponseEntity<AccountDto> withdrawMoney(@PathVariable String id ,@PathVariable Double amount){
        return ResponseEntity.ok(accountService.withdrawMoney(id,amount));
    }

    @PutMapping(value = "/add/{id}/{amount}")
    public ResponseEntity<AccountDto> addMoney(@PathVariable String id ,@PathVariable Double amount){
        return ResponseEntity.ok(accountService.addMoney(id,amount));
    }
}

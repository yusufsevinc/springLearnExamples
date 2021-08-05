package com.example.springbank.service;

import com.example.springbank.dto.*;
import com.example.springbank.model.Account;
import com.example.springbank.model.Customer;
import com.example.springbank.repository.AccountRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter accountDtoConverter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConverter accountDtoConverter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;

        this.accountDtoConverter = accountDtoConverter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.getCustomerById(createAccountRequest.getId());
        if (customer.getId() == null || customer.getId() == "") {
            throw new NullPointerException();
        } else {
            Account account = new Account();
            account.setId(createAccountRequest.getId());
            account.setBalance(createAccountRequest.getBalance());
            account.setCurrency(createAccountRequest.getCurrency());
            account.setCustomerId(createAccountRequest.getCustomerId());
            account.setCity(createAccountRequest.getCity());

            return accountDtoConverter.convert(accountRepository.save(account));
        }
    }
        public AccountDto updateAccount(String id , UpdateAccountRequest request){
            Customer customer = customerService.getCustomerById(request.getCustomerId());
            if (customer.getId() == null || customer.getId() == "") {
                throw new NullPointerException();
            }else{
                Optional<Account> accountOptional = accountRepository.findById(id);
                accountOptional.ifPresent(account -> {
                    account.setBalance(request.getBalance());
                    account.setCity(request.getCity());
                    account.setCurrency(request.getCurrency());
                    account.setCustomerId(request.getCustomerId());
                    accountRepository.save(account);
                });
                return accountOptional.map(accountDtoConverter::convert).orElse(new AccountDto());
            }
        }

        public List<AccountDto> getAllAccounts(){
            List<Account> accountList = accountRepository.findAll();
           return accountList.stream().map(accountDtoConverter::convert).collect(Collectors.toList());

        }
        public  AccountDto getAccountById(String id){
        return accountRepository.findById(id).map(accountDtoConverter::convert).orElse(new AccountDto());
        }


        public void deleteAccount(String id){
            accountRepository.deleteById(id);
        }

        public AccountDto withdrawMoney(String id , Double amount){
        Optional<Account> accountOptional = accountRepository.findById(id);
        accountOptional.ifPresent(account ->
        {
            if (account.getBalance() >= amount){
                account.setBalance(account.getBalance() - amount);
                accountRepository.save(account);
            }else {
                System.out.println("FAİL");
            }
        });
        return accountOptional.map(accountDtoConverter::convert).orElse(new AccountDto());
        }

    public AccountDto addMoney(String id , Double amount){
        Optional<Account> accountOptional = accountRepository.findById(id);
        accountOptional.ifPresent(account ->
        {

                account.setBalance(account.getBalance() + amount);
                accountRepository.save(account);

        });
        return accountOptional.map(accountDtoConverter::convert).orElse(new AccountDto());
    }



}

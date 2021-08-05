package com.example.springbank.dto;

import com.example.springbank.model.Account;
import com.example.springbank.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoConverter {

    public  AccountDto convert(Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setBalance(account.getBalance());
        accountDto.setCurrency(account.getCurrency());
        accountDto.setCustomerId(account.getCustomerId());

        return accountDto;
    }


}

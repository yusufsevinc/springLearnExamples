package com.spring.placeholder.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Database {

    private String url;
    private String username;
    private String password;



    public void openConnection(){
        System.out.println("URL: " + url + "\n" +
                "Username: " + username + "\n" +
                "Password: " + password );

        System.out.println("Bağlantı açıldı...");

    }

    public void closeConnection(){
        System.out.println("Bağlantı kapatıldı...");
    }

}

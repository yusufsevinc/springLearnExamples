package com.spring.required.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Required;

@Getter
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

    @Required
    public void setUrl(String url) {
        this.url = url;
    }
    @Required
    public void setUsername(String username) {
        this.username = username;
    }
    @Required
    public void setPassword(String password) {
        this.password = password;
    }
}

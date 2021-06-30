package com.spring.beanpostprocesor.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DBConnection {

    private String url;
    private String username;
    private String password;

    private void validation(){
        if (this.url == null
        || this.password == null
        || this.username == null){

            System.err.println("Girilen değer Null...");

            throw new NullPointerException("Eksik değer girildi..");
        }else{
            System.out.println("Bütün değerler girildi...");
        }
    }

    public void openConnection(){
        System.out.println("URL: " + url + "\n" +
                "Username: " + username + "\n" +
                "Password: " + password);

        System.out.println("Bağlantı açıldı...");

    }

    public void closeConnection(){
        System.out.println("Bağlantı kapatıldı...");
    }

}

package com.spring.autowired.db;

import com.spring.autowired.model.Database;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DBConnection {

    @Autowired
    private Database database;

    @Autowired
    private Database database2;

    public void openConnection() {


        System.out.println("Bağlantı açıldı...");

    }

    public void closeConnection() {
        System.out.println("Bağlantı kapatıldı...");
    }

    public void getDBInfo() {

        System.out.println("URL: " + database.getUrl() + "\n" +
                "Username: " + database.getUsername() + "\n" +
                "Password: " + database.getPassword());
        System.out.println("***********************\n" +
                "***********************\n" +
                "***********************");

        System.out.println("URL: " + database2.getUrl() + "\n" +
                "Username: " + database2.getUsername() + "\n" +
                "Password: " + database2.getPassword());


    }

}

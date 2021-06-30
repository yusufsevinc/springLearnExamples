package com.spring.component.db;

import com.spring.component.model.Database;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.management.DescriptorKey;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component(value = "dbConnect")
public class DBConnection {

    @Autowired
    private Database database;

    @PostConstruct
    public void openConnection() {


        System.out.println("Bağlantı açıldı...");

    }
    @PreDestroy
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



    }

}

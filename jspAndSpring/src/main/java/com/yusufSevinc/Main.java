package com.yusufSevinc;

import com.yusufSevinc.model.User;
import com.yusufSevinc.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main  implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class ,args);
        System.out.println("asdsad");
    }

    @Override
    public void run(String... args) throws Exception {
        User yusuf = new User(1L ,"Yusuf" , "Sevinç");
        userRepository.addUser(yusuf);

        User ali = new User(2L ,"Ali" , "Korkmaz");
        userRepository.addUser(ali);

        User burak = new User(3L ,"Burak" , "Ünlü");
        userRepository.addUser(burak);

        User cahit = new User(4L ,"Cahit" , "Araf");
        userRepository.addUser(cahit);

    }
}

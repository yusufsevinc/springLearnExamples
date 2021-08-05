package com.yusufSevinc.repository;

import com.yusufSevinc.model.User;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserRepository {

    private List<User> users = new ArrayList<User>();

    public void addUser(User user){
        users.add(user);

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

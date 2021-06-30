package com.spring.event.event;

import com.spring.event.model.User;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


public class UserSendMailEvent extends ApplicationEvent {

   private String title;
   private  String content;
   private User user;

    public UserSendMailEvent(User user ,String title ,String content) {
        super(user);
        this.user = user;
        this.title = title;
        this.content = content;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

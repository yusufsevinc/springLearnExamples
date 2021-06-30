package com.spring.event.publisher;

import com.spring.event.event.UserSendMailEvent;
import com.spring.event.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component(value = "userSendMailPublisher")
public class UserSendMailPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void userRegisterMessage(){
        String title = "Kayıt onay mesajı";
        String content ="Kaydı tamamlamak için aşağıdaki bilgilere tıklayınız...";

        User user = new User("1yusufsevinc@gmail.com" , "12345" , "yusuf", "sevinc");

        UserSendMailEvent sendMailEvent = new UserSendMailEvent(user , title ,content);

        this.applicationEventPublisher.publishEvent(sendMailEvent);
    }
}

package com.spring.event.listener;

import com.spring.event.event.UserSendMailEvent;
import com.spring.event.model.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component(value = "userSendMailListener")
public class UserSendMailListener  implements ApplicationListener<UserSendMailEvent> {
    @Override
    public void onApplicationEvent(UserSendMailEvent userSendMailEvent) {
        User user = userSendMailEvent.getUser();
        System.out.println("Mail gönderilecek user bilgileri...");

        System.out.println(user);
        System.out.println("Mail başlığı: " + userSendMailEvent.getTitle());
        System.out.println("Mail içeriği: " + userSendMailEvent.getContent());
    }
}

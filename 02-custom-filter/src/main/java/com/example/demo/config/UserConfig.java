package com.example.demo.config;

import com.example.demo.model.MyUser;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "users")
public class UserConfig {

    private List<MyUser> userList = Collections.EMPTY_LIST;

    public List<MyUser> getUserList() {
        return userList;
    }

    public void setUserList(List<MyUser> userList) {
        this.userList = userList;
    }
}

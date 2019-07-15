package com.example.demo.service;

import com.example.demo.config.UserConfig;
import com.example.demo.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 获取用户实体类
 * 实际应用中一般从数据库中读取用户信息，
 * 但在这个列子中我们从配置文件读取用户信息
 */
@Service
public class MyUserService {

    @Autowired
    private UserConfig userConfig;

    public MyUser getUserWithName(String name) {
        List<MyUser> userList = userConfig.getUserList();
        for (int i = 0; i < userList.size(); i++) {
            if (name.equals(userList.get(i).getUsername())) {
                return userList.get(i);
            }
        }
        return null;
    }
}

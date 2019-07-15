package com.example.demo.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    public MyAuthenticationFailureHandler(String defaultFailureUrl){
        super(defaultFailureUrl);
    }

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            request.getSession().setAttribute("loginerror", "用户名或密码错误！");
        }
        super.onAuthenticationFailure(request, response, exception);
        // request.getRequestDispatcher("/login").forward(request, response);
    }
}


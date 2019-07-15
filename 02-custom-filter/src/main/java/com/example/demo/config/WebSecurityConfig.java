package com.example.demo.config;

import com.example.demo.handler.MyAuthenticationFailureHandler;
import com.example.demo.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    /**
     * 用于配置用户具体权限
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 定义一个密码编码器,采用单向不可逆的加密方式
         * 用于对用户输入的密码进行加密并与存储的密码进行对比（SpringSecurity5 中必须使用）
         * 由于在这个例子中我们使用的是明文，所以其实这个密码编码器并没有做什么事情
         */
        PasswordEncoder myPasswordEncoder = new MyPasswordEncoder();
        //定义用户名，密码，以及用户对应权限等
        auth.userDetailsService(myUserDetailsService).passwordEncoder(myPasswordEncoder);
    }

    /**
     * 用于配置具体需要拦截的请求
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //允许访问静态资源
                .antMatchers("/bootstrap/**", "/img/**").permitAll()
                //登录登出页不做拦截
                .antMatchers("/login", "/logout").permitAll()
                //index页和user下页面需要USER 或 ADMIN 角色才可以访问
                .antMatchers("/index", "/user/**").hasAnyRole("USER", "ADMIN")
                //admin下页面需要 ADMIN 角色才可访问
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                //其他任意资源登录认证之后才可访问
                .anyRequest().authenticated()
                .and()
                //配置自定义登录页和登录成功默认跳转页
                .formLogin().loginPage("/login").defaultSuccessUrl("/index")
                .failureHandler(new MyAuthenticationFailureHandler("/login?error"))
                .and()
                //配置登出url以及登出成功后的页面
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }

}

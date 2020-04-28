package com.demo.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity // 这个注解必须加，开启Security
@EnableGlobalMethodSecurity(prePostEnabled = true)//保证post之前的注解可以使用
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  AuthorizationTokenFilter authenticationTokenFilter;
  
  //拦截策略
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
    	.headers().frameOptions().disable().and()
    	.exceptionHandling() //验证失败后的处理
        .and()
        .authorizeRequests()
        //.antMatchers("/decision/**","/govern/**","/employee/*").hasAnyRole("EMPLOYEE","ADMIN")//对decision和govern 下的接口 需要 USER 或者 ADMIN 权限
        //.antMatchers("/employee/login").permitAll()///employee/login 不限定
        //.antMatchers("/admin/**").hasRole("ADMIN")//对admin下的接口 需要ADMIN权限
        //.antMatchers("/oauth/**").permitAll()//不拦截 oauth 开放的资源
        //swagger 允许访问 
        .regexMatchers("/doc/.*","/swagger-ui.*","/static/*.jpg").permitAll()
        .antMatchers("/static/**","/webjars/**","/test/login","/swagger-resources/**","/v2/**").permitAll()
        .antMatchers("/","/login","/loginPage","/index","/main/**").permitAll()
        //.antMatchers(HttpMethod.GET,"/main?page=*").permitAll()
        //.antMatchers("/haha").permitAll() // 对于获取token的rest api要允许匿名访问
        //.antMatchers("/sysUser/test").permitAll() 
        //.antMatchers(HttpMethod.OPTIONS, "/**").anonymous() //对前后端分离的时候前端过来的第一次验证请求
        .anyRequest().authenticated()    // 剩下所有配置权限的请求都需要验证
        //.and().anonymous()//对于没有配置权限的其他请求允许匿名访问
        .and().formLogin()
        .loginPage("/loginPage")//使用 指定登录页面登录页面允许访问
        .and()
        .csrf().disable()       // 禁用 Spring Security 自带的跨域处理
        // 定制我们自己的 session 策略：调整为让 Spring Security 不创建和使用 session
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .sessionFixation().none();
      

    http.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    // 禁用缓存
    http.headers().cacheControl();

  }

  @Bean
  public PasswordEncoder passwordEncoderBean() {
    return new BCryptPasswordEncoder();
  }
  

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

}

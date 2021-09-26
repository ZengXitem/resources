package cn.cinz.admin.config;//package cn.cinz.cyxx.config;
//
//import cn.cinz.cyxx.common.EUser;
//import cn.cinz.cyxx.pojo.User;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
///**
// * spring security 权限认证配置类
// *
// * @Author: zengcheng
// * @Description: 认证权限 控制用户访问资源
// * @Date: 2021/9/11 9:16
// */
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    //授权
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        //首页所有人可以访问 登陆页可以访问
//        http.authorizeRequests().antMatchers("/").permitAll()
//            .antMatchers("/login").permitAll()
//            .antMatchers("/error").permitAll()
//            .antMatchers("/user/**").hasRole("/user/home")  //只有普通用户可以访问 /user/**下的所有资源
//            .antMatchers("/admin/**").hasRole(EUser.管理员.getName()) //只有管理员才能访问 /admin/** 下的所有资源
//        ;
//
//
//        http.formLogin();
//
//    }
//
//    //认证
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("admin")
//                .password(new BCryptPasswordEncoder().encode("admin"))
//                .roles(EUser.普通用户.getName())
//        ;
//
//
//        super.configure(auth);
//    }
//}

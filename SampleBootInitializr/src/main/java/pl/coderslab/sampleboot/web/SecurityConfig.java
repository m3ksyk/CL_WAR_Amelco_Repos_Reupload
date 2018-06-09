package pl.coderslab.sampleboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.sampleboot.service.SpringDataUserDetailsService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private BCryptPasswordEncoder encoder;

    @Autowired
    private DataSource dataSource;

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
////                .withUser("test").password(encoder.encode("zxc123")).roles("USER");
//    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password(encoder.encode("user123")).roles("USER")
//                .and()
//                .withUser("admin1").password(encoder.encode("admin123")).roles("ADMIN")
//                .and()
//                .withUser("mod1").password(encoder.encode("moder123")).roles("MODERATOR");
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/all", "/view").permitAll()
//                .antMatchers("/restricted").authenticated()
//                .antMatchers("/moderator/**").hasRole("MODERATOR")
//                .antMatchers("/remove").hasAnyRole("MODERATOR","USER")
//                .antMatchers("/update").hasRole("USER")
//                .and().httpBasic();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").anonymous()
                .antMatchers("/panel", "/logout").authenticated()
                .antMatchers("/restricted").hasRole("ADMIN")
                .anyRequest().denyAll()
                .and()
                .formLogin()
                .defaultSuccessUrl("/panel")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and().exceptionHandling().accessDeniedPage("/403");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {

        return new SpringDataUserDetailsService();
    }
}
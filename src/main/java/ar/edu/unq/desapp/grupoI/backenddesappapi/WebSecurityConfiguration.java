package ar.edu.unq.desapp.grupoi.backenddesappapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/review/newReview").permitAll()
                .antMatchers(HttpMethod.POST, "/newReview").permitAll()
                .antMatchers(HttpMethod.POST, "/newReview").permitAll()
                .antMatchers(HttpMethod.POST, "/newuser/*").permitAll()
                .antMatchers(HttpMethod.GET, "/hello").permitAll()
                .antMatchers(HttpMethod.GET, "/review/hello").permitAll()
                .anyRequest().authenticated();
    }
}

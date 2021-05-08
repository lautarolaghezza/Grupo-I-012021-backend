package ar.edu.unq.desapp.grupoi.backenddesappapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        System.out.println("entre aca");
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/review/newReview").permitAll()
                .antMatchers(HttpMethod.POST, "/newReview").permitAll()
                .antMatchers(HttpMethod.POST, "/newReview").permitAll()
                .antMatchers(HttpMethod.POST, "/publicReview").permitAll()
                .antMatchers(HttpMethod.POST, "/premiumReview").permitAll()
                .antMatchers(HttpMethod.GET, "/hello").permitAll()
                .antMatchers(HttpMethod.GET, "/reviews").permitAll()
                .antMatchers(HttpMethod.GET, "/review/*").permitAll()
                .antMatchers(HttpMethod.GET, "/review/title/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/hello").permitAll()
                .anyRequest().authenticated();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}

package ar.edu.unq.desapp.grupoi.backenddesappapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
                .antMatchers(HttpMethod.POST, "/review/filters").permitAll()
                .antMatchers(HttpMethod.POST, "/valoration").permitAll()
                .antMatchers(HttpMethod.POST, "/report/review").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.POST, "/register").permitAll()
                .antMatchers(HttpMethod.GET, "/generate-token").permitAll()
                .antMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()
                .antMatchers(HttpMethod.GET, "/swagger-ui.html/*").permitAll()
                .antMatchers(HttpMethod.GET, "/swagger-ui/*").permitAll()
                .antMatchers(HttpMethod.GET, "/webjarsi/*").permitAll()
                .antMatchers(HttpMethod.GET, "/reviews").permitAll()
                .antMatchers(HttpMethod.GET, "/valorations").permitAll()
                .antMatchers(HttpMethod.GET, "/valorations/*").permitAll()
                .antMatchers(HttpMethod.GET, "/valorations/review/*").permitAll()
                .antMatchers(HttpMethod.GET, "/users").permitAll()
                .antMatchers(HttpMethod.GET, "/users/*").permitAll()
                .antMatchers(HttpMethod.GET, "/users/location/*").permitAll()
                .antMatchers(HttpMethod.GET, "/users/platform/*").permitAll()
                .antMatchers(HttpMethod.GET, "/users/typeuser/*").permitAll()
                .antMatchers(HttpMethod.GET, "/review/*").permitAll()
                .antMatchers(HttpMethod.GET, "/review/title/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/hello").permitAll()
                .antMatchers(HttpMethod.GET, "/titles").permitAll()
                .antMatchers(HttpMethod.GET, "/titles/**").permitAll()
                .antMatchers(HttpMethod.GET, "/titles/findAny/**").permitAll()
                .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**").permitAll()
                .anyRequest().authenticated();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000")); //or add * to allow all origins
        configuration.setAllowCredentials(true);
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")); //to set allowed http methods
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setExposedHeaders(Arrays.asList("custom-header1", "custom-header2"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}

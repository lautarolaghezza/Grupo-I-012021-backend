package ar.edu.unq.desapp.grupoi.backenddesappapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        http.csrf().disable().cors().configurationSource(corsConfigurationSource());

       // http.csrf().disable().authorizeRequests()
       //         .antMatchers("/").permitAll()
       //         .antMatchers(HttpMethod.POST, "/review/newReview").permitAll()
       //         .antMatchers(HttpMethod.POST, "/newReview").permitAll()
       //         .antMatchers(HttpMethod.POST, "/newReview").permitAll()
       //         .antMatchers(HttpMethod.POST, "/publicReview").permitAll()
       //         .antMatchers(HttpMethod.POST, "/premiumReview").permitAll()
       //         .antMatchers(HttpMethod.POST, "/review/filters").permitAll()
       //         .antMatchers(HttpMethod.POST, "/valoration").permitAll()
       //         .antMatchers(HttpMethod.POST, "/report/review").permitAll()
       //         .antMatchers(HttpMethod.POST, "/login").permitAll()
       //         .antMatchers(HttpMethod.POST, "/register").permitAll()
       //         .antMatchers(HttpMethod.GET, "/generate-token").permitAll()
       //         .antMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()
       //         .antMatchers(HttpMethod.GET, "/swagger-ui.html/*").permitAll()
       //         .antMatchers(HttpMethod.GET, "/swagger-ui/*").permitAll()
       //         .antMatchers(HttpMethod.GET, "/webjarsi/*").permitAll()
       //         .antMatchers(HttpMethod.GET, "/reviews").permitAll()
       //         .antMatchers(HttpMethod.GET, "/reviewscr").permitAll()
       //         .antMatchers(HttpMethod.GET, "/valorations").permitAll()
       //         .antMatchers(HttpMethod.GET, "/valorations/*").permitAll()
       //         .antMatchers(HttpMethod.GET, "/valorations/review/*").permitAll()
       //         .antMatchers(HttpMethod.GET, "/users").permitAll()
       //         .antMatchers(HttpMethod.GET, "/users/*").permitAll()
       //         .antMatchers(HttpMethod.GET, "/users/location/*").permitAll()
       //         .antMatchers(HttpMethod.GET, "/users/platform/*").permitAll()
       //         .antMatchers(HttpMethod.GET, "/users/typeuser/*").permitAll()
       //         .antMatchers(HttpMethod.GET, "/review/*").permitAll()
       //         .antMatchers(HttpMethod.GET, "/review/title/*").permitAll()
       //         .antMatchers(HttpMethod.GET, "/api/hello").permitAll()
       //         .antMatchers(HttpMethod.GET, "/titles").permitAll()
       //         .antMatchers(HttpMethod.GET, "/titles/**").permitAll()
       //         .antMatchers(HttpMethod.GET, "/titles/findAny/**").permitAll()
       //         .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**").permitAll()
       //         .anyRequest().authenticated();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH"));
        configuration.setAllowCredentials(false);
        //the below three lines will add the relevant CORS response headers
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

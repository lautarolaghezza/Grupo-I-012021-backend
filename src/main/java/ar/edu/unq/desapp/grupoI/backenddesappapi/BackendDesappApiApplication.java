package ar.edu.unq.desapp.grupoi.backenddesappapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableScheduling
public class BackendDesappApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendDesappApiApplication.class, args);
    }

}


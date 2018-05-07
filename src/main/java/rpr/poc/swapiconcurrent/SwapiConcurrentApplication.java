package rpr.poc.swapiconcurrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring boot start application class.
 */
@EnableFeignClients
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"rpr.poc.swapiconcurrent.*"})
public class SwapiConcurrentApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SwapiConcurrentApplication.class, args);
    }
}

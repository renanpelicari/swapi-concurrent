package rpr.poc.swapiconcurrent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * The Swagger config.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String CONTACT_NAME = "Renan Peliçari Rodrigues";
    private static final String CONTACT_URL = "https://github.com/renanpelicari/";
    private static final String CONTACT_MAIL = "renanpelicari@gmail.com";
    private static final String API_TITLE = "Concurrent/Async POC";
    private static final String API_DESCRIPTION = "POC to show how to perform async requests to Star Wars API";
    private static final String API_VERSION = "1.0";

    /**
     * API Configuration and Information
     *
     * @return the {@link Docket}
     */
    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("CONCURRENT-POC")
            .apiInfo(metadata())
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(regex("/application/api/*.*"))
            .build()
            .pathMapping("/")
            .apiInfo(metadata());
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
            .title(API_TITLE)
            .description(API_DESCRIPTION)
            .version(API_VERSION)
            .contact(new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_MAIL))
            .build();
    }
}

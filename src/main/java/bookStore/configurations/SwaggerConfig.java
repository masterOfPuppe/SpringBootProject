package bookStore.configurations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private final static String SWAGGER_API_VERSION = "1.0";
    private final static String LICENSE_TEXT = "License";
    private final static String title = "Book Store API";
    private final static String description = "RestAPI to manage the book store";

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(title)
                .version(SWAGGER_API_VERSION)
                .description(description)
                .license(LICENSE_TEXT)
                .build();
    }

    // With RequestHandlerSelectors.basePackage("bookStore") you are specify
    // that the Swagger has to consider only bookStore package to create documentation
    @Bean
    public Docket bookStoreDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("bookStore"))
                .paths(PathSelectors.any())
                .build();
    }
}

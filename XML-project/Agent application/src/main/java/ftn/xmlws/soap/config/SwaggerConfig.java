package ftn.xmlws.soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Class for configurating swagger
 *
 * @author sansajn
 *
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String TITLE = "WS XML API";
    private static final String DESCRIPTION = "API Service for XML";
    private static final String VERSION = "v1.0";
    private static final String TERMS = "";
    private static final String CONTACT_NAME = "Nemanja Mudrinic";
    private static final String LICENCE_URL = "";
    private static final String LICENCE_URLS = "";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/api.*")).build().apiInfo(metaData());
    }

    private ApiInfo metaData(){
        ApiInfo apiInfo = new ApiInfo(
                TITLE,
                DESCRIPTION,
                VERSION,
                TERMS,
                CONTACT_NAME,
                LICENCE_URL,
                LICENCE_URLS);
        return apiInfo;
    }



}

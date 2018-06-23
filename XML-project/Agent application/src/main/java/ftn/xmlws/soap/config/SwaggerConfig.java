package ftn.xmlws.soap.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

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

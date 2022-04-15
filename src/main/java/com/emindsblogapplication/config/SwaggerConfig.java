package com.emindsblogapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@Configuration
public class SwaggerConfig {


   private ApiInfo apiInfo(){

       return  new ApiInfo(

               "Blog Rest Apis",
               "Springboot Blog Rest APi Documentation",
               "1",
               "terms of service",
               new Contact("vijay","www.eminds.com","vijayyes15@yahoo.com"),
               "License Of Api",
               "API License Url",
               Collections.emptyList()
       );

   }

   @Bean
   public Docket api(){

       return new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(apiInfo())
               .select()
               .apis(RequestHandlerSelectors.any())
               .paths(PathSelectors.any())
               .build();

   }

}

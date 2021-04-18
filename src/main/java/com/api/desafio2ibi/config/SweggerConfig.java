package com.api.desafio2ibi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SweggerConfig {
	
	private Contact contact = new Contact("Euclides Rosario de Aevedo", "", "Euclidesdeazevedo@protonmail.com");
	  private ApiInfo apiInfo = new ApiInfo(
	      "Documentacao da api do desafio da 2IBI",
	      "esta pagina apresenta a documentacao do da api proposto pela 2ibi,  RESTful api Endpoints",
	      "1.0",
	      "",
	      contact,
	      "",
	      "");

	 @Bean
	    public Docket api() {
	        
	        return new Docket(DocumentationType.SWAGGER_2).select()
	                 .apis(RequestHandlerSelectors.any())
	                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
	                .paths(PathSelectors.any())
	                
	                .build().apiInfo(apiInfo);
	       
	    }
}

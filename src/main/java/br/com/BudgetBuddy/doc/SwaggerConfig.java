package br.com.BudgetBuddy.doc;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import springfox.documentation.service.Contact;

import java.util.Arrays;
import java.util.HashSet;


@Configuration
public class SwaggerConfig {


    private Contact contato() {
        return new Contact("NOME", "https://www.google.com.br", "email@gmail.com");
    }

    private ApiInfoBuilder api() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Controle Financeiro");
        apiInfoBuilder.description("Controle Financeiro Simples");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        apiInfoBuilder.contact(this.contato());
        return apiInfoBuilder;
    }

    @Bean
    public Docket detalheAPI() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.BudgetBuddy.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.api().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;

    }

}

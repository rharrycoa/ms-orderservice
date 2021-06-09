package com.pe.appventas.msorderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
    @Bean
    public Docket  apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(getApiInfo());
    } // bean hace que el docket sea detectado por spring

    private ApiInfo getApiInfo(){
        return new ApiInfo("appVentas orderService API",
                           "Este API tiene como fin implementar los endpoints para Ventas",
                           "1.0",
                           "Terminos de uso",
                           new Contact("Harry Coa", "https://harrycoa.github.io/appPortafolioCv/", "rharrycoa@gmail.com"),
                           "LICENSE","licence url" , Collections.emptyList());
    }
}

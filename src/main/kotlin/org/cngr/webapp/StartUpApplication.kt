package org.cngr.webapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
@Configuration
open class StartUpApplication {

    companion object {
        const val BASE_PACKAGE = "org.cngr.webapp"
    }

    @Bean
    open fun apiDocket() : Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .select()
            .paths(PathSelectors.ant("/v1/*"))
            .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title("Sample")
            .description("Kotlin Spring Boot API")
            .license("MIT License")
            .version("2.0")
            .build()
    }
}

fun main(args: Array<String>) {
    runApplication<StartUpApplication>(*args)
}

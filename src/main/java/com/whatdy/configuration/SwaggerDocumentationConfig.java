package com.whatdy.configuration;

import io.swagger.annotations.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.whatdy.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
        return docket;
    }
    private ApiInfo apiInfo()
    {
        return  new ApiInfoBuilder()
                .title("Spring boot 中使用Swagger2构建RESTFUL APIs")
                .description("描述")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("http://www.whatdy.com")
                .version("1.0.0")
                .contact("zhang1577121881@gmail.com")
                .build();
    }
}

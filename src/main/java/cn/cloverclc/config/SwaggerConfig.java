package cn.cloverclc.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//http://localhost:8080/swagger-ui/index.html

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI swaggerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("人事管理系统")
                        .description("CloverCLC"))
                .externalDocs(new ExternalDocumentation()
                        .description("我的github")
                        .url("https://github.com/CloverCLC"));
    }
}

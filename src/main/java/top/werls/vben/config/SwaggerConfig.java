package top.werls.vben.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SwaggerConfig {


    @Value("${env.version}")
    private String version;

    public static final String TOKEN_HEADER = "Authorization";

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .components(components())
                .info(new Info()
                        .title("Vben admin API")
                        .description("Vben admin  api")
                        .version(version));
    }

    private Components components() {
        Components components = new Components();
        components.addSecuritySchemes(TOKEN_HEADER,
                new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"));
        return components;
    }

}

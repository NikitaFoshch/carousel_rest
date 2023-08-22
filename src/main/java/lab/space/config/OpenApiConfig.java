package lab.space.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("SpaceLab Java Rest API")
                                .version("1")
                                .description("This is a spacelab-java-rest server.")
                                .termsOfService("https://swagger.io/terms/")
                )
                .addServersItem(new Server().url("https://slj.avada-media-dev1.od.ua/projects-rest"));
    }

    @Bean
    public GroupedOpenApi myApi() {
        return GroupedOpenApi.builder()
                .group("spacelab-java-rest")
                .packagesToScan("lab.space.controller")
                .build();
    }
}

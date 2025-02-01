package cursos.br.com.example.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${openapi.dev.url")
    private String url;

    @Bean
    public OpenAPI openAPI(){
        var devServer = new Server()
                .url(url)
                .description("URL do ambiente de desenvolvimento");

        var info = new Info()
                .title("API de gerenciamento de cursos")
                .version("1.0")
                .description("Esta API expõe endpoints para gerenciar o sistema de cadastro de cursos");

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}

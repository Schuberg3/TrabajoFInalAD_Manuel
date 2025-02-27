package ad.RepasoAPIDTO.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    //http://localhost:8080/swagger-ui/index.html#/
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestion Empresarial")
                        .version("1.0")
                        .description("Documentacion Gestion Empresarial")
                        .contact(new Contact()
                                .name("Manuel")
                                .email("manuel.perez.feijoo@iessanmamede.com")
                                .url("www.google.es")));
    }
}

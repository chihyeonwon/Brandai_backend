package likelion.hackathon.BradingHelper.Config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("BranDai 서비스 RestAPI Doc")
                .description("api 호출시에는 localhost:8080/~~ 으로 URL을 바인드 해주세요.\t예시) localhost:8080/card/1/2")
                .version("1.0.0");
    }
}
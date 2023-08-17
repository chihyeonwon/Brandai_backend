package likelion.hackathon.BradingHelper.ApiAccess.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import likelion.hackathon.BradingHelper.ApiAccess.Logo.LogoGenerator;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Logo.LogoToStringPrompt;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Prompt;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "로고 생성 API")
@RequestMapping("/dai/api")
public class LogoApiController {
    private final LogoGenerator logoGenerator;
    private final LogoToStringPrompt logoToStringPrompt;

    private static final Logger logger = LoggerFactory.getLogger(LogoApiController.class);

    @Operation(summary = "로고 생성", description = "프롬프트에서 키워드를 추출해 적절한 로고를 생성합니다.")
    @PostMapping("/logo")
    public Map<String, Object> LogoRestApi(@RequestBody Prompt prompt) {
        logger.info("<IMAGE LOGO GENERATING..>");

        String stringPrompt = logoToStringPrompt.getStringPrompt(prompt);

        logger.info("<IMAGE LOGO GENERATED !!>");
        return logoGenerator.getLogo(stringPrompt);
    }
}

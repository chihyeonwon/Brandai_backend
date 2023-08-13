package likelion.hackathon.BradingHelper.ApiAccess.Controller;

import likelion.hackathon.BradingHelper.ApiAccess.Logo.LogoGenerator;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Logo.LogoToStringPrompt;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Prompt;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class LogoApiController {
    private final LogoGenerator logoGenerator;
    private final LogoToStringPrompt logoToStringPrompt;

    @PostMapping("/logo")
    public Map<String, Object> LogoRestApi(@RequestBody Prompt prompt) {
        String stringPrompt = logoToStringPrompt.getStringPrompt(prompt);
        return logoGenerator.getLogo(stringPrompt);
    }
}

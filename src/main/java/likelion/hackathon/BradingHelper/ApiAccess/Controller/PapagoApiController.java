package likelion.hackathon.BradingHelper.ApiAccess.Controller;

import likelion.hackathon.BradingHelper.ApiAccess.Translation.PapagoTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PapagoApiController {
    private final PapagoTranslator papagoTranslator;

    @PostMapping("/papago")
    public Map<String, Object> translateRestApi(@RequestBody Map<String, String> requestBody) {
        String prompt = requestBody.get("prompt");
        return papagoTranslator.translate(prompt);
    }
}

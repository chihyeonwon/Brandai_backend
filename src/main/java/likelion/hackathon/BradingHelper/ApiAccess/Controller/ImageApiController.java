package likelion.hackathon.BradingHelper.ApiAccess.Controller;

import likelion.hackathon.BradingHelper.ApiAccess.Image.ImageGenerator;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Image.ImageToStringPrompt;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Prompt;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ImageApiController {
    private final ImageGenerator imageGenerator;
    private final ImageToStringPrompt imageToStringPrompt;

    @PostMapping("/image")
    public Map<String, Object> ImageRestApi(@RequestBody Prompt prompt) {
        String stringPrompt = imageToStringPrompt.getStringPrompt(prompt);
        return imageGenerator.getImage("a");
    }
}

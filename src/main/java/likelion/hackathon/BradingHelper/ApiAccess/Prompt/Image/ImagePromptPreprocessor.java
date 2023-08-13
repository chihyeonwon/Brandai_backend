package likelion.hackathon.BradingHelper.ApiAccess.Prompt.Image;

import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Interface.PromptPreprocessor;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Prompt;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.TranslatePrompt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ImagePromptPreprocessor implements PromptPreprocessor {
    private final TranslatePrompt translatePrompt;

    @Override
    public Map<String, String> promptPreprocessor(Prompt prompt) {

        // Translate Ko -> En
        Prompt enPrompt = translatePrompt.translatePrompt(prompt);

        // Classify Prompt
        Map<String, String> classifyPrompt = new HashMap<>();

        classifyPrompt.put("mood", enPrompt.getOption().getMood());
        classifyPrompt.put("baseColor", enPrompt.getOption().getBaseColor());
        classifyPrompt.put("object", enPrompt.getOption().getObject());
        classifyPrompt.put("parentCategory", enPrompt.getCategory().getParentCategory());
        classifyPrompt.put("childCategory", enPrompt.getCategory().getChildCategory());

        return classifyPrompt;
    }

}

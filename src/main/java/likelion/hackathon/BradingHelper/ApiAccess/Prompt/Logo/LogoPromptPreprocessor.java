package likelion.hackathon.BradingHelper.ApiAccess.Prompt.Logo;

import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Interface.PromptPreprocessor;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Prompt;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.TranslatePrompt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class LogoPromptPreprocessor implements PromptPreprocessor {
    private final TranslatePrompt translatePrompt;

    @Override
    public Map<String, String> promptPreprocessor(Prompt prompt) {

        // Translate Ko -> En
        Prompt enPrompt = translatePrompt.translatePrompt(prompt);

        // Classify Prompt
        Map<String, String> classifyPrompt = new HashMap<>();

        classifyPrompt.put("mood", enPrompt.getOption() != null && enPrompt.getOption().getMood() != null
                ? enPrompt.getOption().getMood() : "");
        classifyPrompt.put("baseColor", enPrompt.getOption() != null && enPrompt.getOption().getBaseColor() != null
                ? enPrompt.getOption().getBaseColor() : "");
        classifyPrompt.put("object", enPrompt.getOption() != null && enPrompt.getOption().getObject() != null
                ? enPrompt.getOption().getObject() : "");
        classifyPrompt.put("keyword", enPrompt.getHashtag() != null
                ? enPrompt.getHashtag().toString() : "");
        classifyPrompt.put("parentCategory", enPrompt.getCategory() != null && enPrompt.getCategory().getParentCategory() != null
                ? enPrompt.getCategory().getParentCategory() : "");
        classifyPrompt.put("childCategory", enPrompt.getCategory() != null && enPrompt.getCategory().getChildCategory() != null
                ? enPrompt.getCategory().getChildCategory() : "");

        return classifyPrompt;
    }

}

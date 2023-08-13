package likelion.hackathon.BradingHelper.ApiAccess.Prompt.Description;

import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Interface.PromptPreprocessor;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Prompt;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.TranslatePrompt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DescriptionPromptPreprocessor implements PromptPreprocessor {
    private final TranslatePrompt translatePrompt;

    public Map<String, String> promptPreprocessor(Prompt prompt) {

        // Translate Ko -> En
        Prompt enPrompt = translatePrompt.translatePrompt(prompt);

        // Classify Prompt
        Map<String, String> classifyPrompt = new HashMap<>();

        classifyPrompt.put("brandName", enPrompt.getBrandName());
        classifyPrompt.put("keyword", enPrompt.getHashtag().toString());
        classifyPrompt.put("parentCategory", enPrompt.getCategory().getParentCategory());
        classifyPrompt.put("childCategory", enPrompt.getCategory().getChildCategory());
        classifyPrompt.put("description", enPrompt.getDescription());

        return classifyPrompt;
    }

}

package likelion.hackathon.BradingHelper.ApiAccess.Prompt;

import likelion.hackathon.BradingHelper.ApiAccess.Papago.PapagoTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TranslatePrompt {
    public final PapagoTranslator papagoTranslator;

    public Prompt translatePrompt(Prompt prompt) {
        String description = prompt.getDescription();
        List<String> hashTags = prompt.getHashtag();

        hashTags.replaceAll(s -> papagoTranslator.translate(s)
                .get("translatedText")
                .toString());

        prompt.setDescription(description);
        prompt.setHashtag(hashTags);

        return prompt;
    }
}

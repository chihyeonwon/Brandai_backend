package likelion.hackathon.BradingHelper.ApiAccess.Description;

import likelion.hackathon.BradingHelper.ApiAccess.ChatGpt.ChatGptDataGenerator;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Description.DescriptionToStringPrompt;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Prompt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DescriptionResponse {

    private final DescriptionToStringPrompt descriptionToStringPrompt;
    private final ChatGptDataGenerator chatGptDataGenerator;

    public String descriptionResponse(Prompt prompt) {
        String stringPrompt = descriptionToStringPrompt.getStringPrompt(prompt);
        return chatGptDataGenerator.chatGpt(stringPrompt).get("content").toString();
    }
}

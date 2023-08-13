package likelion.hackathon.BradingHelper.ApiAccess.ChatGpt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class ChatGptDataGenerator {
    private final ChatGptPreprocessor chatGptPreprocessor;

    public Map<String, Object> chatGpt(String prompt) {
        return chatGptPreprocessor.fetchData(prompt);
    }
}

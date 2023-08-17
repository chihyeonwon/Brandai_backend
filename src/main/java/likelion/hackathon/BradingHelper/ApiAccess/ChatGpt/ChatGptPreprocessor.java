package likelion.hackathon.BradingHelper.ApiAccess.ChatGpt;

import likelion.hackathon.BradingHelper.ApiAccess.Interfaces.DataPreprocessorInterface;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ChatGptPreprocessor implements DataPreprocessorInterface {

    private final ChatGptApiRequester chatGptApiRequester;

    @Override
    public Map<String, Object> fetchData(String prompt) {
        String data = chatGptApiRequester.ApiRequest(prompt);
        JSONObject jsonObject = new JSONObject(data);

        String content = jsonObject.getJSONArray("choices")
                .getJSONObject(0)
                .getJSONObject("message")
                .getString("content");

        Map<String, Object> result = new HashMap<>();
        result.put("content", content);

        return result;


    }
}

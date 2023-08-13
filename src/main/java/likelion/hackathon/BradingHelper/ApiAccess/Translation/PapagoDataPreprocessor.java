package likelion.hackathon.BradingHelper.ApiAccess.Translation;

import likelion.hackathon.BradingHelper.ApiAccess.Interfaces.DataPreprocessorInterface;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PapagoDataPreprocessor implements DataPreprocessorInterface {
    private final PapagoApiRequester papagoApiRequester;

    @Override
    public Map<String, Object> fetchData(String prompt) {
        String data = papagoApiRequester.ApiRequest(prompt);

        JSONObject jsonObject = new JSONObject(data);
        JSONObject messageObject = jsonObject.getJSONObject("message");
        JSONObject resultObject = messageObject.getJSONObject("result");

        String translatedText = resultObject.getString("translatedText");

        Map<String, Object> result = new HashMap<>();
        result.put("translatedText", translatedText);

        return result;
    }
}

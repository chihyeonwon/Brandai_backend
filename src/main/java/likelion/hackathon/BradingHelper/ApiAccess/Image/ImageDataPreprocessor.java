package likelion.hackathon.BradingHelper.ApiAccess.Image;

import likelion.hackathon.BradingHelper.ApiAccess.Interfaces.DataPreprocessorInterface;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ImageDataPreprocessor implements DataPreprocessorInterface {

    private final ImageApiRequester imageApiRequester;

    @Override
    public Map<String, Object> fetchData(String prompt) {
        String data = imageApiRequester.ApiRequest(prompt);

        JSONObject jsonObject = new JSONObject(data);
        JSONArray artifactsArray = jsonObject.getJSONArray("artifacts");

        String base64Value;
        if (artifactsArray.length() > 0) {
            JSONObject artifactObject = artifactsArray.getJSONObject(0);
            base64Value = artifactObject.getString("base64");
        } else {
            throw new RuntimeException("No artifacts found.");
        }

        Map<String, Object> result = new HashMap<>();
        result.put("base64", base64Value);

        return result;


    }
}

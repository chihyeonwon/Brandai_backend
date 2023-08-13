package likelion.hackathon.BradingHelper.ApiAccess.Logo;

import likelion.hackathon.BradingHelper.ApiAccess.Interfaces.DataPreprocessorInterface;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class LogoDataPreprocessor implements DataPreprocessorInterface {

    private final LogoApiRequester logoApiRequester;

    @Override
    public Map<String, Object> fetchData(String prompt) {

        String data = logoApiRequester.ApiRequest(prompt);

        JSONObject jsonObject = new JSONObject(data);
        JSONArray dataArray = jsonObject.getJSONArray("data");

        List<String> urlList = new ArrayList<>();
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject dataObject = dataArray.getJSONObject(i);
            String url = dataObject.getString("url");
            urlList.add(url);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("url", urlList);

        return result;
    }
}

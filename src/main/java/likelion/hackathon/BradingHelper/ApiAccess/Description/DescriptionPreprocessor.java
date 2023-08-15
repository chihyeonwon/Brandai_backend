package likelion.hackathon.BradingHelper.ApiAccess.Description;

import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Prompt;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DescriptionPreprocessor {
    private final DescriptionResponse descriptionResponse;

    public String descriptionPreprocessor(Prompt prompt) {
        String content = descriptionResponse.descriptionResponse(prompt);

        JSONObject object = new JSONObject(content);

        String descriptions = "제품명|" + object.getString("제품명") + "|간단한 소개|" + object.getString("간단한 소개") + "|";

        JSONObject feature_1 = object.getJSONObject("제품 특징1");
        descriptions += "특징1|" + feature_1.getString("특징") + "|설명1|" + feature_1.getString("설명") + "|";

        JSONObject feature_2 = object.getJSONObject("제품 특징2");
        descriptions += "특징2|" + feature_2.getString("특징") + "|설명2|" + feature_2.getString("설명") + "|";

        JSONObject feature_3 = object.getJSONObject("제품 특징3");
        descriptions += "특징3|" + feature_3.getString("특징") + "|설명3|" + feature_3.getString("설명") + "|";

        descriptions += "제품 홍보 글|" + object.getString("제품 홍보 글");

        return descriptions;
    }
}

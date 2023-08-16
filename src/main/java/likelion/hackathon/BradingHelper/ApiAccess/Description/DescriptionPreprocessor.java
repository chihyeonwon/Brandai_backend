package likelion.hackathon.BradingHelper.ApiAccess.Description;

import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Prompt;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DescriptionPreprocessor {
    private final DescriptionResponse descriptionResponse;

    public DescriptionApi descriptionPreprocessor(Prompt prompt) {
        String content = descriptionResponse.descriptionResponse(prompt);
        DescriptionApi description = new DescriptionApi();

        JSONObject object = new JSONObject(content);

        description.setProductName(object.getString("제품명"));
        description.setIntroduction(object.getString("간단한 소개"));

        JSONObject feature_1 = object.getJSONObject("제품 특징1");
        description.setFeatureFirst(feature_1.getString("특징"));
        description.setFeatureDescription1(feature_1.getString("설명"));

        JSONObject feature_2 = object.getJSONObject("제품 특징2");
        description.setFeatureSecond(feature_2.getString("특징"));
        description.setFeatureDescription2(feature_2.getString("설명"));

        JSONObject feature_3 = object.getJSONObject("제품 특징3");
        description.setFeatureThird(feature_3.getString("특징"));
        description.setFeatureDescription3(feature_3.getString("설명"));

        description.setPromotion(object.getString("제품 홍보 글"));

        return description;
    }
}
package likelion.hackathon.BradingHelper.ApiAccess.Description;

import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Prompt;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DescriptionPreprocessor {
    private final DescriptionResponse descriptionResponse;

    public DescriptionTemplate descriptionPreprocessor(Prompt prompt) {
        String content = descriptionResponse.descriptionResponse(prompt);
        try {
            JSONObject object = new JSONObject(content);

            return DescriptionTemplate.builder()
                    .productName(object.getString("제품명"))
                    .introduction(object.getString("간단한 소개"))
                    .featureFirst(object.getJSONObject("제품 특징1").getString("특징"))
                    .featureDescription1(object.getJSONObject("제품 특징1").getString("설명"))
                    .featureSecond(object.getJSONObject("제품 특징2").getString("특징"))
                    .featureDescription2(object.getJSONObject("제품 특징2").getString("설명"))
                    .featureThird(object.getJSONObject("제품 특징3").getString("특징"))
                    .featureDescription3(object.getJSONObject("제품 특징3").getString("설명"))
                    .promotion(object.getString("제품 홍보 글"))
                    .build();
        } catch (Exception e) {
            return null;
        }
    }
}
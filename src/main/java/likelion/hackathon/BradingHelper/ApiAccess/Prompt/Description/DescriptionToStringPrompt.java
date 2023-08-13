package likelion.hackathon.BradingHelper.ApiAccess.Prompt.Description;

import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Interface.ToStringPrompt;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Prompt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class DescriptionToStringPrompt implements ToStringPrompt {
    private final DescriptionPromptPreprocessor descriptionPromptPreprocessor;

    public String getStringPrompt(Prompt prompt) {
        Map<String, String> classifyPrompt
                = descriptionPromptPreprocessor.promptPreprocessor(prompt);

        return "Prompt for Generating an article on the sale of goods.\n"
                + "brandName: " + classifyPrompt.get("brandName") + "\n"
                + "Keywords: " + classifyPrompt.get("keyword") + "\n\n"
                + "The brand is focused on " + classifyPrompt.get("parentCategory") + " within an e-commerce platform run by small businesses. \n" +
                "It specializes in " + classifyPrompt.get("childCategory") + ".\n" +
                "Simple description " + classifyPrompt.get("description") + ".\n" +
                "Please create an article on the sale of goods." + "\n\n" +
                "Please make it into a json form like below." + "\n\n" +
                "\"제품명\": \"\", " + "\n" +
                "\"간단한 소개\": \"\", " + "\n" +
                "\"제품 특징1\": {" + "\n" +
                "\"특징\": \"\", " + "\n" +
                "\"설명\": \"\"" + "\n" +
                "}, " +
                "\"제품 특징2\": {" + "\n" +
                "\"특징\": \"\", " + "\n" +
                "\"설명\": \"\"" + "\n" +
                "}, " +
                "\"제품 특징3\": {" + "\n" +
                "\"특징\": \"\", " + "\n" +
                "\"설명\": \"\"" + "\n" +
                "}, " +
                "\"제품 홍보 글\": \"\"" + "\n" +
                "Please write in Korean." + "\n" +
                "Please write in 1000 words.";

    }
}

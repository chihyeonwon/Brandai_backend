package likelion.hackathon.BradingHelper.ApiAccess.Prompt.Logo;

import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Interface.ToStringPrompt;
import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Prompt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class LogoToStringPrompt implements ToStringPrompt {
    private final LogoPromptPreprocessor logoPromptPreprocessor;

    @Override
    public String getStringPrompt(Prompt prompt) {
        Map<String, String> classifyPrompt
                = logoPromptPreprocessor.promptPreprocessor(prompt);


        System.out.println("Prompt for Generating Brand Logo Image\n"
                + "Mood: " + classifyPrompt.get("mood") + "\n"
                + "Base Color: " + classifyPrompt.get("baseColor") + "\n"
                + "Keywords: " + classifyPrompt.get("keyword") + "\n\n"
                + "The brand is focused on " + classifyPrompt.get("parentCategory") + " within an e-commerce platform run by small businesses. \n" +
                "It specializes in " + classifyPrompt.get("childCategory") + ".\n" +
                "Please create a brand logo image.");

        return "Prompt for Generating Brand Logo Image\n"
                + "Mood: " + classifyPrompt.get("mood") + "\n"
                + "Base Color: " + classifyPrompt.get("baseColor") + "\n"
                + "Logo Object: " + classifyPrompt.get("object") + "\n"
                + "Keywords: " + classifyPrompt.get("keyword") + "\n\n"
                + "The brand is focused on " + classifyPrompt.get("parentCategory") + " within an e-commerce platform run by small businesses. \n" +
                "It specializes in " + classifyPrompt.get("childCategory") + ".\n" +
                "Please create a brand logo image.";
    }
}

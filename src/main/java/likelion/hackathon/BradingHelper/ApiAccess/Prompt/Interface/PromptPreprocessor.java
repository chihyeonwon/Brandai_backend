package likelion.hackathon.BradingHelper.ApiAccess.Prompt.Interface;

import likelion.hackathon.BradingHelper.ApiAccess.Prompt.Prompt;

import java.util.Map;

public interface PromptPreprocessor {
    Map<String, String> promptPreprocessor(Prompt prompt);
}

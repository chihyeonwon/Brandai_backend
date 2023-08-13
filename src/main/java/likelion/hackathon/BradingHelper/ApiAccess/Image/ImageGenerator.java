package likelion.hackathon.BradingHelper.ApiAccess.Image;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class ImageGenerator {
    private final ImageDataPreprocessor imageDataProcessor;

    public Map<String, Object> getImage(String prompt) {
        return imageDataProcessor.fetchData(prompt);
    }
}

package likelion.hackathon.BradingHelper.ApiAccess.Logo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class LogoGenerator {
    private final LogoDataPreprocessor logoDataProcessor;

    public Map<String, Object> getLogo(String prompt) {
        return logoDataProcessor.fetchData(prompt);
    }
}

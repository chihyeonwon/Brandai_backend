package likelion.hackathon.BradingHelper.ApiAccess.Translation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class PapagoTranslator {
    private final PapagoDataPreprocessor papagoDataProcessor;

    public Map<String, Object> translate(String prompt) {
        return papagoDataProcessor.fetchData(prompt);
    }
}

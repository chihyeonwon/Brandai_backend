package likelion.hackathon.BradingHelper.ApiAccess.Papago;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PapagoTranslator {
    private final PapagoDataPreprocessor papagoDataProcessor;

    public Map<String, Object> translate(String prompt) {

        String query;
        try {
            query = URLEncoder.encode(prompt, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("인코딩 실패", e);
        }

        return papagoDataProcessor.fetchData(query);
    }
}

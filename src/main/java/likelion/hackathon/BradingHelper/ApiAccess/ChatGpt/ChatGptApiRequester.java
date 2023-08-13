package likelion.hackathon.BradingHelper.ApiAccess.ChatGpt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import likelion.hackathon.BradingHelper.ApiAccess.Interfaces.ApiRequesterInterface;
import likelion.hackathon.BradingHelper.ApiAccess.Security.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ChatGptApiRequester implements ApiRequesterInterface {

    private final TokenManager tokenManager;

    @Override
    public String ApiRequest(String prompt) {
        final String URL = "https://api.openai.com/v1/chat/completions";
        final String TOKEN = tokenManager.getApi_key_logo();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + TOKEN);

        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("model","gpt-3.5-turbo");

        Map<String, String> messageMap = new HashMap<>();
        messageMap.put("role", "user");
        messageMap.put("content", prompt);

        List<Map<String, String>> message = new ArrayList<>();
        message.add(messageMap);

        requestBody.put("messages", message);

        HttpEntity<Map<String, Object>> responseEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.postForEntity(URL, responseEntity, Map.class);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(response.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{\"error\": \"JSON processing error\"}";
        }
    }
}

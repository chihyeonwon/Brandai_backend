package likelion.hackathon.BradingHelper.Auth.Service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class KakaoService {

    public String getKakaoToken(String code) {
        try {
            final String tokenUrl = "https://kauth.kakao.com/oauth/token";
            final String restApiKey = "bd35d95b8db977e0b07b6fd668527afe";
            final String redirectUri = "http://localhost:3000/get-started/login-redirect";

            MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
            requestBody.add("grant_type", "authorization_code");
            requestBody.add("client_id", restApiKey);
            requestBody.add("redirect_uri", redirectUri);
            requestBody.add("code", code);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<Map> response = restTemplate.exchange(
                    tokenUrl,
                    HttpMethod.POST,
                    requestEntity,
                    Map.class
            );

            if (response.getStatusCode() == HttpStatus.OK) {
                Map<String, Object> responseBody = response.getBody();
                return (String) responseBody.get("access_token");
            } else {
                System.out.println("Request failed with status code: " + response.getStatusCode());
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public Map<String, String> getKakaoUserData(String token) {
        Map<String, String> userData = new HashMap<>(); // Setting Return Value.

        try {
            final String URL = "https://kapi.kakao.com/v2/user/me";
            final String AUTHORIZATION = "Bearer " + token;

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", AUTHORIZATION);

            HttpEntity<?> entity = new HttpEntity<>(headers);

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<Map> response = restTemplate.exchange(URL, HttpMethod.GET, entity, Map.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                Map<String, Object> responseBody = response.getBody();
                String name, email;

                Map<String, Object> kakaoAccount = (Map<String, Object>) responseBody.get("kakao_account");
                email = (String) kakaoAccount.get("email");

                Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");
                name = (String) profile.get("nickname");

                userData.put("name", name);
                userData.put("email", email);
                return userData;
            }

            return null;
        } catch (Exception e) {
            return null;
        }
    }

}


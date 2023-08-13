package likelion.hackathon.BradingHelper.ApiAccess.Logo;

import likelion.hackathon.BradingHelper.ApiAccess.Interfaces.ApiRequesterInterface;
import likelion.hackathon.BradingHelper.ApiAccess.Utils.HttpUtils;
import likelion.hackathon.BradingHelper.ApiAccess.Security.TokenManager;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
@RequiredArgsConstructor
public class LogoApiRequester implements ApiRequesterInterface {

    private final TokenManager tokenManager;
    private final HttpUtils httpUtils;

    @Override
    public String ApiRequest(String prompt) {

        // API URL
        final String API_URL = "https://api.openai.com/v1/images/generations";

        // Header
        final String CONTENT_TYPE = "application/json";
        final String AUTHORIZATION = "Bearer " + tokenManager.getApi_key_logo();

        // RequestBody
        final String SIZE = "256x256";
        final int N = 2;

        HttpURLConnection conn = null;
        String result = "";

        try {
            URL url = new URL(API_URL);

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(50000);
            conn.setRequestProperty("Content-Type", CONTENT_TYPE);
            conn.setRequestProperty("Authorization", AUTHORIZATION);

            conn.setDoOutput(true);

            try (DataOutputStream dataOutputStream =
                         new DataOutputStream(conn.getOutputStream())) {

                JSONObject jsonRequest = new JSONObject();
                jsonRequest.put("prompt", prompt);
                jsonRequest.put("n", N);
                jsonRequest.put("size", SIZE);

                String json_str = jsonRequest.toString();

                dataOutputStream.writeBytes(json_str);
                dataOutputStream.flush();

                result = httpUtils.getHttpResponse(conn);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        return result;
    }

}

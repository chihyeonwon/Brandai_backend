package likelion.hackathon.BradingHelper.ApiAccess.Image;

import likelion.hackathon.BradingHelper.ApiAccess.Interfaces.ApiRequesterInterface;
import likelion.hackathon.BradingHelper.ApiAccess.Utils.HttpUtils;
import likelion.hackathon.BradingHelper.ApiAccess.Security.TokenManager;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
@RequiredArgsConstructor
public class ImageApiRequester implements ApiRequesterInterface {

    private final TokenManager tokenManager;
    private final HttpUtils httpUtils;

    @Override
    public String ApiRequest(String prompt) {

        // API URL
        final String API_URL = "https://api.stability.ai/v1/generation/stable-diffusion-xl-beta-v2-2-2/text-to-image";

        // Header
        final String CONTENT_TYPE = "application/json";
        final String ACCEPT = "application/json";
        final String AUTHORIZATION = tokenManager.getApi_key_image();

        // RequestBody
        final int WIDTH = 512;
        final int HEIGHT = 512;
        final int STEPS = 50;
        final int SEED = 0;
        final int CFG_SCALE = 7;
        final int SAMPLES = 1;
        final String STYLE_PRESET = "enhance";

        HttpURLConnection conn = null;
        String result = "";

        try {
            URL url = new URL(API_URL);

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(50000);
            conn.setRequestProperty("Accept", ACCEPT);
            conn.setRequestProperty("Content-Type", CONTENT_TYPE);
            conn.setRequestProperty("Authorization", AUTHORIZATION);

            conn.setDoOutput(true);

            try (DataOutputStream dataOutputStream =
                         new DataOutputStream(conn.getOutputStream())) {

                JSONObject jsonRequest = new JSONObject();
                jsonRequest.put("width", WIDTH);
                jsonRequest.put("height", HEIGHT);
                jsonRequest.put("steps", STEPS);
                jsonRequest.put("seed", SEED);
                jsonRequest.put("cfg_scale", CFG_SCALE);
                jsonRequest.put("samples", SAMPLES);
                jsonRequest.put("style_preset", STYLE_PRESET);

                JSONArray textPromptsArray = new JSONArray();
                JSONObject textPrompt = new JSONObject();
                textPrompt.put("text", prompt);
                textPrompt.put("weight", 1);

                textPromptsArray.put(textPrompt);
                jsonRequest.put("text_prompts", textPromptsArray);

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

package likelion.hackathon.BradingHelper.ApiAccess.Translation;

import likelion.hackathon.BradingHelper.ApiAccess.Interfaces.ApiRequesterInterface;
import likelion.hackathon.BradingHelper.ApiAccess.Security.TokenManager;
import likelion.hackathon.BradingHelper.ApiAccess.Utils.HttpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
@RequiredArgsConstructor
public class PapagoApiRequester implements ApiRequesterInterface {

    private final TokenManager tokenManager;
    private final HttpUtils httpUtils;

    @Override
    public String ApiRequest(String prompt) {

        // API URL
        final String API_URL = "https://openapi.naver.com/v1/papago/n2mt";

        // Header
        final String CONTENT_TYPE = "application/x-www-form-urlencoded; charset=UTF-8";
        final String CLIENT_ID = tokenManager.getClient_Id();
        final String CLIENT_SECRET = tokenManager.getClient_secret();

        // RequestBody
        String requestBody = "source=ko&target=en&text=" + prompt;

        HttpURLConnection conn = null;
        String result = "";

        try {
            URL url = new URL(API_URL);

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(50000);
            conn.setRequestProperty("Content-Type", CONTENT_TYPE);
            conn.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
            conn.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);

            conn.setDoOutput(true);

            try (DataOutputStream dataOutputStream =
                         new DataOutputStream(conn.getOutputStream())) {

                dataOutputStream.writeBytes(requestBody);
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

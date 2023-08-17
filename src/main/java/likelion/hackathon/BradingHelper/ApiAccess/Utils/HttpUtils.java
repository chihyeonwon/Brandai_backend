package likelion.hackathon.BradingHelper.ApiAccess.Utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

@Component
public class HttpUtils {
    public String getHttpResponse(HttpURLConnection conn) {
        StringBuilder sb = null;

        try {
            if (conn.getResponseCode() == 200) {
                sb = readResponseData(conn.getInputStream());
            } else {
                System.out.println(conn.getResponseCode());
                System.out.println(conn.getResponseMessage());

                sb = readResponseData(conn.getErrorStream());

                System.out.println("error : " + sb.toString());

                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        } ;

        if (sb == null) return null;

        return sb.toString();
    }

    public StringBuilder readResponseData(InputStream in) {

        if (in == null) return null;

        StringBuilder sb = new StringBuilder();

        String line;

        try (InputStreamReader ir = new InputStreamReader(in);
             BufferedReader br = new BufferedReader(ir)) {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb;
    }
}

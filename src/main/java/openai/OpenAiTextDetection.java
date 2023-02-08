package openai;

import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


/**
 * 文本鉴别
 *
 * @author huanghao
 * @version 1.0
 * company: ANSO
 * copyright: Copyright (c) 2022
 * modified by:
 * @date 2023/2/8 10:48
 */
public class OpenAiTextDetection {

    private static final String API_KEY = "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";
    private static final String MODEL = "text-davinci-002";
    private static final String API_URL = "https://api.openai.com/v1/engines/" + MODEL + "/jobs";

    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(API_URL);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", "Bearer " + API_KEY);

        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("prompt", "What is OpenAI?");

        request.setEntity(new StringEntity(requestBody.toString()));

        HttpResponse response = httpClient.execute(request);
        int responseCode = response.getStatusLine().getStatusCode();
        if (responseCode == 200) {
            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println(responseBody);
        } else {
            System.out.println("Request failed with code: " + responseCode);
        }
    }
}

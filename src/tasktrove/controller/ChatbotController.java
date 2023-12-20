/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasktrove.controller;

import javax.swing.JTextArea;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/**
 *
 * @author riakgu
 */
public class ChatbotController {
    private final String PERPLEXITY_API_KEY = "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";
    private final String PERPLEXITY_ENDPOINT = "https://api.perplexity.ai/chat/completions";
    
    public String getPerplexityResponse(String userMessage) {
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            String requestBody = "{\"model\":\"mistral-7b-instruct\",\"messages\":[{\"role\":\"system\",\"content\":\"Be precise and concise.\"},{\"role\":\"user\",\"content\":\"" + userMessage + "\"}]}";

            Request request = new Request.Builder()
                    .url(PERPLEXITY_ENDPOINT)
                    .post(RequestBody.create(mediaType, requestBody))
                    .addHeader("accept", "application/json")
                    .addHeader("content-type", "application/json")
                    .addHeader("Authorization", "Bearer " + PERPLEXITY_API_KEY)
                    .build();

            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                // Parse the JSON response
                String jsonResponse = response.body().string();
                JSONObject jsonObject = new JSONObject(jsonResponse);

                // Extract the assistant's response
                String assistantResponse = jsonObject.getJSONArray("choices")
                        .getJSONObject(0)
                        .getJSONObject("message")
                        .getString("content");

                return assistantResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Sorry, something went wrong.";
    }
}

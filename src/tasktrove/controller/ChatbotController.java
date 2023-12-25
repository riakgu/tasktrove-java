package tasktrove.controller;

import okhttp3.*;

import org.json.JSONObject;
import tasktrove.config.Api;

/**
 * ChatbotController mengatur komunikasi dengan API chatbot.
 * Kelas ini menggunakan OkHttp untuk mengirim permintaan ke endpoint API
 * dan menerima respon berdasarkan pesan pengguna.
 */
public class ChatbotController {
    private Api api = new Api();
    
    /**
     * Mengirim pesan pengguna ke API chatbot dan mendapatkan respon.
     * Menggunakan model 'mistral-7b-instruct' untuk permintaan ini.
     * 
     * @param userMessage Pesan yang dikirim oleh pengguna.
     * @return Respon dari chatbot atau pesan error jika terjadi kegagalan.
     */
    public String getPerplexityResponse(String userMessage) {
        try {
            // Membuat client HTTP
            OkHttpClient client = new OkHttpClient();

            // Menentukan tipe media untuk permintaan
            MediaType mediaType = MediaType.parse("application/json");
            
            // Membuat isi permintaan dengan format JSON
            String requestBody = "{\"model\":\"mistral-7b-instruct\",\"messages\":[{\"role\":\"system\",\"content\":\"Be precise and concise.\"},{\"role\":\"user\",\"content\":\"" + userMessage + "\"}]}";

            // Membangun permintaan HTTP
            Request request = new Request.Builder()
                    .url(api.PERPLEXITY_ENDPOINT)
                    .post(RequestBody.create(mediaType, requestBody))
                    .addHeader("accept", "application/json")
                    .addHeader("content-type", "application/json")
                    .addHeader("Authorization", "Bearer " + api.PERPLEXITY_API_KEY)
                    .build();

            // Mengirim permintaan dan menerima respon
            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                // Menguraikan respon JSON
                String jsonResponse = response.body().string();
                JSONObject jsonObject = new JSONObject(jsonResponse);

                // Mengambil respon pesan
                String assistantResponse = jsonObject.getJSONArray("choices")
                        .getJSONObject(0)
                        .getJSONObject("message")
                        .getString("content");

                return assistantResponse;
            }
        } catch (Exception e) {
            // Menangani eksepsi
            e.printStackTrace();
        }

        // Mengembalikan pesan kesalahan jika terjadi kegagalan
        return "Maaf, terjadi kesalahan.";
    }
}

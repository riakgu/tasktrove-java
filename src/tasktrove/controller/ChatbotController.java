package tasktrove.controller;

import okhttp3.*;
import org.json.JSONObject;

/**
 * Kelas ChatbotController untuk mengelola interaksi dengan chatbot.
 */
public class ChatbotController {
     public static final String PERPLEXITY_API_KEY = "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";
     public static final String PERPLEXITY_ENDPOINT = "https://api.perplexity.ai/chat/completions";

    /**
     * Mengirimkan pesan pengguna ke API chatbot dan mendapatkan respons.
     *
     * @param userMessage Pesan yang dikirim oleh pengguna.
     * @return String Respons dari chatbot.
     */
    public String getPerplexityResponse(String userMessage) {
        try {
            OkHttpClient client = new OkHttpClient(); // Membuat instance OkHttpClient.

            MediaType mediaType = MediaType.parse("application/json"); // Menentukan media type untuk request body.

            // Membuat request body dengan pesan pengguna.
            String requestBody = "{\"model\":\"codellama-34b-instruct\",\"messages\":[{\"role\":\"system\",\"content\":\"Be precise and concise.\"},{\"role\":\"user\",\"content\":\"" + userMessage + "\"}]}";

            // Membangun request HTTP.
            Request request = new Request.Builder()
                    .url(PERPLEXITY_ENDPOINT) // Menentukan URL endpoint.
                    .post(RequestBody.create(mediaType, requestBody)) // Menetapkan metode POST dengan body.
                    .addHeader("accept", "application/json") // Menambahkan header accept.
                    .addHeader("content-type", "application/json") // Menambahkan header content-type.
                    .addHeader("Authorization", "Bearer " + PERPLEXITY_API_KEY) // Menambahkan header Authorization.
                    .build();

            // Mengirimkan request dan menerima respons.
            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                String jsonResponse = response.body().string(); // Membaca response body sebagai string.
                JSONObject jsonObject = new JSONObject(jsonResponse); // Mengonversi string ke JSONObject.

                // Mengambil dan mengembalikan isi respons dari chatbot.
                String assistantResponse = jsonObject.getJSONArray("choices")
                        .getJSONObject(0)
                        .getJSONObject("message")
                        .getString("content");

                return assistantResponse;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Mencetak stack trace jika terjadi exception.
        }

        return "Maaf, terjadi kesalahan."; // Mengembalikan pesan error jika terjadi kegagalan.
    }
}

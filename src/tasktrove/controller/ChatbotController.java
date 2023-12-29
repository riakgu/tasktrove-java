package tasktrove.controller;

import okhttp3.*;
import org.json.JSONObject;
import tasktrove.config.Api;

/**
 * Kelas ChatbotController untuk mengelola interaksi dengan chatbot.
 */
public class ChatbotController {
    private Api api = new Api(); // Instansiasi konfigurasi API.

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
            String requestBody = "{\"model\":\"mistral-7b-instruct\",\"messages\":[{\"role\":\"system\",\"content\":\"Be precise and concise.\"},{\"role\":\"user\",\"content\":\"" + userMessage + "\"}]}";

            // Membangun request HTTP.
            Request request = new Request.Builder()
                    .url(api.PERPLEXITY_ENDPOINT) // Menentukan URL endpoint.
                    .post(RequestBody.create(mediaType, requestBody)) // Menetapkan metode POST dengan body.
                    .addHeader("accept", "application/json") // Menambahkan header accept.
                    .addHeader("content-type", "application/json") // Menambahkan header content-type.
                    .addHeader("Authorization", "Bearer " + api.PERPLEXITY_API_KEY) // Menambahkan header Authorization.
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

package com.mnemosai.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class GeminiProviderService {

    private static final String API_KEY = Dotenv.load().get("GEMINI_API_KEY");
    private static final String MODEL_NAME = Dotenv.load().get("GEMINI_MODEL_NAME");
    private static final String API_ENDPOINT =
            "https://generativelanguage.googleapis.com/v1beta/models/" + MODEL_NAME + ":generateContent?key=" + API_KEY;

    public String sendRequest(String payload) {
        String requestBody = String.format("""
                {
                  "contents": [{
                    "parts":[{"text": "%s"}]
                    }]
                   }
                """, payload);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_ENDPOINT))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                .build();

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + responseBody);

            JSONObject json = new JSONObject(responseBody);
            JSONArray candidates = json.getJSONArray("candidates");
            JSONObject content = candidates.getJSONObject(0).getJSONObject("content");
            JSONArray parts = content.getJSONArray("parts");
            return parts.getJSONObject(0).getString("text");
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}

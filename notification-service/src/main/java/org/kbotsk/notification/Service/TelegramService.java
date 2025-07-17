package org.kbotsk.notification.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class TelegramService {

   private final String BOT_TOKEN = "8137166915:AAEXprEwMUfL7KpdqqUlv3YHImoBjmIuYzU"; // ← вставь сюда токен
   private final String CHAT_ID = "379150572";             // ← вставь chat_id

   private final RestTemplate restTemplate = new RestTemplate();

   public void sendTelegramMessage(String message) {
      String url = "https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage";

      Map<String, String> body = new HashMap<>();
      body.put("chat_id", CHAT_ID);
      body.put("text", message);

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);

      HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);
      restTemplate.postForEntity(url, request, String.class);
   }
}

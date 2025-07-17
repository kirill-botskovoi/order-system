package org.kbotsk.notification.Controller;

import org.kbotsk.notification.Service.TelegramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification/telegram")
public class TelegramController {

   private final TelegramService telegramService;

   public TelegramController(TelegramService telegramService) {
      this.telegramService = telegramService;
   }

   @PostMapping("/send")
   public ResponseEntity<String> sendMessage(@RequestParam String text) {
      telegramService.sendTelegramMessage(text);
      return ResponseEntity.ok("Message sent to Telegram!");
   }
}


package org.kbotsk.notification.Controller;

import org.kbotsk.notification.Service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification/email")
public class EmailController {

   private final EmailService emailService;

   public EmailController(EmailService emailService) {
      this.emailService = emailService;
   }

   @PostMapping("/send")
   public ResponseEntity<String> sendTestEmail(@RequestParam String to) {
      emailService.sendEmail(to, "Test Subject", "Hello from AWS SES!");
      return ResponseEntity.ok("Email sent to " + to);
   }
}


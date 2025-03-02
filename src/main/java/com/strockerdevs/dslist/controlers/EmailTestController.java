package com.strockerdevs.dslist.controlers;

import com.strockerdevs.dslist.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailTestController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-email")
    public String sendEmail(
            @RequestParam String from,
            @RequestParam String subject,
            @RequestParam String text
    ) {
        try {
            String siteEmail = "stocker.caicara@gmail.com";
            String fullMessage = "Mensagem enviada por: " + from + "\n\n" + text;

            emailService.sendEmail(siteEmail, subject, fullMessage);
            return "E-mail enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar o e-mail. Por favor, tente novamente.";
        }
    }

}

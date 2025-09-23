package com.marketplaceautopartes.marketplaceapi.util;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.ByteArrayInputStream;

@Component
@RequiredArgsConstructor
public class EmailUtil {
    private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;

    public void sendEmail(Mail mail) throws MessagingException {
        try {
            System.out.println("=== INICIANDO ENVÍO DE CORREO ===");
            System.out.println("De: " + mail.getFrom());
            System.out.println("Para: " + mail.getTo());
            System.out.println("Asunto: " + mail.getSubject());

            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED);

            Context context = new Context();
            context.setVariables(mail.getModel());
            System.out.println("Contexto creado con variables: " + mail.getModel());

            System.out.println("Procesando template...");
            String html = templateEngine.process("email/email-template", context);
            System.out.println("Template procesado exitosamente");

            helper.setTo(mail.getTo());
            helper.setText(html, true);
            helper.setSubject(mail.getSubject());
            helper.setFrom(mail.getFrom());

            // Comentar el attachment temporalmente
            // helper.addAttachment("MyTestFyle.txt", new ByteArrayResource("test".getBytes()));

            System.out.println("Enviando mensaje...");
            emailSender.send(message);
            System.out.println("=== CORREO ENVIADO EXITOSAMENTE ===");

        } catch (Exception e) {
            System.out.println("=== ERROR EN EMAILUTIL ===");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
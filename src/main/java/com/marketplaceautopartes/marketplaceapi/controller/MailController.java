package com.marketplaceautopartes.marketplaceapi.controller;
import com.marketplaceautopartes.marketplaceapi.dto.PersonaDTO;
import com.marketplaceautopartes.marketplaceapi.model.ResetMail;
import com.marketplaceautopartes.marketplaceapi.service.ILoginService;
import com.marketplaceautopartes.marketplaceapi.service.IResetMailService;
import com.marketplaceautopartes.marketplaceapi.util.EmailUtil;

import com.marketplaceautopartes.marketplaceapi.util.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {

    private final ILoginService loginService;
    private final IResetMailService resetMailService;
    private final EmailUtil emailUtil;

    @PostMapping("/sendMail")
    public ResponseEntity<Integer> sendMail(@RequestBody PersonaDTO personaDTO) throws Exception {
        int rpta = 0;
        final int EXPIRATION_TIME = 10;

        String email = personaDTO.getPercorreo(); // Obtener el email del DTO

        System.out.println("=== ENVIANDO CORREO DIRECTO ===");
        System.out.println("Email destino: " + email);

        // Validar que el email no esté vacío
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Error: Email vacío");
            return ResponseEntity.ok(0);
        }

        // Crear token sin asociar a usuario específico
        ResetMail resetMail = new ResetMail();
        resetMail.setRandom(UUID.randomUUID().toString());
        resetMail.setUser(null);
        resetMail.setExpiration(EXPIRATION_TIME);

        Mail mail = new Mail();
        mail.setFrom("amstrong1718@gmail.com");
        mail.setTo(email);
        mail.setSubject("RESET PASSWORD MEDIAPP");

        Map<String, Object> model = new HashMap<>();
        String url = "http://localhost:4200/#/forgot/" + resetMail.getRandom();
        model.put("user", email);
        model.put("resetUrl", url);
        mail.setModel(model);

        try {
            System.out.println("Intentando enviar correo...");
            emailUtil.sendEmail(mail);
            System.out.println("Correo enviado exitosamente");
            rpta = 1;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            rpta = 0;
        }

        return ResponseEntity.ok(rpta);
    }

    // Resto de métodos igual...
    @GetMapping("/reset/check/{random}")
    public ResponseEntity<Integer> checkRandom(@PathVariable("random") String random){
        int rpta = 0;

        ResetMail rm = resetMailService.findByRandom(random);
        if(rm != null && rm.getIdResetMail() > 0){
            if(!rm.isExpired()){
                rpta = 1;
            }
        }

        return ResponseEntity.ok(rpta);
    }

    @PostMapping("/reset/{random}")
    public ResponseEntity<Integer> resetPassword(@PathVariable("random") String random, @RequestBody String password){
        int rpta = 0;

        String cleanPassword = password.trim().replace("\"", "");

        ResetMail rm = resetMailService.findByRandom(random);
        if(rm != null && rm.getIdResetMail() > 0){
            if(!rm.isExpired()){
                loginService.changePassword(cleanPassword, rm.getUser().getUsername());
                resetMailService.delete(rm);
                rpta = 1;
            }
        }

        return ResponseEntity.ok(rpta);
    }
}
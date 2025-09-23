package com.marketplaceautopartes.marketplaceapi.controller;
import com.marketplaceautopartes.marketplaceapi.model.ResetMail;
import com.marketplaceautopartes.marketplaceapi.model.Usuario;
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
    public ResponseEntity<Integer> sendMail(@RequestBody String email) throws Exception {
        int rpta = 0;
        final int EXPIRATION_TIME = 10;

        String cleanEmail = email.trim().replace("\"", "");

        System.out.println("=== ENVIANDO CORREO DIRECTO ===");
        System.out.println("Email destino: " + cleanEmail);

        // Crear token sin asociar a usuario específico
        ResetMail resetMail = new ResetMail();
        resetMail.setRandom(UUID.randomUUID().toString());
        resetMail.setUser(null); // o crear un usuario temporal
        resetMail.setExpiration(EXPIRATION_TIME);
        // resetMailService.save(resetMail); // Solo si quieres guardar el token

        Mail mail = new Mail();
        mail.setFrom("amstrong1718@gmail.com");
        mail.setTo(cleanEmail); // Usar directamente el email
        mail.setSubject("RESET PASSWORD MEDIAPP");

        Map<String, Object> model = new HashMap<>();
        String url = "http://localhost:4200/#/forgot/" + resetMail.getRandom();
        model.put("user", cleanEmail); // Usar el email como usuario
        model.put("resetUrl", url);
        mail.setModel(model);

        try {
            emailUtil.sendEmail(mail);
            rpta = 1;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            rpta = 0;
        }

        return ResponseEntity.ok(rpta);
    }

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

        // Limpiar la contraseña de espacios y comillas
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
package org.example.evalbonnabaud.controller;

import org.example.evalbonnabaud.dao.UtilisateurDao;
import org.example.evalbonnabaud.model.Utilisateur;
import org.example.evalbonnabaud.security.AppUserDetails;
import org.example.evalbonnabaud.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Autowired
    protected UtilisateurDao utilisateurDao;

    @Autowired
    protected AuthenticationProvider authenticationProvider;

    @Autowired
    protected JwtUtils jwtUtils;

    @PostMapping("/inscription")
    public ResponseEntity<Utilisateur> inscription(@RequestBody Utilisateur utilisateur) {

        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));

        utilisateurDao.save(utilisateur);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/connexion")
    public ResponseEntity<String> connexion(@RequestBody Utilisateur utilisateur) {

        try {
            AppUserDetails userDetails = (AppUserDetails) authenticationProvider.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            utilisateur.getPseudo(), utilisateur.getPassword()
                    )).getPrincipal();

            String jwt = jwtUtils.generateToken(userDetails);

            return ResponseEntity.ok(jwt);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}















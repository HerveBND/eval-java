package org.example.evalbonnabaud.security;


import org.example.evalbonnabaud.dao.UtilisateurDao;
import org.example.evalbonnabaud.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    protected UtilisateurDao utilisateurDao;

    @Override
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {

        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findByPseudo(pseudo);

        if(optionalUtilisateur.isEmpty()) {
            throw new UsernameNotFoundException("Email introuvable : " + pseudo);
        }

        return new AppUserDetails(optionalUtilisateur.get());
    }
}

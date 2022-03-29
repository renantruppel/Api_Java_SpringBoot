package dio.financial.service.financialservice.modulos.usuarios.service;


import dio.financial.service.financialservice.modulos.usuarios.Entities.Usuarios;
import dio.financial.service.financialservice.modulos.usuarios.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Component
public class UsuariosLoginService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private PasswordEncoder encoder;

    public Usuarios checarLogin(String login, String senha) {
        Usuarios usuario = usuariosRepository.FindByAccount(login);

        if(encoder.matches(senha,usuario.getSenha())) {
            System.out.println(usuario);
            System.out.println("ok2");
            return usuario;
        }
        else {
            usuario = null;
            System.out.println(usuario);
            return usuario;
        }
    }

}

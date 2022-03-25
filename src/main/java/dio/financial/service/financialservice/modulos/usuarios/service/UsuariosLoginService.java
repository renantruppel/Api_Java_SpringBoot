package dio.financial.service.financialservice.modulos.usuarios.service;


import dio.financial.service.financialservice.modulos.usuarios.Entities.Usuarios;
import dio.financial.service.financialservice.modulos.usuarios.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class UsuariosLoginService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public Usuarios checarLogin(String login,String senha) {
        return usuariosRepository.FindByAccount(login, senha);
    }

}

package dio.financial.service.financialservice.modulos.usuarios.util;

import dio.financial.service.financialservice.modulos.usuarios.Entities.Usuarios;
import org.springframework.stereotype.Component;

@Component
public class UsuariosUtil {

    public boolean validateUsuario(Usuarios usuario) {

        if(usuario.getTelefone() != null && usuario.getTelefone().length() < 10
        && usuario.getTelefone() != "") {
            return false;
        }
        if(usuario.getPerfil() != 'a' && usuario.getPerfil() != '0') {
            return false;
        }
        return true;
    }
}

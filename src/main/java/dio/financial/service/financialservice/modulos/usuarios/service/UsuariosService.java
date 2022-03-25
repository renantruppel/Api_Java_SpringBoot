package dio.financial.service.financialservice.modulos.usuarios.service;



import dio.financial.service.financialservice.modulos.usuarios.Entities.Usuarios;
import dio.financial.service.financialservice.modulos.usuarios.Repository.UsuariosListarPorFiltrosRepository;
import dio.financial.service.financialservice.modulos.usuarios.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private UsuariosListarPorFiltrosRepository listarPorFiltrosRepository;

    public Usuarios novoUsuario(Usuarios usuario) {

        if(usuario.getStatus() != 'a' && usuario.getStatus() != 'c') {
            usuario.setStatus('a');
        }
        Usuarios u = usuariosRepository.save(usuario);
        return u;
    }

    public void deletarUsuario(int id) {

        usuariosRepository.deleteById(id);
    }

    public Optional<Usuarios> procurarPorId(int id) {
        Optional<Usuarios> u = usuariosRepository.findById(id);
        return u;
    }


    @Transactional
    public int modificarUsuario(int id, Usuarios usuario) {

        return usuariosRepository.modificarUsuarioById(id, usuario.getNome(), usuario.getLogin(), usuario.getSenha(),
                usuario.getTelefone(),usuario.getEmail(), usuario.getPerfil(),usuario.getStatus());
    }

    public List<Usuarios> listarPorFiltros(String nome, String email) {

        return listarPorFiltrosRepository.listarPorFiltros(nome, email);
    }
}

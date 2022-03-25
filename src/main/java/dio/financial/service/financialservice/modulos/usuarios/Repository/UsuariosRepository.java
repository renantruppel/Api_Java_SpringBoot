package dio.financial.service.financialservice.modulos.usuarios.Repository;

import dio.financial.service.financialservice.modulos.clientes.model.Clientes;
import dio.financial.service.financialservice.modulos.usuarios.Entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

    @Modifying
    @Query("Update Usuarios u set u.nome = :nome, u.login = :login, u.senha = :senha," +
            " u.telefone = :telefone, u.email= :email, u.perfil = :perfil, u.status = :status where u.id = :id")
    int modificarUsuarioById(int id, String nome, String login, String senha,
                String telefone,String email, Character perfil, Character status);

    /*
    @Query("Select c from Clientes c where c.nome = :nome and c.cpf_cnpj = :cpf_cnpj and c.cidade = :cidade and c.uf = :uf")
    Usuarios listarPorFiltros(String nome, String email);*/

    @Query("select u from Usuarios u where u.login = :login and u.senha = :senha")
    Usuarios FindByAccount(String login, String senha);

}

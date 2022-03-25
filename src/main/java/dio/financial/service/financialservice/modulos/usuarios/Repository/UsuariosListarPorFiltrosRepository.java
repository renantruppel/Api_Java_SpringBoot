package dio.financial.service.financialservice.modulos.usuarios.Repository;


import dio.financial.service.financialservice.modulos.livro_caixa.Entities.Livro_Caixa;
import dio.financial.service.financialservice.modulos.usuarios.Entities.Usuarios;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UsuariosListarPorFiltrosRepository {

    private final EntityManager em;

    public UsuariosListarPorFiltrosRepository(EntityManager em) {
        this.em = em;
    }

    public List<Usuarios> listarPorFiltros(String nome, String email) {

        String query = "select u from Usuarios as u where";
        boolean repetido = false;

        if(nome != null && nome.length() > 0) {
            query += " u.nome = :nome";
            repetido = true;
        }
        if(email != null && email.length() > 0) {
            query += repetido ? " and u.email = :email" : " u.email = :email";
        }

        System.out.println(query);

        var q = em.createQuery(query, Usuarios.class);

        if(nome != null && nome.length() > 0) {
            q.setParameter("nome",nome);
        }
        if(email != null && email.length() > 0) {
            q.setParameter("email",email);
        }

        return q.getResultList();

    }
}

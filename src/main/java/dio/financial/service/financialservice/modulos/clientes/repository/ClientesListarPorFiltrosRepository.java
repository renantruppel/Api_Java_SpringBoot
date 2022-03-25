package dio.financial.service.financialservice.modulos.clientes.repository;

import dio.financial.service.financialservice.modulos.clientes.model.Clientes;
import dio.financial.service.financialservice.modulos.usuarios.Entities.Usuarios;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class ClientesListarPorFiltrosRepository {

    private final EntityManager em;

    public ClientesListarPorFiltrosRepository(EntityManager em) {
        this.em = em;
    }


    public List<Clientes> listarPorFiltros(String nome, String cpf_cnpj, String cidade, String uf) {

        String query = "select c from Clientes as c where";
        boolean repetido = false;

        if (nome != null && nome.length() > 0) {
            query += " c.nome = :nome";
            repetido = true;
        }
        if (cpf_cnpj != null && cpf_cnpj.length() > 0) {
            query += repetido ? " and c.cpf_cnpj = :cpf_cnpj" : " c.cpf_cnpj = :cpf_cnpj";
            repetido = true;
        }
        if (cidade != null && cidade.length() > 0) {
            query += repetido ? " and c.cidade = :cidade" : " c.cidade = :cidade";
            repetido = true;
        }
        if (uf != null && uf.length() > 0) {
            query += repetido ? " and c.uf = :uf" : " c.uf = :uf";
        }

        System.out.println(query);

        var q = em.createQuery(query, Clientes.class);

        if (nome != null && nome.length() > 0) {
            q.setParameter("nome", nome);
        }
        if (cpf_cnpj != null && cpf_cnpj.length() > 0) {
            q.setParameter("cpf_cnpj", cpf_cnpj);
        }
        if (cidade != null && cidade.length() > 0) {
            q.setParameter("cidade", cidade);
        }
        if (uf != null && uf.length() > 0) {
            q.setParameter("uf", uf);
        }

        return q.getResultList();
    }
}

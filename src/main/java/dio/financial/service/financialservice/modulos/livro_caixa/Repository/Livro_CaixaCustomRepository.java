package dio.financial.service.financialservice.modulos.livro_caixa.Repository;

import dio.financial.service.financialservice.modulos.livro_caixa.Entities.Livro_Caixa;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class Livro_CaixaCustomRepository {

    private final EntityManager em;

    public Livro_CaixaCustomRepository(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Modifying
    public List<Livro_Caixa> modificarPorFiltros(int id_cliente, String descricao, Character tipo, double valor,
                                                 Long id) {

        Long _id = id;
        String query = "Update Livro_Caixa l set";
        boolean repetido = false;

        if(id_cliente >= 1) {
            query += " l.id_cliente = :id_cliente";
            repetido = true;
        }
        if(descricao != null) {
            query += repetido ? " ,l.descricao = :descricao" : " l.descricao = :descricao";
            repetido = true;
        }
        if(tipo != null) {
            query += repetido ? " ,l.tipo = :tipo" : " l.tipo = :tipo";
            repetido = true;
        }
        if(valor < 0 || valor > 0) {
            query += repetido ? " ,l.valor = :valor" : " l.valor = :valor";
        }
        query += " where l.id = :_id";
        System.out.println(query);

        var q = em.createQuery(query);

        //q.setParameter("id",id);

        if(id_cliente >= 1) {
            q.setParameter("id_cliente",id_cliente);
        }
        if(descricao != null) {
            q.setParameter("descricao",descricao);
        }
        if(tipo != null) {
            q.setParameter("tipo",tipo);
        }
        if(valor < 0 || valor > 0) {
            q.setParameter("valor",valor);
        }
        q.executeUpdate();
        return q.getResultList();

    }

}

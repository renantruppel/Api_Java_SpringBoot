package dio.financial.service.financialservice.modulos.livro_caixa.Repository;

import dio.financial.service.financialservice.modulos.clientes.model.Clientes;
import dio.financial.service.financialservice.modulos.livro_caixa.Entities.Livro_Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Livro_CaixaRepository extends JpaRepository<Livro_Caixa, Integer> {


    @Modifying
    @Query("Update Livro_Caixa l set l.id_cliente = :id_cliente, l.descricao = :descricao," +
            " l.tipo = :tipo, l.valor = :valor where l.id = :id")
    int modificarPorId(Long id, int id_cliente, String descricao, Character tipo, Double valor);

    @Query("Select l from Livro_Caixa l where l.id_cliente = :id")
    List<Livro_Caixa> listarPorFiltros(int id);

    @Query("Select l from Livro_Caixa l where l.id = :id")
    Livro_Caixa findByLongId(Long id);

    @Modifying
    @Query("delete from Livro_Caixa l where l.id = :id")
    int deleteByLongId(Long id);

}

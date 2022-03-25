package dio.financial.service.financialservice.modulos.clientes.repository;

import dio.financial.service.financialservice.modulos.clientes.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Optional;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

    @Modifying
    @Query("Update Clientes c set c.nome = :nome, c.cep = :cep, c.cidade = :cidade," +
            " c.uf = :uf, c.email= :email, c.cpf_cnpj = :cpf_cnpj, c.logradouro = :logradouro, " +
            "c.telefone = :telefone where c.id = :id")
    int modificarClienteById(int id, String nome, String cep, String cidade,
                             String uf,String email, String cpf_cnpj, String logradouro, String telefone);


    @Query("Select c from Clientes c where c.nome = :nome and c.cpf_cnpj = :cpf_cnpj and c.cidade = :cidade and c.uf = :uf")
    Clientes listarPorFiltros(String nome, String cpf_cnpj, String cidade, String uf);


}

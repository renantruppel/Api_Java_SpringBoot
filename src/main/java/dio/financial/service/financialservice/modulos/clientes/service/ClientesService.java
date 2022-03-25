package dio.financial.service.financialservice.modulos.clientes.service;

import dio.financial.service.financialservice.modulos.clientes.model.Clientes;
import dio.financial.service.financialservice.modulos.clientes.repository.ClientesListarPorFiltrosRepository;
import dio.financial.service.financialservice.modulos.clientes.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private ClientesListarPorFiltrosRepository clientesListarPorFiltros;

    public Clientes novoCliente(Clientes cliente) {

        Clientes c = clientesRepository.save(cliente);
        return c;
    }

    public void deletarCliente(int id) {

        clientesRepository.deleteById(id);
    }

    public Optional<Clientes> procurarPorId(int id) {
        Optional<Clientes> c = clientesRepository.findById(id);
        return c;
    }

    @Transactional
    public int modificarCliente(int id, Clientes cliente) {
        return clientesRepository.modificarClienteById(id, cliente.getNome(), cliente.getCep(), cliente.getCidade(),
                cliente.getUf(), cliente.getEmail(), cliente.getCpf_cnpj(),cliente.getLogradouro(),
                cliente.getTelefone());
    }

    public List<Clientes> listarPorFiltros(String nome, String cpf_cnpj, String cidade, String uf) {

        return clientesListarPorFiltros.listarPorFiltros(nome, cpf_cnpj, cidade, uf);
    }


}

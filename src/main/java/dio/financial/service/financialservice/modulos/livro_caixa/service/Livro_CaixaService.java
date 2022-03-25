package dio.financial.service.financialservice.modulos.livro_caixa.service;


import dio.financial.service.financialservice.modulos.livro_caixa.Entities.Livro_Caixa;
import dio.financial.service.financialservice.modulos.livro_caixa.Repository.Livro_CaixaCustomRepository;
import dio.financial.service.financialservice.modulos.livro_caixa.Repository.Livro_CaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class Livro_CaixaService {

    @Autowired
    private Livro_CaixaRepository livro_caixaRepository;
    @Autowired
    private Livro_CaixaCustomRepository livro_caixaCustomRepository;

    public Livro_Caixa novoLancamento(Livro_Caixa livro_caixa) {

        Livro_Caixa u = livro_caixaRepository.save(livro_caixa);
        return u;
    }

    @Transactional
    public int deletarLancamento(Long id) {
        return livro_caixaRepository.deleteByLongId(id);

    }

    public Livro_Caixa procurarPorId(Long id) {
        Livro_Caixa u = livro_caixaRepository.findByLongId(id);
        return u;
    }

    @Transactional
    public int modificarPorFiltros(Long id, Livro_Caixa l) {

        return livro_caixaRepository.modificarPorId(id,l.getId_cliente(),l.getDescricao(),
                l.getTipo(),l.getValor());
    }

    public List<Livro_Caixa> listarPorFiltros(int id) {

        return livro_caixaRepository.listarPorFiltros(id);
    }
}

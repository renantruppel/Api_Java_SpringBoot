package dio.financial.service.financialservice.modulos.livro_caixa.controller;


import dio.financial.service.financialservice.modulos.livro_caixa.Entities.Livro_Caixa;
import dio.financial.service.financialservice.modulos.livro_caixa.service.Livro_CaixaService;
import dio.financial.service.financialservice.modulos.livro_caixa.util.Livro_CaixaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/livro_caixa")
public class Livro_CaixaController {

    @Autowired
    private Livro_CaixaService livro_caixaService;

    @Autowired
    private Livro_CaixaUtil livro_caixaUtil;

    @PostMapping
    public @ResponseBody
    Livro_Caixa novoLancamento(Livro_Caixa livro) {

        try {
            if(livro_caixaUtil.validarLivro_Caixa(livro) == false) {
                //System.out.println("ok");
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
            //System.out.println("ok");
            return livro_caixaService.novoLancamento(livro);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Livro_Caixa ProcurarPorId(@PathVariable Long id) {
        Livro_Caixa l = livro_caixaService.procurarPorId(id);
        if(l == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return l;
    }

    @PutMapping(path = "/modificar/{id}")
    public @ResponseBody
    String modificarUsuario(@PathVariable Long id, Livro_Caixa l) {
        try{
            if(livro_caixaUtil.validarLivro_Caixa(l) == false) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
            int i = livro_caixaService.modificarPorFiltros(id, l);
            if( i == 1) {
                return "modificado com sucesso";
            }
            return "Não foi possível encontrar o id";
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        try{
            int i = livro_caixaService.deletarLancamento(id);
            if(i == 1) {
                return "Deletado com sucesso";
            }
            return "Não foi encontrado um registro com o id informado";
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/listarPorFiltros/{id}")
    public List<Livro_Caixa> listarPorFiltros(@PathVariable int id) {
        try {
            return livro_caixaService.listarPorFiltros(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

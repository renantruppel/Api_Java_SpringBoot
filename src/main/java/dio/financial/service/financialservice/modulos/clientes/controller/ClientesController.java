package dio.financial.service.financialservice.modulos.clientes.controller;

import dio.financial.service.financialservice.modulos.clientes.model.Clientes;
import dio.financial.service.financialservice.modulos.clientes.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @PostMapping
    public @ResponseBody Clientes novoCliente(Clientes c) {
        try{
            Clientes clientes = clientesService.novoCliente(c);
            if(clientes != null) {
                return clientes;
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Optional<Clientes> ProcurarPorId(@PathVariable int id) {
        try {
            return clientesService.procurarPorId(id);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/modificarcliente/{id}")
    public @ResponseBody
    Clientes modificarCliente(@PathVariable int id, Clientes cliente) {
        try{
           int i = clientesService.modificarCliente(id, cliente);
           if(i == 1) {
               return cliente;
           }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody void deletarCliente(@PathVariable int id) {
        try{
            clientesService.deletarCliente(id);

        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/listarPorFiltros")
    public @ResponseBody List<Clientes> listarPorFiltros(@RequestHeader String nome, @RequestHeader String cpf_cnpj,
                                           @RequestHeader String cidade, @RequestHeader String uf) {
        try{
            return clientesService.listarPorFiltros(nome, cpf_cnpj, cidade, uf);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

package dio.financial.service.financialservice;


import antlr.collections.List;
import dio.financial.service.financialservice.modulos.clientes.model.Clientes;
import dio.financial.service.financialservice.modulos.clientes.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@Component
public class JavaApp implements CommandLineRunner {

    @Autowired
    private ClientesRepository clientesRepository;

    /*public String returnValues() {

        //List<Clientes> cliente = new ArrayList<Clientes>();
        for(Clientes c: clientesRepository.findAll()) {
            System.out.println(c);
        }
        return "ok";
    }*/

    @Override
    public void run(String... args) throws Exception {
        /*Clientes c = new Clientes("Renan", "123", "rua",
                "SBC", "SP", "09812620", "4123", "s@gmail.com");
        clientesRepository.save(c);*/



    }
}

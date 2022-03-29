package dio.financial.service.financialservice.modulos.livro_caixa.util;


import dio.financial.service.financialservice.modulos.livro_caixa.Entities.Livro_Caixa;
import org.springframework.stereotype.Component;

@Component
public class Livro_CaixaUtil {

    public boolean validarLivro_Caixa(Livro_Caixa l) {

        char tipo = Character.toLowerCase(l.getTipo());

        if(tipo != 'd' && tipo != 'c') {
            return false;
        }
        return true;
    }
}

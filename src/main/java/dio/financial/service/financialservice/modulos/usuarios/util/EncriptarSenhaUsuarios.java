package dio.financial.service.financialservice.modulos.usuarios.util;

import dio.financial.service.financialservice.FinancialServiceApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})*/
public class EncriptarSenhaUsuarios {

    /*public static void main(String[] args) {
        SpringApplication.run(FinancialServiceApplication.class, args);
    }*/
/*
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }*/

}

package dio.financial.service.financialservice.modulos.clientes.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "data_cadastro")
    private Date dataCadastro;

    @PrePersist
    private void onCreate() {
        dataCadastro = new Date();
    }

    @Column(length = 30, nullable = false)
    private String nome;

    @Column(length = 14, nullable = false, unique = true)
    private String cpf_cnpj;

    @Column(length = 50,nullable = false)
    private String logradouro;

    @Column(length = 40, nullable = false)
    private String cidade;

    @Column(length = 2, nullable = false)
    private String uf;

    @Column(length = 8, nullable = false)
    private String cep;

    @Column(length = 11)
    private String telefone;

    @Column(length = 100)
    private String email;


    public Clientes(String nome, String cpf_cnpj, String logradouro, String cidade, String uf, String cep, String telefone, String email) {
        this.dataCadastro = new Date();
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
    }

    public Clientes(){}


    public Integer getId() {
        return id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    /*public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }*/
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package dio.financial.service.financialservice.modulos.usuarios.Entities;


import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Usuarios {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "data_cadastro")
    private Date dataCadastro;

    @PrePersist
    private void onCreate() {
        dataCadastro = new Date();
        status = 'a';
    }

    @Column(length = 30, nullable = false)
    private String nome;

    @Column(length = 15, nullable = false, unique = true)
    private String login;

    @Column(length = 10, nullable = false)
    private String senha;

    @Column(length = 11)
    private String telefone;

    @Column(length = 100, unique = true)
    private String email;

    @Column(length = 1, nullable = false)
    private Character perfil;

    @Column(length = 1, nullable = false)
    private Character status;

    public Usuarios(String nome, String login, String senha,
                    String telefone, String email, Character perfil) {
        this.dataCadastro = null;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
        this.perfil = perfil;
        this.status = 'a';
    }

    public Usuarios() {}


    public Integer getId() {
        return id;
    }

    /*public void setId(Integer id) {
        this.id = id;
    }*/

    public Date getDataCadastro() {
        return dataCadastro;
    }

    /*public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }*/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getPerfil() {
        return perfil;
    }

    public void setPerfil(Character perfil) {
        this.perfil = perfil;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }


}

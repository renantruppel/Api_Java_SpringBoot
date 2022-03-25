package dio.financial.service.financialservice.modulos.usuarios.dtos;

import dio.financial.service.financialservice.modulos.usuarios.Entities.Usuarios;

import java.util.Date;

public class DisplayUsuarioDto {

    private Integer id;

    private Date dataCadastro;

    private String nome;

    private String login;

    private String telefone;

    private String email;

    private Character perfil;

    private Character status;

    public DisplayUsuarioDto(Usuarios usuario) {
        this.id = usuario.getId();
        this.dataCadastro = usuario.getDataCadastro();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.telefone = usuario.getTelefone();
        this.telefone = usuario.getTelefone();
        this.email = usuario.getEmail();
        this.perfil = usuario.getPerfil();
        this.status = usuario.getStatus();
    }

    public DisplayUsuarioDto(){}

}

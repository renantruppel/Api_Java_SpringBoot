package dio.financial.service.financialservice.modulos.livro_caixa.Entities;


import javax.persistence.Entity;

import dio.financial.service.financialservice.modulos.clientes.model.Clientes;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "livro_caixa")
//@SecondaryTable(name = "clientes", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id_cliente", referencedColumnName = "id"))
public class Livro_Caixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false /*table = "clientes"*/)
    private Integer id_cliente;


    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "data_lancamento")
    private Date dataLancamento;

    @PrePersist
    private void onCreate() {
        dataLancamento = new Date();
    }

    @Column(length = 50, nullable = false)
    private String descricao;

    @Column(length = 1, nullable = false)
    private char tipo;

    @Column(nullable = false)
    private Double valor;

    public Livro_Caixa(int id_cliente, String descricao, char tipo, Double valor) {
        this.id_cliente = id_cliente;
        this.dataLancamento = null;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Livro_Caixa(){}

    public Long getId() {
        return id;
    }
/*
    public void setId(Long id) {
        this.id = id;
    }*/

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }
/*
    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }*/

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}

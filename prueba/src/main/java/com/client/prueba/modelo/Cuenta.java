package com.client.prueba.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "tcuentas")
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtcuenta;

    @Column(name = "IDTCLIENTE")
    private Long idtcliente;

    @Column(name = "TIPOCUENTA")
    private String tipocuenta;
    @Column(name = "SALDOINICIAL")
    private BigDecimal saldoinicial;
    @Column(name = "ESTADO")
    private boolean estado;
    @Column(name = "NUMEROCUENTA")
    private int numerocuenta;

//    @OneToOne(fetch = FetchType.LAZY )
//    @JoinColumn( name="idtcliente",referencedColumnName="idtcliente",insertable=false, updatable=false)
//    private Cliente cliente;

    public Cuenta(Long idtcuenta,Long idtcliente, String tipocuenta, BigDecimal saldoinicial, boolean estado, int numerocuenta) {
        this.idtcuenta=idtcuenta;
        this.idtcliente=idtcliente;
        this.tipocuenta = tipocuenta;
        this.saldoinicial = saldoinicial;
        this.estado = estado;
        this.numerocuenta = numerocuenta;
    }

    public Cuenta() {}

    public Long getIdtcuenta() {
        return idtcuenta;
    }

    public void setIdtcuenta(Long idtcuenta) {
        this.idtcuenta = idtcuenta;
    }

    public int getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(int numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public BigDecimal getSaldoinicial() {
        return saldoinicial;
    }

    public void setSaldoinicial(BigDecimal saldoinicial) {
        this.saldoinicial = saldoinicial;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Long getIdtcliente() {
        return idtcliente;
    }

    public void setIdtcliente(Long idtcliente) {
        this.idtcliente = idtcliente;
    }


//    public Cliente getCliente() {
//        return cliente;
//    }
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }

}

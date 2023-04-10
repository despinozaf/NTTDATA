package com.client.prueba.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tmovimientos")
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtmovimiento;
    @Column(name = "FECHA")
    private Date fecha;
    @Column(name = "TIPOMOVIMIENTO")
    private String tipomovimiento;
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "SALDO")
    private BigDecimal saldo;
    @Column(name = "NUMEROCUENTA")
    private int numerocuenta;

//    @OneToOne(fetch = FetchType.LAZY )
//    @JoinColumn( name="numerocuenta",referencedColumnName="numerocuenta",insertable=false, updatable=false)
//    private Cuenta cuenta;

    public Movimiento(Long idtmovimiento, Date fecha, String tipomovimiento, BigDecimal valor, BigDecimal saldo, int numerocuenta) {
        this.fecha = fecha;
        this.tipomovimiento = tipomovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.numerocuenta = numerocuenta;
        this.idtmovimiento=idtmovimiento;
    }

    public Long getIdtmovimiento() {
        return idtmovimiento;
    }

    public void setIdtmovimiento(Long idtmovimiento) {
        this.idtmovimiento = idtmovimiento;
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(int numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public Movimiento() {

    }


    public String getTipomovimiento() {
        return tipomovimiento;
    }

    public void setTipomovimiento(String tipomovimiento) {
        this.tipomovimiento = tipomovimiento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

//        public Cuenta getCuenta() {
//        return cuenta;
//    }
//
//    public void setCuenta(Cuenta cuenta) {
//        this.cuenta = cuenta;
//    }

}

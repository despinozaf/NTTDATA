package com.client.prueba.modelo;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class MovimientosResponse {

    private Long idtmovimiento;

    private Date fecha;

    private String tipomovimiento;

    private BigDecimal valor;

    private BigDecimal saldo;

    private int numerocuenta;

    private String tipocuenta;

}

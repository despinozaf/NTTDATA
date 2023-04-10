package com.client.prueba.Dao;


import com.client.prueba.modelo.Cuenta;
import com.client.prueba.modelo.Persona;
import com.client.prueba.modelo.Cliente;
import com.client.prueba.modelo.Movimiento;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;

public interface GeneralDao {
	List<Persona> getAllPersona();
	Long savePersona(Persona persona);
	Long saveCliente(Cliente cliente);
	Long saveCuenta(Cuenta cuenta);
	Long saveMovimiento(Movimiento movimiento);
	BigDecimal findSaldoActual(int numerocuenta);
	BigDecimal findSaldoInicial(int numerocuenta);
	List<Movimiento> findAllByFecha(Date finicio, Date ffin, int cuenta);
}

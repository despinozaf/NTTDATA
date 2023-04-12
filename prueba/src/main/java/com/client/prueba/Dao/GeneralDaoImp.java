package com.client.prueba.Dao;

import com.client.prueba.modelo.Cuenta;
import com.client.prueba.modelo.Movimiento;
import com.client.prueba.modelo.Persona;
import com.client.prueba.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public class GeneralDaoImp implements GeneralDao {

	@Autowired
	PersonaRepository PersonaJPA;

	@Autowired
	ClienteRepository ClienteJPA;

	@Autowired
	CuentaRepository CuentaJPA;

	@Autowired
	MovimientoRepository MovimientoJPA;
	@Override
	public List<Persona> getAllPersona() {
		return PersonaJPA.findAll();
	}

	@Override
	public Long savePersona(Persona persona) {
		Long id=0L;
		PersonaJPA.save(persona);
		PersonaJPA.flush();
		System.out.println("idPersona: "+persona.getIdtpersona());
		id=persona.getIdtpersona();
		return id;
	}

	@Override
	public Long saveCliente(Cliente cliente) {
		Long id=0L;
		ClienteJPA.save(cliente);
		ClienteJPA.flush();
		System.out.println("idCliente: "+cliente.getIdtcliente());
		id=cliente.getIdtcliente();
		return id;
	}

	@Override
	public Long saveCuenta(Cuenta cuenta) {
		Long id=0L;
		CuentaJPA.save(cuenta);
		CuentaJPA.flush();
		System.out.println("idCuenta: "+cuenta.getIdtcuenta());
		id=cuenta.getIdtcuenta();
		return id;
	}

	@Override
	public Persona getPersona(String identificacion) {
		return PersonaJPA.getPersona(identificacion);
	}

	@Override
	public Cliente getCliente(Long idtpersona) {

		return ClienteJPA.getCliente(idtpersona);
	}

	public void deleteCliente(Long idtpersona){
		ClienteJPA.deleteCliente(idtpersona);
	}
	public void deletePersona(Long idtpersona){
		PersonaJPA.deletePersona(idtpersona);
	}



	@Override
	public Long saveMovimiento(Movimiento movimiento) {
		Long id=0L;
		MovimientoJPA.save(movimiento);
		MovimientoJPA.flush();
		System.out.println("idMovimiento: "+movimiento.getIdtmovimiento());
		id=movimiento.getIdtmovimiento();
		return id;
	}

	@Override
	public BigDecimal findSaldoActual(int numerocuenta) {

		return MovimientoJPA.findSaldoActual(numerocuenta);
	}

	@Override
	public BigDecimal findSaldoInicial(int numerocuenta) {
		return CuentaJPA.findSaldoInicial(numerocuenta);
	}

	@Override
	public List<Movimiento> findAllByFecha(Date finicio, Date ffin, int cuenta) {
		System.out.println(finicio);
		return MovimientoJPA.findAllByFecha(finicio, ffin, cuenta);
	}
}

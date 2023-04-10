package com.client.prueba.Dao;

import com.client.prueba.modelo.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Repository
@Transactional
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    @Query(value = "SELECT SALDOINICIAL FROM prueba.tcuentas where NUMEROCUENTA = :numerocuenta",
            nativeQuery = true)
    BigDecimal findSaldoInicial(@Param("numerocuenta") int numerocuenta);


}

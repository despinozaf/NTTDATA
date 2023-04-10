package com.client.prueba.Dao;

import com.client.prueba.modelo.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    @Query(value = "SELECT SALDO FROM prueba.tmovimientos WHERE NUMEROCUENTA = :numerocuenta ORDER BY FECHA DESC LIMIT 1;",
            nativeQuery = true)
    BigDecimal findSaldoActual(@Param("numerocuenta") int numerocuenta);

    @Query(value = "SELECT * FROM prueba.tmovimientos tm WHERE tm.FECHA BETWEEN :finicio AND :ffin AND NUMEROCUENTA = :cuenta", nativeQuery = true)
    List<Movimiento> findAllByFecha(@Param("finicio") Date finicio,
                                     @Param("ffin") Date ffin,
                                     @Param("cuenta") int cuenta);

}



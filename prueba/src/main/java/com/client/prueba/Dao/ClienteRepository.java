package com.client.prueba.Dao;

import com.client.prueba.modelo.Cliente;
import com.client.prueba.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM prueba.tclientes WHERE idtpersona = :idtpersona",
            nativeQuery = true)
    Cliente getCliente(@Param("idtpersona") Long idtpersona);

    @Modifying
    @Query(value = "DELETE FROM prueba.tclientes WHERE idtpersona = :idtpersona",
            nativeQuery = true)
         void deleteCliente(@Param("idtpersona") Long idtpersona);

}

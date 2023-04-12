package com.client.prueba.Dao;

import com.client.prueba.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    @Query(value = "SELECT * FROM prueba.tpersonas WHERE identificacion = :identificacion",
            nativeQuery = true)
    Persona getPersona(@Param("identificacion") String identificacion);

    @Modifying
    @Query(value = "DELETE FROM prueba.tpersonas WHERE idtpersona = :idtpersona",
            nativeQuery = true)
    void deletePersona(@Param("idtpersona") Long idtpersona);

    List<Persona> findAll();
    
}

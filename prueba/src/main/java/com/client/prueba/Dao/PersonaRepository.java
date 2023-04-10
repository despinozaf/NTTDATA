package com.client.prueba.Dao;

import com.client.prueba.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    List<Persona> findAll();
    
}

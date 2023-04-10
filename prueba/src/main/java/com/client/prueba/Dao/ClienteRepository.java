package com.client.prueba.Dao;

import com.client.prueba.modelo.Cliente;
import com.client.prueba.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

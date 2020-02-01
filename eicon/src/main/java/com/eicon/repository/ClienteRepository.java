package com.eicon.repository;

import com.eicon.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eicon.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{

}

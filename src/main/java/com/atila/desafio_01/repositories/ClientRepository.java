package com.atila.desafio_01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atila.desafio_01.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}

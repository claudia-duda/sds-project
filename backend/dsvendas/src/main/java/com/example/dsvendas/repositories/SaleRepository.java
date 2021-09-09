package com.example.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}

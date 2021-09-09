package com.example.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.dsvendas.entities.Sale;
import com.example.dsvendas.dto.SaleSucessDTO;
import com.example.dsvendas.dto.SaleSumDTO;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.example.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupBySeller();
	
	@Query("SELECT new com.example.dsvendas.dto.SaleSucessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSucessDTO> sucessGroupBySeller();
}

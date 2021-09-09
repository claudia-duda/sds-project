package com.example.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dsvendas.dto.SaleDTO;
import com.example.dsvendas.dto.SaleSucessDTO;
import com.example.dsvendas.dto.SaleSumDTO;
import com.example.dsvendas.entities.Sale;
import com.example.dsvendas.repositories.SaleRepository;
import com.example.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> sales = repository.findAll(pageable);
		Page<SaleDTO> saleDTOList = sales.map(sale -> new SaleDTO(sale));
		return saleDTOList;
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupBySeller(){
		return repository.amountGroupBySeller();
	}
	@Transactional(readOnly = true)
	public List<SaleSucessDTO> sucessGroupBySeller(){
		return repository.sucessGroupBySeller();
	}
}

package com.devsuperior.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.DTO.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public List<SellerDTO> findAll() {
		List<Seller> list = sellerRepository.findAll();
		
		/* como o Page JÁ É UM STREAM DO JAVA 8, REMOVER O STREAM() E O COLLECT(COLLECTOR.TOLIST)) */
		return list.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList()); 
	}
}

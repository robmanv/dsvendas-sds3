package com.devsuperior.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.DTO.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	/* Adicionei o SellerRepository aqui pra já gerar o objeto neste momento e pesquisar no findAll pra ficar disponível em cache, toda a lista */
	@Autowired
	private SellerRepository sellerRepository;
	
	/* Para fazer operação de leitura sem LOCK DO BANCO, e tudo relacionado ao banco começa e termina aqui */	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll(); /* Como tem o AUTOWIRED, nem preciso atribuir, ele vai trazer em memória e ficará disponível para uso em outros componentes */
		
		Page<Sale> list = saleRepository.findAll(pageable);
		
		return list.map(x -> new SaleDTO(x)); 
	}
}

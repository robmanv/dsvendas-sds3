package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.DTO.SaleSumDTO;
import com.devsuperior.dsvendas.DTO.SaleSuccessDTO;
import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	/* Pode usar SQL, mas nesse caso usamos o JPQL */
	/* o FROM é exatamente o nome da classe Sale */
	/* Faço o SELECT É JÁ EFETUO O NEW NO SaleSumDTO que é o tipo do método que retorno nessa consulta */
	@Query("SELECT new com.devsuperior.dsvendas.DTO.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.devsuperior.dsvendas.DTO.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> sucessGroupedBySeller();
}

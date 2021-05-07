package com.devsuperior.dsvendas.DTO;

import java.time.LocalDate;

import com.devsuperior.dsvendas.entities.Sale;

import lombok.Data;
import lombok.NonNull;

@Data
public class SaleDTO {
	@NonNull
	private Long id;
	
	@NonNull
	private Integer visited;
	
	@NonNull
	private Integer deals;
	
	@NonNull
	private Double amount;
	
	@NonNull
	private LocalDate date;
	
	/* IMPORTANTE: A CAMADA CONTROLADORA NUNCA DEVE TER REFERENCIA A OBJETO DA CAMADA DE SERVIÇO */
	@NonNull
	private SellerDTO sellerDTO;

	public SaleDTO(Sale sale) {
		this.id = sale.getId();
		this.visited = sale.getVisited();
		this.deals = sale.getDeals();
		this.amount = sale.getAmount();
		this.date = sale.getDate();
		this.sellerDTO = new SellerDTO(sale.getSeller());
	}
	
	
	
}

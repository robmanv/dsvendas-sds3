package com.devsuperior.dsvendas.DTO;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

import lombok.Data;
import lombok.NonNull;

@Data
public class SaleSumDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NonNull
	private String sellerName;

	@NonNull
	private Double sum;
	
	
	/* Nesse contrutor é melhor passar o objeto Seller ao inves do sellerName, devido ao agrupamento de dados na consulta é por Seller e não por Name, h2 funciona mas não no PostGres */
	public SaleSumDTO(Seller seller, double sum) {
		this.sellerName = seller.getName();
		this.sum = sum;
	}
	
}

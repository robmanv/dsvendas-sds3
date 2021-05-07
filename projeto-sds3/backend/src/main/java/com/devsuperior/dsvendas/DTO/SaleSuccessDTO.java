package com.devsuperior.dsvendas.DTO;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

import lombok.Data;
import lombok.NonNull;

@Data
public class SaleSuccessDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NonNull
	private String sellerName;

	@NonNull
	private Long visited;

	@NonNull
	private Long deals;
	
	public SaleSuccessDTO(Seller seller, Long visited, Long deals) {
		this.sellerName = seller.getName();
		this.visited = visited;
		this.deals = deals;
	}
	
	
 
}

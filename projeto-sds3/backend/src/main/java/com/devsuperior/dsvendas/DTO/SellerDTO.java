package com.devsuperior.dsvendas.DTO;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

import lombok.Data;
import lombok.NonNull;

/* o Serializable é pra garantir que meu objeto possa ser transformado em bytes */

@Data
public class SellerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NonNull
	private Long id;
	
	@NonNull
	private String name;
	
	public SellerDTO(Seller seller) {
		this.id = seller.getId();
		this.name = seller.getName();
	}

}

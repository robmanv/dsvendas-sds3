package com.devsuperior.dsvendas.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_sales")
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	/* Como é MANYTOONE vai ficar fazendo SELECT 1 A 1 na base SELLER, vamos corrigir este caso, fazendo a pesquisa de todos os vendedores antes lá no SERVICE DO SALE */	
	@NonNull
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private Seller seller;
}

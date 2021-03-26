package com.ruby.biz.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "S_PRODUCT")
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;		// 상품 아이디
	
	private String name;	// 상품 이름
		
	@Column(name = "SHORT_DESC")	
	private String shortDesc;		// 상품 설명
	
	private String category;		// 카테고리	
	
	@OneToMany(mappedBy = "product")
	private List<Item> itemList = new ArrayList<>();
}

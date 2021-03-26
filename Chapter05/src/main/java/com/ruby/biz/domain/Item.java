package com.ruby.biz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "S_ITEM")
public class Item
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITEM_ID")
	private Long id;		// 주문내역 아이디
	
	@ManyToOne
	@JoinColumn(name = "ORD_ID")
	private Order order;	// 주문 참조
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;	// 상품 참조
	
	private Long price;		// 주문 가격
	
	private Long quantity;	// 주문 수량
	
	// 주문과의 양방향 참초 설정
	public void SetOrder(Order order)
	{
		this.order = order;
		
		order.getItemList().add(this);
	}
}

package com.ruby.biz.client;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ruby.biz.domain.Item;
import com.ruby.biz.domain.Order;
import com.ruby.biz.domain.Product;

public class ManyToManyBothWayRelationEntityClient
{

	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter05");
		
		try
		{
			dataInsert(emf);
			dataSelect(emf);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			emf.close();
		}
	}
	
	private static void dataSelect(EntityManagerFactory emf)
	{
		EntityManager em = emf.createEntityManager();
		
		Order order = em.find(Order.class, 1L);
		System.out.println("주문 날짜 : " + order.getOrderDate());
		System.out.println(" [ 주문 목록 ]");
		List<Item> itemList = order.getItemList();
		for(Item item : itemList)
		{
			System.out.println("---> " + item.getProduct().getName());
		}
		
	}
	
	private static void dataInsert(EntityManagerFactory emf)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// 상품 등록
		Product product1 = new Product();
		product1.setName("LG 통돌이 세탁기");
		em.persist(product1);
		
		Product product2 = new Product();
		product2.setName("갤럭시 20");
		em.persist(product2);
		
		// 주문 등록
		Order order = new Order();
		order.setOrderDate(new Date());
		em.persist(order);
		
		// 카트 등록
		Item item1 = new Item();
		item1.SetOrder(order);
		item1.setProduct(product1);
		item1.setPrice(100000L);
		item1.setQuantity(2L);
		em.persist(item1);
		
		Item item2 = new Item();
		item2.SetOrder(order);
		item2.setProduct(product2);
		item2.setPrice(270000L);
		item2.setQuantity(3L);
		em.persist(item2);		
		
		em.getTransaction().commit();
		em.close();
	}

}

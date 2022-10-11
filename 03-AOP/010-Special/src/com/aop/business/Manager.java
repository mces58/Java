package com.aop.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aop.aspect.LogAnnotation;
import com.aop.entity.Product;

@Component
public class Manager {

	private List<Product> products;

	public Manager() {
		this.products = new ArrayList<Product>();
	}

	// hangi metotda calismasini istiyorsak onun basina anatasyon ismini vermeliyiz
	@LogAnnotation
	public void insert(Product product) {
		this.products.add(product);
		System.out.println("Veri tabanina eklendi");
	}

	@LogAnnotation
	public void delete(Product product) {
		this.products.remove(product);
		System.out.println("Veri tabanindan silindi");
	}

	public void getAllProduct() {
		for (Product product : this.products) {
			System.out.println(product);
		}
	}

	public Product findProduct(int index) {
		return this.products.get(index);
	}
}
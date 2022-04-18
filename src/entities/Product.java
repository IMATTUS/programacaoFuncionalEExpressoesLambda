package entities;

public class Product {
	/*
	 * Removemos o "implements Comparable<Product>" da definição da classe
	 * e removemos o metodo compareTo da classe, fica só os gets e sets e o toString.
	 */
	private String name;
	private Double price;
	
	public Product() {
	}

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
}
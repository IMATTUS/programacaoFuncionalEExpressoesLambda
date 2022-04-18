package application;

import java.util.Comparator;

import entities.Product;

public class MyComparator implements Comparator<Product> {
	/*
	 * a classe MyComparator implementa o Comparator<Product> e n�o o Comparable<Product>
	 * 
	 * essa � apenas uma das formas poss�veis
	 */

	@Override
	public int compare(Product p1, Product p2) {
		/*
		 * returns a positive number if p1 > p2
		 * returns ZERO				 if p1 = p2
		 * returns a negative number if p1 < p2
		 */
		return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
	}
}
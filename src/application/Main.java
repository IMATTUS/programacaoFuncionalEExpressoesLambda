package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entities.Product;

public class Main {

	public static void main(String[] args) {
		/*
		 * XXX Em estudos anteriores deixamos a classe Product com implements Comparable<Product>
		 * para implementar a interface comparable.
		 * Entretanto, a classe não fica fechada para alteração, se a forma de comparação mudar, 
		 * teriamos que alterar a classe Product para dar manutenção 
		 * e isso não é muito em termos de manutenção,
		 * o ideal seria ter criterios de comparação independentes da classe Product
		 * para isso usaremos o default method sort dentro da interface List ao invés de usar o
		 * Collections.sort
		 * o default method sort da interface List recebe um Comparator como argumento:
		 * 		default void sort(Comparator<? super E> c)
		 * 
		 */
		expressoesLambda();
		
		/*
		 * A programacao tem paradigmas
		 * Imperativo (C,Pascal, Fortran, Cobol)
		 * Orientado a Objeto (C++, Object Pascal, Java(<8), C#(<3))
		 * Funcional (Haskell, Closure, Clean, Erlang)
		 * Lógico (Prolog)
		 * Multiparadigma (JavaScript, Java(8+), C#(3+), Ruby, Python, Go)
		 * 
		 * Programacao Imperativa
		 * 	Como se descreve algo a ser computado		: comandos
		 * 	Funções possuem transparência referencial
		 * 		(ausencia de efeitos colaterais)		: fraco
		 * Objetos imutáveis							: raro
		 * Funções são objetos de primeria ordem		: não
		 * Expressividade / código conciso				: baixo
		 * Tipagem dinâmica / inferência de tipos		: raro
		 *  
		 * 
		 * Programacao Funcional
		 * 	Como se descreve algo a ser computado		: expressões
		 * 	Funções possuem transparência referencial
		 * 		(ausencia de efeitos colaterais)		: forte
		 * Objetos imutáveis							: comum
		 * Funções são objetos de primeria ordem		: sim
		 * Expressividade / código conciso				: alta
		 * Tipagem dinâmica / inferência de tipos		: comum
		 */
		
	}
	
	public static void expressoesLambda() {
		List<Product> list = new ArrayList<>();
		List<Product> list2 = new ArrayList<>();
		List<Product> list3 = new ArrayList<>();
		List<Product> list4 = new ArrayList<>();
		List<Product> list5 = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));

		list2.add(new Product("TV", 900.00));
		list2.add(new Product("Notebook", 1200.00));
		list2.add(new Product("Tablet", 450.00));
		
		list3.add(new Product("TV", 900.00));
		list3.add(new Product("Notebook", 1200.00));
		list3.add(new Product("Tablet", 450.00));
		
		list4.add(new Product("TV", 900.00));
		list4.add(new Product("Notebook", 1200.00));
		list4.add(new Product("Tablet", 450.00));
		
		list5.add(new Product("TV", 900.00));
		list5.add(new Product("Notebook", 1200.00));
		list5.add(new Product("Tablet", 450.00));
		
		/*
		 * Passamos o Comparator que é uma interface para fazer o sort.
		 * o Comparator é uma interface funcional (possui apenas 1 metodo) podendo ter metodos default e estáticos
		 * mas temos que implementar o 'compare(T o1, T o2)' retornando um int
		 */
		list.sort(new MyComparator());
		
		/*
		 * outra forma é declarar um comparator no programa utilizando sintaxe de classe anônima
		 * Podemos declarar uma variavel do tipo Comparator<Product> e declarar o compare nele
		 * a classe anonima é a criação de uma classe dentro do programa, sem criar um outro arquivo para ela
		 * essa declaração é muito grande e podemos trocar tudo isso por uma expressão lambda
		 * que é uma função anonima
		 */
		Comparator<Product> comp = new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				/*
				 * returns a positive number if p1 > p2
				 * returns ZERO				 if p1 = p2
				 * returns a negative number if p1 < p2
				 */
				return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
			}
		};
		list2.sort(comp);
		
		/*
		 * Expressão lambda, comp2: 
		 * p1 e p2 levando à uma implementação de função, chamado também de arrow function
		 * (p1,p2) -> {}
		 * 
		 * o compilador infere qual é o tipo de p1 e p2, colocar o tipo da variável é opcional.
		 */
		Comparator<Product> comp2 = (p1,p2) -> {
			return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		};
		
		list3.sort(comp2);
		
		/*
		 * como a expressão de comp2 tem apenas 1 linha ela pode ser simplificada da seguinte forma:
		 */
		Comparator<Product> comp3 = (p1,p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		list4.sort(comp3);
		
		/*
		 * ao invés de declarar o comparator, podemos colocar a expressão lambda e colocar diretamente como
		 * argumento do sort da lista
		 */
		list5.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
		
		System.out.println("List");
		for (Product p : list) {
			System.out.println(p);
		}
		System.out.println();
		
		System.out.println("List 2");
		for (Product p : list2) {
			System.out.println(p);
		}
		System.out.println();
		
		System.out.println("List 3");
		for (Product p : list3) {
			System.out.println(p);
		}
		System.out.println();
		
		System.out.println("List 4");
		for (Product p : list4) {
			System.out.println(p);
		}
		System.out.println();
		
		System.out.println("List 5");
		for (Product p : list5) {
			System.out.println(p);
		}
		System.out.println();
	}

}

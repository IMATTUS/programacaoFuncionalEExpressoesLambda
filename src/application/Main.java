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
		 * Entretanto, a classe n�o fica fechada para altera��o, se a forma de compara��o mudar, 
		 * teriamos que alterar a classe Product para dar manuten��o 
		 * e isso n�o � muito em termos de manuten��o,
		 * o ideal seria ter criterios de compara��o independentes da classe Product
		 * para isso usaremos o default method sort dentro da interface List ao inv�s de usar o
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
		 * L�gico (Prolog)
		 * Multiparadigma (JavaScript, Java(8+), C#(3+), Ruby, Python, Go)
		 * 
		 * Programacao Imperativa
		 * 	Como se descreve algo a ser computado		: comandos
		 * 	Fun��es possuem transpar�ncia referencial
		 * 		(ausencia de efeitos colaterais)		: fraco
		 * Objetos imut�veis							: raro
		 * Fun��es s�o objetos de primeria ordem		: n�o
		 * Expressividade / c�digo conciso				: baixo
		 * Tipagem din�mica / infer�ncia de tipos		: raro
		 *  
		 * 
		 * Programacao Funcional
		 * 	Como se descreve algo a ser computado		: express�es
		 * 	Fun��es possuem transpar�ncia referencial
		 * 		(ausencia de efeitos colaterais)		: forte
		 * Objetos imut�veis							: comum
		 * Fun��es s�o objetos de primeria ordem		: sim
		 * Expressividade / c�digo conciso				: alta
		 * Tipagem din�mica / infer�ncia de tipos		: comum
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
		 * Passamos o Comparator que � uma interface para fazer o sort.
		 * o Comparator � uma interface funcional (possui apenas 1 metodo) podendo ter metodos default e est�ticos
		 * mas temos que implementar o 'compare(T o1, T o2)' retornando um int
		 */
		list.sort(new MyComparator());
		
		/*
		 * outra forma � declarar um comparator no programa utilizando sintaxe de classe an�nima
		 * Podemos declarar uma variavel do tipo Comparator<Product> e declarar o compare nele
		 * a classe anonima � a cria��o de uma classe dentro do programa, sem criar um outro arquivo para ela
		 * essa declara��o � muito grande e podemos trocar tudo isso por uma express�o lambda
		 * que � uma fun��o anonima
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
		 * Express�o lambda, comp2: 
		 * p1 e p2 levando � uma implementa��o de fun��o, chamado tamb�m de arrow function
		 * (p1,p2) -> {}
		 * 
		 * o compilador infere qual � o tipo de p1 e p2, colocar o tipo da vari�vel � opcional.
		 */
		Comparator<Product> comp2 = (p1,p2) -> {
			return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		};
		
		list3.sort(comp2);
		
		/*
		 * como a express�o de comp2 tem apenas 1 linha ela pode ser simplificada da seguinte forma:
		 */
		Comparator<Product> comp3 = (p1,p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		list4.sort(comp3);
		
		/*
		 * ao inv�s de declarar o comparator, podemos colocar a express�o lambda e colocar diretamente como
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

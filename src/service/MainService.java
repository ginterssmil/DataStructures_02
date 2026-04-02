package service;

import datastr.MyLinkedList;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList<Character> symbols = new MyLinkedList<Character>();
		
		try
		{
			symbols.add('A');//A
			symbols.add('B');//B
			symbols.add('C');//C
			symbols.print();//A B C
			symbols.add('Z');//A B C Z
			symbols.print();//A B C Z
			symbols.add('X', 0);//X A B C Z
			symbols.print();//X A B C Z
			symbols.add('U', 5);//X A B C Z U
			symbols.print();//X A B C Z U
			symbols.add('Q', 2);
			symbols.print();
			
			symbols.remove(0);
			symbols.print();
			symbols.remove(5);
			symbols.print();
			symbols.remove(2);
			symbols.print();
			
			System.out.println(symbols.get(3));
			symbols.add('Q');
			System.out.println(symbols.search('Q'));
			symbols.add('Q');
			System.out.println(symbols.search('Q'));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
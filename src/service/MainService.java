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
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
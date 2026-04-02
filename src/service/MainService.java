package service;

import datastr.MyLinkedList;
import model.Student;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList<Character> symbols = new MyLinkedList<Character>();
		
		try
		{
			System.out.println("------Simboli-------");
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
			
			System.out.println("------Studenti-------");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	        MyLinkedList<Student> allStudents = new MyLinkedList<Student>();
	        Student s1 = new Student("Ilmars", "Sula", "123458-12345");
	        Student s2 = new Student("Austrins", "Zeidz", "341259-12345");
	        Student s3 = new Student("Janis", "Berzins", "173521-12345");
	        try{
	        allStudents.add(s1);
	        allStudents.add(s2);
	        allStudents.add(s3,0);
	        allStudents.print();
	        System.out.println(allStudents.search(s3));
	        

	        System.out.println("remove 1 ele");
	        allStudents.remove(0);

	        System.out.println("==========howManyElements======");
	        System.out.println(allStudents.getHowManyElements());

	        System.out.println("==========makeEmpty======");
	        allStudents.makeEmpty();
	        allStudents.print();
	        }
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
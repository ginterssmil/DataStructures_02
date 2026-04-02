package datastr;

import java.util.ArrayList;

public class MyLinkedList<Ttype> {
	private MyNode<Ttype> firstNode = null;
	private MyNode<Ttype> lastNode = null;
	private int howManyElements = 0;

	//set funkciju netaisām, jo lietotajs nedrīkst 
	//mainīt howManyelements vērtību patstāvīgi
	public int getHowManyElements() {
		return howManyElements;
	}
	
	//firstNode un lastNode netaisām ne set ne get, 
	//jo neļaujam lietotajma pieķļūt via mainīt blokus

	
	//bezargumenta konstruktors būs no Object klases,
	//bet argumenta nevajag taisīt
	
	public boolean isEmpty() {
		return (howManyElements == 0);
	}
	
	public boolean isFull() {
		try
		{
			new MyNode<Character>('A');//mēginu RAM atmiņā rezervēt vietu
			return false;
		}
		catch (OutOfMemoryError e) {
			return true;
		}
	}
	
	public void add(Ttype element) throws Exception {
		if(isFull()) {
			throw new Exception(
					"Saraksts ir pilns un nav iespējams pievienot elementu");
		}
		
		if(element == null) {
			throw new Exception("Padotais elements nav norādīts");
		}
		//TODO var optimizēt kodu, izvelkot no if-else vienādas koda rindiņas
		//ja būs pievienots pirmais bloks
		if(isEmpty())
		{
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			lastNode = newNode;
			firstNode =  newNode;
			howManyElements++;
		}
		else//ja jau ir vismaz viens bloks iekš saraksta
		{
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			
			lastNode.setNextNode(newNode);
			newNode.setPreviousNode(lastNode);
			
			lastNode = newNode;
			howManyElements++;
			
		}
		
	}
	public void add(Ttype element, int position) throws Exception{
		if(isFull()) {
			throw new Exception(
					"Saraksts ir pilns un nav iespējams pievienot elementu");
		}
		
		if(element == null) {
			throw new Exception("Padotais elements nav norādīts");
		}
		
		if(position < 0) {
			throw new Exception("Pozīcija var būt tikai pozitīva");
		}
		
		if(position > howManyElements) {
			throw new Exception("Pozīcija nevar būt lielāka par esošo elementu skaitu");
		}
		
		
		//ja velas pievienot 0 pozīcijā
		if(position == 0)
		{
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			
			newNode.setNextNode(firstNode);
			firstNode.setPreviousNode(newNode);
			
			firstNode = newNode;
			howManyElements++;
		}
		//ja vēlas pievienot beigās
		else if(position == howManyElements) {
			add(element);
		}
		//ja vēlas pievienot pa vidu
		else {
			//pozīcija ir tuvak pirmajam blokam un veicam lēkšanu
			//no pirmā bloka uz priekšu
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			MyNode<Ttype> currentNode = null;

			if(position < howManyElements/2) {
				currentNode = firstNode;
				
				for(int i = 1; i <= position-1; i++) {
					currentNode = currentNode.getNextNode();
				}
			}
			//pozīcija ir tuvak pēdējam blokam un veicam lēkšanu 
			//no pēdejā bloka uz atpakaļ
			else {
				currentNode = lastNode;

				for(int i = howManyElements+1; i > position; i--) {
					currentNode = currentNode.getPreviousNode();
				}
			}
			
			MyNode<Ttype> leftNode = currentNode;
			MyNode<Ttype> rightNode = leftNode.getNextNode();
			
			leftNode.setNextNode(newNode);
			newNode.setPreviousNode(leftNode);
			
			rightNode.setPreviousNode(newNode);
			newNode.setNextNode(rightNode);
			
			howManyElements++;
		}
	}
	//remove by position
	public void remove(int position) throws Exception{
		if(isEmpty()) {
			throw new Exception("nevar iznemt elementu, jo saraksts ir tukss");
		}
		if(position < 0) {
			throw new Exception("Pozīcija var būt tikai pozitīva");
		}
		
		if(position >= howManyElements) {
			throw new Exception("Pozīcija nevar būt lielāka par esošo elementu skaitu");
		}
		//dzest sakuma
		if(position == 0){
			firstNode = firstNode.getNextNode();
			firstNode.setPreviousNode(null);
			howManyElements--;
		}
		//ja vēlas dzest beigās
		else if(position == howManyElements) {
			lastNode = lastNode.getPreviousNode();
			lastNode.setNextNode(null);

			howManyElements--;
		}
		else {
			MyNode<Ttype> currentNode = firstNode;
			
			for(int i = 1; i <= position-1;i++ ) {
				currentNode = currentNode.getNextNode();
			}
			MyNode<Ttype> leftNode = currentNode.getPreviousNode();
			MyNode<Ttype> rightNode = currentNode.getNextNode();
			
			leftNode.setNextNode(rightNode);
			rightNode.setPreviousNode(leftNode);
			howManyElements--;
		}
	}
	//get by position
	public Ttype get(int position) throws Exception {
		if(isEmpty()) {
			throw new Exception("nevar iznemt elementu, jo saraksts ir tukss");
		}
		if(position < 0) {
			throw new Exception("Pozīcija var būt tikai pozitīva");
		}
		
		if(position >= howManyElements) {
			throw new Exception("Pozīcija nevar būt lielāka par esošo elementu skaitu");
		}
		
		MyNode<Ttype> currentNode = null;
		if(position < howManyElements/2) {
			currentNode = firstNode;
			
			for(int i = 1; i <= position; i++) {
				currentNode = currentNode.getNextNode();
			}
		}

		else {
			currentNode = lastNode;
			
			for(int i = howManyElements+1; i > position; i--) {
				currentNode = currentNode.getPreviousNode();
			}
		}
		return currentNode.getElement();
	}
	
	public ArrayList<Integer> search(Ttype element) throws Exception {
		if(isEmpty()) {
			throw new Exception(
			"Sarakstā nav elementu, līdz ar to neko nevar izprintēt");
		}
		if(element == null) {
			throw new Exception("elements ir tukss");
		}
		ArrayList<Integer> foundPositions = new ArrayList<Integer>();
		int tempPosition = 0;
		MyNode<Ttype> currentNode = firstNode;
		
		while(currentNode != null) {
			if(currentNode.getElement().equals(element)) {
				foundPositions.add(tempPosition);
			}
			tempPosition++;
			
			currentNode = currentNode.getNextNode();
		}
		if(foundPositions.isEmpty()) {
			throw new Exception("Mekletais elemets nav atrasts saraksta");
		}
		
		return foundPositions;
	}
	
	//makeEmpty
	public void makeEmpty() {
		firstNode = null;
		lastNode = null;
		howManyElements = 0;
		System.gc();
	}
	//print
	public void print() throws Exception{
		if(isEmpty()) {
			throw new Exception(
			"Sarakstā nav elementu, līdz ar to neko nevar izprintēt");
		}
		
		MyNode<Ttype> currentNode = firstNode;
		
		while(currentNode != null) {
			System.out.print(currentNode.getElement() + " ");
			currentNode = currentNode.getNextNode();
		}
		
		System.out.println();
		
		
	}

}
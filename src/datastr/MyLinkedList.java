public class MyLinkedList<Ttype> {
    private MyNode<Ttype> firsNode = null;
    private MyNode<Ttype> lastNode = null;
    private int howManyElements = 0;
    
    public int getHowManyElements() {
        return howManyElements;
    }

    //bezargumenta konstruktors bus no Object klases

    public boolean isEmpty() {
        return (howManyElements == 0);
    }

    public boolean isFull() {
        try {
            new MyNode<Character>('A');
            return false;
        }
        catch (OutOfMemoryError e) {
            return true;
        }
    }

    public void add(Ttype element) throws Exception{
        if(isFull()) {
            throw new Exception("Saraksts ir pilns un nav iespejams pieveinot elementu");
        }
        if(element == null) {
            throw new Exception("Padotais elements ir null");
        }
        if(isEmpty()){
            MyNode<Ttype> newNode = new MyNode<Ttype>(element);
            lastNode = newNode;
            firsNode = newNode;
            howManyElements++;
        }
        else {
            MyNode<Ttype> newNode = new MyNode<Ttype>(element);
            
            lastNode.setNextNode(newNode);
            newNode.setPreviousNode(lastNode);

            lastNode = newNode;
            howManyElements++;
        }
    }
}

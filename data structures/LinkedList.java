
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.util.Iterator;
import java.lang.Iterable;

public class LinkedList<T> implements Iterable<T> {


    private Node<T> itsFirstNode;
    private Node<T> itsLastNode;
    private Node<T> currentNode;
    private int size;


    public LinkedList() {
        itsFirstNode = null;
        itsLastNode = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(T element) {

        Node<T> node = new Node<T>(element);

        if (itsFirstNode == null) {
            itsFirstNode = node;
        }
        size++;
    }
    public void add(T element, int index) {
        int counter = 0;
        Node<T> newNode = new Node<T>(element);
        Node<T> current = itsFirstNode;
        while (current != null ) {
            if (counter == index - 1 )
                break;
            current = current.getNextNode();
            counter++;
        }
        newNode.setNextNode(current.getNextNode());
        current.setNextNode(newNode);
        size++;
    }
    public T get(int index) {
        int counter = 0;
        Node<T> current = itsFirstNode;
        while (current != null ) {
            if (counter == index)
                break;
            current = current.getNextNode();
            counter++;
        }
        return current.getData();
    }


    // returns true if element is in the list, false if not
    public boolean contains(T element) {
      Node<T> current = itsFirstNode;
      while(current!=null){

        if (current.getData() != element){
            current = current.getNextNode();
        }
        else{
            return true;
        }
      }
      return false;    
    }

    public String toString() {
        String returnVal = "";
        Node<T> current = itsFirstNode;
        if (size != 0 ) {
            while (current != null ) {
                returnVal += current.toString();
                returnVal += "\n";
                current = current.getNextNode();
            }
        }
        return returnVal;
    }  // end toString

   public T getNthFromFirst(int n) {
        Node<T> node = itsFirstNode;
        
        for(int i = 0; i < n-1 ; i++) {
        
            if(node.getNextNode() != null) {
                node = node.getNextNode();

            }

        }
        System.out.println(n + " nodes from first: " + node.getData());
        return node.getData();
    }
    
    /* Return the nth value from the last (count starts with zero) */
    public T getNthFromLast(int n) {
        Node<T> node = itsFirstNode;
       Node<T> current = itsLastNode;
        
        for(int i = 0; i < n-1; i++) {      
            while (node.getNextNode() != current) {          
                node = node.getNextNode();
                
            }
            current = node;                     
        }
        System.out.println(n + " nodes from last: " + current.getData());
        return node.getData();
    }

    public SinglylinkedListIterator iterator() {
        return new SinglylinkedListIterator();
    }

 public class SinglylinkedListIterator implements Iterator<T>{
    public SinglylinkedListIterator(){
        currentNode =  itsFirstNode;
    }

    // return true if there is a "next" element, otherwise returns false
    public boolean hasNext() {
        if (currentNode != null){
            return true;
        }
        else{
        return false;
        }
    }

    
    // returns the "next" node (really the current one) and
    // moves the Iterator forward by one node
    public T next() {
     if (currentNode == null) {
        throw new NoSuchElementException();
            }
        T data;
        data = currentNode.getData();
        currentNode = currentNode.getNextNode();
        return data;

        
    }
    public void remove( ){
        throw new UnsupportedOperationException("remove operation is not supported by this iterator");
}
    
    }//end of Iterator<T>

    class Node<T> {
    
        private T data;
        private Node<T> itsNext;
    
        public Node(T data) {
            itsNext = null;
            this.data = data;
        }
    
    
        public T getData() {
            return this.data;
        }
    
        public Node<T> getNextNode() {
            return itsNext;
        }
    
        public void setNextNode(Node<T> next) {
            itsNext = next;
        }

    
        public String toString() {
            return data.toString();
        }
    
    }  // end of Node<T>


}

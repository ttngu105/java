public class LinkedList<T>  {


    Node<T> itsFirstNode;
    Node<T> itsLastNode;
    private int size;


    public LinkedList() {
        itsFirstNode = null;
        itsLastNode = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }
    
    public Iterator<T> getIterator() {
        return new Iterator<T>(this);
    }

    // THIS WILL NEED TO BE MODIFIED FOR DOUBLY LINKED LIST
    public void add(T element) {

        Node<T> node = new Node<T>(element);

        if (itsFirstNode == null) {
            itsFirstNode = node;
            itsLastNode = node;
        }
        else {
            node.setPriorNode(itsLastNode);
            itsLastNode.setNextNode(node);
            itsLastNode = node;
        }
        size++;
    }

    // THIS WILL NEED TO BE MODIFIED FOR DOUBLY LINKED LIST
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
        newNode.setPriorNode(current.getPriorNode());
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

    // returns the index of the element if it is in the list, -1 if not found
    public int indexOf(T element) {
        Node<T> currentNode = itsFirstNode;
        int counter = 1;
        while (currentNode.getData() != null){
        if(currentNode.getData() != element){
                counter++;
                currentNode = currentNode.getNextNode();         
        }
        else{
            return counter;
        }
        }
        
        return -1;
    }

    // returns an Iterator at the location of the element if it is in the list
    // returns the null reference if the element is not found
 
    public Iterator<T> iteratorAt(T element) {
       Iterator<T> iter = null;
       Node<T> currentNode = itsFirstNode;
       int counter = 0;
       while(currentNode.getNextNode() != null){
       	if (currentNode.getData() == element){
       		iter = getIterator();
       		for(int i = 0; i < counter; i++){
       			iter.next();
       		}
       		break;
       	}
       	currentNode = currentNode.getNextNode();
       	counter++;
       }
       return iter;

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

    class Node<T> {
    
        private T data;
        private Node<T> itsNext;
        private Node<T> itsPrior;
    
        public Node(T data) {
            itsNext = null;
            itsPrior = null;
            this.data = data;
        }
    
    
        public T getData() {
            return this.data;
        }
    
        public Node<T> getNextNode() {
            return itsNext;
        }

        public Node<T> getPriorNode( ) {
            return itsPrior;
        }

    
        public void setNextNode(Node<T> next) {
            itsNext = next;
        }

        public void setPriorNode(Node<T> prior) {
            itsPrior = prior;
        }
    
        public String toString() {
            return data.toString();
        }
    
    }  // end of Node<T>
}

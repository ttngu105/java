public class Iterator<T> {

    private LinkedList<T> myList;
    private LinkedList<T>.Node<T> myCurrentNode;

    public Iterator(LinkedList<T> list) {
        this.myList = list;
        this.myCurrentNode =  myList.itsFirstNode;
    }

    // return true if there is a "next" element, otherwise returns false
    public boolean hasNext() {
        if (myCurrentNode != null){
            return true;
        }
        else{
        return false;
        }
    }

    
    // return true if there is a "prior" element, otherwise returns false
    public boolean hasPrior() {
        if (myCurrentNode != null){
            return true;
        }
        else {
        	this.myCurrentNode = myList.itsLastNode;
            return false;
        }
    }

    

    // returns the "next" node (really the current one) and
    // moves the Iterator forward by one node
    public T next() {
    	T data;
    	//if(this.hasNext() == true){
        data = myCurrentNode.getData();
        myCurrentNode = myCurrentNode.getNextNode();
        return data;
    	//}

    	//return myCurrentNode.getData();
    	
    }
    
    // returns the "prior" node (really the current one) and
    // moves the Iterator backward by one node
    public T prior() {
    	T data;
    	if(this.hasPrior() == true){
    	data = myCurrentNode.getData();
        myCurrentNode = myCurrentNode.getPriorNode();
        return data;
    	}
    	myCurrentNode = myCurrentNode.getPriorNode();
    	return myCurrentNode.getData();
    }

    // Sets this iterator to point to the last Node in the list
    public void setToEnd() {
        myCurrentNode = myList.itsLastNode;
    }
    
}


public class LinkedGL<E> implements MyList<E> {

    class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    Node<E> front;
    int size;

    public LinkedGL(E[] contents) {
        // Fill in this constructor
    	this.front = new Node<E>(null,null);
    	this.size = contents.length;
    	Node<E> temp = this.front;
    	int i = 0;
    	while(i < this.size) {
    		temp.next = new Node<E>(contents[i],null);
    		temp = temp.next;
    		i += 1;
    	}
    }

    // Fill in all methods

    @SuppressWarnings("unchecked")
    public E[] toArray() {
    	E[] newArray = (E[])new Object[this.size];
    	Node<E> temp = this.front;
    	for (int i = 0; i < this.size; i++) {
    		newArray[i] = temp.next.value;
    		if(temp.next!=null) {
    			temp = temp.next;
    		}
    	}
    	return newArray;
    }
    
    public boolean isEmpty() {
    	if (this.size == 0) {
    		return true;
    	}
    	return false;
    }
    
    @SuppressWarnings("unchecked")
    public void transformAll(MyTransformer mt) {
    	Node<E> temp = this.front;
    	for (int i = 0; i < this.size; i++) {
    		if (temp.next.value != null) {
    			temp.next.value = (E)mt.transformElement(temp.next.value);
    			temp = temp.next;
    		}
    	}
    }
    
    @SuppressWarnings("unchecked")
    public void chooseAll(MyChooser mc) {
    	int newSize = 0;
    	Node<E> newFront = new Node<E>(null,null);
    	Node<E> newTemp = newFront;
    	Node<E> temp = this.front;
    	for (int i = 0; i < this.size; i++) {
    		if (temp.next.value != null) {
    			if (mc.chooseElement(temp.next.value)) {
    				newTemp.next = temp.next;
    				if(newTemp.next!=null) {
    					newTemp = newTemp.next;
    	    			temp = temp.next;
    	    			newSize += 1;
    				}    				
    			}
    		}
    	}
    	this.front = newFront;
    	this.size = newSize;
    }
}
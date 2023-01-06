public class ArrayGL<E> implements MyList<E> {

    E[] elements;
    int size;

    public ArrayGL(E[] initialElements) {
    	this.elements = initialElements;
        this.size = initialElements.length;
    }

    // Fill in all required methods here
    
    @SuppressWarnings("unchecked")
    public E[] toArray() {
    	E[] newArray = (E[])new Object[this.size];
    	for (int i = 0; i < this.size; i++) {
    		newArray[i] = this.elements[i];
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
    	E[] newArray = (E[])new Object[this.size];
    	for (int i = 0; i < this.size; i++) {
    		if (this.elements[i] != null) {
    			newArray[i] = (E)mt.transformElement(this.elements[i]);
    		}
    	}
    	this.elements = newArray;
    }
    
    @SuppressWarnings("unchecked")
    public void chooseAll(MyChooser mc) {
    	int newSize = 0;
    	E[] newArray = (E[])new Object[this.size];
    	for (int i = 0; i < this.size; i++) {
    		if(this.elements[i]!=null) {
    			if(mc.chooseElement(this.elements[i])) {
        			newArray[i] = this.elements[i];
        			newSize += 1;
        		}
    		}
    	}
    	this.elements = newArray;
    	this.size = newSize;
    }
    	
}
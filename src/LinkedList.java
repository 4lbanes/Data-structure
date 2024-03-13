
class LinkedList<E> implements List<E>{

	private class Node{
		E value;
		Node next;

		public Node(E value){
			this.value = value;
			// next = null;
		}
	}
	
	private int size;
	private Node head;
	private Node tail;

	public LinkedList(){}

	public LinkedList(E value){
		add(value);
	}

	@Override
	public void add(E value) {
		Node newNode = new Node(value);
		if(isEmpty()){
			head = newNode;            
		}else{
			tail.next = newNode;           
		}
		tail = newNode;
		size++;        
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}

		E value = null;
		Node newNode= head;

		if(index == 0) {
			value = head.value;
		}else {
			for(int i = 0; i < index; i++) {
				newNode = newNode.next;
				value = newNode.value;
			}
		}
		return value;
	}
	@Override
	public void insert(E value) {
		Node newNode = new Node(value);

		if(isEmpty()){
			head = newNode;
			tail = newNode;
		}else{
			newNode.next = head;
			head = newNode;
		}

		size++;
	}

	private Node getNode(int index){
		Node auxNode = head;
		for(int i = 0; i < index; i++){
			auxNode = auxNode.next;
		}
		return auxNode;
	}

	@Override
	public void insert(int index, E value)  {

		if(index<=0){
			insert(value);
		}else if(index>=size){
			add(value);
		}else{
			Node newNode = new Node(value);
			Node auxNode = getNode(index-1);
			newNode.next = auxNode.next;
			auxNode.next = newNode;
			size++;
		}
	}

	@Override
	public boolean isEmpty() {       
		return size == 0;
	}

	@Override
	public E removeByIndex(int index) throws IndexOutOfBoundsException, EmptyListException {
		if(isEmpty()){
			throw new EmptyListException("Linked List is Empty!");
		}

		if(index < 0 || index > size) {

		}
		return null;
	}

	@Override
	public E removeFirst() throws EmptyListException {
		if(isEmpty()){
			throw new EmptyListException("Linked List is Empty!");
		}
		Node auxNode = head;
		if(size == 1){
			head = null;
			tail = null;
		}else{
			head = head.next;
			auxNode.next = null;
		}
		size--;
		return auxNode.value;
	}

	@Override
	public E removeLast() throws EmptyListException {
		if(isEmpty()){
			throw new EmptyListException("Linked List is Empty!");
		}
		E value = tail.value;
		if(size == 1){
			head = null;
			tail = null;
		}else{
			Node auxNode = getNode(size-2);
			tail = auxNode;
			auxNode.next = null;
		}
		size--;
		return value;
	}

	@Override
	public void set(int index, E value) throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new EmptyListException("List is empty!");
		}

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index!");
		}else {
			Node currentNode = getNode(index);
			currentNode.value = value;
		}
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {        
		StringBuilder sb = new StringBuilder("[");
		Node auxNode = head;
		while(auxNode!=null){
			sb.append(auxNode.value);
			if(auxNode.next != null){
				sb.append(", ");
			}
			auxNode = auxNode.next;
		}
		return sb.append("]").toString();
	}

	@Override
	public void replaceValue(E previousValue, E newValue) throws EmptyListException {
		if(isEmpty()) {
			new EmptyListException("Linked list is empty");
		}
		
		Node currentNode = head;
		boolean valueExchanged = false;
		
		while(currentNode != null) {
			if(currentNode.value.equals(previousValue)) {
				currentNode.value = newValue;
				valueExchanged = true;
			}
			currentNode = currentNode.next; 
		}
		
		if(valueExchanged == false) {
		System.out.println(previousValue + " not found in list");
		}
	}

	@Override
	public boolean contains(E value) throws EmptyListException {
		
		if(isEmpty()) {
			new EmptyListException("Linked list is empty");
		}
		
		Node newNode = head;
		
		while(newNode != null) {
			if(newNode.value.equals(value)) {
				return true;
			}
			newNode = newNode.next;
		}
		
		return false;
	}

	public E removeByValue(E value) throws EmptyListException {
	    if(isEmpty()) {
	        throw new EmptyListException("Linked list is empty");
	    }
	    
	    E removedValue = null;
	    
	    if(value.equals(head.value)) {
	        removedValue = removeFirst();
	    } else if(value.equals(tail.value)) {
	        removedValue = removeLast();
	    } else {
	        Node previousNode = null;
	        Node currentNode = head;
	        
	        while(currentNode != null && !currentNode.value.equals(value)) {
	            previousNode = currentNode;
	            currentNode = currentNode.next;
	        }
	        
	        if(currentNode != null) {
	            removedValue = currentNode.value;
	            previousNode.next = currentNode.next;
	            currentNode.next = null;
	            size--;
	        } else {
	            System.out.println(value + " not found in list");
	        }
	    }
	    
	    return removedValue;
	}


	





}

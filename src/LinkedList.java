
class DoubleLinkedList<E> implements List<E> {

	private class Node {
		E value;
		Node next;
		Node prev;

		public Node(E value) {
			this.value = value;
			// next = null;
		}
	}

	private int size;
	private Node head;
	private Node tail;
	private int j;

	public DoubleLinkedList() {
	}

	public DoubleLinkedList(E value) {
		add(value);
	}

	@Override
	public void add(E value) {
		Node newNode = new Node(value);

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			newNode.next = null;
			tail = newNode;
		}
		size++;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		return getNode(index).value;
	}

	@Override
	public void insert(E value) {
		Node newNode = new Node(value);

		if (isEmpty()) {
			tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
		}
		head = newNode;
		size++;
	}

	private Node getNode(int index) {
		Node auxNode = head;
		for (int i = 0; i < index; i++) {
			auxNode = auxNode.next;
		}
		return auxNode;
	}

	@Override
	public void insert(int index, E value) {

		if (index <= 0) {
			insert(value);
		} else if (index >= size) {
			add(value);
		} else {
			Node newNode = new Node(value);
			Node auxNode1 = getNode(index);
			Node auxNode2 = getNode(index - 1);

			auxNode2.next = newNode;
			newNode.prev = auxNode2;
			newNode.next = auxNode1;
			auxNode1.prev = newNode;
			size++;
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E removeByIndex(int index) throws IndexOutOfBoundsException, EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException("Linked List is Empty!");
		}

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		E removedValue = null;

		if (index == 0) {
			removedValue = removeFirst();
		} else if (index == size - 1) {
			removedValue = removeLast();
		} else {
			Node auxNode1 = getNode(index);
			Node auxNode2 = getNode(index - 1);
			Node auxNode3 = getNode(index + 1);
			removedValue = auxNode1.value;

			auxNode2.next = auxNode1.next;
			auxNode3.prev = auxNode1.prev;

			auxNode1.prev = null;
			auxNode1.next = null;

			size--;
		}
		return removedValue;
	}

	@Override
	public E removeFirst() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException("Linked List is Empty!");
		}
		Node auxNode = head;
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			head = head.next;
			auxNode.next = null;
		}
		size--;
		return auxNode.value;
	}

	@Override
	public E removeLast() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException("Linked List is Empty!");
		}
		E value = tail.value;

		if (size == 1) {
			head = null;
			tail = null;
		} else {
			Node auxNode = getNode(size - 2);
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
		} else {
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
		while (auxNode != null) {
			sb.append(auxNode.value);
			if (auxNode.next != null) {
				sb.append(", ");
			}
			auxNode = auxNode.next;
		}
		return sb.append("]").toString();
	}

	public String reverseString() {
		StringBuilder sb = new StringBuilder("[");
		Node auxNode = tail;

		while (auxNode != null) {
			sb.append(auxNode.value);
			if (auxNode.prev != null) {
				sb.append(", ");
			}
			auxNode = auxNode.prev;
		}

		sb.append("]");
		return sb.toString();
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public void remove(E value) throws EmptyListException {
	    if (isEmpty()) {
	        throw new EmptyListException("List is empty!");
	    }

	    Node currentNode = head;

	    while (currentNode != null) {
	        if (currentNode.value.equals(value)) {
	            if (currentNode == head) {
	                removeFirst();
	            } else if (currentNode == tail) {
	                removeLast();
	            } else {
	                Node prevNode = currentNode.prev;
	                Node nextNode = currentNode.next;

	                prevNode.next = nextNode;
	                nextNode.prev = prevNode;

	                currentNode.next = null;
	                currentNode.prev = null;

	                size--;

	                System.out.println("The value: " + value + " was removed from the list.");
	            }
	            return; 
	        }

	        currentNode = currentNode.next;
	    }
	    System.out.println("The value: " + value + " was not found in the list.");
	}

	@Override
	public boolean contains(E value) throws EmptyListException{
		if (isEmpty()) {
	        throw new EmptyListException("List is empty!");
	    }

		Node auxNode = head;

		while(auxNode != null){
			if(auxNode.value.equals(value)){
				return true;
			}
			auxNode = auxNode.next;
		}
		return false;
	}

	@Override
	public int indexOf(E value) throws EmptyListException{
		if (isEmpty()) {
	        throw new EmptyListException("List is empty!");
	    }

		Node newNode = head;
		int index = 0;

		while(newNode != null){
			if(newNode.value.equals(value)){
				return index;
			}
			newNode = newNode.next;
			index++;
		}
		return -1;
	}

	@Override
	public void swap(int index1, int index2) throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException("List is empty!");
		}
	
		if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
			throw new IndexOutOfBoundsException("Some invalid index!");
		}
	
		Node node1 = getNode(index1);
		Node node2 = getNode(index2);

		E value1 = node1.value;
		E value2 = node2.value;
	
		node1.value = value2;
		node2.value = value1;
	}

	@Override
	public void swap2(int index, E newValue) throws EmptyListException{
		if (isEmpty()) {
			throw new EmptyListException("List is empty!");
		}

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Some invalid index!");
		}

		Node newNode = new Node(newValue);

		if(index == 0){
			Node auxNode = getNode(index);
			Node auxNode2 = getNode(index + 1);

			auxNode2.prev = newNode;
			newNode.next = auxNode2;
			newNode.prev = null;

			auxNode.next = null;
			auxNode.prev = null;

			head = newNode;
		}else if(index == size - 1){
			Node auxNode = getNode(index);
			Node auxNode2 = getNode(index - 1);

			auxNode2.next = newNode;
			newNode.prev = auxNode;

			auxNode.next = null;
			auxNode.prev = null;
		}else{
			Node auxNode = getNode(index);
			Node auxNode2 = getNode(index - 1);
			Node auxNode3 = getNode(index + 1);

			newNode.next = auxNode3;
			newNode.prev = auxNode2;

			auxNode2.next = newNode;
			auxNode3.prev = newNode;

			auxNode.next = null;
			auxNode.prev = null;
		}
	}
}

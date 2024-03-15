
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
			auxNode.prev = null;
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
	public void clear() throws EmptyListException {
		head = null;
		tail = null;
		size = 0;
	}
}

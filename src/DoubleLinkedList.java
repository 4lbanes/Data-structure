
class DoubleLinkedList<E> implements List<E> {
	private class Node {
		E value;
		private Node next;
		private Node prev;

		public Node(E value) {
			this.value = value;
			// next = null;
		}
	}

	private int size;
	private Node head;
	private Node tail;

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(E value) {
		Node newNode = new Node(value);

		if (isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
		}
		tail = newNode;
		size++;
	}

	@Override
	public void insert(E value) {
		Node newNode = new Node(value);
		if (isEmpty()) {
			tail = newNode;
		} else {
			head.prev = newNode;
			newNode.next = head;
		}
		size++;
		head = newNode;
	}

	private Node getNode(int index) {
		Node auxNode = head;

		for (int i = 0; i < index; i++) {
			auxNode = auxNode.next;
		}
		return auxNode;
	}

	@Override
	public void insert(int index, E value) throws IndexOutOfBoundsException {
		Node newNode = new Node(value);

		if (isEmpty() || index <= 0) {
			insert(value);
		} else if (index >= size) {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			size++;
		} else {
			Node auxNode1 = getNode(index - 1);
			Node auxNode2 = getNode(index);

			newNode.next = auxNode2;
			newNode.prev = auxNode1;

			auxNode1.next = newNode;
			auxNode2.prev = newNode;
			size++;
		}
	}

	@Override
	public E removeLast() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException("Double linked list is empty");
		}

		E removedValue = tail.value;

		if (size == 1) {
			head = null;
			tail = null;
		} else {
			tail = tail.prev;
			tail.next = null;
		}
		size--;
		return removedValue;
	}

	@Override
	public E removeFirst() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException("Double linked list is empty");
		}

		E removedValue = head.value;

		if (size == 1) {
			head = null;
			tail = null;
		} else {
			head = head.next;
			head.prev = null;
		}

		size--;
		return removedValue;
	}

	@Override
	public E removeByIndex(int index) throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new EmptyListException("Double linked list is empty");
		}

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index + " is an illegal index");
		}

		E removedValue;

		if (index == 0) {
			removedValue = removeFirst();
		} else if (index == size - 1) {
			removedValue = removeLast();
		} else {
			Node nodeToRemove = getNode(index);
			Node prevNode = nodeToRemove.prev;
			Node nextNode = nodeToRemove.next;

			prevNode.next = nextNode;
			nextNode.prev = prevNode;

			removedValue = nodeToRemove.value;

			size--;
		}

		return removedValue;
	}

	@Override
	public void remove(E value) throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException("Double linked list is empty");
		}

		Node auxNode = head;
		int index = 0;
		while (auxNode.next != head) {
			if (auxNode.value.equals(value)) {
				Node auxNode2 = getNode(index - 1);
				Node auxNode3 = getNode(index);
				Node auxNode4 = getNode(index + 1);

				auxNode2.next = auxNode4;
				auxNode4.prev = auxNode2;

				auxNode3.next = null;
				auxNode.prev = null;
			}
			index++;
			auxNode = auxNode.next;
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index + " its illegal index");
		}

		Node auxNode = head;

		for (int i = 0; i < index; i++) {
			auxNode = auxNode.next;
		}
		return auxNode.value;
	}

	@Override
	public void set(int index, E value) throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new EmptyListException("linked list is empty");
		}

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index + " its illegal index");
		} else {
			Node auxNode = getNode(index);
			auxNode.value = value;
		}
	}

	@Override
	public void clear() throws EmptyListException {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public boolean contains(E value) throws EmptyListException {
		Node auxNode = head;

		while (auxNode != null) {
			if (auxNode.value.equals(value)) {
				return true;
			}
			auxNode = auxNode.next;
		}
		return false;
	}

	@Override
	public int indexOf(E value) throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException("double linked list is empty");
		}

		int index = 0;
		if (!contains(value)) {
			System.out.println(value + " not found in double linked list");
		} else {
			Node auxNode = head;

			while (auxNode != null) {
				if (auxNode.value.equals(value)) {
					return index;
				}
				auxNode = auxNode.next;
				index++;
			}
		}
		return -1;
	}

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

	public void replace(E prevValue, E newValue) {
		if (isEmpty()) {
			throw new EmptyListException("double linked list is empty!");
		}

		if (contains(prevValue)) {
			Node auxNode = head;

			while (auxNode != null) {
				if (auxNode.value.equals(prevValue)) {
					auxNode.value = newValue;
				}
				auxNode = auxNode.next;
			}
		}
	}

	public void removeLastOccurrence(E value) {
		if (isEmpty()) {
			throw new EmptyListException("Double linked list is empty");
		}

		Node auxNode = tail;
		int index = size - 1;

		while (auxNode != null) {
			if (auxNode.value.equals(value)) {
				removeByIndex(index);
				break;
			}
			index--;
			auxNode = auxNode.prev;
		}
	}

	public void replaceLastOccurence(E prev, E newValue) {
		if (isEmpty()) {
			throw new EmptyListException("Double linked list is empty");
		}

		Node auxNode = tail;

		while (tail != null) {
			if (auxNode.value.equals(prev)) {
				auxNode.value = newValue;
				break;
			}
			auxNode = auxNode.prev;
		}
	}

	public int counterOccurrences(E value) {
		if (isEmpty()) {
			throw new EmptyListException("Double linked list is empty");
		}

		Node auxNode = head;
		int counter = 0;

		while (auxNode != null) {
			if (auxNode.value.equals(value)) {
				counter++;
			}
			auxNode = auxNode.next;
		}

		return counter;
	}

	public int lastIndexOf(E value) {
		if (isEmpty()) {
			throw new EmptyListException("Double linked list is empty");
		}

		for (int i = size - 1; i >= 0; i--) {
			if (get(i).equals(value)) {
				return i;
			}
		}
		return -1;
	}

	public boolean hasCycle() {
		if (isEmpty()) {
			throw new EmptyListException("Double linked list is empty");
		}

		Node auxNode = head;

		if (auxNode.prev == tail) {
			return true;
		}

		return false;
	}

	public boolean equality(DoubleLinkedList<E> list2) {
		if (isEmpty() || list2.isEmpty()) {
			throw new EmptyListException("Some double linked list is empty");
		}

		for (int i = 0; i < size; i++) {
			if (!get(i).equals(list2.get(i))) {
				return false;
			}
		}

		return true;
	}

	public void intersections(DoubleLinkedList<E> list2) {
		if (isEmpty()) {
			throw new EmptyListException("Double linked list is empty");
		}

		DoubleLinkedList<E> intersections = new DoubleLinkedList<>();

		for (int i = 0; i < size; i++) {
			if (get(i).equals(list2.get(i))) {
				intersections.add(get(i));
			}
		}
		System.out.println(intersections);
	}

	public void uniques(DoubleLinkedList<E> list2) {
		if (isEmpty()) {
			throw new EmptyListException("Double linked list is empty");
		}

		DoubleLinkedList<E> differences = new DoubleLinkedList<>();

		for (int i = 0; i < size; i++) {
			if (!get(i).equals(list2.get(i))) {
				differences.add(get(i));
			}
		}
		System.out.println(differences);
	}

	public String getValuesByIndex(int index, DoubleLinkedList<E> list2) {
		if (isEmpty() || list2.isEmpty()) {
			throw new EmptyListException("Some double linked list is empty");
		}

		if (index < 0 || index >= size || index >= list2.size) {
			throw new IndexOutOfBoundsException("Invalid index!");
		}

		E v1 = get(index);
		E v2 = list2.get(index);

		return "[" + v1 + ", " + v2 + "]";
	}

	public E mode() {
		if (isEmpty()) {
			throw new EmptyListException("Double linked list is empty");
		}

		E mode = null;
		int maxOccurrences = 0;

		Node auxNode = head;
		while (auxNode != null) {
			if (counterOccurrences(auxNode.value) > maxOccurrences) {
				mode = auxNode.value;
				maxOccurrences = counterOccurrences(auxNode.value);
			}
			auxNode = auxNode.next;
		}

		return mode;
	}

	public Double mean() {
		if (isEmpty()) {
			return 0.0;
		}

		if (!(head.value instanceof Number)) {
			throw new IllegalArgumentException("Os elementos da lista devem ser números");
		}

		Double sum = 0.0;

		Node auxNode = head;
		while (auxNode != null) {
			sum += ((Number) auxNode.value).doubleValue();
			auxNode = auxNode.next;
		}

		return sum / size;
	}

	public E median() {
		if (size % 2 == 1) {
			return get(size / 2);
		}

		return get((size / 2) - 1);
	}

	public void addOverload(E value) {
		Node newNode = new Node(value);

		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.prev = tail;
			newNode.next = head;
			head.prev = newNode;
			tail.next = newNode;
		}
		tail = newNode;
		size++;
	}

	public void insertOverload(E value) {
		Node newNode = new Node(value);

		if (isEmpty()) {
			tail = newNode;
		} else {
			newNode.next = head;
			newNode.prev = tail;
			head.prev = newNode;
			tail.prev = newNode;
		}
		head = newNode;
		size++;
	}

	public void rotateLeft() {
		if (size < 2) {
			return; 
		}

		Node newHead = head.next; // O segundo nó se tornará o novo cabeçalho
		tail.next = head; // Conecta o antigo último nó ao antigo cabeçalho
		head = newHead; // Atualiza a referência do cabeçalho
		tail = tail.next; // Atualiza a referência da cauda
		tail.next = null; 
	}

	public void rotate() {
        for (int i = 1; i < size / 2; i++) {
            E tailValue = tail.value;
            E headValue = head.value;

            tail.value = headValue;
            head.value = tailValue;

            E val1 = get(i);
            E val2 = get(size - 1 - i);

            getNode(i).value = val2;
            getNode(size - 1 - i).value = val1;
        }
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

		return sb.append("]").toString();
	}
}
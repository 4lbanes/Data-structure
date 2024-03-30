
public class CircularList<E> implements List<E> {

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
    private E value;

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
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
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
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail.prev = newNode;
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
    public void insert(int index, E value) throws IndexOutOfBoundsException {
        if (index <= 0) {
            insert(value);
        } else if (index >= size) {
            add(value);
        } else {
            Node newNode = new Node(value);

            Node auxNode1 = getNode(index - 1);
            Node auxNode2 = getNode(index);

            newNode.prev = auxNode1;
            newNode.next = auxNode2;

            auxNode1.next = newNode;
            auxNode2.prev = newNode;

            size++;
        }
    }

    @Override
    public E removeLast() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Circular list is empty");
        }

        E valueRemoved = tail.value;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
        }
        size--;
        return valueRemoved;
    }

    @Override
    public E removeFirst() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Circular list is empty");
        }

        E removedValue = head.value;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = tail;
        }
        size--;
        return removedValue;
    }

    @Override
    public E removeByIndex(int index) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new EmptyListException("Circular list is empty");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is Illegal index.");
        }
        E removedValue = null;

        if (index == 0) {
            removedValue = removeFirst();
        } else if (index == size - 1) {
            removedValue = removeLast();
        } else {

            Node auxNode1 = getNode(index - 1);
            Node auxNode2 = getNode(index);
            Node auxNode3 = getNode(index + 1);

            auxNode1.next = auxNode3;
            auxNode3.prev = auxNode1;

            auxNode2.next = null;
            auxNode2.prev = null;

            size--;
        }
        return removedValue;
    }

    @Override
    public void remove(E value) throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Circular list is empty");
        }

        Node auxNode = head.next;

        if (value.equals(head.value)) {
            removeFirst();
        } else if (value.equals(tail.value)) {
            removeLast();
        } else {
            while (auxNode != head) {
                if (auxNode.value.equals(value)) {
                    auxNode.prev.next = auxNode.next;
                    auxNode.next.prev = auxNode.prev;
                }
                auxNode = auxNode.next;
            }
            size--;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is illegal index!");
        }

        Node auxNode = head;
        for (int i = 0; i < index; i++) {
            auxNode = auxNode.next;
        }

        return auxNode.value;
    }

    @Override
    public void set(int index, E value) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is illegal index!");
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
        if (isEmpty()) {
            throw new EmptyListException("Circular linked list is empty");
        }

        Node auxNode = head;

        while (auxNode.next != head) {
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
            throw new EmptyListException("circular list is empty");
        }

        int index = 0;
        Node auxNode = head;

        while (auxNode.next != head) {
            if (auxNode.value.equals(value)) {
                return index;
            }
            auxNode = auxNode.next;
            index++;
        }
        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node auxNode = head;

        while (auxNode.next != head) {
            sb.append(auxNode.value);
            if (auxNode.next != head) {
                sb.append(", ");
            }
            auxNode = auxNode.next;
        }
        sb.append(", ").append(tail.value);
        return sb.append("]").toString();
    }

    public String reverseString() {
        StringBuilder sb = new StringBuilder("[");
        Node auxNode = tail;

        while (auxNode != head) {
            sb.append(auxNode.value);
            if (auxNode.prev != head) {
                sb.append(", ");
            }
            auxNode = auxNode.prev;
        }

        sb.append(", ").append(head.value);

        return sb.append("]").toString();
    }

    public void replace(E prevValue, E newValue) {
        if (isEmpty()) {
            throw new EmptyListException("Circular linked list is empty");
        }

        Node auxNode = head;

        while (auxNode.next != head) {
            if (auxNode.value.equals(prevValue)) {
                auxNode.value = newValue;
            }
            auxNode = auxNode.next;
        }
    }

    public E max() {
        if (isEmpty()) {
            throw new EmptyListException("Circular linked list is empty");
        }

        E element = head.value;
        Node auxNode = head;

        while (auxNode.next != head) {
            if (((Comparable<E>) auxNode.value).compareTo(element) > 0) {
                element = auxNode.value;
            }
            auxNode = auxNode.next;
        }

        return element;
    }

    public E min() {
        if (isEmpty()) {
            throw new EmptyListException("Circular linked list is empty");
        }

        E element = head.value;
        Node auxNode = head;

        while (auxNode.next != head) {
            if (((Comparable<E>) auxNode.value).compareTo(element) == -1) {
                element = auxNode.value;
            }
            auxNode = auxNode.next;
        }
        return element;
    }

    public boolean hasCycle() {
        Node auxNode = head;

        if (auxNode.prev == tail) {
            return true;
        }

        return false;
    }

    public void replaceLastOccurence(E value, E newValue) {
        Node auxNode = tail;

        while (auxNode.prev != tail) {
            if (auxNode.value.equals(value)) {
                auxNode.value = newValue;
            }
            auxNode = auxNode.prev;
        }
    }

    public void removeLastOccurence(E value) {
        Node auxNode = tail;
        int index = size - 1;

        while (auxNode.prev != tail) {
            if (auxNode.value.equals(value)) {
                removeByIndex(index);
                break;
            }
            auxNode = auxNode.prev;
            index--;
        }
    }

    public int counterOccurrences(E value) {
        Node auxNode = head;
        int ct = 0;

        while (auxNode.next != head) {
            if (auxNode.value.equals(value)) {
                ct++;
            }
            auxNode = auxNode.next;
        }
        return ct;
    }

    public E mode() {
        Node auxNode = head;
        E element = null;
        int maxOccurrences = 0;

        while (auxNode.next != head) {
            if (counterOccurrences(auxNode.value) > maxOccurrences) {
                maxOccurrences = counterOccurrences(auxNode.value);
                element = auxNode.value;
            }
            auxNode = auxNode.next;
        }

        return element;
    }
}
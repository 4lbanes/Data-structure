public class LinkedList<E> implements List<E> {

    private class Node {
        E value;
        Node next;

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
            newNode.next = head;
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
        Node newNode = new Node(value);
        if (index <= 0) {
            insert(value);
        } else if (index >= size) {
            add(value);
        } else {
            Node auxNode = getNode(index - 1);
            Node auxNode2 = getNode(index);

            auxNode.next = newNode;
            newNode.next = auxNode2;
            size++;
        }
    }

    @Override
    public E removeLast() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("List is empty!");
        }
        E removedValue = tail.value;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node auxNode = getNode(size - 2);
            auxNode.next = null;
            tail = auxNode;
        }
        size--;
        return removedValue;
    }

    @Override
    public E removeFirst() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("List is empty!");
        }
        E removedValue = head.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node auxNode = head;
            head = head.next;
            auxNode.next = null;
        }

        size--;
        return removedValue;
    }

    @Override
    public E removeByIndex(int index) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new EmptyListException("List is empty!");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Illegal index!");
        }
        E removedValue = null;
        if (index == 0) {
            removedValue = removeFirst();
        } else if (index == size - 1) {
            removedValue = removeLast();
        } else {
            Node auxNode1 = getNode(index);
            Node auxNode2 = getNode(index - 1);
            removedValue = auxNode1.value;

            auxNode2.next = auxNode1.next;
            auxNode1.next = null;
        }
        return removedValue;
    }

    @Override
    public void remove(E value) throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("List is empty!");
        }

        if (value == head.value) {
            removeFirst();
        } else if (value == tail.value) {
            removeLast();
        } else {
            Node auxNode = head;

            while (auxNode != null) {
                if (auxNode.value.equals(value)) {
                    int indexAuxNode2 = indexOf(auxNode.value);
                    int indexAuxNode3 = indexOf(auxNode.next.value);

                    Node auxNode2 = getNode(indexAuxNode2 - 1);
                    auxNode = getNode(indexAuxNode2);
                    Node auxNode4 = getNode(indexAuxNode3);

                    auxNode2.next = auxNode4;
                    auxNode.next = null;
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
        if (isEmpty()) {
            throw new EmptyListException("Linked List is Empty!");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Illegal index " + index + ". Availabe indexes are [0 - " + (size - 1) + "]");
        }
        Node auxNode = head;
        E value = null;
        for (int i = 0; i < index; i++) {
            auxNode = auxNode.next;
            value = auxNode.value;
        }
        return value;
    }

    @Override
    public void set(int index, E value) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new EmptyListException("Linked List is Empty!");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Illegal index " + index + ". Availabe indexes are [0 - " + (size - 1) + "]");
        }

        getNode(index).value = value;
    }

    @Override
    public void clear() throws EmptyListException {
        tail = null;
        head = null;
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
    public int indexOf(E value) {
        int index = 0;
        Node auxNode = head;

        while (auxNode != null) {
            if (auxNode.value.equals(value)) {
                return index;
            }
            auxNode = auxNode.next;
            index++;
        }
        return -1;
    }

    public int counterOccurrences(E value) {
        Node auxNode = head;
        int counter = 0;

        while (head != null) {
            if (auxNode.value.equals(value)) {
                counter++;
            }
            auxNode = auxNode.next;
        }
        return counter;
    }

    public boolean equality(LinkedList<E> list2) {
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

    public void removeLastOccurence(E value) {
        for (int i = size - 1; i >= 0; i--) {
            if (get(i).equals(value)) {
                removeByIndex(i);
                break;
            }
        }
    }

    public void replaceLastOccurence(E value, E toReplace) {
        for (int i = size - 1; i >= 0; i--) {
            if (get(i).equals(value)) {
                set(i, toReplace);
                break;
            }
        }
    }

    public int lastIndexOf(E value) {
        for (int i = size - 1; i >= 0; i--) {
            if (get(i).equals(value)) {
                return i;
            }
        }

        return -1;
    }

    public void removeDuplicates(E value) {
        if (isEmpty()) {
            throw new EmptyListException("Double linked list is empty");
        }

        Node auxNode = head;
        int index = 1;

        while (auxNode != null) {
            if (auxNode.value.equals(value)) {
                removeByIndex(index);
            } else {
                index++;
            }
            auxNode = auxNode.next;
        }
    }

    public E mode() {
        Node auxNode = head;
        int maxOccurrences = 0;
        E element = null;

        while (auxNode != null) {
            if (counterOccurrences(auxNode.value) > maxOccurrences) {
                maxOccurrences = counterOccurrences(auxNode.value);
                element = auxNode.value;
            }
            auxNode = auxNode.next;
        }
        
        return element;
    }
 
    public void intersections(LinkedList<E> l2) {
        LinkedList<E> intersections = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            E element = get(i);
            if (l2.contains(element) && contains(element)) {
                intersections.add(element);
            }
        }

        System.out.println(intersections);
    }

    public void differences(LinkedList<E> l2) {
        LinkedList<E> differences = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            E element = get(i);
            if (!l2.contains(element) && contains(element)) {
                differences.add(element);
            }
        }

        System.out.println(differences);
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

        for (int i = size - 1; i >= 0; i--) {
            E value = get(i);
            if (value != null) {
                sb.append(value);
                if (i != 0) {
                    sb.append(", ");
                }
            }
        }
        return sb.append(head.value).append("]").toString();
    }
}

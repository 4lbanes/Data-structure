public class StaticStack<E> implements Stack<E> {
    private int size;
    private int maxSize;
    private E[] data;
    private int top;

    @SuppressWarnings("unchecked")
    public StaticStack(int maxSize) {
        size = 0;
        this.maxSize = maxSize;
        data = (E[]) new Object[maxSize];
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E value) {
        if (isFull()) {
            throw new FullListException("Static stack is full!");
        }

        top++;
        data[top] = value;
        size++;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new EmptyListException("Static stack is empty");
        }

        E removed = data[top];
        top--;
        size--;

        return removed;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is illegal index");
        }

        return data[index];
    }

    @Override
    public void set(int index, E value) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is illegal index");
        }

        data[index] = value;
    }

    @Override
    public void clear() throws EmptyListException {
        size = 0;
        top = -1;
    }

    @Override
    public boolean contains(E value) throws EmptyListException {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E value) throws EmptyListException {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (data[i] != null) {
                sb.append(data[i]);
                if (i != size - 1) { 
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
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
    public void push(E value) {
        if (isFull()) {
            throw new FullListException("Static stack is full!");
        }

        top++;
        data[top] = value;
        size++;
    }

    @Override
    public E pop() {
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
    public E peek() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new EmptyListException("Static stack is empty!");
        }

        return data[top];
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

    @Override
    public void swap(int i1, int i2) throws IndexOutOfBoundsException, EmptyListException{
        if (i1 < 0 || i1 >= size || i2 < 0 || i2 >= size) {
            throw new IndexOutOfBoundsException("Some invalid index");
        }

        if(isEmpty()){
            throw new EmptyListException("Static stack is empty");
        }

        E val1 = data[i1];
        E val2 = data[i2];

        data[i1] = val2;
        data[i2] = val1;
    }

    @Override
    public void rotate() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Static stack is empty!");
        }

        for (int i = 0; i < size / 2; i++) {
            if (data[i] != null) {
                E val1 = get(i);
                E val2 = get((size - 1) - i);

                data[i] = val2;
                data[(size - 1) - i] = val1;
            }
        }
    }

    @Override
    public int counterOccurrences(E value) throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Static stack is empty!");
        }

        int occurrences = 0;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                occurrences++;
            }
        }
        return occurrences;
    }

    @Override
    public E mode() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Static stack is empty!");
        }

        int maxOccurrences = 0;
        E element = data[0];

        for (int i = 0; i < size; i++) {
            if (counterOccurrences(data[i]) > maxOccurrences) {
                element = data[i];
                maxOccurrences = counterOccurrences(element);
            }
        }
        return element;
    }

    @Override
    public void average() throws EmptyListException{
        if (isEmpty()) {
            throw new EmptyListException("Static stack is empty");
        }

        if (data[0] instanceof Number) {
            double average = sum() / size;
            System.out.println("Average: " + average);
        }else{
            throw new IllegalArgumentException("Static stack contains non-numeric elements");
        }
    }

    @Override
    public E weightedAverage() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Static stack is empty");
        }
    
        double sum = 0;
        int weights = 0;
        for (int i = 0; i < size; i++) {
            if (data[i] instanceof Number) {
                double weightedValue = ((i + 1) * ((Number) data[i]).doubleValue());
                sum += weightedValue;
                weights += (i + 1);
            } else {
                throw new IllegalArgumentException("Static stack contains non-numeric elements");
            }
        }
    
        double weightedAverage = sum / weights;
        return (E) Double.valueOf(weightedAverage);
    }

    @Override
    public E median() throws EmptyListException{
        if (isEmpty()) {
            throw new EmptyListException("Static stack is empty");
        }

        return data[size/2];
    }

    @Override
    public void replaceLastOccurrance(E value, E toReplace) throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Static stack is empty!");
        }

        for (int i = size - 1; i >= 0; i--) {
            if (data[i] != null && data[i].equals(value)) {
                data[i] = toReplace;
                break;
            }
        }
    }

    @Override
    public void replace(E value, E toReplace) throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Static stack is empty!");
        }

        for (int i = 0; i < size; i++) {
            if (data[i] != null && data[i].equals(value)) {
                data[i] = toReplace;
                break;
            }
        }
    }

    @Override
    public E min() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Static stack is empty");
        }

        E element = data[0];
        for (int i = 0; i < size; i++) {
            if (data[i] != null) {
                if (((Comparable<E>) data[i]).compareTo(element) == -1) {
                    element = data[i];
                }
            }
        }

        return element;
    }

    @Override
    public E max() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Static stack is empty");
        }

        E element = data[0];
        for (int i = 0; i < size; i++) {
            if (data[i] != null) {
                if (((Comparable<E>) data[i]).compareTo(element) == 1) {
                    element = data[i];
                }
            }
        }
        return element;
    } 

    @Override
    public double sum() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Static stack is empty");
        }

        double sum = 0;
        if (data[0] instanceof Number) {
            for (int i = 0; i < size; i++) {
                if (data[i] != null && data[i] instanceof Number) {
                    sum += ((Number) data[i]).doubleValue();
                }
            }
        } else {
            System.out.println("Static stack type incompatible");
        }
        return sum;
    }

    @Override
    public double mux() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Static stack is empty");
        }

        double mux = 1;
        if (data[0] instanceof Number) {
            for (int i = 0; i < size; i++) {
                if (data[i] != null && data[i] instanceof Number) {
                    mux *= ((Number) data[i]).doubleValue();
                }
            }
            System.out.println(mux);
        } else {
            System.out.println("Static stack type incompatible");
        }
        return mux;
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

    public String reveString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = size - 1; i >= 0; i--) {
            if (data[i] != null) {
                sb.append(data[i]);

                if (i != 0) {
                    sb.append(", ");
                }

            }
        }

        sb.append("]");
        return sb.toString();
    }
}
import java.util.Arrays;

public class DynamicStack<E> implements Stack<E> {
    private int size;
    private E[] data;
    private int top;

    public DynamicStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }

        data = (E[]) new Object[initialCapacity];
        top = -1;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(E value) {
        if (isFull()) {
            resize();
        }

        top++;
        data[top] = value;
        size++;
    }

    @Override
    public E pop() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Dynamic stack is empty!");
        }

        E removed = data[top];
        top--;
        size--;
        return removed;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is illegal index");
        }

        return data[index];
    }

    @Override
    public E peek() throws EmptyListException {
        return data[top];
    }

    @Override
    public void set(int index, E value) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is invalid!");
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
        if (isEmpty()) {
            throw new EmptyListException("Dynamic stack is empty!");
        }

        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E value) throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Dynamic stack is empty!");
        }

        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void swap(int i1, int i2) throws IndexOutOfBoundsException, EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Dynamic stack is empty!");
        }

        if (i1 < 0 || i1 >= size || i2 < 0 || i2 >= size) {
            throw new IndexOutOfBoundsException("Some invalid index");
        }

        E val1 = data[i1];
        E val2 = data[i2];

        data[i1] = val2;
        data[i2] = val1;
    }

    @Override
    public void rotate() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Dynamic stack is empty");
        }

        for (int i = 0; i < size / 2; i++) {
            E val1 = get(i);
            E val2 = get((size - 1) - i);

            data[i] = val2;
            data[(size - 1) - i] = val1;
        }
    }

    @Override
    public int counterOccurrences(E value) throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Dynamic stack is empty");
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
            throw new EmptyListException("Dynamic stack is empty");
        }

        E element = data[0];
        int maxOccurrences = 0;
        for (int i = 0; i < size; i++) {
            if (counterOccurrences(data[i]) > maxOccurrences) {
                element = data[i];
                maxOccurrences = counterOccurrences(element);
            }
        }

        return element;
    }

    @Override
    public void average() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Dynamic stack is empty");
        }

        if (data[0] instanceof Number) {
            double average = sum() / size;
            System.out.println(average);
        } else {
            System.out.println("Static stack contains non-numeric elements");
        }
    }

    @Override
    public E weightedAverage() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Dynamic stack is empty");
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
    public E median() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Dynamic stack is empty");
        }

        return data[size / 2];
    }

    @Override
    public void replaceLastOccurrance(E value, E toReplace) throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Dynamic stack is empty");
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
            throw new EmptyListException("Dynamic stack is empty");
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
                if (data[i] != null) {
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
        } else {
            System.out.println("Static stack type incompatible");
        }
        return mux;
    }

    private boolean isFull() {
        return top == data.length - 1;
    }

    private void resize() {
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
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

    public String reverseString() {
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

    public boolean equality(DynamicStack ds2) {
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(ds2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public DynamicStack<E> evens() {
        DynamicStack<E> evenStack = new DynamicStack<>(size);

        for (int i = 0; i < size; i++) {
            if (data[i] instanceof Number) {
                Number number = (Number) data[i];
                if (number.doubleValue() % 2 == 0) {
                    evenStack.push(data[i]);
                }
            } else {
                throw new IllegalArgumentException("element is not a number");
            }
        }

        return evenStack;
    }

    public DynamicStack<E> odds() {
        DynamicStack<E> oddStack = new DynamicStack<>(size);

        for (int i = 0; i < size; i++) {
            if (data[i] instanceof Number) {
                Number number = (Number) data[i];
                if (number.doubleValue() % 2 != 0) {
                    oddStack.push(data[i]);
                }
            } else {
                throw new IllegalArgumentException("element is not a number");
            }
        }

        return oddStack;
    }

    public void multiply(DynamicStack<Integer> stack, int k) {
        for (int i = 0; i < stack.size(); i++) {
            int value = stack.get(i) * k;
            stack.set(i, value);
        }
    }

    public void division(DynamicStack<Integer> stack, int k) {
        for (int i = 0; i < stack.size(); i++) {
            int value = stack.get(i) / k;
            stack.set(i, value);
        }
    }

    public DynamicStack<Integer> findAllIndicesOf(E value) {
        DynamicStack<Integer> indexesStack = new DynamicStack<>(size);
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                indexesStack.push(i);
            }
        }
        return indexesStack;
    }

    public DynamicStack<E> interleave(DynamicStack<E> stack2) {
        if (size() != stack2.size()) {
            throw new IllegalArgumentException("stacks are different sizes");
        }
        DynamicStack<E> newStack = new DynamicStack<>(size);
        for (int i = 0; i < size; i++) {
            newStack.push(get(i));
            newStack.push(stack2.get(i));
        }

        return newStack;
    }
}

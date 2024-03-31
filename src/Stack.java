public interface Stack<E> {
    int size();
	void push(E value);
	E pop() throws EmptyListException;
	boolean isEmpty();
	E get(int index) throws IndexOutOfBoundsException;
	E peek() throws EmptyListException;
	void set(int index, E value) throws IndexOutOfBoundsException;
	void clear() throws EmptyListException;
	boolean contains(E value) throws EmptyListException;
	int indexOf(E value) throws EmptyListException;
	void swap(int i1, int i2) throws IndexOutOfBoundsException, EmptyListException;
	void rotate() throws EmptyListException;
	int counterOccurrences(E value) throws EmptyListException;
	E mode() throws EmptyListException;
	void average() throws EmptyListException;
	E weightedAverage() throws EmptyListException;
	E median() throws EmptyListException;
	void replaceLastOccurrance(E value, E toReplace) throws EmptyListException;
	void replace(E value, E toReplace) throws EmptyListException;
	E min() throws EmptyListException;
	E max() throws EmptyListException;
	double sum() throws EmptyListException;
	double mux() throws EmptyListException;
}

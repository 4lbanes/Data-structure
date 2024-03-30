public interface Stack<E> {
    int size();
	void add(E value);
	E remove() throws EmptyListException;
	boolean isEmpty();
	E get(int index) throws IndexOutOfBoundsException;
	void set(int index, E value) throws IndexOutOfBoundsException;
	void clear() throws EmptyListException;
	boolean contains(E value) throws EmptyListException;
	int indexOf(E value) throws EmptyListException;
}

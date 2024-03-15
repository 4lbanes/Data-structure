
public interface List<E>{
	int size();
	void add(E value);
	void insert(E value);
	void insert(int index, E value) throws IndexOutOfBoundsException;
	E removeLast() throws EmptyListException;
	E removeFirst() throws EmptyListException;
	E removeByIndex(int index) throws IndexOutOfBoundsException;
<<<<<<< HEAD
	void remove(E value) throws EmptyListException;
=======
>>>>>>> cde7affcd257485d0fd8a0a567854d51d9b945de
	boolean isEmpty();
	E get(int index) throws IndexOutOfBoundsException;
	void set(int index, E value) throws IndexOutOfBoundsException;
	void clear() throws EmptyListException;
	boolean contains(E value) throws EmptyListException;
	int indexOf(E value) throws EmptyListException;
	void swap(int index1, int index2) throws IndexOutOfBoundsException, EmptyListException;
	void swap2(int index, E value) throws IndexOutOfBoundsException, EmptyListException;
}

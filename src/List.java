
public interface List<E>{
	int size();
	void add(E value);
	void insert(E value);
	void insert(int index, E value) throws IndexOutOfBoundsException;
	E removeLast() throws EmptyListException;
	E removeFirst() throws EmptyListException;
	E removeByIndex(int index) throws IndexOutOfBoundsException;
	void remove(E value) throws EmptyListException;
	boolean isEmpty();
	E get(int index) throws IndexOutOfBoundsException;
	void set(int index, E value) throws IndexOutOfBoundsException;
	void clear() throws EmptyListException;
	boolean contains(E value) throws EmptyListException;
	int indexOf(E value) throws EmptyListException;
} 

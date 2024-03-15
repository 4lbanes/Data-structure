
public class Main {
	public static void main(String[] args) throws EmptyListException {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

		list.add(3);
		list.add(5);

		list.add(7);
		list.insert(1);
		list.insert(1, 2);
		list.insert(3, 4);
		list.insert(5, 6);

		list.removeByIndex(3);
<<<<<<< HEAD
		//System.out.println(list);

		list.insert(3, 4);
		//System.out.println("LISTA COM PRINT NORMAL: "+list);

		//System.out.println("LISTA COM 'PRINT REVERSO': "+list.reverseString());

		//list.remove(2);
		//list.swap(1, 4);

		list.swap2(6, 20);
=======
		System.out.println(list);

		list.insert(3, 4);
		System.out.println("LISTA COM PRINT NORMAL: "+list);

		System.out.println("LISTA COM 'PRINT REVERSO': "+list.reverseString());

		list.removeFirst();
		list.removeLast();
>>>>>>> cde7affcd257485d0fd8a0a567854d51d9b945de
		System.out.println(list);
		//System.out.println(list.indexOf(6));
	}
}

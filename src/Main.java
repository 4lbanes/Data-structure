
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

		list.removeByIndex(4);
		System.out.println(list);
	}
}

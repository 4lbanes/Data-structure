
public class Main {
	public static void main(String[] args) throws EmptyListException {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

		list.insertSorted(2);
		list.insertSorted(3);
		System.out.println(list);
		list.insertSorted(1);
		System.out.println(list);
	}
}

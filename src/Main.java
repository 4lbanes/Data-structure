public class Main {
    public static void main(String[] args) throws EmptyListException {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
		DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();

		list.add(20);
		list.add(20);
		list.add(20);
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(90);
		list.add(10);

		list2.add(100);
		list2.add(0);
		list2.add(0);
		list2.add(0);
		list2.add(0);
		list2.add(0);
		list2.add(0);
		list2.add(0);

		System.out.println(list.getValuesByIndex(0, list2));
    }
}


public class Main {
	public static void main(String[] args) throws EmptyListException {
		LinkedList<Integer> list = new LinkedList<>();

		list.add(1);
	
		list.add(3);
		list.add(5);

		list.insert(1, 2);
		list.insert(3, 4);
		
		list.remove(3);
		System.out.println(list);
	}
}

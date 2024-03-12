

public class Main {
	public static void main(String[] args) throws EmptyListException {
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(6);
		System.out.println(list);
		
		list.insert(1);
		System.out.println(list);
		
		list.insert(3, 4);
		System.out.println(list);
		
		list.set(4, 20);
		System.out.println(list);
		
		System.out.println(list.get(4));
		
		list.replaceValue(199, 100);
		System.out.println(list);
		
		//list.removeByIndex(3);
		//System.out.println(list);
		
	}
}












public class Main {
	public static void main(String[] args) throws EmptyListException {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

		list.insert(1);
		list.insertSorted(2);
		list.insertSorted(3);
		
	
		System.out.println("LISTA COM PRINT NORMAL: "+list);
		System.out.println("LISTA COM 'PRINT REVERSO': "+list.reverseString());
		//System.out.println(list.indexOf(6));
	}
}

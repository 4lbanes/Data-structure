public class Main {
    public static void main(String[] args) throws EmptyListException {
		CircularList<Integer> list = new CircularList<>();

		list.add(1);
		list.add(200);
		list.add(300);
		list.add(400);
		list.add(600);
		list.insert(4, 500);
		list.replace(200, 1000);
		System.out.println(list);
		System.out.println(list.reverseString());

		System.out.println(list.max());
		System.out.println(list.min());
    }
}

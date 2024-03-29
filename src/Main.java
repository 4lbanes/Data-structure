public class Main {
    public static void main(String[] args) throws EmptyListException {
       CircularList<Integer> list = new CircularList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        System.out.println(list);

        System.out.println(list.reverseString());

    }
}

public class Main {
    public static void main(String[] args) throws EmptyListException {
       DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
      
       list.add(1);
       list.add(2);
       list.add(3);
       list.add(4);
       list.add(5);
       list.add(5);
       list.add(7);
       list.add(8);

       System.out.println(list);
       list.removeByIndex(5);
       System.out.println(list);

       System.out.println(list.reverseString());


    }
}

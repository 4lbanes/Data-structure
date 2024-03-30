public class Main {
    public static void main(String[] args) throws EmptyListException {
        StaticStack<Integer> sk = new StaticStack<>(5);

        sk.add(2);
        sk.add(10);
        sk.add(20);
        sk.add(4);

        System.out.println(sk);
    
        System.out.println(sk.max());

    }
}

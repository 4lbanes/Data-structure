public class Main {
    public static void main(String[] args) throws EmptyListException {
        DynamicStack<Integer> ds = new DynamicStack<>(10);

        ds.push(2);
        ds.push(20);
        ds.push(10);
        ds.push(4);
        ds.push(2);
        ds.push(20);
        ds.push(10);
        ds.push(4);
        ds.push(10);
        ds.push(4);
        ds.push(4);

        System.out.println(ds.mode());
        ds.rotate();
        System.out.println(ds);

    }
}

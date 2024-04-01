public class Main {
    public static void main(String[] args) throws EmptyListException {
        DynamicStack<Integer> ds = new DynamicStack<>(10);

        ds.push(30);
        ds.push(20);
        ds.push(10);
        ds.push(40);
        ds.push(100);

        System.out.println(ds);
        ds.division(ds, 2);
        System.out.println(ds);
        ds.multiply(ds, 10);
        System.out.println(ds);
    }
}

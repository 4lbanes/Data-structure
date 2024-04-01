public class Main {
    public static void main(String[] args) throws EmptyListException {
        CircularList<String> dStack = new CircularList<>();

        dStack.add("arthur");
        dStack.add("arthur");
        dStack.add("pedro");
        dStack.add("natha");
        dStack.add("pedro");
        dStack.add("sexo");
       
      System.out.println(dStack.findAllIndicesOf("pedro"));
    }
}

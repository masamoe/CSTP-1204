public class HelloWorld {
    public static void main(String[] args) {
        MySet x = new MySet();
        x.add(11);
        x.add(12);
        x.add(13);
        x.remove(11);

        System.out.println(x.contains(12));
        System.out.println(x.size());
    }
}


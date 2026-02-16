public class IntegerPoolExample {
    public static void main(String[] args) {
        Integer a=-128;
        Integer b=-128;
        Integer x=127;
        Integer y=127;
        System.out.println("a==b: " + (a==b));
        System.out.println("a.equals(b): " + a.equals(b));
        System.out.println("x==y: " + (x==y));
        System.out.println("x.equals(y): " + x.equals(y));
    }
}

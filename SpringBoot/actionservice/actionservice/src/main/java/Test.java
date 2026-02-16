public class Test {
    public static void main(String[] args) {
        String a="abc";
        String b="abc";
//        String c=new String("abc");
//        String d=new String("abc");
//        System.out.println(a==b);
//        System.out.println(a.equals(b));
//        System.out.println(a==c);
//        System.out.println(a.equals(c));
//        System.out.println(c==d);
//        System.out.println(c.equals(d));

        StringBuffer c=new StringBuffer("abc");
        StringBuffer d=new StringBuffer("abc");
//        System.out.println(c==d);
//        System.out.println(c.equals(d));

        StringBuilder e=new StringBuilder("abc");
        StringBuilder f=new StringBuilder("abc");
//        System.out.println(c==d);
//        System.out.println(c.equals(d));

        System.out.println(c.equals(a));
        System.out.println(e.equals(a));
        System.out.println(e.equals(c));
    }
}

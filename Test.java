public class Test{
  public static void main(String[] args){
    MyDeque<Integer> a = new MyDeque<Integer>();
    a.addFirst(4);
    a.addLast(1);
    a.addFirst(2);
    a.addLast(20);
    a.addFirst(6);
    System.out.println(a);
    System.out.println(a.debug());
    System.out.println(a.size());
    a.removeLast();
    a.removeFirst();
    System.out.println(a);
    System.out.println(a.debug());
    System.out.println(a.size());
    a.addFirst(12);
    System.out.println(a);
    System.out.println(a.debug());
    System.out.println(a.size());
  }
}

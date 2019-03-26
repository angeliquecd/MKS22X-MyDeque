public class MyDriver{
  public static void main (String[] args){
    MyDeque<Integer> list = new MyDeque<Integer>();
    list.addFirst(1);
    System.out.println(list);
    list.addLast(2);
    System.out.println(list);
    list.addLast(3);
    System.out.println(list);
    list.addLast(4);
    System.out.println(list);
    list.addLast(6);
    System.out.println(list);
    list.addLast(2);
    System.out.println(list);
    list.addFirst(1);
    System.out.println(list);
    list.addLast(10);
    System.out.println(list);
    System.out.println(list.size());
  }
}

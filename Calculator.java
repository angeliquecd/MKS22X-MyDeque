import java.util.*;
public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      String[] operations = new String[s.length()];
      MyDeque<Double> values = new MyDeque<Double>(s.length());
      String[] everything =s.split(" ");
      int index1 =0;
      int index2 = 0;
      for (int a=0;a<everything.length;a++){
        if (isnum(everything[a])) {
          values.addLast(Double.parseDouble(everything[a]));//fills up deque with all numbers
          index1++;}
        else {
          operations[index2]=everything[a];
          index2++;
        }
      }
      int j=0;
      while (values.size()>1){
        double primary = values.removeFirst();
        double secondary= values.removeFirst();//takes two parts of the binary operation
        //System.out.println("primary: "+primary+" secondary: "+secondary+"size: "+values.size());
        if (operations[j].equals("+")){
          //System.out.println("here");
        //  System.out.println(values);
          double sum = primary+secondary;
        //  System.out.println(sum);
          values.addFirst(sum);
      //    System.out.println(values);
        }
        else if (operations[j].equals("-")){
          double diff = primary-secondary;
        //  System.out.println(sum);
          values.addFirst(diff);
        }
        else if (operations[j].equals("/")){
          double quo = primary/secondary;
        //  System.out.println(sum);
          values.addFirst(quo);
        }
        else if (operations[j].equals("*")){
          double pro = primary*secondary;
        //  System.out.println(sum);
          values.addFirst(pro);
        }
        else if (operations[j].equals("%")){
          double mod = primary*secondary;
        //  System.out.println(sum);
          values.addFirst(mod);
        }
        j++;
      }
      //System.out.println(values);
      //System.out.println(debug(operations));
    //  System.out.println(debug(everything));
      return values.getLast();
    }
    public static boolean isnum(String a){
      try{
        Double.parseDouble(a);
        return true;
      }
      catch (NumberFormatException c){
        return false;
      }
    }
    public static String debug(double[] data){
      String value ="";
      for (double element: data){
        value+=" "+element;
      }
      return value;
    }
    public static String debug(String[] data){
      String value ="";
      for (String element: data){
        value+=" "+element;
      }
      return value;
    }
    public static void main(String[] args){
      System.out.println(eval("3 5 +"));
      System.out.println(eval("10 2.0 +"));
      System.out.println(eval("11 3 - 4 + 2.5 *") );
      System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")) ;
      System.out.println(eval("1 2 3 4 5 + * - -")) ;

    }
}

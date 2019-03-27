import java.util.*;
public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      String[] operations = new String[s.length()];
      double[] values = new double[s.length()];
      String[] everything =s.split(" ");
      int index1 =0;
      int index2 = 0;
      for (int a=0;a<everything.length;a++){
        if (isnum(everything[a])) {
          values[index1]=Double.parseDouble(everything[a]);
          index1++;}
        else {
          operations[index2]=everything[a];
          index2++;
        }
      }
      System.out.println(debug(values));
      System.out.println(debug(operations));
      System.out.println(debug(everything));
      return 2;
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
      eval("1 2 +");
    }
}

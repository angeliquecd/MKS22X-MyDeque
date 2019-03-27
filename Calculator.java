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
          values.addLast(Double.parseDouble(everything[a]));
          index1++;}
        else {
          operations[index2]=everything[a];
          index2++;
        }
      }
      int i=0;
      int j=0;
      boolean starting=true;
      while (values.size()>2||starting){
        double primary = values.removeFirst();
        double secondary= values.getFirst();
        System.out.println("primary: "+primary+" secondary: "+secondary+"size: "+values.size());
        if (operations[j].equals("+")){
          System.out.println("here");
          System.out.println(values);
          double sum = primary+secondary;
          System.out.println(sum);
          values.addLast(sum);
          values.removeFirst();
          System.out.println(values);
        }
        else if (operations[j].equals("-")){
          values.addFirst(primary-secondary);
        }
        else if (operations[j].equals("/")){
          values.addFirst(primary*secondary);
        }
        else if (operations[j].equals("*")){
          values.addFirst(primary/secondary);
        }
        i+=2;
        j++;
        starting=false;
      }
      System.out.println(values);
      System.out.println(debug(operations));
      System.out.println(debug(everything));
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
    }
}

import java.util.*;
public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
     public static double eval(String s){//actually version 2
       MyDeque<Double> values = new MyDeque<Double>(s.length());
       String[] stuff =s.split(" ");
       for (int i=0;i<stuff.length;i++){
         String place = stuff[i];
         if (isnum(place)){//until you get to operation
           values.addLast(Double.parseDouble(place));//adds up the whole thing
             //System.out.println(values);
         }
         else{
           double secondary = values.removeLast();
           double primary = values.removeLast();
           if (place.equals("+")){
             //System.out.println("here");
            // System.out.println(values);
             double sum = primary+secondary;
           //  System.out.println(sum);
             values.addLast(sum);

          //  System.out.println(values);
           }
           else if (place.equals("-")){
             double diff = primary-secondary;
              //  System.out.println(values);
           //  System.out.println(sum);
             values.addLast(diff);
              // System.out.println(values);
           }
           else if (place.equals("/")){
             double quo = primary/secondary;
            //    System.out.println(values);
           //  System.out.println(sum);
             values.addLast(quo);
            //   System.out.println(values);
           }
           else if (place.equals("*")){
             double pro = primary*secondary;

           //  System.out.println(sum);
             values.addLast(pro);
            //   System.out.println(values);
           }
           else if (place.equals("%")){
             double mod = primary%secondary;
           //  System.out.println(sum);
             values.addLast(mod);
            //  System.out.println(values);
           }
         }//adds values to the end after doing the stuff so that you can work with them again
       }
       return values.getFirst();
     }
     public static double eval3(String s){
       MyDeque<Double> values = new MyDeque<Double>(s.length());
       String[] stuff =s.split(" ");
       double answer =0;
       double secondary=0;
       double primary=0;
       for (int i=0;i<stuff.length;i++){
         String place = stuff[i];
         if (isnum(place)){
           values.addLast(Double.parseDouble(place));
             System.out.println(values);
         }
         else{
           if (values.size()>1){
          primary = values.removeFirst();
            secondary = values.removeFirst();
          if (place.equals("+")){
            //System.out.println("here");
            System.out.println(values);
            primary+= secondary;
            values.addFirst(primary);
          //  System.out.println(sum);
         //   values.addFirst(sum);

           System.out.println(answer);
          }
          else if (place.equals("-")){
            primary-=secondary;
            values.addFirst(primary);
               System.out.println(answer);
          //  System.out.println(sum);
         //   values.addFirst(diff);
           //   System.out.println(values);
          }
          else if (place.equals("/")){
            primary=primary/secondary;
            values.addFirst(primary);
            System.out.println(answer);
          }
          else if (place.equals("*")){
           primary=primary*secondary;
           values.addFirst(primary);
           System.out.println(answer);
          }
          else if (place.equals("%")){
            primary=primary%secondary;
            values.addFirst(primary);
            System.out.println(answer);
          }}
           else{
             secondary=values.removeFirst();
           System.out.println("answer is: "+answer);
           System.out.println("secondary is: "+secondary);
           if (place.equals("+")){
             //System.out.println("here");
             System.out.println(values);
             answer+= secondary;
           //  System.out.println(sum);
          //   values.addFirst(sum);

            System.out.println(answer);
           }
           else if (place.equals("-")){
             answer-=secondary;
                System.out.println(answer);
           //  System.out.println(sum);
          //   values.addFirst(diff);
            //   System.out.println(values);
           }
           else if (place.equals("/")){
             answer=answer/secondary;
             System.out.println(answer);
           }
           else if (place.equals("*")){
            answer=answer*secondary;
            System.out.println(answer);
           }
           else if (place.equals("%")){
             answer=answer%secondary;
             System.out.println(answer);
           }}
         }
       }
       return values.getFirst();
     }//proof that i tried
    public static double eval2(String s){
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
      //System.out.println(debug(operations));//more proof that i tried
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
/*
      System.out.println("Answer: " + eval2("3 5 +"));//8
      System.out.println("Answer: " +eval2("10 2.0 +"));//12
      System.out.println("Answer: " +eval2("11 3 - 4 + 2.5 *") );//30
      System.out.println("Answer: " +eval2("8 2 + 99 9 - * 2 + 9 -")) ;//893
      System.out.println("Answer: " +eval2("1 2 3 4 5 + * - -")) ;//26
    /*  System.out.println("Answer: " + eval3("3 5 +"));//8
      System.out.println("Answer: " +eval3("10 2.0 +"));//12
      System.out.println("Answer: " +eval3("11 3 - 4 + 2.5 *") );//30
      System.out.println("Answer: " +eval3("8 2 + 99 9 - * 2 + 9 -")) ;//893
      System.out.println("Answer: " +eval3("1 2 3 4 5 + * - -")) ;//26*/
    }
}

import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

@SuppressWarnings("unchecked")
  public MyDeque(){
	   data = (E[]) new Object[10];
	    size =0;
	     start = 0;
	      end = 0;
 }//suppress warning

 @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
	   data = (E[]) new Object[initialCapacity];
	    size = 0;
	     start=0;
	      end=0; }

  public int size(){
	   return size;}

     @SuppressWarnings("unchecked")
  public String toString(){
    int capacity=data.length;
    String value ="";
    int total =start;
    int inc =0;
    int level=0;
  //  boolean goneback = false;
    E ending= (E) new Object();
    while (inc<size){//idea: it works backward until it finds the end and then works forwards until it finds the end
      //was a bad idea ^^
      int index=(total+level)%capacity;
      //System.out.println(index);
      E workingwith = data[index];
      if (index!=end){
      value+=workingwith+" ";
    //  System.out.println(value);
      inc++;
      level++;
    }
    else{
       ending =workingwith;
      level++;
      inc++;
    }
  }
    return value+ending;
}
public String debug(){
  String value ="";
  for (E element: data){
    value+=" "+element;
  }
  return "start: "+start+" end: "+end+" \n"+ value;
}
  public void addFirst(E element){
    try{
      int capacity = data.length;
    if (element == null) throw new NullPointerException();
    if(size==0){//when list is empty
        data[0] = element;
      }
    else if(start == 0){
        data[capacity-1] = element;//adds it to the very back of the array
        start = capacity-1;//sets start to right spot
      }
      else{//works its way backward?
        data[start - 1] = element;
        start-=1;
      }
      size++;//increases the size of the list
    //  System.out.println("added"+element);
    }
  catch (NullPointerException e){
    e.printStackTrace();
  }
}

  public void addLast(E element){
    try{
      int capacity=data.length;//makes use of full array
      if (element == null) throw new NullPointerException();
      if (end==capacity-1){
        data[capacity-1]=element;
        end=capacity-1;//won't work later on!
        }
        else{
          data[end+1]=element;
          end+=1;
        }
	       size++;
         if (size>=data.length) resize();
        // System.out.println("added"+element);
}
catch (NullPointerException e){
  e.printStackTrace();
}}


  public E removeFirst(){
    try{
    if (size==0) throw new NoSuchElementException();
    E toreturn = data[start];
    if(size!=1){
    start+=1;}
	   size--;
  return toreturn;
}
catch(NoSuchElementException e){
    e.printStackTrace();
  }
  return null;
}

  public E removeLast(){
    try{
  if (size==0) throw new NoSuchElementException();
	E endy =data[end];
  if (size!=1){
	end-=1;
	size--;}
	return endy;
}
  catch (NoSuchElementException e){
    e.printStackTrace();
  }
return null;
}
//pop

   @SuppressWarnings("unchecked")
  private void resize(){//if it reaches capacity, resize to make it twice as big
    //System.out.println("resizing");
    int newlength = 2*data.length;
    E[] newdata = (E[]) new Object[newlength];
    if (start<end){//in the rare case data isn't twisted
    for (int i =0;i<data.length;i++){
      newdata[i]=data[i];
    }
    data=newdata;}
  else{
    for (int h=start;h<data.length;h++){
      newdata[h-start]=data[h];//works from start to back
    }
    int spot=data.length-start;
    for (int a=0;a<=end;a++){//works with ending stuff and tacks it on
      newdata[spot]=data[a];
      spot++;
    }
  }
  start=0;
  end=size;//by design
  data=newdata;
  }

  public E getFirst(){
	return data[start]; }//do not remove the element
  public E getLast(){
	return data[end]; }
}

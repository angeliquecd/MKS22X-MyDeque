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
    String value ="{";
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
      value+=workingwith+", ";
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
    if(size>0)return value+ending+"}";
    else return "{}";
}
public String debug(){
  String value ="";
  for (E element: data){
    value+=" "+element;
  }
  return "start: "+start+" end: "+end+" \n"+ value;
}
  public void addFirst(E element){
      int capacity = data.length;
    if (element == null) throw new NullPointerException();
    if(size==0){//when list is empty
        data[0] = element;
        start=0;
        end=0;
      }
    else if(start == 0){//if only one element has been added(or just resized)
        data[capacity-1] = element;//adds it to the very back of the array
        start = capacity-1;//sets start to right spot
      }
      else{//works its way backward?
        data[start - 1] = element;
        start-=1;
      }
      size++;//increases the size of the list
      if (size>=capacity) resize();
    //  System.out.println("added"+element);
}

  public void addLast(E element){
      int capacity=data.length;//makes use of full array
      if (element == null) throw new NullPointerException();
      if (end==capacity-1){
        data[0]=element;
        end=0;//won't work later on!
        }
      else if (size==0){
        data[0]=element;
        start=0;
        end=0;
      }
        else{
          data[end+1]=element;
          end+=1;
        }
	       size++;
         if (size>=capacity) resize();
        // System.out.println("added"+element);
}



  public E removeFirst(){
    if (size==0) throw new NoSuchElementException();
    E toreturn = data[start];
    if(size!=1){
    start+=1;
   size--;}
    else{
      size=0;
      start=0;
      end=0;
    }
  return toreturn;

}

  public E removeLast(){
  if (size==0) throw new NoSuchElementException();
	E endy =data[end];
  if (end!=0){
	end-=1;
}
else{
  if (size!=1){
    end = data.length-1;
  }
}
  size--;
	return endy;
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
  end=size-1;//by design
  data=newdata;
  }

  public E getFirst(){
    if (size==0) throw new NoSuchElementException();
	return data[start]; }//do not remove the element
  public E getLast(){
    if (size==0) throw new NoSuchElementException();
	return data[end]; }
}

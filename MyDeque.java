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
    String value ="";
    int total =start;
    int inc =0;
    int level=0;
    boolean goneback = false;
    E ending= (E) new Object();
    while (inc<size){//idea: it works backward until it finds the end and then works forwards until it finds the end
      E workingwith = data[(total+level)%size];
      if ((total+level)%size!=end){
      value+=workingwith+" ";
      inc++;
      level--;
      goneback =true;}
      else{
        if (goneback){
        ending = workingwith;
        inc++;
        level++;
      }
    }
    return value+ending;
}}
public String debug(){
  String value ="";
  for (E element: data){
    value+=" "+element;
  }
  return value;
}
  public void addFirst(E element){
    try{
      int capacity = data.length;
    if (element == null) throw new NullPointerException();
    if(size==0){//when list is empty
        data[0] = element;
        end=1;
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
    }
  catch (NullPointerException e){
    e.printStackTrace();
  }}

  public void addLast(E element){
    try{
      if (element == null) throw new NullPointerException();
	     data[size]=element;
	      end = size;
	       size++;
         if (size>=data.length) resize();
}
catch (NullPointerException e){
  e.printStackTrace();
}}


  public E removeFirst(){
    try{
    if (size==0) throw new NoSuchElementException() ;
    E toreturn = data[start];
    start-=1;
	size--;
  return toreturn;
}
catch(NoSuchElementException e){
    e.printStackTrace();
  }
}

  public E removeLast(){
    try{
  if (size==0) throw new NoSuchElementException();
	E endy =data[end];
	end-=1;
	size--;
	return endy;
}
  catch (NoSuchElementException e){
    e.printStackTrace();
  }
}
//pop

   @SuppressWarnings("unchecked")
  private void resize(){//if it reaches capacity, resize to make it twice as big
    int newlength = 2*data.length;
    E[] newdata = (E[]) new Object[newlength];
    for (int i =0;i<data.length;i++){
      newdata[i]=data[i];
    }
    data=newdata;
  }

  public E getFirst(){
	return data[start]; }//do not remove the element
  public E getLast(){
	return data[end]; }
}

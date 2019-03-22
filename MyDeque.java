

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
	    size = initialCapacity;
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
    E ending= (E) new Object();
    while (inc<size){
      E workingwith = data[(total+level)%size];
      if ((total+level)%size!=end){
      value+=workingwith+" ";
      inc++;
      level++;}
      else{
        ending = workingwith;
        inc++;
        level++;
      }
    }
    return value+ending;
  }
  public void addFirst(E element){
    try{
      if (element == null) throw new NullPointerException();
      data[size]=data[start];
     data[start]=element;
     size++;
    if (size>=data.length) resize();
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
  //  try{
  //  if (size==0) throw new NoSuchElementException() ;
    if (start+1!=end && start+1<size) start = start+1;
	size--;
  return data[start];
//}
  //catch(NoSuchElementException e){
    //e.printStackTrace();
//  }
}
  public E removeLast(){
  //  try{
  //if (size==0) throw new NoSuchElementException();
	int endy =end;
	end = size;
	size--;
	return data[endy];
//}
  //catch (NoSuchElementException e){
    //e.printStackTrace();
//  }
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


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
  public String toString(){
    String value ="";
    int total =start;
    int inc =0;
    int level=0;
    while (inc<=size){
      value+=data[total+level%size]+" ";
      inc++;
      level++;
    }
    return value;
  }
  public void addFirst(E element){
	   start=size;
     data[size]=element;
     size++;
	}
  public void addLast(E element){
	data[size]=element;
	end = size;
	size++;}
  public E removeFirst(){
    if (start+1!=end && start+1<size) start = start+1;
	size--;
  return data[start];}
  public E removeLast(){
	int endy =end;
	end = data[size-2];
	size--;
	return data[endy];}//pop
  public E getFirst(){
	return start; }//do not remove the element
  public E getLast(){
	return end; }
}

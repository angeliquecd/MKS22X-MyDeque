public class MyDeque<E>{
  private E[] data;
  private int size, start, end;
@SuppressWarnings("unchecked");
  public MyDeque(){ 
	data = (E[]) new Object[10];
	size =0;
	start = null;
	end = null;
 }//suppress warning
  public MyDeque(int initialCapacity){ 
	data = (E[]) new Object[initialCapacity];
	size = initialCapacity;
	start=0;
	end=0; }
  public int size(){ 
	return size;}
  public String toString(){ }
  public void addFirst(E element){
	start=element;
	size++	 
	}
  public void addLast(E element){
	data[size]=element;
	end = ;
	size++;}
  public E removeFirst(){
	first = data[1];
	size--; }
  public E removeLast(){
	endy =end
	end = data[size-2]; 
	size--;
	return data[endy];}//pop
  public E getFirst(){
	return start; }//do not remove the element
  public E getLast(){
	return end; }
}

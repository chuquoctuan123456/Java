package hw4_21000710_chuquoctuan.ex4;

public interface QueueInterface<E> extends Iterable<E>{
    public void enqueue(E element);
    public E dequeue();
    public boolean isEmpty();
    public void print();
}

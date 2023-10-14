package deque;

import java.util.Arrays;

public class ArrayDeque<T> {
    private T[] items = (T[]) new Object[8];
    private int size;
    private int pre;
    private int next;

    public ArrayDeque() {
         size = 0;
         pre = 3;
         next = 4;
    }

    public ArrayDeque(T item){
        items[3] = item;
        size = 1;
        pre = 2;
        next = 4;
    }
    public void addFirst(T item){
        items[pre] = item;
        size += 1;
        pre -= 1;

    }

    public void addLast(T item){
        items[next] = item;
        size += 1;
        next += 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){

    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        pre += 1;
        T item = items[pre];
        items[pre] = null;
        size -= 1;
        return item;
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        next -= 1;
        T item = items[next];
        items[next] = null;
        size -= 1;
        return item;
    }

    public T get(int index){
        if (index < 0 || index > size - 1){
            return null;
        }
        int itemIndex = pre + index + 1;
        return items[itemIndex];
    }

    private void resize(int s){

    }

}

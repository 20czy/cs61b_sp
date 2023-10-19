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
        if (pre == -1){
            resize(size * 2);
        }

    }

    public void addLast(T item){
        items[next] = item;
        size += 1;
        next += 1;
        if (next == items.length){
            resize(size * 2);
        }
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

    private void ShrinkSize(int N){
        if (isEmpty()){
            resize(8);
            // the use rate of the array is small then 25%
        } else if (items.length / 4 > size && size >= 4) {
            resize(size / 2);
        }
    }


    public T get(int index){
        if (index < 0 || index > size - 1){
            return null;
        }
        int itemIndex = pre + index + 1;
        return items[itemIndex];
    }

    private void resize(int s){
        T[] newItems = (T[]) new Object[s];
        int firstPos = Math.abs(s - size) / 2;
        System.arraycopy(items, next + 1, newItems, firstPos, size);
        items = newItems;
        pre = firstPos - 1;
        next = firstPos + size;
    }

}

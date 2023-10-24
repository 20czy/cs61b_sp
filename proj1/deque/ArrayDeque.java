package deque;

import java.util.Arrays;

public class ArrayDeque<T> implements Deque<T>{
    private T[] items = (T[]) new Object[8];
    private int size;
    private int pre;
    private int next;
    private int centre; // no matter what size the array is , the centre is always point to the first node of the array

    public ArrayDeque() {
        centre = 8 / 2;
         size = 0;
         pre = centre;
         next = centre + 1;
    }

    public ArrayDeque(T item){
        items[centre] = item;
        size = 1;
        pre = centre - 1;
    }

    @Override
    public void addFirst(T item){
        items[pre] = item;
        size += 1;
        if (size == items.length){
            resize(items.length * 2);
        }
        pre -= 1;
        if (pre == -1){
            pre = items.length - 1;
        }

    }

    @Override
    public void addLast(T item){
        items[next] = item;
        size += 1;
        if (size == items.length){
            resize(items.length * 2);
        }
        next += 1;
        if (next == items.length){
           next = 0;
        }
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        if (size == 0){
            return;
        }
        for (int i = 0;i < size; i++){
            T a = get(i);
            System.out.println(a);
        }
    }

    @Override
    public T removeFirst(){
        if (isEmpty()) {
            return null;
        }
        pre += 1;
        if (pre == items.length) {
            pre = 0;
        }
        T item = items[pre];
        items[pre] = null;
        size -= 1;
        if (items.length / 4 > size && size > 8){
            ShrinkSize();
        }
        return item;
    }

    @Override
    public T removeLast(){
        if (isEmpty()) {
            return null;
        }
        next -= 1;
        if (next == -1) {
            next = items.length - 1;
        }
        T item = items[next];
        items[next] = null;
        size -= 1;
        if (items.length / 4 > size && size > 8){
            ShrinkSize();
        }
        return item;
    }


    private void ShrinkSize(){
        if (isEmpty() || size < 8){
            resize(8);
            // the use rate of the array is small then 25%
        } else if (items.length / 4 > size) {
            resize(size / 2);
        }
    }


    @Override
    public T get(int index){
        if (index < 0 || index > size - 1){
            return null;
        }
        int itemIndex = pre + index + 1;
        return items[itemIndex];
    }

    private void resize(int s){
        T[] newItems = (T[]) new Object[s];
        int firstPos = s / 2;
        System.arraycopy(items,0, newItems, firstPos, size);
        items = newItems;
        pre = firstPos - 1;
        if (firstPos + size == items.length){
            next = 0;
        }
        else {
            next = firstPos + size;
        }
    }

}

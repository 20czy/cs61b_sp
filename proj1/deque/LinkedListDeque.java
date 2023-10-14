package deque;

public class LinkedListDeque<T> {
    public static class ItemNode<T>{
        public ItemNode<T> prev;
        public T item;
        public ItemNode<T> next;

        public ItemNode(T item, ItemNode<T> n, ItemNode<T> m) {
            this.item = item;
            next = n;
            prev = m;
        }
    }
    private final ItemNode<T> head = new ItemNode<>(null ,null,null);
    private int size;
    public LinkedListDeque(){
        head.next = head;
        head.prev = head;
        size = 0;
    }

    public LinkedListDeque(T item){
        head.next = new ItemNode<>(item, head, head);
        head.prev = head.next;
        size = 1;
    }

    public void addFirst(T item){
        //adds an item of type T
        head.next = new ItemNode<>(item, head.next, head);
        head.next.next.prev = head.next;
        size += 1;
    }

    public void addLast(T item){
        head.prev = new ItemNode<>(item, head, head.prev);
        head.prev.prev.next = head.prev;
        size += 1;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        if (size == 0){
            return;
        }

        String[] items = new String[size];
        ItemNode<T> p = head.next;

        for (int i = 0; i < size; i++){
            items[i] = p.item.toString();
            p = p.next;

        }
        System.out.println(String.join(" ",items));
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        T item = head.next.item;
        head.next = head.next.next;
        head.next.prev = head;
        size -= 1;
        return item;
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        T item = head.prev.item;
        head.prev = head.prev.prev;
        head.prev.next = head;
        size -= 1;
        return item;

    }

    public T get(int index){
        if (index < 0 || index > size){
            return null;
        }
        ItemNode<T> p = head.next;
        for (int i = 0; i < index; i ++){
            p = p.next;
        }
        return p.item;
    }
}

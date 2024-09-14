import java.util.Arrays;

public class MyList<T>{
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MyList() {
        this.array = (T[]) new Object[10];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyList(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public int getCapacity(){
        return this.array.length;
    }

    public void add(T data) {
        if (size == array.length) {
            resizeArray();
        }
        array[size++] = data;
    }

    private void resizeArray(){
        array = Arrays.copyOf(array, array.length *2);
    }

    public T get(int index){
        if (index >= 0 && index < size ){
            return array[index];
        }
        return null;
    }

    public T remove(int index){
        if (index >= 0 && index < size){
            T removedElement = array[index];
            for (int i = index; index < size-1; i++){
                array[i] = array[i+1];
            }
            array[--size] = null;
            return removedElement;
        }
        return null;
    }

    public T set(int index, T data){
        if (index >=0 && index < size){
            T oldValue = array[index];
            array[index] = data;
            return oldValue;
        }
        return null;
    }

    @Override
    public String toString(){
        if (size == 0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++){
            sb.append(array[i]);
            if (i < size -1){
                sb.append(", ");
            }

        }
        sb.append("]");
        return sb.toString();

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public MyList<T> subList(int start, int finish) {
        if (start < 0 || finish > size || start > finish) {
            throw new IndexOutOfBoundsException("Geçersiz indeksler.");
        }
        MyList<T> sublist = new MyList<>(finish - start);
        for (int i = start; i < finish; i++) {
            sublist.add(array[i]);
        }
        return sublist;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }




}

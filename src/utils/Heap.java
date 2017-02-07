package utils;
import java.util.ArrayList;
import java.util.NoSuchElementException;


/**
 * Created by ciaran on 06/02/2017.
 */
public class Heap<T extends Comparable<T>> {

    private ArrayList<T> heap;

    public Heap(){
        heap = new ArrayList<T>();
    }

    public void siftUp(){
        int k = heap.size() - 1;
        while (k > 0){
            int p = (k-1)/2;
            T item = heap.get(k);
            T parent = heap.get(p);

            if(item.compareTo(parent) > 0){
                heap.set(k, parent);
                heap.set(p, item);

                k = p;
            }else{
                break;
            }
        }
    }

    public void siftDown(){
        int k = 0;
        int l = 2*k+1;
        while (l<heap.size()){
            int max = l, r=l+l;
            if(r < heap.size()){
                if(heap.get(r).compareTo(heap.get(l))>0){
                    max ++;
                }
            }
            if(heap.get(k).compareTo(heap.get(max))<0){
                T temp =heap.get(k);
                heap.set(k, heap.get(max));
                heap.set(max, temp);
                k = max;
                l = 2*k+1;
            }else{
                break;
            }
        }
    }

    public void add(T newEntry){
        heap.add(newEntry);
        siftUp();
    }

    public T delete() throws NoSuchElementException{
        if(heap.size() == 0){
            throw new NoSuchElementException();
        }if (heap.size() == 1){
            return heap.remove(0);
        }
        T hold = heap.get(0);
        heap.set(0, heap.remove(heap.size()-1));
        siftDown();
        return hold;
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }

    public int getSize(){
        return heap.size();
    }

    public void clear(){
        heap.clear();
    }

    public String toString(){
        return heap.toString();
    }
}

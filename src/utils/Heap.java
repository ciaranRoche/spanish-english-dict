package utils;
import models.Word;

import java.util.ArrayList;
import java.util.NoSuchElementException;


/**
 * Created by ciaran on 06/02/2017.
 * Class of Type Generic Heap which extends Comparable Generic
 */
public class Heap<T extends Comparable<T>> {

    private ArrayList<T> heap;

    public Heap(){
        heap = new ArrayList<T>();
    }

    /**
     * Method Sift Up, used for adding an Item to heap. As their is a pattern to a heap
     * the order to which items appear in the heap, it is possible to find a nodes parent
     * by compairing to the parent if result is greater than 0 swap the parent for the node,
     * keep going until parent is less than 0
      */
    public void siftUp(){
        boolean check = true;
        int k = heap.size() - 1;
        while ((k > 0)&&(check)){
            int p = (k-1)/2;
            T item = heap.get(k);
            T parent = heap.get(p);
            if(item.compareTo(parent) > 0){
                heap.set(k, parent);
                heap.set(p, item);

                k = p;
            }else{
                check = false;
            }
        }
    }

    /**
     * Similar to the sift up method, as the pattern is known, it is possible to find the
     * children of a node. This method starts at the top node and iterates down the tree
     * comparing parent to node and replacing where needed, used when deleting the top node.
     */
    public void siftDown(){
        boolean check = true;
        int k = 0;
        int l = 2*k+1;
        while ((l<heap.size())&&(check)){
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
                check = false;
            }
        }
    }


    public void add(T newEntry){
        heap.add(newEntry);
        siftUp();
    }

    /**
     * Delete method to which deletes top node then sifts down the tree to find new top node
     * @return
     * @throws NoSuchElementException
     */
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

    public int size(){
        return heap.size();
    }

}

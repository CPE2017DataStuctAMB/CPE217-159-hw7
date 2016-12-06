/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw7;

/**
 *
 * @author patiw
 */
public class Heap {
    boolean isMinHeap; // true if minHeap, false if maxHeap
    int heapSize;
    Node[] arr;//Array as a complete binary tree
    int back;
    // For each node to be inserted into the heap, timeCounter will increase by 1
    int timeCounter;
    public Heap(boolean isMinHeap, int size){
        arr = new Node[size+1];
        heapSize = size;
        back = 1;
        this.isMinHeap = isMinHeap;
        timeCounter = 0;
    }
    public Node top(){
        if(back>1)
            return arr[1];
        else
            return null;
    }
    
    public void push(Node node){
        node.timestamp = timeCounter++;
        arr[back] = node;
        while(back>1)
        {
            if(arr[back].compare(arr[back/2]))
                swap(back,back/2);
            back>>=1;
        }
        back++;
    }
    public Node pop(){
        int b = 2;
        Node returnNode = arr[1];
        arr[1] = arr[--back];
        arr[back] = null;
        while(b<back)
        {
            if(b+1<back && arr[b+1].compare(arr[b]))
                b++;
            if(arr[b].compare(arr[b/2]))
                swap(b,b/2);
            b<<=1;
        }
        return returnNode;
    }

    // Optional: If you do not know what this function does, you do not have to use it
    public void swap(int index1, int index2){
        Node temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    // Optional: If you do not know what this function does, you do not have to use it
    public void printArray(){
        System.out.print("[");
        for (int i=1; i<back; i++){
            System.out.print(arr[i].price);
            if (i<back-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

}

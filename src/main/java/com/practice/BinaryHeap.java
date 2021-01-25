package com.practice;

import java.util.Arrays;

public class BinaryHeap {

    public static void main(String[] args) {
        int[] arr = new int[]{32, 42, 1, 33, 13, 2};
        BinaryHeap h = new BinaryHeap(arr, 12);
//        BinaryHeap h = new BinaryHeap(12);
        h.print();
        h.insert(53);
        h.print();
        h.insert(153);
        h.print();
        h.insert(3);
        h.print();
        h.insert(7);
        h.print();
        h.insert(5);
        h.print();
        h.insert(-1);
        h.print();

        for(int i = h.size; i >=0;i--){
            System.out.print("Max:"+h.poll()+" Current Max:"+h.peek());
            System.out.println();
        }

    }

    public int[] heap;
    public int size;
    public int capacity;

    public BinaryHeap(int capacity) {
        size = 0;
        this.capacity = capacity;
        heap = new int[capacity];
    }

    public BinaryHeap(int[] arr, int capacity) {
        size = arr.length - 1;
        this.capacity = capacity;
        heap = Arrays.copyOf(arr, capacity);
        buildHeap(heap);
    }

    void print() {
        for (int i : heap) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    int poll() {
        int ret = heap[0];

        // swap 1st element with one at "size" index
        int t = heap[size];
        heap[size] = heap[0];
        heap[0] = t;
        //  discard last element
        size = size - 1 ;
        heapify(0);
        return ret;
    }

    int peek() {
        if(size < 0)
            return Integer.MIN_VALUE;
        return heap[0];
    }

    void buildHeap(int[] arr) {

        // get the parent of the last element
        for (int i = parent(size); i >= 0; i--) {
            heapify(i);
        }
    }

    void insert(int item) {
        if (size + 1 >= capacity) {
            throw new RuntimeException("Heap Capacity Reached");
        }
        size++;
        heap[size] = item;

        int i = size;
        while (i >= 0 && heap[parent(i)] < heap[i]) {

            int t = heap[parent(i)];
            heap[parent(i)] = heap[i];
            heap[i] = t;
            i = parent(i);
        }
    }


    void heapify(int i) {

        if (i >= capacity) {
            return;
        }
//        if (i >= size) {
//            return;
//        }

        int l = left(i);
        int r = right(i);
        int max = i;
        if (l <= size && heap[l] > heap[max]) {
            max = l;
        }
        if (r <= size && heap[r] > heap[max]) {
            max = r;
        }

        if (max != i) {
            // swap i with max element. Max heap parent is
            int t = heap[max];
            heap[max] = heap[i];
            heap[i] = t;
            heapify(max);
        }

    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }


}

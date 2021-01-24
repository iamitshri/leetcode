package com.practice;

import java.util.Iterator;

public class PriorityQueueDS {

	/**
	 * 
	 * Min or Max Heap
	 * 
	 * Stored in Array Datastructure
	 * 
	 * Heap Sort
	 * 
	 * Heapify
	 * 
	 * @return
	 * 
	 * 
	 */
	int[] arr;

	int[] createHeap(int[] arr) {
		this.arr = arr;
		System.out.println();
		for (int i = (arr.length / 2) - 1; i >= 0; i--) {
			System.out.print(i + " ");
			heapify(i);
		}
		return arr;
	}

	void heapify(int i) {
		int leftIndex = leftChildIndex(i);
		int rightIndex = rightChildIndex(i);
		int pos = i;
		if (leftIndex < arr.length && arr[leftIndex] < arr[i]) {
			pos = leftIndex;
		}
		if (rightIndex < arr.length && arr[rightIndex] < arr[i]) {
			pos = rightIndex;
		}
		if (i != pos) {
			swap(arr, i, pos);
			heapify(pos);
		}
	}

	private int rightChildIndex(int i) {
		return 2 * i + 2;
	}

	private int leftChildIndex(int i) {
		return 2 * i + 1;
	}

	private void swap(int[] arr, int i, int pos) {
		int temp = arr[i];
		arr[i] = arr[pos];
		arr[pos] = temp;

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2432, 124, 32, 34, 15, 1 };
		new PriorityQueueDS().createHeap(arr);
		System.out.println();
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}

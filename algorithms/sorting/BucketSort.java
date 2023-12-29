package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

	public static void sort(int[] arr, int numberOfBuckets) {
		if (arr.length <= 1) return;

		List<Integer>[] buckets = new List[numberOfBuckets];

		for (int i = 0; i < numberOfBuckets; i++) {
			buckets[i] = new ArrayList<>();
		}

		for (int item : arr) {
			int bucketIndex = item / numberOfBuckets;
			buckets[bucketIndex].add(item);
		}

		int index = 0;
		for (int i = 0; i < numberOfBuckets; i++) {
			Collections.sort(buckets[i]);
			for (int item : buckets[i]) {
				arr[index++] = item;
			}
		}
	}

	public static void printArray(int[] arr) {
		for (int item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {22, 45, 12, 8, 10, 6, 72, 81, 33, 18, 50, 14};
		int numberOfBuckets = 5; // For example

		System.out.println("Original Array:");
		printArray(arr);

		sort(arr, numberOfBuckets);

		System.out.println("Sorted Array:");
		printArray(arr);
	}
}

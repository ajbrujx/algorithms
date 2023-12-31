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
}

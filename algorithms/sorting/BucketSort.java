import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

	// Function to perform bucket sort
	public static void sort(int[] arr, int numberOfBuckets) {
		if (arr.length <= 1) return;

		// Create bucket array
		List<Integer>[] buckets = new List[numberOfBuckets];

		// Initialize empty buckets
		for (int i = 0; i < numberOfBuckets; i++) {
			buckets[i] = new ArrayList<>();
		}

		// Distribute input array values into buckets
		for (int item : arr) {
			int bucketIndex = item / numberOfBuckets;
			buckets[bucketIndex].add(item);
		}

		// Sort individual buckets and concatenate all buckets into the original array
		int index = 0;
		for (int i = 0; i < numberOfBuckets; i++) {
			Collections.sort(buckets[i]);
			for (int item : buckets[i]) {
				arr[index++] = item;
			}
		}
	}
}

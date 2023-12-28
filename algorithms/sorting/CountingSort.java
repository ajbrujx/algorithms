public class CountingSort {

	void sort(int[] arr) {
		int n = arr.length;

		// The output character array that will have sorted arr
		int[] output = new int[n];

		// Create a count array to store the count of individual
		// characters and initialize count array as 0
		int max = getMax(arr);
		int[] count = new int[max + 1];
		for (int i = 0; i <= max; ++i) {
			count[i] = 0;
		}

		// Store count of each character
		for (int i = 0; i < n; ++i) {
			++count[arr[i]];
		}

		// Change count[i] so that count[i] now contains actual
		// position of this character in output array
		for (int i = 1; i <= max; ++i) {
			count[i] += count[i - 1];
		}

		// Build the output array
		for (int i = n - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			--count[arr[i]];
		}

		// Copy the output array to arr, so that arr now
		// contains sorted characters
		for (int i = 0; i < n; ++i) {
			arr[i] = output[i];
		}
	}

	// Function to get the maximum value in the array
	int getMax(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	// A utility function to print an array
	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// Driver method
	public static void main(String[] args) {
		CountingSort sort = new CountingSort();
		int[] arr = {4, 2, 2, 8, 3, 3, 1};
		System.out.println("Original Array:");
		printArray(arr);

		sort.sort(arr);
		System.out.println("Sorted Array:");
		printArray(arr);
	}
}

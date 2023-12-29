package sorting;

public class CountingSort {

	void sort(int[] arr) {
		int n = arr.length;

		int[] output = new int[n];

		int max = getMax(arr);
		int[] count = new int[max + 1];
		for (int i = 0; i <= max; ++i) {
			count[i] = 0;
		}

		for (int i = 0; i < n; ++i) {
			++count[arr[i]];
		}

		for (int i = 1; i <= max; ++i) {
			count[i] += count[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			--count[arr[i]];
		}

		for (int i = 0; i < n; ++i) {
			arr[i] = output[i];
		}
	}

	int getMax(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

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

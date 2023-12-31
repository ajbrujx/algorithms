package sorting;

public class CombSort {

	public static int getNextGap(int gap) {
		// Shrink gap by a factor of 1.3
		gap = (gap * 10) / 13;
		if (gap < 1) {
			return 1;
		}
		return gap;
	}
	public static void sort(int arr[]) {
		int n = arr.length;

		int gap = n;
		boolean swapped = true;
		while (gap != 1 || swapped) {
			// Find the next gap
			gap = getNextGap(gap);

			// Reset swapped
			swapped = false;

			for (int i = 0; i < n - gap; i++) {
				if (arr[i] > arr[i + gap]) {
					// Swap arr[i] and arr[i+gap]
					int temp = arr[i];
					arr[i] = arr[i + gap];
					arr[i + gap] = temp;

					swapped = true;
				}
			}
		}
	}
}

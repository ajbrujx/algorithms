package sorting;

public class SelectionSort {
          public static void sort(int[] arr) {
                    int n = arr.length;
                    for (int i = 0; i < n - 1; i++) {
                              int minIdx = i;
                              for (int j = i + 1; j < n; j++) {
                                        if (arr[j] < arr[minIdx]) {
                                                  minIdx = j;
                                        }
                              }
                              int temp = arr[minIdx];
                              arr[minIdx] = arr[i];
                              arr[i] = temp;
                    }
          }

          public static void printArray(int[] arr) {
                    for (int element : arr) {
                              System.out.print(element + " ");
                    }
                    System.out.println();
          }

          public static void main(String[] args) {
                    int[] arr = {64, 25, 12, 22, 11};
                    System.out.println("Original Array:");
                    printArray(arr);

                    sort(arr);
                    System.out.println("Sorted Array:");
                    printArray(arr);
          }
}
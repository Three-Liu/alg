package sort;


import java.util.Arrays;
import java.util.Random;

class QuickSort {
    public static void sort(int[] arr) {
        quicksort2(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int left, int right) {
        if (left > right) return;
        int i = left, j = right, pivot = arr[left];
        while (i < j) {
            while (i < j && pivot <= arr[j]) j--;
            arr[i] = arr[j];
            while (i < j && arr[i] <= pivot) i++;
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        quicksort(arr, left, i - 1);
        quicksort(arr, i + 1, right);
    }

    private static void quicksort2(int[] arr, int left, int right) {
        if (left > right) return;
        int p = arr[left], i = left;
        for (int k = left + 1; k <= right; k++) {
            if (p > arr[k]) {
                i++;
                swap(arr, i, k);
            }
        }
        swap(arr, i, left);
        quicksort2(arr, left, i - 1);
        quicksort2(arr, i + 1, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

class MergeSort {
    public static void sort(int[] arr) {
        mergesort(arr, 0, arr.length - 1);
    }

    private static void mergesort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergesort(arr, left, mid);
        mergesort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tArr = new int[right - left + 1];
        int z = 0, i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tArr[z++] = arr[i];
                i++;
            } else {
                tArr[z++] = arr[j];
                j++;
            }
        }
        while (i <= mid) {
            tArr[z++] = arr[i++];
        }

        while (j <= right) {
            tArr[z++] = arr[j++];
        }
        for (i = 0; i < tArr.length; i++) {
            arr[left + i] = tArr[i];
        }
    }
}

class HeapSort {
    public static void sort(int[] arr) {
        heapsort(arr);
    }

    private static void heapsort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i);
        }
    }

    private static void heapAdjust(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                swap(arr, i, k);
                i = k;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arrt = new Random().ints(10, 0, 10).toArray();
        int[] arr = Arrays.copyOf(arrt, arrt.length);
        printArray(arr);
        QuickSort.sort(arr);
        printArray(arr);
        arr = Arrays.copyOf(arrt, arrt.length);
        MergeSort.sort(arr);
        printArray(arr);
        arr = Arrays.copyOf(arrt, arrt.length);
        HeapSort.sort(arr);
        printArray(arr);

    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

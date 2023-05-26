public class Quicksort {

    public static void quicksort(int[] arr, int lower, int upper) {
        if (upper > lower) {
            int t = partition(arr, lower, upper);
            quicksort(arr, lower, t - 1);
            quicksort(arr, t + 1, upper);
        }
    }

    private static int partition(int[] arr, int lower, int upper) {
        int pivot;
        int k;

        k = lower;

        pivot = arr[upper];

        for (int j = lower; j < upper; j++) {
            if (arr[j] < pivot) {
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                k++;
            }
        }

        int temp = arr[k];
        arr[k] = arr[upper];
        arr[upper] = temp;

        return k;
    }


}

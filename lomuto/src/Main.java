
import java.util.Random;

public class Main {
    public static void main(String[] args) {


        // tworzenie tablicy z randomych 50 liczb calkowitych
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {

            Random randomNumber = new Random();
            int number = randomNumber.nextInt(99);

            arr[i] = number;
        }

        // output i uruchomienie programu
        System.out.print("Przed Sortowaniem : ");
        for (int k : arr) {
            System.out.print(k + " ");
        }
        System.out.println();

        quicksort(arr, 0, arr.length - 1);

        System.out.print("Po Sortowaniu  : ");
        for (int k : arr) {
            System.out.print(k + " ");
        }
    }

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

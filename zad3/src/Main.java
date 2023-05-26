public class Main {
    public static void main(String[] args) {

        long time;
        long time1;
        long time2;

        int [] unsortedArray1 = new int[20000];
        for (int i = 0; i < unsortedArray1.length ; i ++){
            unsortedArray1[i] = unsortedArray1.length - (i + 1);
        }


        // COUNTINGSORT
        long start = System.currentTimeMillis();
        Countingsort.insertion(unsortedArray1);
        long stop = System.currentTimeMillis();
        time = stop - start;




       // HEAP SORT
        int [] unsortedArray2 = new int[20000];
        for (int i = 0; i < unsortedArray2.length ; i ++){
            unsortedArray2[i] = unsortedArray2.length - (i + 1);
        }


       long start2 = System.currentTimeMillis();
        HeapSort heap = new HeapSort();
        heap.sort(unsortedArray2);
        long stop2 = System.currentTimeMillis();
        time2 = stop2 - start2;



//            for (int i = 0; i < unsortedArray2.length; ++i)
//                System.out.print(unsortedArray2[i] + " ");
//            System.out.println();

        int [] unsortedArray3 = new int[20000];
        for (int i = 0; i < unsortedArray3.length ; i ++){
            unsortedArray3[i] = unsortedArray3.length - (i + 1);
        }

        // QUICK SORT
        long start3 = System.currentTimeMillis();
        Quicksort.quicksort(unsortedArray3,0, unsortedArray3.length -1);
        long stop3 = System.currentTimeMillis();
        time1 = stop3 - start3;



        // PODSUMOWANIE:

        System.out.println("Sortowanie przez quicksort dla tablicy n = " + unsortedArray3.length + ". Czas pracy programu =  " + time1 + " ms" ) ;

        System.out.println("Sortowanie przez wstawianie dla tablicy n = " + unsortedArray1.length + ". Czas pracy programu =  " + time + " ms" ) ;

        System.out.println("Sortowanie przez kopcowanie dla tablicy  n = " + unsortedArray2.length + ". Czas pracy programu =  " + time2 + " ms" ) ;

    }
}
public class Sortowanie {


    public static void insertion(int array[]) {


        double time;
        int n = array.length;
        int fn = array.length * array.length; // przy nieposrtowanych fn = n*n
        System.out.println("Fn = " + fn);

        double start = System.currentTimeMillis();
        for (int j = 1; j < n; j++) {  // zaczynam od 2 giego elementu czyli od 1 bo pierwszy element to 0 w tablicy
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }

        double stop = System.currentTimeMillis();
        time = stop - start;


        System.out.println("czas obliczeń = " + time + " ms." );

        if (time == 0){
            System.out.println("Czas sortowania dla n = " +array.length+ " . Jest równy " +time+ " ms.");
            System.out.println("Fn/Tn = 0" );
        }else{
            System.out.println("Czas sortowania dla n = " +array.length+ " . Jest równy " +time+ " ms.");
            System.out.println("Fn/Tn = " +(fn / time)+ " ." );
        }

    }

}

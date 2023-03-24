public class Main {
    public static void main(String[] args) {

// POSORTOWANE
// tworze i wypełniam tablice odpowiednia iloscią elementow
        int[] arraySorted1 = new int[2000];
        for (int i = 0; i < arraySorted1.length; i++) {
            arraySorted1[i] = i;
        }

        int[] arraySorted2 = new int[4000];
        for (int i = 0; i < arraySorted2.length; i++) {
            arraySorted2[i] = i;
        }

        int[] arraySorted3 = new int[8000];
        for (int i = 0; i < arraySorted3.length; i++) {
            arraySorted3[i] = i;
        }

        int[] arraySorted4 = new int[16000];
        for (int i = 0; i < arraySorted4.length; i++) {
            arraySorted4[i] = i;
        }

        int[] arraySorted5 = new int[32000];
        for (int i = 0; i < arraySorted5.length; i++) {
            arraySorted5[i] = i;
        }

// wywołanie odpowiedniej metody sortujacej czyli sorted dla posortowanych tablic.
        Posortowane.sorted(arraySorted1);
        System.out.println();
        Posortowane.sorted(arraySorted2);
        System.out.println();
        Posortowane.sorted(arraySorted3);
        System.out.println();
        Posortowane.sorted(arraySorted4);
        System.out.println();
        Posortowane.sorted(arraySorted5);
        System.out.println();

        // wydaje mi sie ze nalezy to zaokragic do 0 wtedy czasy sie zgadzaja gdy wychodzi 1 ms to mysle ze jest błąd pomiaru czasu.






// NIEPOSORTOWANE
// tworze i wypełniam tablice odpowiednia iloscią elementow
        System.out.println("NIEPOSORTOWANE TABLICE, NAJGORSZY PRZYPADEK");

        int[] arrayUnsorted1 = new int[2000];
        for (int i = 0; i < arrayUnsorted1.length; i++) {
            arrayUnsorted1[i] = arrayUnsorted1.length - (i + 1);

        }

        int[] arrayUnsorted2 = new int[4000];
        for (int i = 0; i < arrayUnsorted2.length; i++) {
            arrayUnsorted2[i] = arrayUnsorted2.length - (i + 1);

        }

        int[] arrayUnsorted3 = new int[8000];
        for (int i = 0; i < arrayUnsorted3.length; i++) {
            arrayUnsorted3[i] = arrayUnsorted3.length - (i + 1);

        }

        int[] arrayUnsorted4 = new int[16000];
        for (int i = 0; i < arrayUnsorted4.length; i++) {
            arrayUnsorted4[i] = arrayUnsorted4.length - (i + 1);

        }

        int[] arrayUnsorted5 = new int[32000];
        for (int i = 0; i < arrayUnsorted5.length; i++) {
            arrayUnsorted5[i] = arrayUnsorted5.length - (i + 1);

        }
        
        // wywołanie odpowiednej metody czyli insertion dla nieposortowanych tablic
        Sortowanie.insertion(arrayUnsorted1);
        System.out.println();
        Sortowanie.insertion(arrayUnsorted2);
        System.out.println();
        Sortowanie.insertion(arrayUnsorted3);
        System.out.println();
        Sortowanie.insertion(arrayUnsorted4);
        System.out.println();
        Sortowanie.insertion(arrayUnsorted5);

    }
}

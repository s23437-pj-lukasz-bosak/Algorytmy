public class Main {

    public static int[] zlicz(String wiadomosc) {
        int[] tabZliczajaca;
        char min = Character.MAX_VALUE;
        char max = Character.MIN_VALUE;
        for (int i = 0; i < wiadomosc.length(); i++) {
            if (min > wiadomosc.charAt(i))
                min = wiadomosc.charAt(i);
            if (max < wiadomosc.charAt(i))
                max = wiadomosc.charAt(i);
        }
        tabZliczajaca = new int[max - min + 1];
        for (int i = 0; i < wiadomosc.length(); i++) {
            tabZliczajaca[wiadomosc.charAt(i) - min]++;
        }
        return tabZliczajaca;
    }

    public static Wierzcholek sortowanie(Wierzcholek[] listaWierzcholkow, int dlugoscListy) {
        int j = dlugoscListy;
        do {
            for (int i = 0; i < j - 1; i++) {
                if (listaWierzcholkow[i].czestosc < listaWierzcholkow[i + 1].czestosc) {
                    Wierzcholek temp = listaWierzcholkow[i];
                    listaWierzcholkow[i] = listaWierzcholkow[i + 1];
                    listaWierzcholkow[i + 1] = temp;
                }
            }
            j--;
        } while (j > 1);

        int k = dlugoscListy;
        while (k > 1) {
            // wierzchołki o najmniejszej częstości znajdują się na końcu listy
            Wierzcholek pierwszyDoUsuniecia = listaWierzcholkow[k - 1];
            Wierzcholek drugiDoUsuniecia = listaWierzcholkow[k - 2];
            Wierzcholek nowyWierzcholek = new Wierzcholek('\0',
                    pierwszyDoUsuniecia.czestosc + drugiDoUsuniecia.czestosc, pierwszyDoUsuniecia, drugiDoUsuniecia);

            listaWierzcholkow[k - 2] = nowyWierzcholek;
            listaWierzcholkow[k - 1] = null;
            k--;
            // umieść nowy wierzchołek w odpowiednim miejscu
            for (int i = k - 1; i > 0; i--) {
                if (listaWierzcholkow[i - 1] == null
                        || listaWierzcholkow[i].czestosc > listaWierzcholkow[i - 1].czestosc) {
                    Wierzcholek temp = listaWierzcholkow[i];
                    listaWierzcholkow[i] = listaWierzcholkow[i - 1];
                    listaWierzcholkow[i - 1] = temp;
                } else
                    break;
            }
        }
        return listaWierzcholkow[0];
    }

    public static void wypiszKod(Wierzcholek doPrzeszukania, String dotychczasowyKod) {
        if (doPrzeszukania.lewy == null && doPrzeszukania.prawy == null) {
            System.out.println("Znak: " + doPrzeszukania.znak +
                    " czestosc: " + doPrzeszukania.czestosc +
                    " slowo kodowe: " + dotychczasowyKod);
        }
        if (doPrzeszukania.lewy != null) {
            wypiszKod(doPrzeszukania.lewy, dotychczasowyKod + "0");
        }
        if (doPrzeszukania.prawy != null) {
            wypiszKod(doPrzeszukania.prawy, dotychczasowyKod + "1");
        }
    }

    static int obecnyElementTablicySlow = 0;

    private static Slowo[] zapiszKod(Wierzcholek doPrzeszukania, String dotychczasowyKod, Slowo[] listaSlow) {
        if (doPrzeszukania.lewy == null && doPrzeszukania.prawy == null) {
            listaSlow[obecnyElementTablicySlow] = new Slowo(doPrzeszukania.znak, doPrzeszukania.czestosc,
                    dotychczasowyKod);
            obecnyElementTablicySlow++;
        }
        if (doPrzeszukania.lewy != null) {
            zapiszKod(doPrzeszukania.lewy, dotychczasowyKod + "0", listaSlow);
        }
        if (doPrzeszukania.prawy != null) {
            zapiszKod(doPrzeszukania.prawy, dotychczasowyKod + "1", listaSlow);
        }
        return listaSlow;
    }

    static String zakodujZnak(char znak, Slowo[] ksiazkaSlow) {
        for (int i = 0; i < ksiazkaSlow.length; i++) {
            if (ksiazkaSlow[i].znak == znak)
                return ksiazkaSlow[i].slowoKodowe;
        }
        return "";
    }

    static String zakodujWiadomosc(String wiadomosc, Slowo[] ksiazkaSlow) {
        String zakodowanaWiadomosc = "";
        for (int i = 0; i < wiadomosc.length(); i++) {
            zakodowanaWiadomosc += zakodujZnak(wiadomosc.charAt(i), ksiazkaSlow);
        }
        return zakodowanaWiadomosc;
    }

    public static void main(String[] args) {
        String wiadomosc = "AABBCCDDDDDDDFFFEEER";
        int[] tabZliczajaca = zlicz(wiadomosc);
        char minZnak = Character.MAX_VALUE;
        for (int i = 0; i < wiadomosc.length(); i++) {
            if (minZnak > wiadomosc.charAt(i))
                minZnak = wiadomosc.charAt(i);
        }
        Wierzcholek[] listaWierzcholkow = new Wierzcholek[tabZliczajaca.length];
        int dlugoscListy = 0;
        for (int i = 0; i < listaWierzcholkow.length; i++) {
            if (tabZliczajaca[i] != 0) {
                listaWierzcholkow[dlugoscListy] = new Wierzcholek((char) (i + minZnak), tabZliczajaca[i], null, null);
                dlugoscListy++;
            }
        }
        Wierzcholek korzen = sortowanie(listaWierzcholkow, dlugoscListy);
                if (dlugoscListy == 1)
            korzen = new Wierzcholek('\0', 1, null, listaWierzcholkow[0]);
        Slowo[] ksiazkaSlow = new Slowo[dlugoscListy];
        wypiszKod(korzen, "");
        ksiazkaSlow = zapiszKod(korzen, "", ksiazkaSlow);
        String wiadomoscZakodowana = zakodujWiadomosc(wiadomosc, ksiazkaSlow);

        System.out.println(wiadomosc);

        System.out.println(wiadomoscZakodowana);
    }
    }

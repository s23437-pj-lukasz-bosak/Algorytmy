public class Wierzcholek {
    char znak;
    int czestosc;
    Wierzcholek lewy = null;
    Wierzcholek prawy = null;
    Wierzcholek(char znak, int czestosc, Wierzcholek lewy, Wierzcholek prawy) {
        this.znak = znak;
        this.czestosc = czestosc;
        this.lewy = lewy;
        this.prawy = prawy;
    }
}

public class Playlist {
    private String titolo;
    private Brano Brani[];

    public Playlist(String titolo, Brano Brani[]) {
        this.titolo = titolo;
        this.Brani = Brani;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Brano[] getBrani() {
        return Brani;
    }

    public void setBrani(Brano[] brani) {
        Brani = brani;
    }
    int n = 0;

    public String out(){
        return Brani[n].titolo + " " +  (n+1);
    }
    public String next(){
        if (n == Brani.length - 1){
            n = 0;
        }else {
            n++;
        }
        return out();
    }
    public String previus(){
        if (n == 0){
            n = Brani.length - 1;
        }else{
        n--;
        }
        return out();
    }
}

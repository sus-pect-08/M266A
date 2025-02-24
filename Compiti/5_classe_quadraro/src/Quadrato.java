public class Quadrato {
    private int l;

    public Quadrato(int l) {
        this.l = l;
    }
    public Quadrato(){
        l = 5;
    }

    public int getL() {
        return l;
    }
    public void setL(int l) {
        this.l = l;
    }

    public int gatArea(){
        return l*l;
    }
    public int gatPerimeter(){
        return 4*l;
    }
    public void draw(){
        int x = 0;
        while(x < l) {
            if (x == 0 || x == l-1) {
                int i = 0;
                while (i < l) {
                    if (i == l - 1) {
                        System.out.println("*");
                        i++;
                    } else {
                        System.out.print("*");
                        i++;
                    }
                }
            }
            else{
                int i = 0;
                while (i < l) {
                    if (i == 0) {
                        System.out.print("*");
                        i++;
                    } else if(i == l - 1) {
                        System.out.println("*");
                        i++;
                    }
                    else{
                        System.out.print(" ");
                        i++;
                    }
                }
            }
            x++;
        }
    }
    public String getDimension(){
        return "Quadrato " + l + " x " + l;
    }
    public String toString(){
    return getDimension() + " Area: " + gatArea() + " Perimeter: " + gatPerimeter();
    }
}

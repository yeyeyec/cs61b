public class TriangleDrawer{
    public static void drawTriangle(int N){
        int x = 0;
        String star = "*";
        while (x<N){
            System.out.println(star);
            x = x+1;
            star = star + "*";
        }
    }
    public static void main(String[] args){
        drawTriangle(10);
    }
}
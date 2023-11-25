import java.util.Scanner;

public class desafio2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int T = teclado.nextInt();
        int anos= 0;


        for (int i = 0; i < T; i++) {
        int pa = teclado.nextInt();
        int pb =  teclado.nextInt();
        double g1 = teclado.nextDouble();
        double g2 = teclado.nextDouble();
        
            anos = calcularCrescimento(pa, pb, g1,g2);
        }

        if (anos > 100) {
            System.out.println("mais de 1 seculo");
        }
        else{
            System.out.println(anos + " anos.");
        }
        teclado.close();
    }
    
    public static int calcularCrescimento(int PA, int PB, double G1, double G2 ){
        int anos = 0;
        

        while (PA <= PB) {
            PA = (int) ( PA * (1 + G1 / 100));
            PB= (int) ( PB * (1 + G2 / 100));
            anos++;

            if (anos > 100) {
                break;
            }
        }
        return anos;
    }
}

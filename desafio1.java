import java.util.Scanner;

public class desafio1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int hi = teclado.nextInt();
        int mi = teclado.nextInt();
        int hf = teclado.nextInt();
        int mf = teclado.nextInt();

       
        int hTotal = hf - hi;
        int mTotal = mf - mi;
        if (hi == hf && mi ==mf) {
            System.out.println("O JOGO DUROU 24 HORA(S) E "+ mTotal +" MINUTO(S)");
        }else{
            int TotalemMinutos = hTotal * 60 + mTotal;

            if (TotalemMinutos < 0) {
                TotalemMinutos += 24 *60;
            }

                hTotal = TotalemMinutos / 60;
                mTotal = TotalemMinutos % 60;

                System.out.println("O JOGO DUROU "+ hTotal +" HORA(S) E "+ mTotal +" MINUTO(S)");
            }
        teclado.close();
    }
}

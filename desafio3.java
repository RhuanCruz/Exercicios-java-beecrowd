import java.util.Scanner;

public class desafio3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (teclado.hasNext()) {
            float anguloHora = teclado.nextFloat();
            float anguloMinuto = teclado.nextFloat();

            String resultado = calcular(anguloHora, anguloMinuto);

            // Saída
            System.out.println(resultado);
        }

        teclado.close();
    }

    private static String calcular(float anguloHora, float anguloMinuto) {
        for (int h = 0; h < 360; h++) {
            for (int m = 0; m < 360; m++) {
                float anguloAtualHora = (h % 12) * 30.0f;
                float anguloAtualMinuto = m * 6.0f;

                if (anguloAtualHora == anguloHora && anguloAtualMinuto == anguloMinuto) {
                    return String.format("%02d:%02d", h % 12, m);
                }
            }
        }

        return "erro";
    }
}
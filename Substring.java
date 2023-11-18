import java.util.Scanner;

public class Substring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();

            int resultado = encontrarMaiorSubstringComum(str1, str2);
            System.out.println(resultado);
        }

        scanner.close();
    }

    private static int encontrarMaiorSubstringComum(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Matriz para armazenar os resultados dos subproblemas
        int[][] matriz = new int[m + 1][n + 1];

        // Preencher a matriz usando programação dinâmica
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    matriz[i][j] = matriz[i - 1][j - 1] + 1;
                } else {
                    matriz[i][j] = Math.max(matriz[i - 1][j], matriz[i][j - 1]);
                }
            }
        }

        return matriz[m][n];
    }
}

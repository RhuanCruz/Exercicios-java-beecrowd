import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CinemaSurpresa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Passo 1: Obter valores de entrada
        int N = scanner.nextInt();
        int H = scanner.nextInt();
        int L = scanner.nextInt();

        Set<Integer> horrorList = new HashSet<>();
        for (int i = 0; i < H; i++) {
            horrorList.add(scanner.nextInt());
        }

        Map<Integer, List<Integer>> similarities = new HashMap<>();
        for (int i = 0; i < L; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            similarities.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            similarities.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        // Passo 2 e 3: Calcular o índice de horror para cada filme
        Map<Integer, Integer> horrorIndex = calcularIndiceHorror(N, horrorList, similarities);

        // Passo 4 e 5: Encontrar e imprimir o melhor filme
        int melhorFilme = encontrarMelhorFilme(N, horrorIndex);
        System.out.println(melhorFilme);
    }

    // Função para calcular o índice de horror para cada filme
    private static Map<Integer, Integer> calcularIndiceHorror(int N, Set<Integer> horrorList, Map<Integer, List<Integer>> similarities) {
        Map<Integer, Integer> horrorIndex = new HashMap<>();

        // Inicializar o índice de horror para cada filme
        for (int i = 0; i < N; i++) {
            horrorIndex.put(i, 0);
        }

        // Definir o índice de horror para 0 para filmes na lista de horror
        for (int movieId : horrorList) {
            horrorIndex.put(movieId, 0);
        }

        // Calcular o índice de horror para outros filmes
        for (int i = 0; i < N; i++) {
            if (!horrorList.contains(i)) {
                int maxSimilarHIndex = similarities.getOrDefault(i, new ArrayList<>())
                        .stream()
                        .mapToInt(j -> horrorIndex.getOrDefault(j, 0))
                        .max()
                        .orElse(0);

                horrorIndex.put(i, maxSimilarHIndex + 1);
            }
        }

        return horrorIndex;
    }

    // Função para encontrar o melhor filme
    private static int encontrarMelhorFilme(int N, Map<Integer, Integer> horrorIndex) {
        // Encontrar o filme com o maior índice de horror
        int melhorFilme = -1;
        int maiorIndiceHorror = -1;

        for (int i = 0; i < N; i++) {
            if (horrorIndex.get(i) > maiorIndiceHorror || (horrorIndex.get(i) == maiorIndiceHorror && i < melhorFilme)) {
                maiorIndiceHorror = horrorIndex.get(i);
                melhorFilme = i;
            }
        }

        return melhorFilme;
    }
}

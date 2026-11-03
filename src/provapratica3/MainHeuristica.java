
package provapratica3;


public class MainHeuristica {
    public static void main(String[] args) {
        System.out.println("--- Resultados da Heuristica (Vizinho Mais Proximo) ---");

        // 1. Instância si535 (535 cidades, diagonal superior)
        int[][] matriz535 = LeitorTSP.lerMatriz("si535.tsp", 535, true);
        long distancia535 = Heuristica.calcularRota(535, matriz535);
        System.out.println("Distancia encontrada para si535.tsp: " + distancia535);

        // 2. Instância pa561 (561 cidades, diagonal inferior)
        int[][] matriz561 = LeitorTSP.lerMatriz("pa561.tsp", 561, false);
        long distancia561 = Heuristica.calcularRota(561, matriz561);
        System.out.println("Distancia encontrada para pa561.tsp: " + distancia561);

        // 3. Instância si1032 (1032 cidades, diagonal superior)
        int[][] matriz1032 = LeitorTSP.lerMatriz("si1032.tsp", 1032, true);
        long distancia1032 = Heuristica.calcularRota(1032, matriz1032);
        System.out.println("Distancia encontrada para si1032.tsp: " + distancia1032);
    }
}

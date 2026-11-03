package provapratica3;

public class MainAproximado {

    private static void executar(String arquivo, int n, boolean diagonalSuperior) {

        int[][] matriz = LeitorTSP.lerMatriz(arquivo, n, diagonalSuperior);

        long ini = System.nanoTime();
        AproximadoAGM.Resultado r = AproximadoAGM.calcularRota(n, matriz);
        long ms = (System.nanoTime() - ini) / 1_000_000;
        boolean[] vista = new boolean[n];
        boolean valida = r.rota.length == n;

        for (int c : r.rota) {
            if (vista[c]) valida = false;
            vista[c] = true;
        }

        long recalculada = 0;

        for (int i = 0; i < n; i++) {
            recalculada += matriz[r.rota[i]][r.rota[(i + 1) % n]];
        }

        System.out.println(arquivo + ": distancia (AGM) = " + r.distancia
                + " | rota valida = " + valida
                + " | recalculada confere = " + (recalculada == r.distancia)
                + " | tempo = " + ms + " ms");
    }

    public static void main(String[] args) {
        System.out.println("--- Algoritmo Aproximado (Arvore Geradora Minima) ---");
        executar("src/provapratica3/arquivosTeste/si535.tsp.txt", 535, true);
        executar("src/provapratica3/arquivosTeste/pa561.tsp.txt", 561, false);
        executar("src/provapratica3/arquivosTeste/si1032.tsp.txt", 1032, true);
    }
}

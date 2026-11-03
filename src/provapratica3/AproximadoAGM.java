package provapratica3;

public class AproximadoAGM {

    public static class Resultado {

        public final int[] rota;
        public final long distancia;

        Resultado(int[] rota, long distancia) {
            this.rota = rota;
            this.distancia = distancia;
        }
    }

    public static Resultado calcularRota(int n, int[][] d) {

        int[] pai = new int[n];
        int[] custo = new int[n];
        boolean[] naArvore = new boolean[n];

        java.util.Arrays.fill(custo, Integer.MAX_VALUE);
        custo[0] = 0;
        pai[0] = -1;

        for (int it = 0; it < n; it++) {
            int u = -1;

            for (int i = 0; i < n; i++) {
                if (!naArvore[i] && (u == -1 || custo[i] < custo[u])) {
                    u = i;
                }
            }

            naArvore[u] = true;
            
            for (int v = 0; v < n; v++) {
                if (!naArvore[v] && d[u][v] < custo[v]) {
                    custo[v] = d[u][v];
                    pai[v] = u;
                }
            }
        }

        int[] primeiroFilho = new int[n];
        int[] proximoIrmao = new int[n];

        java.util.Arrays.fill(primeiroFilho, -1);
        java.util.Arrays.fill(proximoIrmao, -1);

        for (int v = n - 1; v >= 1; v--) {
            proximoIrmao[v] = primeiroFilho[pai[v]];
            primeiroFilho[pai[v]] = v;
        }

        int[] rota = new int[n];
        int[] pilha = new int[n];
        int topo = 0, k = 0;
        pilha[topo++] = 0;

        while (topo > 0) {

            int u = pilha[--topo];
            rota[k++] = u;
            int f = primeiroFilho[u];
            int inicio = topo;

            while (f != -1) {
                pilha[topo++] = f;
                f = proximoIrmao[f];
            }

            for (int a = inicio, b = topo - 1; a < b; a++, b--) {
                int t = pilha[a]; pilha[a] = pilha[b]; pilha[b] = t;
            }
        }

        long total = 0;

        for (int i = 0; i < n - 1; i++) {
            total += d[rota[i]][rota[i + 1]];
        }

        total += d[rota[n - 1]][rota[0]];

        return new Resultado(rota, total);
    }
}

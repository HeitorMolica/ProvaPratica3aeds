
package provapratica3;

/**
 *
 * @author eniov
 */
public class Heuristica {
    public static long calcularRota(int numeroCidades, int[][] distancias) {
        boolean[] visitadas = new boolean[numeroCidades];
        long distanciaTotal = 0; 
        
        int cidadeAtual = 0; // Começamos sempre na cidade 0
        visitadas[cidadeAtual] = true;
        int cidadesVisitadas = 1;

        // Repete até visitar todas as cidades
        while (cidadesVisitadas < numeroCidades) {
            int cidadeMaisProxima = -1;
            int menorDistancia = Integer.MAX_VALUE;

            // Percorre a linha da matriz para achar a menor distância válida
            for (int i = 0; i < numeroCidades; i++) {
                // Se a cidade 'i' não foi visitada e a distância for menor que a atual conhecida
                if (!visitadas[i] && distancias[cidadeAtual][i] < menorDistancia) {
                    // Evita verificar a distância da cidade para ela mesma (que é 0)
                    if (cidadeAtual != i) {
                        menorDistancia = distancias[cidadeAtual][i];
                        cidadeMaisProxima = i;
                    }
                }
            }

            // Move o caixeiro para a cidade escolhida
            distanciaTotal += menorDistancia;
            cidadeAtual = cidadeMaisProxima;
            visitadas[cidadeAtual] = true;
            cidadesVisitadas++;
        }

        // Fim da viagem: soma a distância da última cidade de volta para a cidade inicial (0)
        distanciaTotal += distancias[cidadeAtual][0];

        return distanciaTotal;
    }
}

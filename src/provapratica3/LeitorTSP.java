/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provapratica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LeitorTSP {
    // Método que lê o arquivo e devolve a matriz de distâncias montada
    public static int[][] lerMatriz(String caminhoFicheiro, int dimensao, boolean diagonalSuperior) {
        int[][] matriz = new int[dimensao][dimensao];
        ArrayList<Integer> pesos = new ArrayList<>();

        try {
            File ficheiro = new File(caminhoFicheiro);
            Scanner scanner = new Scanner(ficheiro);
            boolean lendoPesos = false;

            // 1. LER O ARQUIVO E GUARDAR TODOS OS NÚMEROS NUMA LISTA
            while (scanner.hasNext()) {
                String palavra = scanner.next();

                // Fim do arquivo ou início de outra seção
                if (palavra.equals("EOF") || (lendoPesos && palavra.endsWith("_SECTION"))) {
                    break;
                }

                if (lendoPesos) {
                    pesos.add(Integer.parseInt(palavra));
                } else if (palavra.equals("EDGE_WEIGHT_SECTION")) {
                    lendoPesos = true; // Começa a gravar os números a partir daqui
                }
            }
            scanner.close();

            // 2. DISTRIBUIR OS NÚMEROS PELA MATRIZ (SIMÉTRICA)
            int k = 0;
            if (diagonalSuperior) {
                // Formato do si535.tsp e si1032.tsp
                for (int i = 0; i < dimensao; i++) {
                    for (int j = i; j < dimensao; j++) {
                        if (k < pesos.size()) {
                            matriz[i][j] = pesos.get(k);
                            matriz[j][i] = pesos.get(k); // Espelha a distância (A->B = B->A)
                            k++;
                        }
                    }
                }
            } else {
                // Formato do pa561.tsp (diagonal inferior)
                for (int i = 0; i < dimensao; i++) {
                    for (int j = 0; j <= i; j++) {
                        if (k < pesos.size()) {
                            matriz[i][j] = pesos.get(k);
                            matriz[j][i] = pesos.get(k); // Espelha a distância
                            k++;
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro: Ficheiro não encontrado - " + caminhoFicheiro);
        } catch (Exception e) {
            System.out.println("Erro ao ler os dados do ficheiro: " + e.getMessage());
        }

        return matriz;
    }
}

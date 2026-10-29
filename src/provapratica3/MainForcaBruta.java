/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provapratica3;

/**
 *
 * @author heito
 */
import java.util.Random;

public class MainForcaBruta {

    public static void main(String[] args) {
        int limiteMaximoCidades = 13; 
        int pesoMaximoAresta = 100; 
        System.out.println("Forca bruta");

        for (int n = 2; n <= limiteMaximoCidades; n++) {

            int[][] matrizDistancias = gerarMatrizAleatoria(n, pesoMaximoAresta);
            
            long tempoInicio = System.nanoTime();
            ForcaBruta fb = new ForcaBruta(n, matrizDistancias);
            long tempoFim = System.nanoTime();
            
            long tempoDecorridoNano = tempoFim - tempoInicio;
            double tempoMs = tempoDecorridoNano / 1_000_000.0;
            double tempoSegundos = tempoMs / 1_000.0;
            System.out.printf("%-10s | %-18s | %-15s | %-15s%n", "Nº Cidades", "Distância Mínima", "Tempo (ms)", "Tempo (s)");
            System.out.printf("%-10d | %-18d | %-15.3f | %-15.4f%n", n, fb.distancia_total, tempoMs, tempoSegundos);
        }
    }


    public static int[][] gerarMatrizAleatoria(int n, int pesoMaximo) {
        int[][] matriz = new int[n][n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            matriz[i][i] = 0;
            for (int j = i + 1; j < n; j++) {
                int pesoAleatorio = rand.nextInt(pesoMaximo) + 1;
                matriz[i][j] = pesoAleatorio;
                matriz[j][i] = pesoAleatorio;
            }
        }
        return matriz;
    }
}   


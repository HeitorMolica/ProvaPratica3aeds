/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provapratica3;

import java.util.ArrayList;

/**
 *
 * @author heito
 */

public class ForcaBruta {
    
    public int numero_cidades;
    public int[][] distancias;//matriz das distancias 
    public int distancia_atual;
    public int distancia_total;
    public ArrayList<Cidade> rota;
    public ArrayList<Cidade> melhor_rota;
    public ArrayList<Cidade> cidades;
    public int cidades_visitadas;
    public Cidade cidade_inicial;
    
    public ForcaBruta(int numero_cidades, int [][]distancias){
        this.distancias = distancias;
        this.distancia_atual = 0;
        this.cidades_visitadas = 0;
        this.numero_cidades = numero_cidades;
        this.distancia_total = 999999999;
        iniciarCidades();
        
    }
    
    
    public void iniciarCidades(){
        rota = new ArrayList<>();
        cidades = new ArrayList<>();
        melhor_rota = new ArrayList<>();
        for(int i = 0; i < numero_cidades; i++){
            cidades.add(new Cidade(i));
        }
        cidade_inicial = cidades.get(0);
        cidade_inicial.setFlag(true);
        rota.add(cidade_inicial);
        acharRota(cidade_inicial, distancia_atual, 1);
    }
    
    public void acharRota(Cidade cidade_atual,int distancia_atual, int cidades_visitadas){
        if(cidades_visitadas == numero_cidades){//se todas as cidades ja foram visitadas
            distancia_atual += calcularDistancia(cidade_inicial, cidade_atual);
            if(distancia_atual < distancia_total){
                distancia_total = distancia_atual;
                melhor_rota = new ArrayList<>(rota);
            }
            return;
        }
        for(int i = 0; i < numero_cidades; i++){
            Cidade temp = cidades.get(i);
            if(temp.getFlag() == false){
                temp.setFlag(true);
                rota.add(temp);
                acharRota(temp, distancia_atual + calcularDistancia(cidade_atual, temp), cidades_visitadas + 1);
                temp.setFlag(false);
                rota.remove(rota.size() - 1); //remove o ultimo elemento da rota
            }
        }  
    }
    
    public int calcularDistancia(Cidade cidade_inicial, Cidade cidade){
        int posicao_cidade1 = cidade_inicial.getIdentificador();
        int posicao_cidade2 = cidade.getIdentificador();
        return distancias[posicao_cidade1][posicao_cidade2];
    }
    
    public void imprimir(){
        System.out.println("Rota: ");
        for(int i = 0; i < numero_cidades; i++){
            System.out.print("Cidade " + melhor_rota.get(i).getIdentificador() + " -> ");
        }
        System.out.println("");
        System.out.println("Distancia menor rota = " + distancia_total);
    }
}

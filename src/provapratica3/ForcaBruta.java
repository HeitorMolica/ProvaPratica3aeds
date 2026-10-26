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
    public int cidades_visitadas;
    public int cidade_inicial;
    
    public ForcaBruta(int numero_cidades, int [][]distancias){
        this.distancias = distancias;
        this.distancia_atual = 0;
        this.cidades_visitadas = 0;
        this.numero_cidades = numero_cidades;
        this.cidade_inicial = 0;
        this.distancia_total = 999999999;
    }
    
    public void gerarCidades(){
        this.rota = new ArrayList<Cidade>();
        for(int i = 0; i < numero_cidades; i++){
            rota.add(new Cidade(i));
            //criar array list com todas as cidades
            //vao ser adicionadas em ordem para manter as distancias corretamente.  
        }
    }
    
    public void AcharRota(Cidade cidade_atual,int distancia_atual, int cidades_visitadas){
        if(cidades_visitadas == numero_cidades){//se todas as cidades ja foram visitadas
            distancia_atual += calcularDistanciaCidade_Inicial(cidade_atual);
            if(distancia_atual < distancia_total){
                distancia_total = distancia_atual;
            }
            return;
        }
        for(int i = 0; i < numero_cidades; i++){
            
        }  
    }
    
    public int calcularDistanciaCidade_Inicial(Cidade cidade){
        int posicao_cidade = cidade.getNome();
        return distancias[0][posicao_cidade];
    }
}

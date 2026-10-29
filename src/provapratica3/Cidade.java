/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provapratica3;

/**
 *
 * @author heito
 */
public class Cidade {
   
    private int identificador;
    private String nome;
    private int posicao_rota;
    private boolean flag;
    
    public Cidade(String nome, int identificador){
        this.nome = nome;
        this.identificador = identificador;
        this.posicao_rota = -1;
        this.flag = false;
    }
    
    public Cidade(int identificador){
        this.nome = "";
        this.identificador = identificador;
        this.posicao_rota = -1;
        this.flag = false;
    }
    
    public void setFlag(boolean flag){
       this.flag = flag;
    }
    
    public boolean getFlag(){
        return this.flag;
    }
    
    public int getIdentificador(){
        return this.identificador;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getPosicao(){
        return this.posicao_rota;
    }
    
    public void setPosicao(int posicao_rota){
        this.posicao_rota = posicao_rota;
    }
}

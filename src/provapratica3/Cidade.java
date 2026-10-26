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
   
    private int nome;
    private Boolean flag;
    private int posicao_rota;
    
    public Cidade(int nome){
        this.nome = nome;
        this.flag = false;
        this.posicao_rota = -1;
    }
    
    public int getNome(){
        return this.nome;
    }
    
    public Boolean isFlag(){
        return flag;
    }
    
    public void setFlag(Boolean flag){
        this.flag = flag;
    }
    
    public int getPosicao(){
        return this.posicao_rota;
    }
    
    public void setPosicao(int posicao_rota){
        this.posicao_rota = posicao_rota;
    }
}

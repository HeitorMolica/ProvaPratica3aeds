
package provapratica3;

//Heitor Molica, Arthur Reis, Luiz Mattos.
/*
força bruta:
    classe cidade -> nome (cidade0, cidade1, etc)
                  -> flag (se ja foi usada na rota ou nao)
                  -> posicao (ordem da rota, posicao = 0 -> primeira cidade)
    classe forcaBruta -> rota (ArrayList com as cidades em ordem)
                      -> distancia_rota (distancia total)
                      -> 
*/
public class ProvaPratica3 {

    public static void main(String[] args) {
        int[][] distancias = {
                                   { 0, 10, 15, 20 },
                                   { 10,  0, 35, 25 },
                                   { 15, 35,  0, 30 },
                                   { 20, 25, 30,  0 }
                                   };
        ForcaBruta forcaBruta = new ForcaBruta(4, distancias);
        forcaBruta.imprimir();
    }
    
}


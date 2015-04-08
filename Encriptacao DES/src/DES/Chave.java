/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DES;

/**
 *
 * @author Allexandre
 */
public class Chave {
    public void permutaInicial(Bloco x){
        
        Bloco bloco_destino = new Bloco();
        
        int PI[] = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18,
            10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 
            47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53,
            45, 37, 29, 21, 13, 5, 28, 20, 12, 4};

        for(int i = 0; i < 64; i++){
            bloco_destino.bits[i] = x.bits[PI[i] - 1];
            System.out.print(bloco_destino.bits[i]+",");
        }
    }
}

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
public class Main {
    
    public static void main(String[] args) {
        
        int[] bloco1 = {1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0,
        0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1,
        0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1};

        Bloco blocoInicial = new Bloco(bloco1);
        blocoInicial.permuta_PI();
        System.out.println("JUMP");
        blocoInicial.despermuta_PI();

    }       
}
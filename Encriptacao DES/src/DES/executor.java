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
public class executor {//funções e métodos que envolvam os objetos de chave e de bloco
    
    public Bloco f_XOR(int[] entrada, int[] chave){//faz o XOR entre o bloco de entrada e a chave
        Bloco retorno = new Bloco();
        int[] ret = new int[48];
        for (int i=0; i<48; i++){
            ret[i]=entrada[i]^chave[i];
        }
        retorno.setBits(ret);
        return retorno;
    }
    
    public void f_XOR(Bloco dFinal, Chave chave) {
        Bloco bloco_destino = new Bloco();
        for (int i = 0; i < 48; i++) {
            bloco_destino.bits[i] = dFinal.bits[i] ^ chave.bits[i];  //Resolver esse B.O.
        }
    }
    
}

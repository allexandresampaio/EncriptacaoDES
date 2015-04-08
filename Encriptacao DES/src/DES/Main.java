/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DES;

import java.util.ArrayList;

/**
 *
 * @author Allexandre
 */
public class Main {
    
    public void mMain(String mensagem) {
        Mensagem principal = new Mensagem();//instancia um objeto mensagem p/ usar os métodos
        String mensagemBin = principal.converteAscBin(mensagem);//pega a mensagem recebida e coloca em binário
        ArrayList<String> blocos = new ArrayList<>();//cria um array para guardar os blocos
        blocos = principal.divide64(mensagemBin);//coloca os blocos no array
        
        for (int i=0; i<blocos.size(); i++){
            int[] itens = new int[8];
            for (int j=0; j<8; j++){
                itens[i]=blocos.get(i).charAt(j);//pega os itens de cada bloco e coloca no array de inteiros.
            }
            Bloco bloco = new Bloco(itens);
            bloco = bloco.permuta_PI();
            bloco.divisao();
            bloco.setD(bloco.f_expansao()); 
        }

    }       
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chave;

import chave.Chave;
import chave.Rounds;
import java.util.ArrayList;

/**
 *
 * @author Allexandre
 */
public class MainChave {
    
    public ArrayList<String> mMain(String chave) {

       //chave e permutar a chave
        Chave c = new Chave();
        chave=c.permuta(chave);    
        String blocoA="",blocoB="";
        //dividindo a Chave para o bloco A
        blocoA=chave.substring(0, 28);
        //dividindo a chave para o bloco B
        blocoB=chave.substring(28, 56);       
        // Aqui faz os rounds
        ArrayList<String> saidaRoundArray = new ArrayList<>();
        Rounds r = new Rounds();
        //salva o round de todos no array list
        saidaRoundArray=r.rounds(blocoA, blocoB);
        //aqui comeca a permutar
        ArrayList<String> chavePermutada = new ArrayList<>();
        for (int i = 0; i < saidaRoundArray.size(); i++) {
            chavePermutada.add(c.permuta2Chave(saidaRoundArray.get(i)));            
        }
       return chavePermutada;
    }       
}
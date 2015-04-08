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
public class Main {
    
    public static void main(String[] args) {

        String chave="abcdefgh";
        
        //chave e permutar a chave
        Chave c = new Chave();
        chave=c.permuta(chave);
        
        String blocoA="",blocoB="";
        //dividindo a Chave para o bloco A
        blocoA=chave.substring(0, 28);
        System.out.println("blocoA " +blocoA);
        //dividindo a chave para o bloco B
        blocoB=chave.substring(28, 56);
        System.out.println("blocoB "+blocoB);
        
        // Aqui faz os rounds
        ArrayList<String> saidaRoundArray = new ArrayList<>();
        Rounds r = new Rounds();
        //salva o round de todos no array list
        saidaRoundArray=r.rounds(blocoA, blocoB);
        
        for (int i = 0; i < saidaRoundArray.size(); i++) {
            System.out.println("Tamanho: "+saidaRoundArray.get(i).length()+" :"+saidaRoundArray.get(i));
        }
        
        
        

    }       
}
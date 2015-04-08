/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chave;

import java.util.ArrayList;

/**
 *
 * @author Ricardo
 */
public class Rounds {

    private ArrayList<String> allRounds=new ArrayList<>();
    private String blocoPermanenteA="",blocoPermanenteB="";
    public Rounds(){
        
    }
    public ArrayList<String> rounds(String blocoA,String blocoB){
            
                blocoPermanenteA=blocoA;
                blocoPermanenteB=blocoB;
                
                flag1(blocoPermanenteA, blocoPermanenteB);
                flag1(blocoPermanenteA, blocoPermanenteB);
                flag2(blocoPermanenteA, blocoPermanenteB);
                flag2(blocoPermanenteA, blocoPermanenteB);
                flag2(blocoPermanenteA, blocoPermanenteB);
                flag2(blocoPermanenteA, blocoPermanenteB);
                flag2(blocoPermanenteA, blocoPermanenteB);
                flag2(blocoPermanenteA, blocoPermanenteB);
                flag1(blocoPermanenteA, blocoPermanenteB);
                flag2(blocoPermanenteA, blocoPermanenteB);
                flag2(blocoPermanenteA, blocoPermanenteB);
                flag2(blocoPermanenteA, blocoPermanenteB);
                flag2(blocoPermanenteA, blocoPermanenteB);                
                flag2(blocoPermanenteA, blocoPermanenteB);
                flag2(blocoPermanenteA, blocoPermanenteB);
                flag1(blocoPermanenteA, blocoPermanenteB);
                
        return allRounds;
    }
    
    private void flag1(String blocoA,String blocoB){
        String blocoTemp="";
        
        blocoTemp = blocoA.substring(1,28);
        blocoA = blocoTemp + blocoA.charAt(0);
        
        blocoTemp="";
        blocoTemp = blocoB.substring(1,28);
        blocoB = blocoTemp + blocoB.charAt(0);
        
        blocoPermanenteA=blocoA;
        blocoPermanenteB=blocoB;
        allRounds.add(blocoPermanenteA+blocoPermanenteB);        
    }
    
    private void flag2(String blocoA,String blocoB){
        String blocoTemp="";
        blocoTemp=blocoA.substring(2,28);
        blocoA = blocoTemp + blocoA.charAt(0) + blocoA.charAt(1);
        
        blocoTemp = blocoB.substring(2,28);
        blocoB = blocoTemp + blocoB.charAt(0) + blocoB.charAt(1);
        
        blocoPermanenteA=blocoA;
        blocoPermanenteB=blocoB;
        allRounds.add(blocoPermanenteA+blocoPermanenteB);
    }    
}

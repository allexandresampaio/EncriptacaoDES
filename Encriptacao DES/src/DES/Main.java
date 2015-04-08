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
    
    public ArrayList<String> mMain(String mensagem, ArrayList<String> chaveRounds) {
        Mensagem principal = new Mensagem();//instancia um objeto mensagem p/ usar os métodos
        String mensagemBin = principal.converteAscBin(mensagem);//pega a mensagem recebida e coloca em binário
        ArrayList<String> blocos = new ArrayList<>();//cria um array para guardar os blocos
        blocos = principal.divide64(mensagemBin);//coloca os blocos no array
        ArrayList<String> retorno = new ArrayList<>();
        
        for (int i=0; i<blocos.size(); i++){
            int[] itens = new int[8];
            for (int j=0; j<8; j++){
                itens[i]=blocos.get(i).charAt(j);//pega os itens de cada bloco e coloca no array de inteiros.
            }
            Bloco bloco = new Bloco(itens);
            bloco = bloco.permuta_PI();
            bloco.divisao();
            
            for (int k=0; k<16; k++){
                int[] chave = new int[48];
                for (int l=0; l<48; l++){
                    chave[i]=chaveRounds.get(k).charAt(l);//pega os itens de cada bloco e coloca no array de inteiros.
                }
                bloco.setD(bloco.f_expansao());
                bloco = f_XOR(bloco.getD(), chave);
                ArrayList<int[]> blocosDe6 = new ArrayList<>();
                blocosDe6 = bloco.f_divisao();
                int[] blocosDe6reag = new int[32];
                for (int m=0; m<8; m++){
                    bloco.f_reducao(blocosDe6.get(m), m+1);
                }
                blocosDe6reag = bloco.conversao_S();
                blocosDe6reag = bloco.despermuta_PI(blocosDe6reag);
                bloco.aux=blocosDe6reag;
                bloco.setD(bloco.getE());
                bloco.setE(bloco.aux);
            }
        
            retorno.add(String.valueOf(bloco.getD()));
            retorno.add(String.valueOf(bloco.getE()));
        }
        return retorno;
    }

    public Bloco f_XOR(int[] entrada, int[] chave){//faz o XOR entre o bloco de entrada e a chave
        Bloco retorno = new Bloco();
        int[] ret = new int[48];
        for (int i=0; i<48; i++){
            ret[i]=entrada[i]^chave[i];
        }
        retorno.setBits(ret);
        return retorno;
    }
}
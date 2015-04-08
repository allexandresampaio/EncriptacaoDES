/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DES;

import java.util.ArrayList;

public class Mensagem {

    String asc = "Italo";
    String bin = "";
    int[] bloco = new int[64];

    public Mensagem() {

    }

    public String converteAscBin(String texto) {
        byte[] bytes = texto.getBytes();
        String[] binarios = new String[bytes.length];
        String saida = "";
        int cont = 0;
        String zero = "";
        // jogando prum array de string  
        for (int i = 0; i < bytes.length; i++) {
            binarios[i] = Integer.toBinaryString(bytes[i]);

            cont = binarios[i].length();
            if (cont < 8) {
                while (cont < 8) {
                    zero += "0";
                    cont++;
                }
                binarios[i] = zero + "" + binarios[i];
                zero = "";
            }
            saida += binarios[i];
        }
        return saida;
    }

    public void divide64(String texto) {

        ArrayList<String> blocos = new ArrayList<>();
        int tamanho = texto.length();
        int resto = tamanho%64;     
        int count = 64 - resto;     //count é o quanto falta para chegar em 64, ou seja, quantos 0 devo adicionar
        int c = (tamanho + count)/64; //vai servir para saber quantos blocos vão ser criados
        
        // esse for preenche o final da string com 0
        for(int i=0; i<count; i++){ 
            texto += "0";
        }        
        
        //esse for deve criar os blocos de 64 bits
        //w serve para controlar qual índice da String será acessado
        //p serve para contar de 0 a 63 e inserir no bloco temp
        for (int i=1; i<=c; i++){  
            Bloco temp = new Bloco();
            int w = 64 * (i-1);   
            int p=0;
            for(int j=w; j<64*i; j++){  //j conta de 0, 64, 128, etc. até 64 * o numero do bloco
                String t="";
                t += texto.charAt(j);
                int k = Integer.parseInt(t, 2);
                temp.bits[p] = k;
                p++;
            }
            
        }
        
     }

}

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
public class Bloco {
    
    int[] bits = new int[64];
    int[] E = new int[32];
    int[] D = new int[32];
    int[] aux = new int[32];//para fazer a inversao de D e E
    
    public int[] getE() {
        return E;
    }
    public void setE(int[] E) {
        this.E = E;
    }
    public int[] getD() {
        return D;
    }
    public void setD(int[] D) {
        this.D = D;
    }
    public int[] getBits() {
        return bits;
    }
    public void setBits(int[] bits) {
        this.bits = bits;
    }
    
    public Bloco(int[] i) {
        this.bits = i;
    }
    
    public Bloco(){
    }
    
    public void permuta_PI(){//permutação inicial do bloco de entrada
        
        Bloco bloco_destino = new Bloco();
        
        int PI[] = {58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30,
        22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51,
        43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7};

        for(int i = 0; i < 64; i++){
            bloco_destino.bits[i] = this.bits[PI[i] - 1];
            //System.out.print(bloco_destino.bits[i]+",");
        }
    }
    
    public void despermuta_PI(){//permutação final do bloco
        
        Bloco bloco_destino = new Bloco();
        
        int PI[] = {40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54,
        22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51,
        19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25};

        for(int i = 0; i < 64; i++){
            bloco_destino.bits[i] = this.bits[PI[i] - 1];
            //System.out.print(bloco_destino.bits[i]+",");
        }
    }
    
    public void divisao(Bloco x){//divide o bloco original em 2 de 32 bits
        for(int i = 0; i < 32; i++){
            this.E[i] = this.bits[x.bits[i]];
            this.D[i] = this.bits[x.bits[i+32]];
        }
    }
    
    public Bloco f_expansao(Bloco x){//expande o bloco de 32 para 48 bits
        Bloco bloco_destino = new Bloco();
        
        int PI[] = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16,
        17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};

        for(int i = 0; i < 64; i++){
            bloco_destino.bits[i] = x.bits[PI[i] - 1];
        }
        return bloco_destino;
    }
    
    public void f_XOR(Bloco dFinal, Chave chave) {
        Bloco bloco_destino = new Bloco();
        for (int i = 0; i < 48; i++) {
            bloco_destino.bits[i] = dFinal.bits[i] ^ chave.bits[i];  //Resolver esse B.O.
        }
    }
    
    public void f_divideEmOito(Bloco x){
        Bloco b1, b2, b3, b4, b5, b6, b7, b8;
        int k = 0;
        b1 = f_coletaBits(x, k);
        b2 = f_coletaBits(x, k);
        b3 = f_coletaBits(x, k);
        b4 = f_coletaBits(x, k);
        b5 = f_coletaBits(x, k);
        b6 = f_coletaBits(x, k);
        b7 = f_coletaBits(x, k);
        b8 = f_coletaBits(x, k);
    }
    
    public Bloco f_coletaBits(Bloco x, int k){
        Bloco temp = null;
        for(int i = 0; i<6; i++){
            temp.bits[i] = x.bits[k];
            k++;
        }
        return temp;
    }
    public void f_divisao(Bloco x){//divide o bloco em 8 partes menores de 6 bits
        int[] p1 = new int[6];
        int[] p2 = new int[6];
        int[] p3 = new int[6];
        int[] p4 = new int[6];
        int[] p5 = new int[6];
        int[] p6 = new int[6];
        int[] p7 = new int[6];
        int[] p8 = new int[6];
        
        for (int i = 0; i<6; i++){
            p1[i]= x.getBits()[i];
            p2[i]= x.getBits()[i+6];
            p3[i]= x.getBits()[i+12];
            p4[i]= x.getBits()[i+18];
            p5[i]= x.getBits()[i+24];
            p6[i]= x.getBits()[i+30];
            p7[i]= x.getBits()[i+36];
            p8[i]= x.getBits()[i+42];
            
        }
    }
    
    public void f_reducao(int[] x, int flag){//reduz o bloco de 6 para 4 bits, de acordo com as tabelas de S1 a S8
        int[] pontas = {x[0], x[5]};
        int[] meio = {x[1], x[2], x[3], x[4]};
        switch (flag){
            case 1:
                int[][] S1 = {
                    {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                    {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                    {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                    {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}};
                    
                    int linha = Integer.parseInt(pontas[0]+""+pontas[1]);
                    int coluna = Integer.parseInt(meio[0]+""+meio[1]+meio[2]+meio[3]);
                    
                
            case 2:
                int[][] S2 = {
                    {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
                    {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
                    {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
                    {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}};
            case 3:
                int[][] S3 = {
                    {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
                    {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
                    {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
                    {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}};
            case 4:
                int[][] S4 = {
                    {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
                    {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                    {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
                    {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}};
            case 5:
                int[][] S5 = {
                    {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
                    {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                    {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
                    {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}};
            case 6:
                int[][] S6 = {
                    {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
                    {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
                    {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                    {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}};
            case 7:
                int[][] S7 = {
                    {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
                    {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
                    {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
                    {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}};
            case 8:
                int[][] S8 = {
                    {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
                    {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
                    {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
                    {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}};
        }
    } 
}

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
    
    public void permuta_PI(){
        
        Bloco bloco_destino = new Bloco();
        
        int PI[] = {58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30,
        22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51,
        43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7};

        for(int i = 0; i < 64; i++){
            bloco_destino.bits[i] = this.bits[PI[i] - 1];
            System.out.print(bloco_destino.bits[i]+",");
        }
    }
    
    public void despermuta_PI(){
        
        Bloco bloco_destino = new Bloco();
        
        int PI[] = {40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54,
        22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51,
        19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25};

        for(int i = 0; i < 64; i++){
            bloco_destino.bits[i] = this.bits[PI[i] - 1];
            System.out.print(bloco_destino.bits[i]+",");
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
}

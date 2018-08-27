
package ExecucaoGrafo;

import EstruturaGrafo.No;
import EstruturaGrafo.BaseGrafo;
import java.util.ArrayList;

public class AGMPrim {
    private BaseGrafo grafo;
    private int chave[];
    private int Q[];
    private int pai[];

    private int p;
    
    
    public AGMPrim(BaseGrafo grafo, int p){
        this.grafo=grafo;
        chave=new int[grafo.getNumV()];
        Q=new int[grafo.getNumV()];
        pai=new int[grafo.getNumV()];
        this.p=p;
        
    }
    
public void Prim(){
        int u;
        for(int i=0; i<grafo.getNumV();i++){
            chave[i]=1000;
            pai[i]=-1;
            Q[i]=1000;
        }
        chave[p]=0;

        while( verificaQ(Q)){
            u=extraiMinimo(Q,chave);
            
            No adj=grafo.getAdj(u);   
            while(adj != null){   
                if(Q[adj.getvID()] == 1000 && grafo.getValorAresta(u,adj.getvID()) < chave[adj.getvID()] ){ 
                  chave[adj.getvID()]= grafo.getValorAresta(u,adj.getvID());
                  pai[adj.getvID()]=u;
                }   
                
                adj=adj.getProx();
            }
        }
        
    }

    public boolean verificaQ(int[] Q){
     
        for(int i=0;i<grafo.getNumV();i++){
         if(Q[i] == 1000) { 
         return true;
         }
     }
     return false;
    }

    public int extraiMinimo(int[] Q,int[] d){
        int aux=0,menor=9999;
        
        for(int i=0; i<grafo.getNumV();i++)
            if(Q[i] == 1000 && d[i] != 1000)
                if(d[i]<menor){
                    aux=i;
                    menor=d[i];
                }               
        Q[aux]=0;        
       return aux; 
    }
    
    public ArrayList<Integer> getCaminho(){
       ArrayList<Integer> caminho=new ArrayList<Integer>();
        for(int i=0;i<grafo.getNumV();i++)  
           for(int j=1;j<grafo.getNumV();j++){
               if(i==pai[j]){
                   caminho.add(j);
               }
           }
        return caminho;
    }
    
    public BaseGrafo getGrafo() {
        return grafo;
    }

    public void setGrafo(BaseGrafo grafo) {
        this.grafo = grafo;
    }

    public int[] getChave() {
        return chave;
    }

    public void setChave(int[] chave) {
        this.chave = chave;
    }

    public int[] getQ() {
        return Q;
    }

    public void setQ(int[] Q) {
        this.Q = Q;
    }

    public int[] getPai() {
        return pai;
    }

    public void setPai(int[] pai) {
        this.pai = pai;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    
}

package ExecucaoGrafo;

import EstruturaGrafo.No;
import EstruturaGrafo.BaseGrafo;
import java.util.ArrayList;

public class CMCDijkstra {
    private BaseGrafo grafo;
    private int p;
    private int pai[];
    private int d[];
    private int Q[];
    private int S[];
       
    public CMCDijkstra(BaseGrafo grafo, int p){
        this.grafo=grafo;
        pai=new int[grafo.getNumV()];
        d=new int[grafo.getNumV()];
        d=new int[grafo.getNumV()];
        Q=new int[grafo.getNumV()];
        S=new int[grafo.getNumV()];
        this.p=p; 
    }
      
    public void Dijkstra(){
        inicializa(p);
        int u;     
        while(verificaQ(Q)){          
           u=extraiMinimo(Q,d);   
           No adj=grafo.getAdj(u);  
           while(adj != null){      
               relaxa(u,adj.getvID());
               adj=adj.getProx();
           }    
        }
         
    }
        
    public void inicializa(int p){
        for(int i=0; i<grafo.getNumV() ; i++){
            d[i]=1000;
            pai[i]=-1;
            Q[i]=1000;
        }    
        d[p]=0;           
    }
    
    public void relaxa(int origem, int destino){     
          if(d[destino] > (d[origem]+ grafo.getValorAresta(origem, destino))){
            d[destino]= d[origem]+ grafo.getValorAresta(origem, destino);
            pai[destino]=origem;
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
                   System.out.println(" PAI "+pai[j]+" DESTI"+j);
               }
           }
        return caminho;
    }
    
    public BaseGrafo getGrafo() {
        return grafo;
    }

    public int getP() {
        return p;
    }

    public int[] getPai() {
        return pai;
    }

    public int[] getD() {
        return d;
    }

    public int[] getQ() {
        return Q;
    }

    public int[] getS() {
        return S;
    }
    
}

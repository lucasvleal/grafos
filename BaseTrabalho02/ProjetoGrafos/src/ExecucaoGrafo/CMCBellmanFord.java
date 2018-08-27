
package ExecucaoGrafo;

import EstruturaGrafo.Arestas;
import EstruturaGrafo.BaseGrafo;
import java.util.ArrayList;
        
public class CMCBellmanFord {
    BaseGrafo grafo;
    private int pai[];
    private int d[];
    private int p;
    
    
    public CMCBellmanFord(BaseGrafo grafo,int p){
        this.grafo=grafo;
        pai=new int[grafo.getNumV()];
        d=new int[grafo.getNumV()];  
        this.p=p;
    }
    
    public void BellmanFord(){
        ArrayList<Arestas> arestas=grafo.criaListaAresta();       
        inicializa(p);
        
        for(int i=1; i < (grafo.getNumV()-1); i++)
            for(Arestas aux : arestas)
                relaxa(aux.getOrigem(),aux.getDestino());
        
    }
    
    public void inicializa(int p){        
        for(int i=0; i<grafo.getNumV() ; i++){
            d[i]=1000;
            pai[i]=-1;  
        }
        d[p]=0;
        
    }
    
    public void relaxa(int origem, int destino){
        
          if(d[destino] > (d[origem]+ grafo.getValorAresta(origem, destino))){
            d[destino]= d[origem]+ grafo.getValorAresta(origem, destino);
            pai[destino]=origem;
          }
    }
    
    public ArrayList<Integer> getCaminho(){
       ArrayList<Integer> caminho=new ArrayList<Integer>();
        for(int i=0;i<grafo.getNumV();i++)  
           for(int j=0;j<grafo.getNumV();j++){
               if(j!=p){
               if(i==pai[j]){
                   caminho.add(j);
               }
               }
           }
        
        return caminho;
    }
    
    public ArrayList<Integer> getCamin(int d){
        ArrayList<Integer> r=new ArrayList<Integer>();
        r.add(d);
        int aux=d;
        
            while(pai[aux]!=-1){
                r.add(aux);
                
                aux=pai[aux];

            }   
        return r;
    }
    
    public BaseGrafo getGrafo() {
        return grafo;
    }

    public void setGrafo(BaseGrafo grafo) {
        this.grafo = grafo;
    }

    public int[] getPai() {
        return pai;
    }

    public void setPai(int[] pai) {
        this.pai = pai;
    }

    public int[] getD() {
        return d;
    }

    public void setD(int[] d) {
        this.d = d;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }    
    
}


    
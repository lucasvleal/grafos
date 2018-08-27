
package ExecucaoGrafo;

import EstruturaGrafo.Arestas;
import EstruturaGrafo.BaseGrafo;
import java.util.ArrayList;

public class AGMKruskal {
    private BaseGrafo grafo;
    private ArrayList<ArrayList<Integer>> conjV;
    private ArrayList<Arestas> arestas;
    private int pai;
    
    public AGMKruskal(BaseGrafo grafo,int pai){
        this.grafo=grafo;
        this.pai=pai;
        conjV=new ArrayList<ArrayList<Integer>>(grafo.getNumV());
    }
    
    public void Kruskal(){
        arestas = new ArrayList<>();
        ArrayList<Arestas> a=grafo.criaListaAresta();
        
        for(int i=0; i<grafo.getNumV();i++)
            conjV.get(i).add(i);
        
        for(Arestas ar : a){
            addUCVert(ar);
        }
        
    }
    
    public boolean addUCVert(Arestas aresta){
        int o=0,d=0;
        for(int i=0;i<conjV.size();i++)
            for(int j=0;j<conjV.get(i).size();j++){
                if(aresta.getOrigem() == conjV.get(i).get(j)) o=j;
                if(aresta.getDestino()== conjV.get(i).get(j)) d=j;
            }
        
        if(o == 0 && d == 0){
            conjV.get(aresta.getOrigem()).add(aresta.getDestino());
            conjV.remove(aresta.getDestino());
            aresta.setFlag(1);
            return true;
        }else{
            return false;
        }
                
    }
}


package EstruturaGrafo;

import java.util.ArrayList;
import java.util.Collections;

public class GrafoListaAdj extends BaseGrafo {
    private No vertices[];
    

    @Override
    public void criaGrafo(int numV, int orientado, int peso) {
        this.numV=numV;
        this.peso=peso;
        this.orientado=orientado;
        vertices= new No[numV];
    }

    @Override
    public void addAresta(int vIni, int vFim, int peso) {        
        if(orientado==1){                             
            No aux = new No(vFim,peso);
            aux.setProx(vertices[vIni]);
            vertices[vIni]=aux;   
        }
        else{
            No aux = new No(vFim,peso);               
            aux.setProx(vertices[vIni]);
            vertices[vIni]=aux;
            
            aux = new No(vIni,peso);
            aux.setProx(vertices[vFim]);
            vertices[vFim]=aux;
        }
            
    }

    @Override
    public String imprimeGrafo() {
        String texto="";
        for(int i=0; i<numV;i++){
            No adj=getAdj(i);
            texto=texto+"|"+i+"|  ==>";
            while(adj != null){
               texto=texto+" ("+adj.getvID()+") -->";
               adj=adj.getProx();
            }
            texto=texto+"NULL\n";
        }
        return texto;
    }

    public No[] getVertices() {
        return vertices;
    }

    public void setVertices(No[] vertices) {
        this.vertices = vertices;
    }
    
    @Override
    public No getAdj(int u){
        return vertices[u];
    }

    @Override
    public ArrayList<Arestas> criaListaAresta() {
        
        ArrayList<Arestas> arestas= new ArrayList<Arestas>();
        No aux;
        Arestas aux2;
        
        for(int i=0; i< numV ; i++){
            aux=getAdj(i);
            while(aux != null){                 
              
              aux2 = new Arestas(i,aux.getvID(),aux.getPeso());
              arestas.add(aux2);
              aux=aux.getProx();             
            }
        }        
        Collections.sort(arestas);       
      return arestas;
    }
    
    public int verificaAresta(ArrayList<Arestas> arestas, int origem, int destino){
        for(Arestas a : arestas){
            if(a.getOrigem()==destino && a.getDestino() == origem)
                return 0;
        }    
      return 1;
    }
    
    public int getValorAresta(int origem,int destino){
        No adj=getAdj(origem);
        
        while(adj != null){
            if(adj.getvID() == destino)
                return adj.getPeso();
          adj=adj.getProx();
        }            
       return 0; 
    }
    
    public No[] criaTransposto(){
        No [] listavertT=new No[numV]; 
        for(int i=0; i < numV; i++){
            No aux = getAdj(i);
            
            while(aux != null){
               int vIni=aux.getvID();
               int peso = aux.getPeso();
               No novoNo = new No(i,peso);
               novoNo.setProx( listavertT[vIni] );
               listavertT[vIni] = novoNo; 
               
               aux=aux.getProx();
            }      
        } 

        return listavertT;
    }
    
    @Override
    public No getVertice(int i){
        return vertices[i];
    }
    
}

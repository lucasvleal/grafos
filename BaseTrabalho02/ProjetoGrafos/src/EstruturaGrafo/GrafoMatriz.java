
package EstruturaGrafo;

import java.util.ArrayList;
import java.util.Collections;

public class GrafoMatriz extends BaseGrafo {    
    private int matriz[][];
    private int matrizPeso[][];
   
    @Override
    public void criaGrafo(int numV, int orientado, int peso) {
        this.numV=numV;
        this.peso=peso;
        this.orientado=orientado;
        
        matriz = new int[numV][numV];
        matrizPeso= new int[numV][numV];
        for(int i=0 ; i< matriz.length;i++)
            for(int j=0; j<matriz[i].length ; j++){
              matriz[i][j]=0;
              matrizPeso[i][j]=0;
            }  
    }

    @Override
    public void addAresta(int vIni, int vFim, int peso) {
        
        if(this.peso == 1){
             if(orientado == 1){
                matriz[vIni][vFim]=1;
                matrizPeso[vIni][vFim]=peso;       
             }else{
            matriz[vIni][vFim]=1;
            matrizPeso[vIni][vFim]=peso;
            matriz[vFim][vIni]=1;
            matrizPeso[vFim][vIni]=peso;
             }
        } 
        else if(orientado == 1){
          matriz[vIni][vFim]=1;
        
        } else {
            matriz[vIni][vFim]=1;
            matriz[vFim][vIni]=1;
        }
    }

    @Override
    public String imprimeGrafo() {
        String texto;
        if(peso == 1){
        
        texto="         Matriz Adjascentes\n";
        for(int i=0;i<matriz.length;i++){
            for (int j=0;j<matriz[i].length;j++){
                texto=texto+matriz[i][j]+"\t ";
            }
            texto=texto+"\n";
        }
        
        texto=texto+" \n\n      Matriz de Peso \n";
        for(int i=0;i<matriz.length;i++){
            for (int j=0;j<matriz[i].length;j++){
                texto=texto+matrizPeso[i][j] + "\t ";
            }
           texto=texto+"\n";
        }
        } else {
           texto="     Matriz de Adjascentes\n";
        for(int i=0;i<matriz.length;i++){
            for (int j=0;j<matriz[i].length;j++){
                texto=texto+matriz[i][j]+"\t ";
            }
            texto=texto+"\n";
        } 
        
          }
        return texto;
    }

    @Override
    public No getAdj(int u) {
        No aux = null;
         
        for(int i=0;i<numV;i++)
          if(matriz[u][i]== 1){
                                          
            No aux2 = new No(i,matrizPeso[u][i]);
            aux2.setProx(aux);
            aux=aux2;   
          
          }
        return aux;
    }

    @Override
    public ArrayList<Arestas> criaListaAresta() {
        ArrayList<Arestas> arestas= new ArrayList<Arestas>();
        No aux;
        Arestas aux2;
        
        for(int i=0;i<numV;i++){
            aux=getAdj(i);
            while(aux != null){
               if(verificaAresta(arestas,i,aux.getvID()) == 1){
              aux2 = new Arestas(i,aux.getvID(),aux.getPeso());
              arestas.add(aux2);
              }
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

    @Override
    public int getValorAresta(int origem, int destino) {
        int v=matrizPeso[origem][destino];
        return v;
    }
    @Override
    public No[] criaTransposto(){return null;}
    @Override
    public No getVertice(int i){return null;};
}

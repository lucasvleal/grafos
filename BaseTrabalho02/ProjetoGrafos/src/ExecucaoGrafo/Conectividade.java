
package ExecucaoGrafo;

import EstruturaGrafo.No;
import EstruturaGrafo.BaseGrafo;

public class Conectividade {
    private BuscaProfundidade buscaF,buscaC;
    private BaseGrafo grafo;
    private No listV[];

    public Conectividade(BaseGrafo grafo){
         this.grafo=grafo;
         buscaF = new BuscaProfundidade(grafo);
         buscaF.DFS();
         buscaC = new BuscaProfundidade(grafo);
         listV=new No [grafo.getNumV()];
     }
    
    public void conecta(){
        listV=grafo.criaTransposto();
        buscaC.DFScVerif(buscaF.getAux(),listV);       
    }
    
    public int getNumFC(){
       return buscaC.getNumComp();
        
    }
    
    public int[] getComp(){
       return buscaC.getComponentes();
    }
}

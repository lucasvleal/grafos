
package ExecucaoGrafo;

import EstruturaGrafo.No;
import EstruturaGrafo.Fila;
import EstruturaGrafo.BaseGrafo;

public class OrdemTopo {
    private BaseGrafo grafo;
    private No listavT[];
    private int ordenado[];
    
    public OrdemTopo(BaseGrafo grafo){
        this.grafo=grafo;
        listavT=grafo.criaTransposto();
        ordenado=new int[grafo.getNumV()];
        
    }
    
    public int[] ordenaTopo(){
        Fila f1=new Fila(); 
        Fila f2=new Fila();
        int gE[]=new int[grafo.getNumV()];
        
        for(int i=0;i<grafo.getNumV();i++)
            gE[i]=0;
        
        for(int i=0; i<grafo.getNumV();i++){
            No aux=listavT[i];
            while(aux != null){
                gE[i]++;
                aux=aux.getProx();
            }
        }
        
        for(int i=0;i<grafo.getNumV();i++)
            if(gE[i]==0){
                f1.addFila(i);
            }
        while(!f1.vaziaFila()){
            int v=f1.removeFila();
            f2.addFila(v);
            
            No aux=grafo.getAdj(v);
            
            while(aux!=null){
                
                gE[aux.getvID()]--;
                if(gE[aux.getvID()]==0)
                    f1.addFila(aux.getvID());
                aux=aux.getProx();
            }
        }
        
        if(f2.f.size() != grafo.getNumV())
            return null;
        else {
            for(int i=0;i<f2.f.size();i++){
                ordenado[i]=f2.f.get(i);  
                
            }    
        }
        
        return ordenado;       
    }

    public int[] getOrdenado() {
        return ordenado;
    }
    
    
}

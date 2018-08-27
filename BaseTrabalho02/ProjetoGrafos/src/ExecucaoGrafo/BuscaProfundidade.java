
package ExecucaoGrafo;

import EstruturaGrafo.No;
import EstruturaGrafo.BaseGrafo;
import java.util.ArrayList;

public class BuscaProfundidade {
    private BaseGrafo grafo;
    private int tempo;
    private int cor[];   
    private int d[]; //contagem do tempo em que o vertice ficou cinza
    private int f[]; //contagem do tempo em que o vertice ficou preto
    private int componentes[]=null;
    private int ca[];
    private ArrayList<Integer> aux= new ArrayList<Integer>();
    private ArrayList<ArrayList<Integer>> FC= new ArrayList<>();
    

    public BuscaProfundidade(BaseGrafo grafo) {
          this.grafo=grafo;
          cor=new int[grafo.getNumV()];
          d=new int[grafo.getNumV()];
          f=new int[grafo.getNumV()];
          componentes=new int[grafo.getNumV()];
          ca=new int[grafo.getNumV()];
    }
    
    public void inicializa(){
        for(int i=0; i< grafo.getNumV(); i++){
            cor[i]=1;    
            ca[i]=0;
        }   
        tempo=0;
    }
    
    public void imprime(){
        for(int i=0;i<FC.size();i++){
            System.out.println("CONJUNTO "+i);
            for(int j=0;j<FC.get(i).size();j++)
                System.out.println("E: "+FC.get(i).get(j));
        }
    }    
    
      public void verifica(int C[]){
        ArrayList<Integer> aux2=new ArrayList<Integer>();
        for(int i=0;i<C.length;i++){
            if(C[i]==3){
                if(ca[i]==0){
                aux2.add(i);
                ca[i]=1;
                }
            }
        }
        if(!aux2.isEmpty())
        FC.add(aux2);
    }
    
    public void DFScVerif(ArrayList<Integer> fim, No lv[]){
        inicializa();   
        
        for (int i = 0; i < componentes.length; i++)
            componentes[i] = -1;      
        
        int idComp = -1; 
        
        for(int i=0,j=fim.size(); i<fim.size() && j>0 ; i++,j--){            
            if (componentes[i] == -1){               
                idComp++;
                DFSvisitacNo(fim.get(j-1),idComp,lv);
                verifica(cor);
            }
        }
        
    }
          
    public void DFSvisitacNo(int u, int idComp, No lv[]){
        cor[u]=2;  
        componentes[u] = idComp;
        No adj=lv[u];      
          while(adj != null){                
              if(componentes[adj.getvID()]==-1)
                DFSvisitacNo(adj.getvID(),idComp,lv); 
              
          adj=adj.getProx();
          }         
        cor[u]=3;
              
    }
    
    public void DFS(){      
        inicializa();     
        
        for (int i = 0; i < componentes.length; i++) 
            componentes[i] = -1; 
        
        int idComp = -1;   
        
        for(int i=0; i< componentes.length; i++)
            if (componentes[i] == -1){
                idComp++;
                BuscaProfundidade.this.DFSvisita(i,idComp);
            }   
        
    }
    
    public void DFSvisita(int u, int idComp){
        cor[u]=2;
        tempo=tempo+1;
        d[u]=tempo;    
        componentes[u] = idComp;
        No adj=grafo.getAdj(u);      
          while(adj != null){       
              if(componentes[adj.getvID()]==-1)
                BuscaProfundidade.this.DFSvisita(adj.getvID(),idComp);           
          adj=adj.getProx();
          }         
        cor[u]=3;
        aux.add(u);
        tempo=tempo+1;
        f[u]=tempo;
        
    }
    
    public int getNumComp() {
        int numComp=0;
        int count[]=new int[componentes.length];
        for(int i=0;i<count.length;i++)
            count[i]=0;       
          for(int i=0;i<componentes.length;i++)
              if(count[componentes[i]]==0)
                  count[componentes[i]]++;
          
            for(int i=0;i<count.length;i++){
               numComp=numComp+count[i];
            }           
    return numComp;
    }
    
    public int[] getComponentes() {
        return componentes;
    }

    public void setComponentes(int[] componentes) {
        this.componentes = componentes;
    }
    
    public int getTempo() {
        return tempo;
    }

    public int[] getD() {
        return d;
    }

    public int[] getF() {
        return f;
    }
    
     public ArrayList<Integer> getAux() {
        return aux;
    }
}

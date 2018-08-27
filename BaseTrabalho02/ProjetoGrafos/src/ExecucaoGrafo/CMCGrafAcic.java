
package ExecucaoGrafo;

import EstruturaGrafo.No;
import EstruturaGrafo.BaseGrafo;

public class CMCGrafAcic {
    private final BaseGrafo grafo;
    private final int vert;
    private final int d[];
    private final int pai[];
    private int ot[];
    private final int cv[];
    private final OrdemTopo ordT;
    
    
    public CMCGrafAcic(BaseGrafo grafo,int vert){
        this.grafo=grafo;
        this.vert=vert;
        d=new int[grafo.getNumV()];
        pai=new int[grafo.getNumV()];
        cv=new int[grafo.getNumV()];
        ordT=new OrdemTopo(grafo);
    }
    
    public void inicializa(){
        for(int i=0;i<grafo.getNumV();i++){
            d[i]=1000;
            pai[i]=-1;
            cv[i]=0;
        }
        d[vert]=0;
    }
    
    public void caminhoMinimoGA(){
        ot=ordT.ordenaTopo();
        inicializa();        
        for(int i=0;i<ot.length;i++){
            //System.out.println(" O "+ot[i]);
            No aux=grafo.getAdj(ot[i]);
            while(aux != null){  
                relaxa(ot[i],aux.getvID());
            aux=aux.getProx();
            }
        }
    }
    
    public void relaxa(int origem, int destino){       
          if(d[destino] > (d[origem]+ grafo.getValorAresta(origem, destino))){
            d[destino]= d[origem]+ grafo.getValorAresta(origem, destino);
            pai[destino]=origem;
          }
    }   
    
    public void imprime(){
        String c="";
        int aux=vert;
        for(int i=0;i<grafo.getNumV();i++)  
           for(int j=0;j<grafo.getNumV();j++){   
             if(i==pai[j]){
                c=c+pai[j]+"->>"+j+"     ";
             }     
            }
        System.out.println(c);
    }

    public int[] getPai() {
        return pai;
    }

}

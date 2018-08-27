
package ExecucaoGrafo;

import EstruturaGrafo.No;
import EstruturaGrafo.Fila;
import EstruturaGrafo.BaseGrafo;
import java.util.ArrayList;

public class BuscaLargura {
    private BaseGrafo grafo;
    private int inicial;            
    private int cor[];              
    private int d[];                
    private int p[];              
    private Fila fila;
    private ArrayList<Integer> ordem;
    private int nivel[];
    private int idn;
    
    public BuscaLargura(BaseGrafo grafo, int inicial){
        this.grafo=grafo;
        this.inicial=inicial;
        cor= new int[grafo.getNumV()];
        d= new int[grafo.getNumV()];
        p= new int[grafo.getNumV()];
        ordem=new ArrayList<Integer>();
        nivel=new int[grafo.getNumV()];
    }

    public void BFS(){
      
        for(int i=0; i<grafo.getNumV();i++)
            if(i!=inicial){
                cor[i]=1;
                d[i]=1000;
                p[i]=-1;
                nivel[i]=0;
            }
        idn=1;
        cor[inicial]=2;
        p[inicial]=-1;
        d[inicial]=0;
        fila=new Fila();
        fila.addFila(inicial);
        ordem.add(inicial);
        int f;
         
        while(!fila.vaziaFila()){
           f=fila.removeFila();
           idn=nivel[f]+1;
           No adj=grafo.getAdj(f);
           while(adj != null){
               if(cor[adj.getvID()]==1){
                   cor[adj.getvID()]=2;
                   d[adj.getvID()]=d[f]+1;
                   p[adj.getvID()]=f;
                   fila.addFila(adj.getvID());
                   ordem.add(adj.getvID());
                   nivel[adj.getvID()]=idn;
               }
               adj=adj.getProx();
           }           
           cor[f]=3;
         }
        nivel[inicial]=0;
    }

    public int[] getNivel() {
        return nivel;
    }

    public int getIdn() {
        return idn;
    }
    
    
    public BaseGrafo getGrafo() {
        return grafo;
    }

    public void setGrafo(BaseGrafo grafo) {
        this.grafo = grafo;
    }

    public int getInicial() {
        return inicial;
    }

    public void setInicial(int inicial) {
        this.inicial = inicial;
    }

    public int[] getCor() {
        return cor;
    }

    public void setCor(int[] cor) {
        this.cor = cor;
    }

    public int[] getD() {
        return d;
    }

    public void setD(int[] d) {
        this.d = d;
    }

    public int[] getP() {
        return p;
    }

    public void setP(int[] p) {
        this.p = p;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }
    
    public ArrayList<Integer> getOrdem(){
        return ordem;
    }
}

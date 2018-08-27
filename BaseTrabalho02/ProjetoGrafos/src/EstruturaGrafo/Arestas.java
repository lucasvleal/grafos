
package EstruturaGrafo;

public class Arestas implements Comparable<Arestas> {
     private int origem;
     private int destino;
     private int peso;
     private int flag = 0;
    
    
    public Arestas(int origem, int destino, int peso){
        this.peso=peso;
        this.destino=destino;
        this.origem=origem;
    }
    

    @Override
    public int compareTo(Arestas o) {
        if(this.peso > o.getPeso())
            return 1;
        else if(this.peso < o.getPeso())
            return -1;
         
         return 0;      
    }
    
    public int getPeso(){
        return peso;
    }
    
    public int getOrigem(){
        return origem;
    }
    
    @Override
    public String toString() {
        return "origem=" + origem + ", destino=" + destino + " peso= "+peso;
    }

    public int getDestino() {
        return destino;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
    
    
    
}

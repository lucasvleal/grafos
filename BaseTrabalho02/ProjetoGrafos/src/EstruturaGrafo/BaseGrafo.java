
package EstruturaGrafo;

import java.util.ArrayList;

public abstract class BaseGrafo {
     protected int numV = 0;
     protected int orientado;
     protected int peso;
     
    public int getNumV() {
        return numV;
    }

    public void setNumV(int numV) {
        this.numV = numV;
    }

    public int getOrientado() {
        return orientado;
    }

    public void setOrientado(int orientado) {
        this.orientado = orientado;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
   
   public abstract void criaGrafo(int numV, int orientado, int peso);
   public abstract void addAresta(int vIni, int vFim, int peso);
   public abstract String imprimeGrafo();
   public abstract No getAdj(int u);
   public abstract ArrayList<Arestas> criaListaAresta();
   public abstract int getValorAresta(int origem, int destino);
   public abstract No[] criaTransposto();
   public abstract No getVertice(int i);
}
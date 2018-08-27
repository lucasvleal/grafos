
package ExecucaoGrafo;

import EstruturaGrafo.No;
import EstruturaGrafo.BaseGrafo;

public class Coloracao {
    public Coloracao(BaseGrafo grafo) {
        BaseGrafo gf = grafo;
        cores = new int[gf.getNumV()];
        for (int i=0; i<cores.length; i++){
            cores[i] = -1;
        }
        int vMaiorGrau = verticeMaiorGrau(grafo);
        coloreVertice(grafo, vMaiorGrau);
        for(int i=0;i<cores.length;i++)
            if(cores[i]==-1)
                coloreVertice(grafo, i);
    }

    private void coloreVertice(BaseGrafo grafo, int vert) {
        cores[vert] = corApropriada(grafo, vert);   
        No adj = grafo.getAdj(vert);
        while (adj != null) {
            if (cores[adj.getvID()] == -1) {
                coloreVertice(grafo, adj.getvID());
            }
            adj = adj.getProx();
        }
    }
    
    private int corApropriada(BaseGrafo grafo, int vert){
        int cor = -1;
        Boolean flag = false;        
        while (!flag){
            cor++;
            No adj = grafo.getAdj(vert);
            while (adj!=null && cores[adj.getvID()] != cor){
                adj = adj.getProx();
            }
            if (adj == null){
                flag = true;
            }            
        }        
        return cor;
    }

    private int verticeMaiorGrau(BaseGrafo grafo){
        int vert = 0;
        int maior = Integer.MIN_VALUE;
        for (int i=0; i<grafo.getNumV(); i++){
            int cont = 0;
            No aux = grafo.getAdj(i);
            while (aux != null){
                cont++;
                aux = aux.getProx();
            }
            if (cont > maior){
                maior = cont;
                vert = i;
            }
        }
        return vert;
    }

    public int getNumCores(){
        int numComp = 0;
        int count[] = new int[cores.length];
        for (int i=0; i< count.length; i++){
            count[i] = 0;
        }
        for (int i=0; i<cores.length; i++){
            if (count[cores[i]] == 0){
                count[cores[i]]++;
            }
        }
        for (int i=0; i<count.length; i++){
            numComp = numComp + count[i];
        }

        return numComp;
    }

    public int[] getCores() {
        return cores;
    }

    private int cores[] = null;
}

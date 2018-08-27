
package EstruturaGrafo;

import ExecucaoGrafo.CMCBellmanFord;
import ExecucaoGrafo.CMCDijkstra;
import ExecucaoGrafo.CMCGrafAcic;
import ExecucaoGrafo.Conectividade;
import ExecucaoGrafo.AGMPrim;
import ExecucaoGrafo.BuscaLargura;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Grafos {
    private BaseGrafo grafo;    
    private BuscaLargura buscal;    
    private CMCDijkstra dijk;
    private CMCBellmanFord bellFord;
    private int numV;
    private int orientado;
    private int peso = 1;
    //public No nos[] = new No[24];
    public ArrayList nos = new ArrayList();
    
    public Grafos(){};
        
    public void criaGrafo(int numV,int orientado,int peso,BaseGrafo grafo){
       this.numV=numV;
       this.peso=peso;
       this.orientado=orientado;
       this.grafo=grafo;
       grafo.criaGrafo(numV,orientado,peso);
    }
            
    public ArrayList<Arestas> criaListaAresta(){
       for (Arestas l : grafo.criaListaAresta())
            System.out.println(l);
        return grafo.criaListaAresta();
        
    }
    
    public No getVertice(int v){
        return grafo.getVertice(v);
    }
    
    public BaseGrafo criaTransposto(BaseGrafo grafos){
        BaseGrafo grafox = grafos; 
        ArrayList<Arestas> auxA = grafox.criaListaAresta();
        
         for(Arestas l : auxA){
             grafox.addAresta(l.getDestino(),l.getOrigem(),l.getPeso());
             System.out.println(l);
         }       
         System.out.println("-------");
         
         return grafox;
    }
    
    public void conecta(){
        Conectividade conecta=new Conectividade(grafo);
        conecta.conecta();
    }
    
    public void addAresta(int vIni, int vFim, int peso){
        grafo.addAresta(vIni, vFim, peso);
    }
    
    public String imprimeGrafo(){
        return grafo.imprimeGrafo();
    }
    
    public void getAdj(int u){
        No aux=grafo.getAdj(u);
        while(aux!= null){
            System.out.println(aux.getvID()+" "+" "+aux.getPeso());
            aux=aux.getProx();
        }
    }
            
    public void leGrafo(){
        try{
            FileReader arquivo = new FileReader(new File("src\\arquivos\\mapadevoo.txt"));
            BufferedReader in = new BufferedReader(arquivo);
            
            String ler = in.readLine();
            int orienta=Integer.parseInt(ler);
            ler=in.readLine();
            int vertice=Integer.parseInt(ler);
              
          int t=Integer.parseInt(JOptionPane.showInputDialog(null, "Qual tipo deseja trabalhar :\n 1) Matriz de Adjacência\n 2) Lista de Adjacência"));
                if(t != 2  && t!=1)
                    System.out.println("Escolha uma Opção valida por favor.");
                else {   
                    if(t==2)
                        criaGrafo(vertice,orienta,peso,new GrafoListaAdj());
                  else 
                        criaGrafo(vertice,orienta,peso,new GrafoMatriz());
                     
            
            
            int origem,destino,pes;
            String linha[]=in.readLine().split(" ");
            
           
            while( linha != null){
                              
                origem=Integer.parseInt(linha[0]);
                destino=Integer.parseInt(linha[1]);
                pes=Integer.parseInt(linha[2]);
                
                
                grafo.addAresta(origem, destino, pes);
                
                linha=in.readLine().split(" ");
            }
         arquivo.close();
        }
        }        
        catch (IOException e) { 
            JOptionPane.showMessageDialog(null, "Erro na abertura do arquivo.\n");
        }
        catch (NullPointerException e){         
        }
        
    }
   
    public String caminhoBuscaL(int p){
        String caminho="",aux3;
        int aux1[],aux2[],aux4;
        
        buscal=new BuscaLargura(grafo,p);
        buscal.BFS();
        aux1=buscal.getP();
        aux2=buscal.getD();
        
        for(int i=0;i<numV;i++)
            if(i!=p){
                aux3="("+i+") -->";
                aux4=caminhoBuscaLarg(i,aux1);
                while(aux4 != p){
                aux3=aux3+" ("+aux4+") -->";
                aux4=caminhoBuscaLarg(aux4,aux1);   
                }   
                aux3=aux3+"["+p+"].";
              caminho=caminho+"Caminho de "+i+" ate o vertice raiz :"+aux3+"  Distancia :"+aux2[i]+"\n";
            }
               
        
      return caminho;  
    }
    
    public int caminhoBuscaLarg(int d,int aux1[]){
        int aux=aux1[d];
        return aux;
    }
    
    public void agmPrim(int pai){
       AGMPrim prim = new AGMPrim(grafo,pai);
       prim.Prim();
    }
     
    public void cmcDijkstra(int pai){
        dijk=new CMCDijkstra(grafo,pai);
        dijk.Dijkstra();
        
    }
    
    public void cmcBellmanFord(int pai){
        bellFord=new CMCBellmanFord(grafo,pai);
        bellFord.BellmanFord();
        
    }
    
    public BaseGrafo getGrafo() {
        return grafo;
    }

    public void setGrafo(BaseGrafo grafo) {
        this.grafo = grafo;
    }

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
    
    public void orientadoAciclico(){
        CMCGrafAcic cmc = new CMCGrafAcic(grafo,0);
        cmc.caminhoMinimoGA();
    }
    
    public void setNo(No no){
        this.nos.add(no);
    }
}

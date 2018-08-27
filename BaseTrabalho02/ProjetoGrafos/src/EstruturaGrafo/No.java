
package EstruturaGrafo;

public class No {
    private int vID;
    private int peso=0;
    private No prox;
    private String ptTur;
    
    public No(int vID,int peso){
        this.vID=vID;
        prox=null;
        this.peso=peso;
    }

    public int getvID() {
        return vID;
    }

    public void setvID(int vID) {
        this.vID = vID;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
    
    public void setPtTur(String pt){
        this.ptTur = pt;
    }
    
    public String getPtTur(){
        return ptTur;
    }
    
 }

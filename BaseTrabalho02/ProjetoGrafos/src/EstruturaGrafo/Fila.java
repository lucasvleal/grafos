
package EstruturaGrafo;

import java.util.ArrayList;

public class Fila {
    public ArrayList<Integer> f;
    
    public Fila(){
       f = new ArrayList<Integer>();
    }
    
    public void addFila(int elem){        
        f.add(elem);
    }
    
    public int removeFila(){
        int elem=f.get(0);
        f.remove(0);
        return elem;
    }
    
    public boolean vaziaFila(){
        return f.isEmpty();
    }
    
    public int extraiMinino(int d[]){
        int aux=1000;
        int p=0;
       
        for(int i=0; i<d.length ;i++){        
            if(d[i]<aux){ 
                aux=d[i];
                p=i;System.out.println(aux);
        }
        
        d[p]=1000;
        }
        int m=0;
        for(int i=0;i<f.size();i++){
            if(f.get(i) == p){          
                m=f.get(i);
                f.remove(i);              
            }        
        }
        
        return m;
    }
    
    public void imprimeFile(){
        for(int i=0; i<f.size();i++)
            System.out.println(f.get(i));
    }
}

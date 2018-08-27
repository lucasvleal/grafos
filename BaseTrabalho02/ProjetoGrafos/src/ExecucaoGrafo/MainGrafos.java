
package ExecucaoGrafo;

import DesenhoGrafo.View;

public class MainGrafos {    
    public static void main(String[] args) {        
      java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                View visualizacao = new View();
                visualizacao.setTitle("Trabalho 2 - Grafos");
                visualizacao.setVisible(true);
                
            }
        }); 
    }
    
}

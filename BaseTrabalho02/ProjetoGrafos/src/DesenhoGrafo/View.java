package DesenhoGrafo;

import CorGrafo.RainbowScale;
import ExecucaoGrafo.CMCBellmanFord;
import ExecucaoGrafo.Coloracao;
import ExecucaoGrafo.Conectividade;
import EstruturaGrafo.Grafos;
import EstruturaGrafo.No;
import ExecucaoGrafo.AGMPrim;
import ExecucaoGrafo.BuscaLargura;
import ExecucaoGrafo.BuscaProfundidade;
import EstruturaGrafo.GrafoListaAdj;
import ExecucaoGrafo.OrdemTopo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class View extends javax.swing.JFrame {

    int transposto=0;
    int pts;
    public View() {
        this.view = new ViewPanel();
        //this.view.setGraph(this.graph); 
        initComponents();
        lblOrigem.setVisible(false);
        txtOrigem.setVisible(false);
        btnOrigem.setVisible(false);
        lblDestino.setVisible(false);
        txtDestino.setVisible(false);
        btnDestino.setVisible(false);
        txtCResult.setVisible(false);       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtOrigem = new javax.swing.JTextField();
        btnOrigem = new javax.swing.JButton();
        lblOrigem = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        btnDestino = new javax.swing.JButton();
        lblDestino = new javax.swing.JTextField();
        pnlBorderDesenho = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane(this.view);
        pnlBorderDados = new javax.swing.JPanel();
        scrPExecucao = new javax.swing.JScrollPane();
        txtCResult = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        opcoes_Menu = new javax.swing.JMenu();
        mnCarregarGrafo = new javax.swing.JMenuItem();
        mnSalvarImagem = new javax.swing.JMenuItem();
        algoritmos_Menu = new javax.swing.JMenu();
        mnComponentesConexas = new javax.swing.JMenuItem();
        mnColoracao = new javax.swing.JMenuItem();
        mnAGM = new javax.swing.JMenuItem();
        mnConectividade = new javax.swing.JMenuItem();
        mnTransposicao = new javax.swing.JMenuItem();
        mnBuscaLargura = new javax.swing.JMenuItem();
        mnCaminhoMinimo = new javax.swing.JMenuItem();
        mnOrdemTopologica = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mnAplicacao = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GRAFOS");
        setBackground(new java.awt.Color(0, 0, 0));

        txtOrigem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOrigemFocusGained(evt);
            }
        });

        btnOrigem.setText("Verificar Caminho");
        btnOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrigemActionPerformed(evt);
            }
        });

        lblOrigem.setEditable(false);
        lblOrigem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblOrigem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblOrigem.setText("Ponto de Origem");
        lblOrigem.setBorder(null);
        lblOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblOrigemActionPerformed(evt);
            }
        });

        txtDestino.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDestinoFocusGained(evt);
            }
        });

        btnDestino.setText("Ir");
        btnDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDestinoActionPerformed(evt);
            }
        });

        lblDestino.setEditable(false);
        lblDestino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDestino.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblDestino.setText("Ponto de Destino");
        lblDestino.setBorder(null);
        lblDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblDestinoActionPerformed(evt);
            }
        });

        pnlBorderDesenho.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Representação do Grafo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 204, 0))); // NOI18N

        javax.swing.GroupLayout pnlBorderDesenhoLayout = new javax.swing.GroupLayout(pnlBorderDesenho);
        pnlBorderDesenho.setLayout(pnlBorderDesenhoLayout);
        pnlBorderDesenhoLayout.setHorizontalGroup(
            pnlBorderDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
            .addGroup(pnlBorderDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBorderDesenhoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlBorderDesenhoLayout.setVerticalGroup(
            pnlBorderDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnlBorderDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBorderDesenhoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pnlBorderDados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 204, 0))); // NOI18N

        txtCResult.setEditable(false);
        txtCResult.setColumns(20);
        txtCResult.setRows(5);
        txtCResult.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scrPExecucao.setViewportView(txtCResult);

        javax.swing.GroupLayout pnlBorderDadosLayout = new javax.swing.GroupLayout(pnlBorderDados);
        pnlBorderDados.setLayout(pnlBorderDadosLayout);
        pnlBorderDadosLayout.setHorizontalGroup(
            pnlBorderDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBorderDadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrPExecucao, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBorderDadosLayout.setVerticalGroup(
            pnlBorderDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBorderDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrPExecucao, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );

        opcoes_Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-ARQUIVO.png"))); // NOI18N
        opcoes_Menu.setText("Arquivo");

        mnCarregarGrafo.setText("Carregar Grafo");
        mnCarregarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCarregarGrafoActionPerformed(evt);
            }
        });
        opcoes_Menu.add(mnCarregarGrafo);

        mnSalvarImagem.setText("Salvar Imagem");
        mnSalvarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSalvarImagemActionPerformed(evt);
            }
        });
        opcoes_Menu.add(mnSalvarImagem);

        jMenuBar1.add(opcoes_Menu);

        algoritmos_Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-GRAFOS.png"))); // NOI18N
        algoritmos_Menu.setText("Algoritmos");

        mnComponentesConexas.setText("[Grafos] - Componentes Conexas");
        mnComponentesConexas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnComponentesConexasActionPerformed(evt);
            }
        });
        algoritmos_Menu.add(mnComponentesConexas);

        mnColoracao.setText("[Grafos] - Coloração");
        mnColoracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnColoracaoActionPerformed(evt);
            }
        });
        algoritmos_Menu.add(mnColoracao);

        mnAGM.setText("[Grafos] - Arv. Geradora Mínima");
        mnAGM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAGMActionPerformed(evt);
            }
        });
        algoritmos_Menu.add(mnAGM);

        mnConectividade.setText("[Digrafos] - Conectividade");
        mnConectividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConectividadeActionPerformed(evt);
            }
        });
        algoritmos_Menu.add(mnConectividade);

        mnTransposicao.setText("[Digrafos] - Transposição");
        mnTransposicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTransposicaoActionPerformed(evt);
            }
        });
        algoritmos_Menu.add(mnTransposicao);

        mnBuscaLargura.setText("[Digrafos e Grafos] - Busca em Largura");
        mnBuscaLargura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnBuscaLarguraActionPerformed(evt);
            }
        });
        algoritmos_Menu.add(mnBuscaLargura);

        mnCaminhoMinimo.setText("[Digrafos e Grafos] - Caminho Mínimo");
        mnCaminhoMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCaminhoMinimoActionPerformed(evt);
            }
        });
        algoritmos_Menu.add(mnCaminhoMinimo);

        mnOrdemTopologica.setText("[Digrafos Acíclicos] - Ordenação Topológica");
        mnOrdemTopologica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnOrdemTopologicaActionPerformed(evt);
            }
        });
        algoritmos_Menu.add(mnOrdemTopologica);

        jMenuBar1.add(algoritmos_Menu);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-PtTur.png"))); // NOI18N
        jMenu1.setText("Aplicação");

        mnAplicacao.setText("Pontos Turísticos");
        mnAplicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAplicacaoActionPerformed(evt);
            }
        });
        jMenu1.add(mnAplicacao);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrigem)
                        .addGap(24, 24, 24)
                        .addComponent(lblDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDestino)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlBorderDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlBorderDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(47, 47, 47))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBorderDesenho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBorderDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrigem)
                    .addComponent(lblDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDestino))
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnCarregarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCarregarGrafoActionPerformed
        txtCResult.setText("");
        transposto=0;
        int peso=JOptionPane.showConfirmDialog(null,"O Grafo é ponderado?","Sobre o Grafo",JOptionPane.YES_NO_OPTION);
        if(peso == 1)peso=0;else peso=1;
        
        pts=JOptionPane.showConfirmDialog(null,"Vai Utilizar a nossa Aplicação?","Sobre o Grafo",JOptionPane.YES_NO_OPTION);
        if(pts == 1)pts=0;else pts=1;
        
        JFileChooser fc = new JFileChooser("C:\\Users\\Giovanni\\Desktop\\BaseTrabalho02");
        int result;
        result = fc.showOpenDialog(null);
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getAbsolutePath();
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(filename));
                
                int tipo = Integer.parseInt(in.readLine());
                int nVert = Integer.parseInt(in.readLine());
                this.graph = new Graph(nVert); ///desenho
                this.grafo.criaGrafo(nVert, tipo, peso, new GrafoListaAdj());

                //leitura das arestas
                int vPeso;
                String line;
                while ((line = in.readLine()) != null && line.trim().length() > 0){
                    StringTokenizer t1 = new StringTokenizer(line, " ");
                    int vIni  = Integer.parseInt(t1.nextToken().trim()); //verticeInicial
                    int vFim  = Integer.parseInt(t1.nextToken().trim()); //verticeFinal
                    Vertex vS = this.graph.getVertex().get(vIni);
                    Vertex vT = this.graph.getVertex().get(vFim);            
                                    
                    
                    if(peso == 1){
                    vPeso = Integer.parseInt(t1.nextToken().trim()); // peso             
                    this.grafo.addAresta(vIni, vFim, vPeso); 
                    
                      if(pts == 1){ //se for um grafo apto a aplicacao
                        String ptTur = t1.nextToken().trim(); 
                        if(!ptTur.equals("!")){
                        String dados[] = ptTur.split(";");
                        ptTur = "";
                        
                        for(int k = 0; k < dados.length; k++){
                            ptTur += " " + dados[k];
                            
                        }
                        
                        
                        No no = new No(vIni,0);
                        no.setPtTur(ptTur);                                       
                        this.grafo.setNo(no); //exclui as linhas q tem ! no lugar do pt turistic
                        }
                      }
                    }else{
                    vPeso=0;
                    this.grafo.addAresta(vIni, vFim, 0); //estrutura de dados
                    }
                    
                    Edge e = new Edge(vS, vT, vPeso, tipo); //desenho
                    this.graph.addEdge(e);    //desenho

                }  
                   
                this.view.setGraph(graph);
               
            } catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                //fechar o arquivo
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ex) {
                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_mnCarregarGrafoActionPerformed
    
    private void mnSalvarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSalvarImagemActionPerformed
        txtCResult.setText("");
        JFileChooser dialog = new JFileChooser();
        dialog.setMultiSelectionEnabled(false);
        dialog.setDialogTitle("Save file");
        dialog.setCurrentDirectory(new File("D:\\DANILO\\UNESP\\2012\\Aulas\\Grafos\\Programas"));
        int result = dialog.showDialog(this, "Salvar");
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                String filename = dialog.getSelectedFile().getAbsolutePath();
                this.view.saveToPngImageFile(filename);
            } catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mnSalvarImagemActionPerformed

    private void mnComponentesConexasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnComponentesConexasActionPerformed
        try{
        txtCResult.setText("");
        BuscaProfundidade componentesConexas = new BuscaProfundidade(grafo.getGrafo());
        componentesConexas.DFS();
        int comp[] = componentesConexas.getComponentes(); 
        int numComp = componentesConexas.getNumComp();
        int compStep = 255 / numComp;
        RainbowScale rbS = new RainbowScale();
        for (int i = 0; i < comp.length; i++) {
            this.graph.getVertex().get(i).setColor(rbS.getColor(comp[i] * compStep));
        }
        this.view.cleanImage();
        this.view.repaint();
        txtCResult.setText("");
        }catch (NullPointerException ex) {
           JOptionPane.showMessageDialog(null,"Nenhum Grafo Carregado!");
         }
    }//GEN-LAST:event_mnComponentesConexasActionPerformed

    private void mnColoracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnColoracaoActionPerformed
        try{        
        scrPExecucao.setVisible(true);
        txtCResult.setVisible(true);
        txtCResult.setText("");
        Coloracao coloracao = new Coloracao(grafo.getGrafo());
        
        int cores[]=coloracao.getCores();
        int numCores=coloracao.getNumCores();
        int CorM = 255/numCores;
        RainbowScale rbs= new RainbowScale();
           for(int i=0; i<cores.length;i++){
               //System.out.println("Cor"+cores[i]);
               this.graph.getVertex().get(i).setColor(rbs.getColor(cores[i]*CorM));
           }   
        this.view.cleanImage();
        this.view.repaint();
        txtCResult.setText("");
        txtCResult.setText(" O grafo possui número cromático igual a "+ numCores);
        }catch (NullPointerException ex) {
           JOptionPane.showMessageDialog(null,"Nenhum Grafo Carregado!");
         }
    }//GEN-LAST:event_mnColoracaoActionPerformed
    
    private void apagaArestas(){
        RainbowScale rbs=new RainbowScale(); 
        for(int j=0; j<this.graph.getEdges().size();j++){
            //this.graph.getEdges().get(j).setColor(rbs.getColor(15));
            //this.graph.getEdges().get(j).getSource().setColor(rbs.getColor(15));
            //this.graph.getEdges().get(j).getTarget().setColor(rbs.getColor(15));
            this.graph.getEdges().get(j).setSelected(false);
        }
    }
    
    private void desenhaArestas(){
         for(int j=0; j<this.graph.getEdges().size();j++)
            this.graph.getEdges().get(j).setSelected(true);    
    }
    
    private void mnAGMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAGMActionPerformed
        try{               
        RainbowScale rbs=new RainbowScale();   
             
        txtCResult.setText("");
        AGMPrim prim = new AGMPrim(grafo.getGrafo(),0);
        prim.Prim();
        apagaArestas();
        ArrayList<Integer> camin = prim.getCaminho();
        int pai[] = prim.getPai();
        for(int i = 0;i < camin.size();i++){ 
           for(int j=0; j<this.graph.getEdges().size();j++){
                if((this.graph.getEdges().get(j).getSource().getID() == pai[camin.get(i)] && this.graph.getEdges().get(j).getTarget().getID() == camin.get(i)) || (this.graph.getEdges().get(j).getSource().getID() ==  camin.get(i) && this.graph.getEdges().get(j).getTarget().getID() ==pai[i])){
                    //this.graph.getEdges().get(i).getSource().setColor(rbs.getColor(150));
                    //this.graph.getEdges().get(i).getTarget().setColor(rbs.getColor(150));
                    this.graph.getEdges().get(j).setSelected(true);
                }            
           }
        }
        
        
        txtCResult.setText("");
        this.view.setGraph(this.graph);
        this.view.cleanImage();
        this.view.repaint();
        }catch (NullPointerException ex) {
           JOptionPane.showMessageDialog(null,"Nenhum Grafo Carregado!");
         }
    }//GEN-LAST:event_mnAGMActionPerformed

    private void mnConectividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnConectividadeActionPerformed
        try{
        txtCResult.setVisible(true);
        txtCResult.setText("");
        Conectividade conecta=new Conectividade(grafo.getGrafo());
        conecta.conecta();
        int numFC=conecta.getNumFC();
        int comp[]=conecta.getComp();
        int cor=255/numFC;
        int control[]=new int[comp.length];
        RainbowScale rbs=new RainbowScale();
        
        for(int i=0;i<comp.length;i++) 
             this.graph.getVertex().get(i).setColor(rbs.getColor(comp[i]*cor));        
        
        this.view.cleanImage();
        this.view.repaint();
        txtCResult.setText("");
        txtCResult.setText(" O grafo possui "+ numFC +" componentes fortemente conexas!");
        }catch (NullPointerException ex) {
           JOptionPane.showMessageDialog(null,"Nenhum Grafo Carregado!");
         }
    }//GEN-LAST:event_mnConectividadeActionPerformed

    private void mnTransposicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTransposicaoActionPerformed
        try{            
        txtCResult.setText("");
        if(transposto ==0)
        transposto=1;
        else transposto=0;
      
        this.view.setGraph(graph);
        this.view.cleanImage();
        this.view.repaint();
        }catch (NullPointerException ex) {
           JOptionPane.showMessageDialog(null,"Nenhum Grafo Carregado!");
         }
    }//GEN-LAST:event_mnTransposicaoActionPerformed

    private void mnCaminhoMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCaminhoMinimoActionPerformed
        try{        
        scrPExecucao.setVisible(true);
        txtCResult.setVisible(true);
        txtCResult.setText("");
        apagaArestas();
        int escolha=Integer.valueOf(JOptionPane.showInputDialog("Insira o vértice inicial: "));
        CMCBellmanFord caminMin=new CMCBellmanFord(grafo.getGrafo(),escolha);
        caminMin.BellmanFord();
        int pai[]=caminMin.getPai();
        ArrayList<Integer> camin=caminMin.getCaminho();
        int d[]=caminMin.getD();
        String t = "";
        for(int i=0;i<camin.size();i++){ 
           for(int j=0; j<this.graph.getEdges().size();j++){
                if((this.graph.getEdges().get(j).getSource().getID() == pai[camin.get(i)] && this.graph.getEdges().get(j).getTarget().getID() == camin.get(i)) || (this.graph.getEdges().get(j).getSource().getID() ==  camin.get(i) && this.graph.getEdges().get(j).getTarget().getID() == pai[camin.get(i)])){
                this.graph.getEdges().get(j).setSelected(true); 
                this.view.cleanImage();
                this.view.repaint();
                t=t+"Distancia do vértice ("+escolha+") até o vértice ("+camin.get(i)+"): "+d[camin.get(i)] + "\n";
                }
           }
           
        }
        txtCResult.setText(t);
        this.view.cleanImage();
        this.view.repaint();
        }catch (NullPointerException ex) {
           JOptionPane.showMessageDialog(null,"Nenhum Grafo Carregado!");
         }
    }//GEN-LAST:event_mnCaminhoMinimoActionPerformed
    
    private void apagarVertices(){
        for(int j=0; j<this.graph.getVertex().size();j++)
            this.graph.getVertex().get(j).setSelected(false);
        this.view.cleanImage();
        this.view.repaint();
    }
    
    private void mnBuscaLarguraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnBuscaLarguraActionPerformed
        try{                
        txtCResult.setVisible(true);
        txtCResult.setText("");
        RainbowScale rbs=new RainbowScale();  
        desenhaArestas();
        int escolha=Integer.valueOf(JOptionPane.showInputDialog("Insira o vértice inicial:"));
        apagarVertices();
        BuscaLargura buscaL=new BuscaLargura(grafo.getGrafo(),escolha);
        buscaL.BFS();
        ArrayList<Integer> ordem=buscaL.getOrdem();
        int nivel[]=buscaL.getNivel();
        int numN=buscaL.getIdn();
        String t="";
        int aux;
        for(int j=0;j<numN;j++){
         t=t+"Vértices com distância "+j+": ";
         aux = j*50;
         for(int i=0;i<ordem.size();i++){
           if(nivel[ordem.get(i)]==j){
            this.graph.getVertex().get(ordem.get(i)).setSelected(true);
            this.graph.getVertex().get(ordem.get(i)).setColor(rbs.getColor(aux));
            this.view.cleanImage();
            this.view.repaint();
            
            JOptionPane.showMessageDialog(txtCResult, " Distância: "+j+"| Vértice => ("+ordem.get(i)+")");
            t=t+"("+ordem.get(i)+") ";
           }
         }
         t = t+"\n"; 
        }       
        txtCResult.setText(t);
        this.view.setGraph(this.graph);
        this.view.cleanImage();
        this.view.repaint();
        }catch (NullPointerException ex) {
           JOptionPane.showMessageDialog(null,"Nenhum Grafo carregado!");
         }
    }//GEN-LAST:event_mnBuscaLarguraActionPerformed

    private void mnOrdemTopologicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnOrdemTopologicaActionPerformed
            
        try{
            No vertice;                                     
            Vertex vertex;      
            OrdemTopo oT = new OrdemTopo(grafo.getGrafo());   
            oT.ordenaTopo();
            int ordenado[]=oT.getOrdenado();
            int desloc = 80, i, quant = 0, vertInicial, vertFinal, alturaUp = 120, alturaDown= 180, altura;
            float posVertInicial, posVertFinal, posVertMeio;
            
            for(int j=0;j<ordenado.length;j++){
                vertex = new Vertex();
                vertex = this.graph.getVertexID(ordenado[j]);

                vertex.setX(desloc);
                vertex.setY(195);
                desloc = desloc + 90;
            }
             
            this.graph.getEdges().clear();
            for(i=0;i<this.grafo.getNumV();i++){
                
                No adj = this.grafo.getGrafo().getAdj(i);
                
                while(adj!=null){
                    vertInicial = i;
                    vertFinal = adj.getvID();                    
                    posVertInicial = this.graph.getVertexID(vertInicial).getX();
                    posVertFinal = this.graph.getVertexID(vertFinal).getX();  
             
                    Vertex vertI, vertF;
                    Edge e;
                    
                    vertI = this.graph.getVertex().get(vertInicial);
                    vertF = this.graph.getVertex().get(vertFinal);
        
                    if((posVertFinal - posVertInicial )/2 < 90){
                        e = new Edge(vertI, vertF, 0, this.grafo.getOrientado());
                        e.setCor(false);
                        this.graph.addEdge(e);
                        this.view.cleanImage();
                        this.view.repaint();
                    }
                    else{
                        if(quant < 5 ){
                            if(quant == 0) alturaUp = alturaUp - 20;
                            else alturaUp  = alturaUp - 10;
                            altura = alturaUp;
                        }
                        else{ 
                            if(quant == 4) alturaDown = alturaDown + 40;
                            else alturaDown = alturaDown + 40;
                            altura = alturaDown;
                        }
                        quant++;                        
                        
                        Vertex vInvisivel = new Vertex();
                        vInvisivel.setRay(0);
                        vInvisivel.setX((posVertInicial + posVertFinal)/2);
                        vInvisivel.setY(altura);
                        
                        e = new Edge(vertI, vInvisivel, 0, this.grafo.getOrientado());
                        e.setCor(false);
                        this.graph.addEdge(e); 
                        e = new Edge(vInvisivel, vertF, 0, this.grafo.getOrientado());
                        e.setCor(false);
                        this.graph.addEdge(e); 
                        this.view.cleanImage();
                        this.view.repaint();
                    } 
                    adj = adj.getProx();
                }
            }
            this.view.setGraph(this.graph);
            this.view.cleanImage();
            this.view.repaint();
            }catch (NullPointerException ex) {
             JOptionPane.showMessageDialog(null,"Nenhum Grafo Carregado!");
            }
    }//GEN-LAST:event_mnOrdemTopologicaActionPerformed

    private void mnAplicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAplicacaoActionPerformed
        try{
        if(pts == 1){
        txtCResult.setVisible(true);
        String str ="Pontos Turísticos \n";
         for(int i = 0; i < this.grafo.nos.size();i++ ){
             No no = (No) this.grafo.nos.get(i);
             str += "\n"+ i +"-"+" "+no.getPtTur();
         }
        //txtCResult.setText("Pontos Turísticos \n\n  0- Praça Nacional\n  1- Museu de Artes\n  2- Galeria do Rock\n  3- Estádio Hexa\n  4- Lagoa Azul\n  5- Mansão do Danilo\n"
               // + "  6- Bosque Verdejante \n  7- Parque do povo \n 8- Feira de Automóveis \n 9- Estátua da Libertação \n 10- Restaurante do Chef");
        txtCResult.setText(str);
        lblOrigem.setVisible(true);
        txtOrigem.setVisible(true);
        btnOrigem.setVisible(true);
        lblDestino.setVisible(true);
        txtDestino.setVisible(true);
        btnDestino.setVisible(true);
        }
        else JOptionPane.showMessageDialog(null,"Você Disse que não ia usar a aplicação :(");
        }catch (NullPointerException ex) {
         JOptionPane.showMessageDialog(null,"Nenhum Grafo Carregado!");
        }
    }//GEN-LAST:event_mnAplicacaoActionPerformed

    private void lblOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblOrigemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblOrigemActionPerformed
    
    private void btnOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrigemActionPerformed
        try{
            int o=Integer.parseInt(txtOrigem.getText());
        if(o<0 && o>grafo.getNumV()){
            txtOrigem.setFocusable(true);
            JOptionPane.showMessageDialog(null,"Escolha um Vértice de Origem válido!");
        }else{
            apagarVertices();
            apagaArestas();
            this.view.cleanImage();
            this.view.repaint();
            this.graph.getVertex().get(o).setSelected(true);
            No adj=grafo.getGrafo().getAdj(o);
            while(adj != null){
              this.graph.getVertex().get(adj.getvID()).setSelected(true);
                 for(int j=0;j<this.graph.getEdges().size();j++)
                  if((this.graph.getEdges().get(j).getSource().getID() == o && this.graph.getEdges().get(j).getTarget().getID() == adj.getvID()) || (this.graph.getEdges().get(j).getSource().getID() ==  adj.getvID() && this.graph.getEdges().get(j).getTarget().getID() == o)){
                  this.graph.getEdges().get(j).setSelected(true);
                  this.graph.getEdges().get(j).setCor(false);
                 }
              adj=adj.getProx();
            }
        }
        this.view.setGraph(this.graph);
        this.view.cleanImage();
        this.view.repaint();
        }catch (NumberFormatException ex) {
         JOptionPane.showMessageDialog(null,"Escolha um Vértice de Origem Válido!");
        }     
    }//GEN-LAST:event_btnOrigemActionPerformed

    private void txtOrigemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOrigemFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrigemFocusGained

    private void txtDestinoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDestinoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinoFocusGained

    private void btnDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDestinoActionPerformed
        try{
            int peso=0;
            int d=Integer.parseInt(txtOrigem.getText());
            CMCBellmanFord bf=new CMCBellmanFord(grafo.getGrafo(),d);
            bf.BellmanFord();
            ArrayList<Integer> r = bf.getCamin(Integer.parseInt(txtDestino.getText()));
           /* String t="Pontos Turísticos \n\n  0- Praça Nacional\n  1- Museu de Artes\n  2- Galeria do Rock\n 3- Estádio Hexa\n  4- Lagoa Azul\n  5- Mansão do Danilo" +
                 "\n 6- Bosque Verdejante \n  7- Parque do povo\n 8- Feira de Automóveis \n 9- Estátua da Libertação \n 10- Restaurante do Chef";
           */
           String t ="Pontos Turísticos \n";
            for(int i = 0; i < this.grafo.nos.size();i++ ){
                No no = (No) this.grafo.nos.get(i);
                t += "\n"+ i +"-"+" "+no.getPtTur();
            }
            boolean flag=true;
            if(d<0 && d>grafo.getNumV()){
                txtDestino.setFocusable(true);
                JOptionPane.showMessageDialog(null,"Escolha um Vértice de Origem válido!");
            }else{
            apagarVertices();
            apagaArestas();
            this.view.cleanImage();
            this.view.repaint();
            this.graph.getVertex().get(Integer.parseInt(txtOrigem.getText())).setSelected(true);         
            int aux=Integer.parseInt(txtOrigem.getText());
            int cont = 0;
            if(r!=null){
              for(int i=r.size()-1;i>0;i--){
                  this.graph.getVertex().get(r.get(i)).setSelected(true);
                      for(int j=0;j<this.graph.getEdges().size();j++)
                          if((this.graph.getEdges().get(j).getSource().getID() == aux && this.graph.getEdges().get(j).getTarget().getID() == r.get(i)) || (this.graph.getEdges().get(j).getSource().getID() ==  r.get(i) && this.graph.getEdges().get(j).getTarget().getID() == aux)){
                            this.graph.getEdges().get(j).setSelected(true);
                            this.graph.getEdges().get(j).setCor(false);
                            peso=peso+this.graph.getEdges().get(j).getPeso();
                            this.view.cleanImage();
                            this.view.repaint();
                            cont++;
                          }
                      
                   t=t+"\n\nVocê pode transitar do ponto turístico "+ aux +" até o ponto "+r.get(i);
                   if(i != 1) JOptionPane.showMessageDialog(btnOrigem," Verificando pontos turísticos dentro da rota...");
                   aux=r.get(i);
              }
            t=t+"\n\nVocê conseguirá visitar " + (cont-1) +  " pontos turísticos extras sem sair da sua rota," + "\n a nova rota será de "+peso + "km";
            }
            else
                t=t+" \n\n Não possivel chegar nesse destino.";
                
           
             
            txtCResult.setText(t);
            this.view.setGraph(this.graph);
            this.view.cleanImage();
            this.view.repaint();
            }
        }catch (NumberFormatException ex) {
         JOptionPane.showMessageDialog(null,"Escolha um Vértice de Origem Válido!");
        } 
    }//GEN-LAST:event_btnDestinoActionPerformed

    private void lblDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblDestinoActionPerformed
  
    public class ViewPanel extends JPanel {

        public ViewPanel() {
            this.setBackground(java.awt.Color.WHITE);
            this.setLayout(new FlowLayout(FlowLayout.LEFT));
        }

        @Override
        public void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);

            java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
            ////configuração do rendering para obeter melhor qualidade
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);

            if (graph != null && this.imageBuffer == null) {
                this.imageBuffer = new BufferedImage(graph.getSize().width + 1,
                        graph.getSize().height + 1, BufferedImage.TYPE_INT_RGB);

                java.awt.Graphics2D g2Buffer = this.imageBuffer.createGraphics();
                g2Buffer.setColor(this.getBackground());
                g2Buffer.fillRect(0, 0, graph.getSize().width + 1, graph.getSize().height + 1);

                g2Buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                graph.draw(g2Buffer,transposto);
                g2Buffer.dispose();
            }

            if (this.imageBuffer != null) {
                g2.drawImage(this.imageBuffer, 0, 0, null);
            }
        }

        public void saveToPngImageFile(String filename) throws IOException {
            try {
                //this.paint(this.imageBuffer.getGraphics());
                ImageIO.write(this.imageBuffer, "png", new File(filename));
            } catch (IOException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void setGraph(Graph graph) {
            if (graph != null) {
                this.setPreferredSize(new Dimension(graph.getSize().width * 2,
                        graph.getSize().height * 2));
                this.setSize(new Dimension(graph.getSize().width * 2,
                        graph.getSize().height * 2));

                this.cleanImage();
                this.repaint();
            }
        }

        public Vertex getMarkedVertex() {
            return markedVertex;
        }

        public void cleanImage() {
            this.imageBuffer = null;
        }

        public void adjustPanel() {
            float iniX = graph.getVertex().get(0).getX();
            float iniY = graph.getVertex().get(0).getY();
            float max_x = iniX, max_y = iniX;
            float min_x = iniY, min_y = iniY;
            int zero = graph.getVertex().get(0).getRay() * 5 + 10;

            for (int i = 1; i < graph.getVertex().size(); i++) {
                float x = graph.getVertex().get(i).getX();
                if (max_x < x) {
                    max_x = x;
                } else if (min_x > x) {
                    min_x = x;
                }

                float y = graph.getVertex().get(i).getY();
                if (max_y < y) {
                    max_y = y;
                } else if (min_y > y) {
                    min_y = y;
                }
            }

            for (Vertex v : graph.getVertex()) {
                v.setX(v.getX() + zero - min_x);
                v.setY(v.getY() + zero - min_y);
            }

            Dimension d = this.getSize();
            d.width = (int) max_x + zero;
            d.height = (int) max_y + zero;
            this.setSize(d);
            this.setPreferredSize(d);
        }

        public void markVertices(ArrayList<Vertex> vertices) {
            if (vertices != null) {
                this.cleanMarkedVertices(false);

                //change the vertices' colors
                for (Vertex v : vertices) {
                    v.setSelected(true);
                }

                this.cleanImage();
                this.repaint();
            }
        }

        public void cleanMarkedVertices(boolean cleanVertex) {
            if (graph != null) {
                this.markedVertex = null;

                for (Vertex vertex : graph.getVertex()) {
                    vertex.setSelected(false);

                }
            }

            this.cleanImage();
            this.repaint();
        }

        @Override
        public void setFont(java.awt.Font font) {
            //
        }

        @Override
        public java.awt.Font getFont() {
            return null;// colocar alguma fonte
        }

        @Override
        public void setBackground(Color bg) {
            super.setBackground(bg);

        }
        private java.awt.Color color = java.awt.Color.RED;
        //Used to color based on a document
        private Vertex markedVertex;
        //Used to move the points
        private Vertex selectedVertex;
        //contain the selected vertices which will be moved
        private ArrayList<Vertex> selectedVertices;
        //The image which will be drawn as a graph
        private BufferedImage imageBuffer;
    }
    private ViewPanel view;
    private Graph graph;
    private Grafos grafo = new Grafos();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu algoritmos_Menu;
    private javax.swing.JButton btnDestino;
    private javax.swing.JButton btnOrigem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lblDestino;
    private javax.swing.JTextField lblOrigem;
    private javax.swing.JMenuItem mnAGM;
    private javax.swing.JMenuItem mnAplicacao;
    private javax.swing.JMenuItem mnBuscaLargura;
    private javax.swing.JMenuItem mnCaminhoMinimo;
    private javax.swing.JMenuItem mnCarregarGrafo;
    private javax.swing.JMenuItem mnColoracao;
    private javax.swing.JMenuItem mnComponentesConexas;
    private javax.swing.JMenuItem mnConectividade;
    private javax.swing.JMenuItem mnOrdemTopologica;
    private javax.swing.JMenuItem mnSalvarImagem;
    private javax.swing.JMenuItem mnTransposicao;
    private javax.swing.JMenu opcoes_Menu;
    private javax.swing.JPanel pnlBorderDados;
    private javax.swing.JPanel pnlBorderDesenho;
    private javax.swing.JScrollPane scrPExecucao;
    private javax.swing.JTextArea txtCResult;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtOrigem;
    // End of variables declaration//GEN-END:variables
}

package DesenhoGrafo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;

public class Edge {

    private Color color = Color.WHITE; //Cor da aresta
    private Vertex source; //primeiro vetice da aresta
    private Vertex target; //segundo vertice da aresta
    private Boolean selected = true; //se a aresta está selecionada
    private int peso;
    private int direct; //se a aresta é direcionada
    private boolean cor=true;
    
    public Edge(Vertex source, Vertex target, int peso, int direct) {
        this.source = source;
        this.target = target;
        this.peso=peso;
        this.direct=direct;
    }

    public void draw(java.awt.Graphics2D g2, int transposto) {
        //Combines the color of the two vertex to paint the edge

        if (selected) { //se os vertices estao selecionados
            g2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, 1.0f));
            g2.setStroke(new java.awt.BasicStroke(3.0f));
        } else {
            g2.setStroke(new java.awt.BasicStroke(0.8f));
            if ((this.target.isSelected() && this.source.isSelected())) { 
                g2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, 0.8f));
            }
        }
        
        if(!cor){
            this.color = new Color(150);
        }else{
        this.color = new Color((this.source.getColor().getRed() + this.target.getColor().getRed()) / 2,
                (this.source.getColor().getGreen() + this.target.getColor().getGreen()) / 2,
                (this.source.getColor().getBlue() + this.target.getColor().getBlue()) / 2);
        }
        g2.setColor(this.color);
        
        g2.drawLine(((int) this.source.getX()), ((int) this.source.getY()),
                ((int) this.target.getX()), ((int) this.target.getY()));
        g2.setStroke(new java.awt.BasicStroke(3.0f));

        
        if (isDirect()==1) {
            if(transposto==1){
            drawArrow(g2, new Point((int) target.getX(), (int) target.getY()),
            new Point((int) source.getX(), (int) source.getY()),8,14);
           }else
            drawArrow(g2, new Point((int) source.getX(), (int) source.getY()),
            new Point((int) target.getX(), (int) target.getY()),8,14);
            
        }
        //PESOS
        Point t = new Point((int) source.getX(), (int) source.getY());
        Point s = new Point((int) target.getX(), (int) target.getY());
        float size = 16.0f;
        float r = (float) Math.sqrt(Math.pow(s.x - t.x, 2) + Math.pow(s.y - t.y, 2));
        float cos = (t.x - s.x) / (r);
        float sen = (t.y - s.y) / (r);
        
        int transX = (int) ((t.x + s.x) * 0.5f); //Metade da Reta
        int transY = (int) ((t.y + s.y) * 0.5f);
        Point pa = new Point(Math.round(-sen * size) + (transX), Math.round(cos * size) + (transY));
        Point pb = new Point(Math.round(-sen * -size) + (transX), Math.round(cos * -size) + (transY));
        Point pc = new Point(Math.round(cos * size) + (transX), Math.round(sen * size) + (transY));
        
        if(peso != 0 && selected){
            g2.setFont(new Font("Arial", Font.BOLD, 16));
            g2.drawString(String.valueOf(this.getPeso()),pa.x-2.5f,pa.y+10f);
        }
        g2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, 1.0f));
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getTarget() {
        return target;
    }

    public void setTarget(Vertex target) {
        this.target = target;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    private void drawArrow(Graphics2D g2, Point s, Point t, int size, int deslocamento) {
        float r = (float) Math.sqrt(Math.pow(s.x - t.x, 2) + Math.pow(s.y - t.y, 2));
        float cos = (t.x - s.x) / r;
        float sen = (t.y - s.y) / r;

        float xAB = size + deslocamento;
        float yA = size;
        float yB = -size;

        Point pa = new Point(Math.round(xAB * -cos - yA * -sen) + t.x, Math.round(xAB * -sen + yA * -cos) + t.y);
        Point pb = new Point(Math.round(xAB * -cos - yB * -sen) + t.x, Math.round(xAB * -sen + yB * -cos) + t.y);
        Point pc = new Point(Math.round(deslocamento * -cos) + t.x, Math.round(deslocamento * -sen) + t.y);

        g2.drawLine(pc.x, pc.y, pa.x, pa.y);
        g2.drawLine(pc.x, pc.y, pb.x, pb.y);
    }

    public int isDirect() {
        return direct;
    }

    public void setDirected(int direct) {
        this.direct = direct;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public void setCor(boolean cor) {
        this.cor = cor;
    }
    
}

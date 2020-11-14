package GraficoBarra;

import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;

public class Valores implements Serializable {
    private final PropertyChangeSupport supp = new PropertyChangeSupport(this);
    private int red = 255;
    private int green = 255;
    private int blue = 255;
    
    Barra barra = new Barra();

    
    public Valores() {}

    public Valores(int red, int green, int blue) {
        if (red < 0 || red > 255) {
            throw new IllegalArgumentException("" + red);
        }
        if (green < 0 || green > 255) {
            throw new IllegalArgumentException("" + green);
        }
        if (blue < 0 || blue > 255) {
            throw new IllegalArgumentException("" + blue);
        }
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    
    public Valores(int red, int green, int blue, List<String> titulosX,List<String> titulosY,List<Integer> valores) {
        if (red < 0 || red > 255) {
            throw new IllegalArgumentException("" + red);
        }
        if (green < 0 || green > 255) {
            throw new IllegalArgumentException("" + green);
        }
        if (blue < 0 || blue > 255) {
            throw new IllegalArgumentException("" + blue);
        }
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.barra = new Barra(titulosX, titulosY, valores);
    }

    public List<String> getTitulosX(){
        return barra.getTitulosX();
    }
    public List<String> getTitulosY(){
        return barra.getTitulosY();
    }
    public List<Integer> getValores(){
        return barra.getValores();
    }
    
    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public int getRed() {
        return red;
    }
    
    public Color getColorFondo(){
        return new Color(red,green,blue);
    }
    
    public void setTitulosX(List<String> titulos){
        List<String> old = this.barra.getTitulosX();
        this.barra.setTitulosX(titulos);
        if(titulos != old)
            supp.firePropertyChange("titulosX", old, titulos);
    }
    public void setTitulosY(List<String> titulos){
        List<String> old = this.barra.getTitulosY();
        this.barra.setTitulosY(titulos);
        if(titulos != old)
            supp.firePropertyChange("titulosY", old, titulos);
    }
    public void setValores(List<Integer> valores){
        List<Integer> old = this.barra.getValores();
        this.barra.setValores(valores);
        if(valores != old)
            supp.firePropertyChange("valores", old, valores);
    }
    public void setColorFondo(Color c){
        int oldRed = this.red;
        this.red = c.getRed();
        supp.firePropertyChange("red", oldRed, c.getRed());
        int oldGreen = this.green;
        this.green = c.getGreen();
        supp.firePropertyChange("green", oldGreen, c.getGreen());
        int oldBlue = this.blue;
        this.blue = c.getBlue();
        supp.firePropertyChange("blue", oldBlue, c.getBlue());

    }

    public void setGreen(int green) {
        if (green < 0 || green > 255) {
            throw new IllegalArgumentException("" + green);
        }
        int old = this.green;
        this.green = green;
        if (green != old) {
            supp.firePropertyChange("green", old, green);
        }
    }

    public void setBlue(int blue) {
        if (blue < 0 || blue > 255) {
            throw new IllegalArgumentException("" + blue);
        }
        int old = blue;
        this.blue = blue;
        if (old != blue) {
            supp.firePropertyChange("blue", old, blue);
        }
    }

    public void setRed(int red) {
        if (red < 0 || red > 255) {
            throw new IllegalArgumentException("" + red);
        }
        int old = this.red;
        this.red = red;
        if (old != red) {
            supp.firePropertyChange("red", old, red);
        }
    }

    public Color toColor() {
        return new Color(red, green, blue);
    }



    @Override
    public int hashCode() {
        //evenly distribute 3 byte values across 32 bits
        return red + (green << 12) + (blue << 24);
    }

    public void removePropertyChangeListener(PropertyChangeListener pl) {
        supp.removePropertyChangeListener(pl);
    }

    public void addPropertyChangeListener(PropertyChangeListener pl) {
        supp.addPropertyChangeListener(pl);
    }
}

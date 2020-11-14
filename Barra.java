package GraficoBarra;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Enrique
 */
public class Barra {
       private List<String> titulosX = new ArrayList<>();
    private List<String> titulosY = new ArrayList<>();
    private List<Integer> valores = new ArrayList<>();
    private int x, y;

    public Barra() {
    }
    public Barra(int x,int y) {
        this.x = x;
        this.y = y;
    }
    public Barra(List<String> titulosX,List<String> titulosY,List<Integer> valores) {
        this.titulosX = titulosX;
        this.titulosY = titulosY;
        this.valores = valores;
    }
    public List<String> getTitulosX() {
        return titulosX;
    }

    public void setTitulosX(List<String> titulosX) {
        this.titulosX = titulosX;
    }

    public List<String> getTitulosY() {
        return titulosY;
    }

    public void setTitulosY(List<String> titulosY) {
        this.titulosY = titulosY;
    }

    public List<Integer> getValores() {
        return valores;
    }

    public void setValores(List<Integer> valores) {
        this.valores = valores;
    }
    
    
}

package viewer;

import image.Image;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

public class PaletteRasterImage implements Image {

    private List <Color> palette;
    private int[][] indexesOfColor;
    private int height;
    private int width;

    /* Constructeurs */

    public PaletteRasterImage(Color color, int width, int height){
        this.height = height;
        this.width = width;
        indexesOfColor = new int[height][width];
        palette = new ArrayList<>();
    }

    public PaletteRasterImage(Color[][] pixels){

    }


    /* Méthodes */

    public void createRepresentation(){
        Color[][] image = new Color[getHeight()][getWidth()];
    }
    
    public void setPixelColor(Color color, int x, int y){

    }

    public Color getPixelColor(int x, int y){

    }

    public void setPixelsColor(Color[][] pixels){

    }

    private void setPixelsColor(Color color){
        for(int i=0; i<width;i++) {
            for (int j = 0; j < height; j++) {
                indexesOfColor[j][i] = color;
            }
        }
    }

    public int getWidth(){
        return indexesOfColor.length;
    }

    public int getHeight(){
        return indexesOfColor[0].length;
    }

    protected void setWidth(int width){
        this.width = width;
    }

    protected void setHeight(int height){
        this.height = height;
    }

}

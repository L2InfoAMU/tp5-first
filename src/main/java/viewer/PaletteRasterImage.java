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

        palette.add(color);

    }

    public PaletteRasterImage(Color[][] pixels){
        setPixelsColor(pixels);
    }


    /* Méthodes */

    public void createRepresentation(){
        Color[][] image = new Color[getHeight()][getWidth()];
    }

    public void setPixelColor(Color color, int x, int y) {
        indexesOfColor[x][y] = getPaletteIndexOfColor(color);
    }

    private int getPaletteIndexOfColor(Color color) {
        for (int index = 0; index < getWidth(); index++) {
            if (palette.get(index) == color)
                return index;
        }
        return -1;
    }


    public Color getPixelColor(int x, int y){
        return palette.get(indexesOfColor[y][x]);
    }

    public void setPixelsColor(Color[][] pixels){
        for (int x = 0; x < getWidth(); x++)
            for (int y = 0; y < getHeight(); y++)
                setPixelColor(pixels[x][y], x, y);
    }

    private void setPixelsColor(Color color){
        if (palette.contains(color) != true)
            palette.add(color);
        for (int x = 0; x < getWidth(); x++)
            for (int y = 0; y < getHeight(); y++)
                setPixelColor(color, x, y);
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

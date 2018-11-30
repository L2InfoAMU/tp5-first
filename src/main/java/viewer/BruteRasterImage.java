package viewer;
import image.Image;
import javafx.scene.paint.Color;


/*— BruteRasterImage : dans cette représentation, on stocke pour chaque pixel sa couleur sous la forme
d’un objet Color. Une image de ce type contiendra donc une matrice Color[][] pixels.*/


public class BruteRasterImage implements Image {
    private Color[][] pixels;
    private int height;
    private int width;

    /* Constructeurs */

    public BruteRasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new Color[height][width];

        for(int i=0; i<width;i++) {
            for (int j = 0; j < height; j++) {
                pixels[j][i] = color;
            }
        }
    }

    public BruteRasterImage(Color[][] colors) {
        pixels = colors;
    }


    /* Méthodes */

    public void createRepresentation(){
        Color[][] image = new Color[getHeight()][getWidth()];
    }

    public void setPixelColor(Color color, int x, int y){
        pixels[x][y]=color;
    }

    private void setPixelsColor(Color[][] pixels){
        for(int i=0; i<getWidth();i++)
            for(int j=0; i<getHeight();i++)
                pixels[j][i]=pixels[j][i];
    }

    private void setPixelsColor(Color color){
        for(int i=0; i<getWidth();i++)
            for(int j=0; i<getHeight();i++)
                pixels[j][i]=color;
    }

    protected void setWidth(int width){
        width=getWidth();
    }
    protected void setHeight(int height){
        height=getHeight();
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return pixels[x][y];
    }

    @Override
    public int getWidth() {
        return pixels.length;
    }

    @Override
    public int getHeight() {
        return pixels[0].length;
    }

}
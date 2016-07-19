package IntermediateGame;


import javax.swing.*;
import java.awt.*;

/**
 * Class that holds enemy specific data.
 */
public class Enemy extends Sprite{

    //Static: Use same pic in memory for all sprites in an array.
    //Reduces memory usage.
    private static ImageIcon IMAGE;



    /*
     * Default constructor.
     */
    public Enemy(){
        super();

    }

    //Move with bounds.
    protected void moveInBounds(){
        move();

        //Bounds. (offset by sprite size.)
        if(getX() > (1920 - getWidth()) || getX() < 0){
            setVx(-(getVx()));
        }
        if(getY() > (1080 - getHeight()) || getY() < 0){
            setVy(-(getVy()));
        }
    }



    /*
     * Setters.
     */
    public static void setIMAGE(ImageIcon image) { IMAGE = image; }



    /*
     * Getters.
     */
    //Returns image width, else 20.
    public static int getWidth() {

        if(IMAGE == null)
            return 20;
        else
            return IMAGE.getIconWidth();
    }

    //Returns image height, else 20.
    public static int getHeight() {

        if(IMAGE == null)
            return 20;
        else
            return IMAGE.getIconHeight();
    }



    /*
     * Methods.
     */
    //Method to put graphic onto panel.
    public void paint(Graphics g, JPanel panel){
        if(show){
            if(IMAGE == null){
                g.drawRect(getX(), getY(), 20, 20);
            }
            else{
                IMAGE.paintIcon(panel, g, getX(), getY());
            }
        }
    }
/////
}

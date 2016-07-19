package IntermediateGame;


import javax.swing.*;
import java.awt.*;

/**
 * Class that holds hero specific data.
 */
public class Hero extends Sprite{

    //Static: Use same pic in memory for all sprites in an array.
    //Reduces memory usage.
    private static ImageIcon IMAGE;



    /*
     * Default constructor.
     */
    public Hero(){
        super();

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
    //Method to check for collisions.
    public boolean isCollision(Enemy other){

        Rectangle thisSprite = new Rectangle(getX(), getY(), getWidth(), getHeight());
        Rectangle otherSprite = new Rectangle(other.getX(), other.getY(), other.getWidth(), other.getHeight());

        //See if images intersect.
        return thisSprite.intersects(otherSprite);
    }

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

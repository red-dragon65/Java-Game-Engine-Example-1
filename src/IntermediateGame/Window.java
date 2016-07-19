package IntermediateGame;

//For making windows.
import javax.swing.JFrame;


/**
 * Class to create a window with custom parameters.
 */
public class Window extends JFrame{

    /*
    Default constructor.
     */
    public Window(){

        //Add the display panel to this window.
        add(new Display());

        //Specify the close button action.
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);


        //Set the size of the window.
        setSize(1920, 1080);

        //Prevent user from changing window size.
        setResizable(false);

        //Displays the window to user.
        setVisible(true);
    }



    /**
     * Main method that creates a new instance
     * of the window class.
     */
    public static void main(String args[]){

        //Create a new window.
        new Window();
    }
/////
}
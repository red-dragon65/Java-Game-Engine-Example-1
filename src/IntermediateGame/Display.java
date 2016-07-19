package IntermediateGame;

//Allow drawing to panel.
import java.awt.Graphics;

//For game loop.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Keyboard input listener.
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

//Panel that goes into JFrame.
import javax.swing.*;



/**
 * Class that creates a custom panel to go into
 * a window (JFrame). Holds main gameloop.
 */
public class Display extends JPanel implements ActionListener{


    //Gameloop
    Timer gameLoop;

    //Array to hold enemy sprites.
    private final int num_of_enemies = 100;
    Enemy[] enemies = new Enemy[num_of_enemies];

    //Hero sprite.
    private Hero hero = new Hero();

    //Hero image.
    ImageIcon heroImg = new ImageIcon(getClass().getResource("link.png"));

    //Enemy image.
    ImageIcon enemyImg = new ImageIcon(getClass().getResource("red_chu_chu.png"));

    //Random gen to set enemy location.
    Random rand = new Random();


    /*
     * Default constructor.
     */
    public Display(){

        //Initialize keyboard input.
        addKeyListener(new KeyPressing());

        //Sets the focus to the JPanel (this).
        setFocusable(true);

        //Makes the movement smooth.
        setDoubleBuffered(true);

        //Set panel size. (Set to same size as window).
        setSize(1920, 1080);

        initializeSprites();

        //Create the game loop at 20 milliseconds intervals.
        //1,000 milliseconds in a second. 1,000 / 20 = 50 intervals. A.K.A 50fps.
        gameLoop = new Timer(20, this);
        gameLoop.start();
    }



    /*
     * Method to set sprite data.
     */
    private void initializeSprites(){

        //Set hero image.
        hero.setIMAGE(heroImg);

        //Set hero starting location.
        hero.setX(500);
        hero.setY(500);


        //Create enemies.
        for(int i = 0; i < num_of_enemies; i++){
            enemies[i] = new Enemy();

            enemies[i].setIMAGE(enemyImg);
            enemies[i].setVx(10);
            enemies[i].setVy(5);
            enemies[i].setX((int)(1000 * rand.nextFloat()));
            enemies[i].setY((int)(1000 * rand.nextFloat()));
        }
    }



    /*
     * Game loop timer. Runs at 50 intervals a second.
     */
    public void actionPerformed(ActionEvent e){

        //Makes the hero move.
        hero.move();

        //Make the enemies move.
        for(Enemy s : enemies){
            s.moveInBounds();

            //TODO: put 'isCollision' here for optimization!
        }

        //Check for collisions.
        for(Enemy s : enemies) {

            if(hero.isCollision(s)){

                /**If they instersect, do something.*/

                //* if(other.right > thisSprite.left)
                if((s.getX() + (s.getWidth()) > hero.getX())){
                    //Reverse direction.
                    s.setVx(-(s.getVx()));
                }
                //* if(other.left < thisSprite.right)
                if(s.getX() < (hero.getX() + hero.getWidth())){
                    //Reverse direction.
                    s.setVx(-s.getVx());
                }
            }
        }

        //refreshes the screen.
        repaint();
    }



    /*
     * Draw graphics onto screen using sprite paint method.
     * NOTE: Whatever is painted last will be on top of the other sprites.
     */
    public void paintComponent(Graphics g){
        //Erases the previous screen.
        super.paintComponent(g);

        //Draw enemies.
        for(Enemy s : enemies){
            s.paint(g, this);
        }

        //Draw hero.
        hero.paint(g, this);
    }






    /**
     * Class that reads keyboard input for moving.
     */
    public class KeyPressing extends KeyAdapter{

        /*
         * Event that occurs when the user presses a key.
         * Used to move hero.
         */
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_RIGHT:
                    hero.setVx(10);
                    break;
                case KeyEvent.VK_LEFT:
                    hero.setVx(-10);
                    break;
                case KeyEvent.VK_UP:
                    hero.setVy(-10);
                    break;
                case KeyEvent.VK_DOWN:
                    hero.setVy(10);
                    break;
            }
            repaint();
        }



        /*
         * Event that occurs when the user releases a key.
         * Used to stop the hero.
         */
        public void keyReleased(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_RIGHT:
                    hero.setVx(0);
                    break;
                case KeyEvent.VK_LEFT:
                    hero.setVx(0);
                    break;
                case KeyEvent.VK_UP:
                    hero.setVy(0);
                    break;
                case KeyEvent.VK_DOWN:
                    hero.setVy(0);
                    break;
            }
        }
    }
/////
}
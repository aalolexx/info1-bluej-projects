import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo   
{
    public static final boolean LEAVE_TRACES_ON_GROUND = true;
    public static final boolean LEAVE_TRACE = true;
    private Canvas myCanvas;
    private ArrayList<BouncingBall> balls;
    Random randomizer = new Random();

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500, LEAVE_TRACE);
        drawFrame();
        bounce(5);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numBalls)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        if (LEAVE_TRACES_ON_GROUND)
            myCanvas.drawLine(50, ground, 550, ground);
        else
            myCanvas.drawLine(50, ground+1, 550, ground+1);
            
        balls = new ArrayList<>();
        // create and show the balls
        for (int i = 0; i < numBalls; i++) {
            Color color = new Color(0, 153, (255/numBalls*i));
            int posY = randomizer.nextInt(200);
            BouncingBall temp = new BouncingBall((i * 20) + 50, posY, 16, color, ground, myCanvas);
            temp.draw();
            balls.add(temp);
        }

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50); // small delay
            for (BouncingBall b : balls) {
                b.move();
                if (b.getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
     /**
     * Demonstrate some of the drawing operations that are
     * available on a Canvas object.
     */
    public void drawDemo()
    {
        myCanvas.setFont(new Font("helvetica", Font.BOLD, 14));
        myCanvas.setForegroundColor(Color.red);

        myCanvas.drawString("We can draw text, ...", 20, 30);
        myCanvas.wait(1000);

        myCanvas.setForegroundColor(Color.black);
        myCanvas.drawString("...draw lines...", 60, 60);
        myCanvas.wait(500);
        myCanvas.setForegroundColor(Color.gray);
        myCanvas.drawLine(200, 20, 300, 50);
        myCanvas.wait(500);
        myCanvas.setForegroundColor(Color.blue);
        myCanvas.drawLine(220, 100, 370, 40);
        myCanvas.wait(500);
        myCanvas.setForegroundColor(Color.green);
        myCanvas.drawLine(290, 10, 320, 120);
        myCanvas.wait(1000);

        myCanvas.setForegroundColor(Color.gray);
        myCanvas.drawString("...and shapes!", 110, 90);

        myCanvas.setForegroundColor(Color.red);

        // the shape to draw and move
        int xPos = 10;
        Rectangle rect = new Rectangle(xPos, 150, 30, 20);

        // move the rectangle across the screen
        for(int i = 0; i < 200; i ++) {
            myCanvas.fill(rect);
            myCanvas.wait(10);
            myCanvas.erase(rect);
            xPos++;
            rect.setLocation(xPos, 150);
        }
        // at the end of the move, draw once more so that it remains visible
        myCanvas.fill(rect);
    }
    
    /**
     * Draw a frame around the canvas
     */
    public void drawFrame () {
        int width = (int) myCanvas.getSize().getWidth();
        int height = (int) myCanvas.getSize().getHeight();
        myCanvas.setForegroundColor(Color.black);
        myCanvas.fillRectangle(0, 0, width, height);
        myCanvas.setForegroundColor(Color.white);
        myCanvas.fillRectangle(20, 20, width - 40, height - 40);
    }

}

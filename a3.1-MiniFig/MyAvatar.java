import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Module 3 Week 1 Activity
 * 
 * Uses the MiniFig class to draw a custom avatar.
 * 
 * @author CS121 instructors
 * @author ShaelynnNixonBSU
 */
@SuppressWarnings("serial")
public class MyAvatar extends JPanel
{
	public final int INITIAL_WIDTH = 800;
	public final int INITIAL_HEIGHT = 600;
	
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param canvas The drawing area of the window.
	 */
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);

		/* Store the height and width of the panel at the time
		 * the paintComponent() method is called.
		 */
		int currentHeight = getHeight();
		int currentWidth = getWidth();
		
		/* This is the anchor point for the MiniFig (x,y) -> (mid,top) */
		int mid = currentWidth / 2;
		int top = 50;
		
		/* This is the scaler that is used to calculate the dimensions (height / width) 
		 * of each of the MiniFig components. It uses the Math.min() function to select
		 * the smaller of currentWidth/INITIAL_WIDTH and currentHeight/INITIAL_HEIGHT.
		 * This way all the components are scaled to fit within the smaller of the two 
		 * panel dimensions.
		 */
		double scaleFactor = Math.min(currentWidth/(double)INITIAL_WIDTH,currentHeight/(double)INITIAL_HEIGHT );

		// TODO: 1. Instantiate a new Point object called "anchor". Use "mid" as your x value and
		//       "top" as your y value.
		Point anchor = new Point(mid,top);	


		// TODO: 2. Instantiate a new MiniFig object and give the reference variable a name of a person, 
		//       such as "bob". Use the MiniFig constructor with the following
		//       parameters: MiniFig(g, scaleFactor, anchor)
		
		MiniFig shae = new MiniFig(g,scaleFactor, anchor);
		
		// TODO: 3. Create a new custom Color object. An example is shown below.
		//Color torsoColor = new Color (127,31,31);

		// TODO: 4. Invoke the setTorsoColor(Color color) method on your MiniFig instance.
		//       Use your color object as a parameter to change the shirt color.
		//       This lets you change the color of "bob's" shirt. :)
		//shae.setTorsoColor(torsoColor);
		
		// TODO: 5. Invoke the draw() method on your MiniFig instance. This is where "bob" is displayed on the screen.
		//shae.draw();
		// TODO: 6. Adjust the size of your Avatar's window. Notice how the avatar does not stay grounded
		//       on the grass. To fix this, use the getBaseMidPoint() method to find the the base mid point of your
		//       MiniFig. This method returns a Point object that represents the x,y coordinates at the
		//       base of the MiniFig, right between its feet. 
		//       Replace the hard-coded value of grassYOffset with the y value 
		//       of the returned point.
		//int grassYOffset = 400;

		//DESIGNING THE BACKGROUND
		Point basePoint = shae.getBaseMidPoint();
		Color skyBlue = new Color (156, 204, 255);
		g.setColor(skyBlue);
		g.fillRect(0, 0, currentWidth, currentHeight);
		int grassYOffset = basePoint.y;
		Color grassGreen = new Color (125, 176, 120);
		g.setColor(grassGreen);
		g.fillRect(0, grassYOffset, currentWidth, currentHeight - grassYOffset);
		


		// TODO: 7. Create an Alias of for your MiniFig object and change the torso color of the alias.
		//       If in step 2 you used the variable name "bob", you can create an alias named "robert"
		//       using the following:
		//       MiniFig robert = bob;
		//       robert.setTorsoColor(Color.RED);
		//MiniFig robert = shae;

		//DESIGNING THE MINIFIGURE 
		Color skinColor = new Color(255, 233, 189);
		shae.setHeadColor(skinColor);
		shae.setHandColor(skinColor);
		Color torsoColor = new Color(34, 79, 28);
		shae.setArmColor(torsoColor);
		shae.setTorsoColor(torsoColor);
		Color pantsColor = new Color(0, 0, 0);
		shae.setBeltColor(pantsColor);
		shae.setLegColor(pantsColor);
		shae.setOutlineColor(pantsColor);
		Color shoeColor = new Color(155, 155, 155);
		shae.setFootColor(shoeColor);
		shae.draw();

		
		
	        // TODO: 8. Comment out the draw statement under TODO item 5 and then draw the original MiniFig 
		//       below. If you used the variable name "bob" it would simply be the following:
		//       bob.draw();
		//       What color is Bob's Shirt?  Why?
		//Red because Robert is an alias for Bob (shae in my case) not a duplicate, its two names for the same address. Two references to the same thing.
	}


	/**
	 * Constructor (panel initialization)
	 */
	public MyAvatar()
	{
		setBackground(Color.white);
		setPreferredSize(new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT));
	}

	/**
	 * Sets up a JFrame and the MiniFigDriver panel.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MyAvatar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MyAvatar());
		frame.pack();
		frame.setVisible(true);
	}
}

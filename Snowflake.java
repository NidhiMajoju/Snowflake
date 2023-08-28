import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel
{
	public SnowFlakePanel()
	{
		super.setPreferredSize(new Dimension(400, 400));
		super.setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics g)
	{
		int width  = getWidth();
		int height = getHeight();

		super.paintComponent(g);
		drawBlizzard(g, width, height);
		/* DRAWING CODE BELOW
		 */
		//g.setColor(new Color ((int)(256*Math.random()),(int)(256*Math.random()),(int)(256*Math.random()) ));
		//drawStar(g, width/2, height/2, width/4);

	}
	public void drawStar (Graphics g, int x, int y, int size)
	{

		if (size <= 10)
		{
			return;
		}
		for (int i = 0; i<6; i++)
		{
			g.drawLine(x, y, (int)( size*Math.cos(i*Math.PI/3)) + x, (int) (size*Math.sin (i*Math.PI/3)) +y);
			drawStar(g, (int)( size*Math.cos(i*Math.PI/3)) + x,(int) (size*Math.sin (i*Math.PI/3)) +y , size/3);
		}

	}
	public void drawBlizzard (Graphics g, int x, int y)
	{
		for (int i = 0; i<15; i++)
		{
			g.setColor(new Color ((int)(256*Math.random()),(int)(256*Math.random()),(int)(256*Math.random())));
			drawStar(g, (int)(Math.random()*x), (int)(Math.random()*y), (int)(Math.random()*50));
		}
	}
}


public class Snowflake
{
	public static void main ( String[] args )
	{
		/*
		 * A frame is a container for a panel
		 * The panel is where the drawing will take place
		 */
		JFrame frame = new JFrame("Snowflake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SnowFlakePanel());
		frame.pack();
		frame.setVisible(true);
	}
}
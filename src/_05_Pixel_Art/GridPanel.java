package _05_Pixel_Art;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.JPanel;

public class GridPanel extends JPanel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int windowWidth;
	private int windowHeight;
	private int pixelWidth;
	private int pixelHeight;
	private int rows;
	private int cols;

	// 1. Create a 2D array of pixels. Do not initialize it yet.
	Pixel[][] pixels;

	private Color color;

	public GridPanel(int w, int h, int r, int c) {
		this.windowWidth = w;
		this.windowHeight = h;
		this.rows = r;
		this.cols = c;

		this.pixelWidth = windowWidth / cols;
		this.pixelHeight = windowHeight / rows;

		color = Color.BLACK;

		setPreferredSize(new Dimension(windowWidth, windowHeight));

		// 2. Initialize the pixel array using the rows and cols variables.
		pixels = new Pixel[rows][cols];
		
		for (int rows = 0; rows < pixels.length; rows++) {
			for (int cols = 0; cols < pixels.length; cols++) {

				// 3. Iterate through the array and initialize each element to a new pixel.

				pixels[rows][cols] = new Pixel(rows*pixelHeight, cols*pixelWidth);
			}
		}
	}

	public void setColor(Color c) {
		color = c;
	}

	public void clickPixel(int mouseX, int mouseY) {
		// 5. Use the mouseX and mouseY variables to change the color
		// of the pixel that was clicked. *HINT* Use the pixel's dimensions.
		pixels[mouseX/pixelWidth][mouseY/pixelHeight].color = color;
	}

	@Override
	public void paintComponent(Graphics g) {
		// 4. Iterate through the array.
		// For every pixel in the list, fill in a rectangle using the pixel's color.
		// Then, use drawRect to add a grid pattern to your display.
		for (int rows = 0; rows < pixels.length; rows++) {
			for (int cols = 0; cols < pixels.length; cols++) {
				g.setColor(pixels[rows][cols].color);
				g.fillRect(pixels[rows][cols].x, pixels[rows][cols].y, pixelWidth, pixelHeight);
				g.setColor(Color.black);
				g.drawRect(pixels[rows][cols].x, pixels[rows][cols].y, pixelWidth, pixelHeight);
			}
		}
	}
}

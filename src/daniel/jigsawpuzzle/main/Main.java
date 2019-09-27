package daniel.jigsawpuzzle.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Main extends JFrame implements KeyListener {
	
	Canvas canvas = new Canvas();
	
	BufferedImage[][] tiles = new BufferedImage[4][4];
	
	final int tileWidth = 200;
	
	public static void main(String[] args) {
		new Main();
	}
	
	Main() {
		initImages(createImage());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);
		setTitle("Jigsaw Puzzle");
		setBackground(Color.red);
		
		add(canvas);
		
		setVisible(true);
		canvas.createBufferStrategy(3);
		
		render();
	}
	
	void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		Graphics g = bs.getDrawGraphics();
		g.setColor(getBackground());
		g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
//		for (int x = 0; x < tiles.length; x++) {
//			for (int y = 0; y < tiles[0].length; y++) {
//				if (tiles[x][y] != null) {
//					BufferedImage tile = tiles[x][y];
//					g.drawImage(tile, x * tileWidth, y * tileWidth, null);
//				}
//			}
//		}
		g.drawImage(createImage(), 0, 0, null);
		g.dispose();
		bs.show();
	}
	
	void initImages(BufferedImage wholeImage) {
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {
				BufferedImage tile = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
				int[] colors = new int[200 * 200];
				wholeImage.getRGB(x * 200, y * 200, 200, 200, colors, 0, 200);
				tile.setRGB(0, 0, 200, 200, colors, 0, 200);
				tiles[x][y] = tile;
			}
		}
		for (int x = 0; x < tiles.length; x++)
			for (int y = 0; y < tiles[0].length; y++)
				System.out.println(tiles[x][y]);
	}
	
	BufferedImage createImage() {
		BufferedImage image = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < 800 * 800; i++)
			image.setRGB(i % 800, i / 800, (int) (0xFFFFFF * (i / 160000d)));
		return image;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			
			break;
		case KeyEvent.VK_ENTER:
			
			break;
		}
	}

}

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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);
		setTitle("Jigsaw Puzzle");
		setBackground(new Color(0x5f5f5f));
		
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
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {
				if (tiles[x][y] != null) {
					BufferedImage tile = tiles[x][y];
					g.drawImage(tile, x * tileWidth, y * tileWidth, null);
				}
			}
		}
		g.dispose();
		bs.show();
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

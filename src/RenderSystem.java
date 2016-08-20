import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class RenderSystem extends Canvas implements SystemProcessor{

	private static final long serialVersionUID = 1L;
	private int width,height,tileSize;
	private long fps=0,fpsAvg=0;
	private JFrame frame;
	final double ns = 1000000000.0 / 60;
	double delta = 0.0;
	private long previousGameTick, frameTime=0;
	//private BufferedImage image;
	

	public RenderSystem(int width,int height,int tileSize){
		this.width=width;
		this.height=height;
		this.tileSize=tileSize;		
		
		setPreferredSize(new Dimension(800,800));
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Testing");
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	@Override
	public void processOneTick(long lastFrameTick) {
		BufferStrategy bs = getBufferStrategy();
		if(bs==null){
			createBufferStrategy(2);
			return;
		}
		
		
		
		
		
		Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
		g2d.setColor(Color.CYAN);
		g2d.fillRect(15, 15, 50, 50);
		g2d.dispose();
		bs.show();
		
		fps++;
		if(lastFrameTick-previousGameTick>1000000000){
			previousGameTick=lastFrameTick;
			fpsAvg=fps;
			fps=0;
		}
		frame.setTitle("Testing | " + " FPS: " + fpsAvg );
	}

}

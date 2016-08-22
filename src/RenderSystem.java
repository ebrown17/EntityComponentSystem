import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Collection;

import javax.swing.JFrame;

public class RenderSystem extends Canvas implements SystemProcessor{

	private static final long serialVersionUID = 1L;
	private int width,height,tileSize;
	private long fps=0,fpsAvg=0;
	private JFrame frame;
	final double ns = 1000000000.0 / 60;
	double delta = 0.0;
	private long previousGameTick, frameTime=0;
	private EntityManager em;
	private BufferedImage image;	

	public RenderSystem(int width,int height,int tileSize,EntityManager em){
		this.width=width;
		this.height=height;
		this.tileSize=tileSize;		
		this.em = em;
		this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		setPreferredSize(new Dimension(width,height));
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
		Collection<Renderable> test = em.getAllComponentsOfType(Renderable.class);
		
		Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
		Graphics g =image.getGraphics();
		
		for(Renderable rend : test){	
			g.setColor(rend.tile.color);
			g.fillRect(rend.position.x*5, rend.position.y*5, 5, 5);
		
		}
		g2d.drawImage(image, 0, 0, getWidth(), getHeight(),null);
		g2d.dispose();
		g.dispose();
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

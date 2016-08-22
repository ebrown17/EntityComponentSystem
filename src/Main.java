import java.util.Random;

import map_utils.TileType;

public class Main {

	
	public static void main(String[] args){
		String seed = "TESTers";		
		new WorldManager(25, null).generateWorld(400, 400, seed);
		
		EntityManager em = new EntityManager();
		RenderSystem renderSystem = new RenderSystem(400,400,5,em);
		int count =0;
		for(int i=0; i < 80; i++){
			for(int j=0;j<80; j++) {
				int entity = em.createEntity();
				Position pos = new Position(i,j);
				Renderable r;
				if(count %2 == 0){
					r = new Renderable(pos,TileType.WALL);
				} 
				else {
					r = new Renderable(pos,TileType.CLEAR);
				}
				
				em.addComponent(entity,pos);
				em.addComponent(entity,r);
				count++;
			}			
		}
		
		
		while(true){
			renderSystem.processOneTick(System.nanoTime());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/*EntityManager em = new EntityManager();
		
		for(int i=0; i < 5; i++){
			for(int j=0;j<5; j++) {
				int entity = em.createEntity();				
				em.addComponent(entity, new Position(i,j));
			}			
		}
		
		for(int entity: em.entities){
			
			System.out.println((em.getComponent(entity, Position.class)).x + " " + (em.getComponent(entity, Position.class)).y);
		}*/
		
	}
}

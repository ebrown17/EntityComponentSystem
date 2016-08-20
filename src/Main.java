import java.util.Random;

public class Main {

	
	public static void main(String[] args){
		String seed = "TESTers";
		int stringToLong = seed.hashCode();
		Random worldSeed = new Random(stringToLong);
		
		new WorldManager(25, null).generateWorld(400, 400, seed);
		
		RenderSystem renderSystem = new RenderSystem(25,25,5);
		while(true){
			renderSystem.processOneTick(System.nanoTime());
			try {
				Thread.sleep(200);
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

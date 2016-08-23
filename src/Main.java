import graph_utils.nodes.GridNode;
import map_utils.mazes.RecursiveMaze;

public class Main {

	
	public static void main(String[] args){
		String seed = "TESTers";		
		//RecursiveMaze maze = new WorldManager(25, null).generateWorld(400, 400, seed);
		RecursiveMaze maze = new RecursiveMaze(80,80);
		EntityManager em = new EntityManager();
		RenderSystem renderSystem = new RenderSystem(400,400,5,em);
		
		for(GridNode node : maze.getNodeList()){
			int entity = em.createEntity();
			Position pos = new Position(node.postion.x,node.postion.y);
			Renderable r =  new Renderable(pos,node.tile);
			em.addComponent(entity,pos);
			em.addComponent(entity,r);
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

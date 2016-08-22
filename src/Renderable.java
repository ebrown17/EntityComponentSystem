import java.awt.Color;

import map_utils.TileType;

public class Renderable implements Component{

	public Position position;
	public TileType tile;
	Renderable(Position position,TileType tile){
		this.position=position;
		this.tile = tile;
	}
}

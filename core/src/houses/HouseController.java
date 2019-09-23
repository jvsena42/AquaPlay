package houses;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class HouseController {

    private World world;
    private House house;

    public HouseController(World world) {
        this.world=world;
        createHouse();
    }


    public void createHouse(){
        house = new House(world,"house1");
    }


    public void drawHouse(SpriteBatch batch,float x,float y){
        house.setSpritePosition(x,y);
        batch.draw(house,house.getX(),house.getY());
    }
}

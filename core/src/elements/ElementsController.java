package elements;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class ElementsController {

    private World world;
    private Elements elements;

    public ElementsController(World world) {
        this.world=world;
    }


    public void createHouse(String elementName){
        elements = new Elements(world,elementName);
    }


    public void drawHouse(SpriteBatch batch, String name,float x,float y){
        createHouse(name);
        elements.setSpritePosition(x,y);
        batch.draw(elements, elements.getX(), elements.getY());
    }
}

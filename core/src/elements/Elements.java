package elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.World;

public class Elements extends Sprite {

    public World world;
    public String houseType;

    public Elements(World world, String houseTipe){
        super(new Texture("Elements/"+houseTipe+".png"));
        this.world = world;
        this.houseType = houseTipe;
    }

    public void setSpritePosition(Float x, Float y){
        setPosition(x-getWidth()/2f,y);
    }

    public String getHouseType(){
        return this.houseType;
    }
}

package pipes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

import helper.GameInfo;

public class Pipe extends Sprite {

    private World world;

    private float diameter;
    private float length;
    private String pipeType;


    public Pipe(World world, String pipeType) {
        super(new Texture("Pipes/"+pipeType+".png"));
        this.pipeType = pipeType;
        this.world = world;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getPipeType() {
        return this.pipeType;
    }

    public void setSpritePositionV(Float x, Float y){
        setPosition(x-getWidth()/2f,y);
    }

    public void setSpritePositionH(Float x, Float y){
        setPosition(x,y-getHeight()/2);
    }

}

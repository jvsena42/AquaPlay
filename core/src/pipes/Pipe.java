package pipes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.World;

public class Pipe extends Sprite {

    private World world;

    private float diameter;
    private float length;
    private String pipeType;

    public Pipe(World world, String pipeType){
        super(new Texture("Pipes/"+pipeType+".png"));
        this.world = world;
        this.pipeType = pipeType;
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

}

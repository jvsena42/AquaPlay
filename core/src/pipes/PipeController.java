package pipes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

import elements.Elements;
import helper.GameInfo;

public class PipeController {

    private World world;
    private Pipe pipes;

    public PipeController(World world) {
        this.world=world;
    }


   public void createPipe(String pipeName){
        pipes = new Pipe(world,pipeName);

    }


   public void drawPipe(SpriteBatch batch, String name, float x, float y) {
        createPipe(name);
        pipes.setSpritePosition(x, y);
        batch.draw(pipes, pipes.getX(), pipes.getY());
   }


}

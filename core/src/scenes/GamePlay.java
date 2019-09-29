package scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tcc.aquaplay.GameMain;

import helper.GameInfo;
import elements.ElementsController;
import pipes.PipeController;

public class GamePlay implements Screen {

    private GameMain game;
    private Sprite backGround;

    private OrthographicCamera mainCamera;
    private Viewport gameViewport;

    private World world;

    private ElementsController elementsController;
    private PipeController pipeController;

    public GamePlay(GameMain game) {
        this.game = game;

        mainCamera = new OrthographicCamera(GameInfo.WIDTH,GameInfo.HEIGH);
        mainCamera.position.set(GameInfo.WIDTH/2f,GameInfo.HEIGH/2f,0);

        gameViewport = new StretchViewport(GameInfo.WIDTH,GameInfo.HEIGH,mainCamera);

        world = new World(new Vector2(0,0),true);

        elementsController = new ElementsController(world);
        pipeController = new PipeController(world);


        createBackground();

    }

    public void createBackground(){
        backGround = new Sprite(new Texture("Backgrounds/Game BG.png"));
        backGround.setPosition(0,0);
    }

    public void drawBackgound(){
        game.getBatch().draw(backGround,backGround.getX(),backGround.getY());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();

        drawBackgound();
        elementsController.drawHouse(game.getBatch(),"house1",GameInfo.COORDINATE_2,GameInfo.COORDINATE_A);
        elementsController.drawHouse(game.getBatch(),"house1",GameInfo.COORDINATE_6,GameInfo.COORDINATE_A);
        elementsController.drawHouse(game.getBatch(),"watertank",GameInfo.COORDINATE_4,GameInfo.COORDINATE_F);
        pipeController.drawPipe(game.getBatch(),"cano_topo",GameInfo.COORDINATE_4,GameInfo.COORDINATE_F);

        game.getBatch().end();

        game.getBatch().setProjectionMatrix(mainCamera.combined);
        mainCamera.update();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

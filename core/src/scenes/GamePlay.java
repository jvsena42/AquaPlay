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
import pipes.Pipe;

public class GamePlay implements Screen {

    private GameMain game;
    private Sprite backGround;

    private World world;


    private OrthographicCamera mainCamera;
    private Viewport gameViewport;


    private ElementsController elementsController;

    private Pipe[] pipe;

    public GamePlay(GameMain game) {
        this.game = game;

        mainCamera = new OrthographicCamera(GameInfo.WIDTH,GameInfo.HEIGH);
        mainCamera.position.set(GameInfo.WIDTH/2f,GameInfo.HEIGH/2f,0);

        gameViewport = new StretchViewport(GameInfo.WIDTH,GameInfo.HEIGH,mainCamera);

        world = new World(new Vector2(0,0),true);

        elementsController = new ElementsController(world);

        createPipes();
        createBackground();

    }

    public void createBackground(){
        backGround = new Sprite(new Texture("Backgrounds/Game BG.png"));
        backGround.setPosition(0,0);
    }

    public void drawBackgound(){
        game.getBatch().draw(backGround,backGround.getX(),backGround.getY());
    }

    public void createPipes(){

        pipe = new Pipe[3];
        for (int i=0;i<3;i++){
            pipe[i] = new Pipe(world,"pipe"+i);
        }

    }

    public void drawPipe(){

        pipe[1].setSpritePositionV(GameInfo.COORDINATE_4,GameInfo.COORDINATE_E);
        pipe[2].setSpritePositionH(GameInfo.COORDINATE_4,GameInfo.COORDINATE_E);

        game.getBatch().draw(pipe[1],pipe[1].getX(),pipe[1].getY(),pipe[1].getWidth(),GameInfo.COORDINATE_A);
        game.getBatch().draw(pipe[2],pipe[2].getX(),pipe[2].getY(),GameInfo.COORDINATE_1,pipe[2].getHeight());

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
        elementsController.drawHouse(game.getBatch(),"house1",GameInfo.COORDINATE_5,GameInfo.COORDINATE_E);
        elementsController.drawHouse(game.getBatch(),"watertank",GameInfo.COORDINATE_4,GameInfo.COORDINATE_F);
        drawPipe();

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

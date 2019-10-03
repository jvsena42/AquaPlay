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
        pipe[0].setSpritePosition(GameInfo.COORDINATE_4,GameInfo.COORDINATE_B);
        pipe[1].setSpritePosition(GameInfo.COORDINATE_6,GameInfo.COORDINATE_C);
        pipe[2].setSpritePosition(GameInfo.COORDINATE_1,GameInfo.COORDINATE_D);

        for (int i=0;i<3;i++){
            game.getBatch().draw(pipe[i],pipe[i].getX(),pipe[i].getY());
        }
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

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
import houses.HouseController;

public class GamePlay implements Screen {

    private GameMain game;
    private Sprite backGround;

    private OrthographicCamera mainCamera;
    private Viewport gameViewport;

    private World world;

    private HouseController houseController;

    public GamePlay(GameMain game) {
        this.game = game;

        mainCamera = new OrthographicCamera(GameInfo.WIDTH,GameInfo.HEIGH);
        mainCamera.position.set(GameInfo.WIDTH/2f,GameInfo.HEIGH/2f,0);

        gameViewport = new StretchViewport(GameInfo.WIDTH,GameInfo.HEIGH,mainCamera);

        world = new World(new Vector2(0,0),true);

        houseController = new HouseController(world);

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
        houseController.drawHouse(game.getBatch(),GameInfo.COORDINATE_A,GameInfo.COORDINATE_1);
        houseController.drawHouse(game.getBatch(),GameInfo.COORDINATE_7,GameInfo.COORDINATE_1);
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

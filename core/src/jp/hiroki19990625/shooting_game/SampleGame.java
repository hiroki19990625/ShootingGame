package jp.hiroki19990625.shooting_game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import jp.hiroki19990625.shooting_game.actor.ActorManager;
import jp.hiroki19990625.shooting_game.actor.object.EnemySpawner;
import jp.hiroki19990625.shooting_game.actor.player.Player;
import jp.hiroki19990625.shooting_game.image.ImageManager;

public class SampleGame extends ApplicationAdapter {
    private static SampleGame _instance;

    public ImageManager img;
    public ActorManager actor;

    private SpriteBatch batch;
    private BitmapFont font;
    private Camera camera;
    private Viewport viewport;
    private Player player;

    public static SampleGame getInstance() {
        return _instance;
    }

    @Override
    public void create() {
        if (_instance != null) {
            Gdx.app.error("エラー", "複数のインスタンスを作成できません。");
            return;
        }

        _instance = this;

        Graphics graphics = Gdx.graphics;
        camera = new PerspectiveCamera();
        viewport = new ScalingViewport(Scaling.fit, graphics.getWidth(), graphics.getHeight(), camera);

        batch = new SpriteBatch();
        font = new BitmapFont();

        img = new ImageManager();
        actor = new ActorManager();

        player = new Player();
        actor.addActor(player);

        EnemySpawner spawner = new EnemySpawner();
        actor.addActor(spawner);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        actor.callRender();

        batch.begin();
        actor.callBatchRender(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}

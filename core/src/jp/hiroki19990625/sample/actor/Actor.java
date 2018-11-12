package jp.hiroki19990625.sample.actor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import jp.hiroki19990625.sample.SampleGame;
import jp.hiroki19990625.sample.image.ImageManager;

public abstract class Actor {
    protected Vector2 position;

    public Actor() {
        this.create();
    }

    public abstract void create();

    public abstract void render();

    public abstract void batchRender(SpriteBatch batch);

    public abstract void dispose();

    public void setPosition(Vector2 pos) {
        this.position = pos;
    }

    public ImageManager getImageManager() {
        return SampleGame.getInstance().img;
    }

    public ActorManager getActorManager() {
        return SampleGame.getInstance().actor;
    }
}

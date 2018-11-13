package jp.hiroki19990625.shooting_game.actor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import jp.hiroki19990625.shooting_game.SampleGame;
import jp.hiroki19990625.shooting_game.image.ImageManager;

import java.util.Collection;

public abstract class Actor {
    protected Vector2 position = new Vector2(-5000, -5000);
    protected Circle circle = new Circle(-5000, -5000, 0);

    private boolean isHit;
    private int hitActorHash;

    public Actor() {
        this.create();
    }

    public abstract void create();

    public abstract void render();

    public abstract void batchRender(SpriteBatch batch);

    public abstract void dispose();

    public ImageManager getImageManager() {
        return SampleGame.getInstance().img;
    }

    public ActorManager getActorManager() {
        return SampleGame.getInstance().actor;
    }

    public void updatePosition() {
        circle.setPosition(position.x, position.y);
    }

    public void updateCollision(Collection<Actor> actors) {
        for (Actor actor : actors) {
            if (isHit && hitActorHash != actor.hashCode()) {
                continue;
            }

            if (Intersector.overlaps(circle, actor.circle)) {
                if (!isHit) {
                    onCollisionEnter(actor);
                    isHit = true;
                    hitActorHash = actor.hashCode();
                } else {
                    onCollisionStay(actor);
                }
            } else {
                if (isHit) {
                    onCollisionPass(actor);
                    isHit = false;
                }
            }
        }
    }

    public void onCollisionEnter(Actor actor) {

    }

    public void onCollisionStay(Actor actor) {

    }

    public void onCollisionPass(Actor actor) {

    }
}

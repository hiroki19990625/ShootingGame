package jp.hiroki19990625.shooting_game.actor.enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import jp.hiroki19990625.shooting_game.SampleGame;
import jp.hiroki19990625.shooting_game.actor.Actor;
import jp.hiroki19990625.shooting_game.actor.object.Beem;

public abstract class EnemyBase extends Actor {
    protected int health;

    private boolean isDamage;
    private int damageTime = 3;
    private ShapeRenderer renderer;

    public EnemyBase(Vector2 pos) {
        renderer = new ShapeRenderer();
        circle.setPosition(pos);
        circle.radius = getImage().getWidth() / 2;
    }

    @Override
    public void create() {

    }

    @Override
    public void render() {
        circle.y -= 3;
        if (circle.y <= -getImage().getHeight()) {
            getActorManager().removeActor(hashCode());
        }
    }

    @Override
    public void batchRender(SpriteBatch batch) {
        if (isDamage && damageTime <= 0) {
            damageTime = 3;
            isDamage = false;
        } else if (isDamage) {
            damageTime--;
        } else {
            batch.draw(getImage(), circle.x - circle.radius, circle.y - circle.radius);
        }
        Gdx.app.log("test", circle.toString());
    }

    @Override
    public void onCollisionEnter(Actor actor) {
        if (isDamage) {
            return;
        }

        if (health <= 0) {
            SampleGame.getInstance().player.killCount++;
            getActorManager().removeActor(hashCode());
        }

        if (actor instanceof Beem) {
            isDamage = true;
            health--;
        }
    }

    @Override
    public void dispose() {

    }

    public abstract Texture getImage();
}

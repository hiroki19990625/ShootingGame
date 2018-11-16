package jp.hiroki19990625.shooting_game.actor.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import jp.hiroki19990625.shooting_game.actor.Actor;
import jp.hiroki19990625.shooting_game.actor.enemy.EnemyBase;

public class Beem extends Actor {
    private int destoryTime = 3;
    private boolean isDestroy;

    public Beem(Vector2 pos) {
        circle.setPosition(pos);
        circle.radius = getImageManager().getImage("beem").getWidth() / 2;
    }

    @Override
    public void create() {

    }

    @Override
    public void render() {
        circle.y += 5;

        if (circle.y >= Gdx.graphics.getHeight()) {
            getActorManager().removeActor(hashCode());
        }

        if (isDestroy && destoryTime <= 0) {
            getActorManager().removeActor(hashCode());
        }

        destoryTime--;
    }

    @Override
    public void onCollisionEnter(Actor actor) {
        if (actor instanceof EnemyBase && !isDestroy) {
            isDestroy = true;
        }
    }

    @Override
    public void batchRender(SpriteBatch batch) {
        batch.draw(getImageManager().getImage("beem"), circle.x, circle.y);
    }

    @Override
    public void dispose() {

    }
}

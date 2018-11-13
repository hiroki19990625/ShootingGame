package jp.hiroki19990625.shooting_game.actor.enemy;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import jp.hiroki19990625.shooting_game.SampleGame;
import jp.hiroki19990625.shooting_game.actor.Actor;
import jp.hiroki19990625.shooting_game.actor.object.Beem;

public class SimpleEnemy extends Actor {
    public SimpleEnemy(Vector2 pos) {
        position = pos;
    }

    @Override
    public void create() {
        circle.radius = getImageManager().getImage("simple_enemy").getWidth() / 2;
    }

    @Override
    public void render() {
        position.y -= 3;
        if (position.y <= -getImageManager().getImage("simple_enemy").getHeight()) {
            getActorManager().removeActor(hashCode());
        }
    }

    @Override
    public void batchRender(SpriteBatch batch) {
        batch.draw(getImageManager().getImage("simple_enemy"), position.x, position.y);
    }

    @Override
    public void onCollisionEnter(Actor actor) {
        if (actor instanceof Beem) {
            SampleGame.getInstance().player.killCount++;
            getActorManager().removeActor(hashCode());
        }
    }

    @Override
    public void dispose() {

    }
}

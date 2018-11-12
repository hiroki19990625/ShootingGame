package jp.hiroki19990625.shooting_game.actor.enemy;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import jp.hiroki19990625.shooting_game.actor.Actor;

public class SimpleEnemy extends Actor {
    @Override
    public void create() {

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
    public void dispose() {

    }
}

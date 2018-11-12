package jp.hiroki19990625.shooting_game.actor.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import jp.hiroki19990625.shooting_game.actor.Actor;

public class Beem extends Actor {
    @Override
    public void create() {

    }

    @Override
    public void render() {
        position.y += 5;

        if (position.y >= Gdx.graphics.getHeight()) {
            getActorManager().removeActor(hashCode());
        }
    }

    @Override
    public void batchRender(SpriteBatch batch) {
        batch.draw(getImageManager().getImage("beem"), position.x, position.y);
    }

    @Override
    public void dispose() {

    }
}

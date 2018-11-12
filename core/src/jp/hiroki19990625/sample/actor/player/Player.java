package jp.hiroki19990625.sample.actor.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import jp.hiroki19990625.sample.actor.Actor;
import jp.hiroki19990625.sample.actor.object.Beem;

public class Player extends Actor {
    private final int SHOT_TIME = 10;
    private int shotTime = SHOT_TIME;

    @Override
    public void create() {
        position = new Vector2(0, 20);
    }

    @Override
    public void render() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            if ((position.x - 5) >= 0) {
                position.add(-5, 0);
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            if (position.x <= Gdx.graphics.getWidth() - getImageManager().getImage("player").getWidth()) {
                position.add(5, 0);
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && shotTime >= SHOT_TIME) {
            Beem beem = new Beem();
            Vector2 offset = position.cpy();
            offset.add(0, getImageManager().getImage("beem").getWidth());
            beem.setPosition(offset);
            getActorManager().addActor(beem);

            shotTime = 0;
        }

        shotTime++;
    }

    @Override
    public void batchRender(SpriteBatch batch) {
        batch.draw(getImageManager().getImage("player"), position.x, position.y);
    }

    @Override
    public void dispose() {

    }
}

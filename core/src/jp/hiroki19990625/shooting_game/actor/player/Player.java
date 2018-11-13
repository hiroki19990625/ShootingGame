package jp.hiroki19990625.shooting_game.actor.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import jp.hiroki19990625.shooting_game.SampleGame;
import jp.hiroki19990625.shooting_game.actor.Actor;
import jp.hiroki19990625.shooting_game.actor.object.Beem;

public class Player extends Actor {
    private final int SHOT_TIME = 10;
    public int killCount;

    private int shotTime = SHOT_TIME;
    private int zannki = 2;
    private boolean isGameOver;
    private int damageTextShow = 30;
    private boolean isShowDamageText;

    @Override
    public void create() {
        position = new Vector2((Gdx.graphics.getWidth() - getImageManager().getImage("player").getWidth()) / 2, 20);
        circle.radius = getImageManager().getImage("player").getWidth() / 2;
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

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && shotTime >= SHOT_TIME && !isGameOver) {
            Vector2 offset = position.cpy();
            offset.add(0, getImageManager().getImage("beem").getWidth());
            Beem beem = new Beem(offset);
            getActorManager().addActor(beem);

            shotTime = 0;
        }

        shotTime++;
    }

    @Override
    public void batchRender(SpriteBatch batch) {
        BitmapFont font = SampleGame.getInstance().font;
        Graphics gs = Gdx.graphics;
        if (isGameOver) {
            font.draw(batch, "GameOver", gs.getWidth() / 2, gs.getHeight() / 2);
        } else {
            batch.draw(getImageManager().getImage("player"), position.x, position.y);
        }

        if (isShowDamageText) {
            font.draw(batch, "Damage!!", gs.getWidth() / 2, gs.getHeight() / 2);

            --damageTextShow;
            if (damageTextShow < 0) {
                damageTextShow = 30;
                isShowDamageText = false;
            }
        }

        font.draw(batch, "zannki: " + zannki, 10, gs.getHeight());
        font.draw(batch, "killCount: " + killCount, 10, gs.getHeight() - 20);
    }

    @Override
    public void onCollisionEnter(Actor actor) {
        if (isShowDamageText || actor instanceof Beem || isGameOver) {
            return;
        }

        zannki--;
        isShowDamageText = true;
        if (zannki < 0) {
            isGameOver = true;
        }
    }

    @Override
    public void dispose() {

    }
}

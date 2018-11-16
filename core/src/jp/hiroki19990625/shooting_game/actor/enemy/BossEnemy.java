package jp.hiroki19990625.shooting_game.actor.enemy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BossEnemy extends EnemyBase {
    public BossEnemy(Vector2 pos) {
        super(pos);
        health = 100;
    }

    @Override
    public void render() {
        circle.y -= 0.05f;
        if (circle.y <= -getImage().getHeight()) {
            getActorManager().removeActor(hashCode());
        }
    }

    @Override
    public Texture getImage() {
        return getImageManager().getImage("boss");
    }
}

package jp.hiroki19990625.shooting_game.actor.enemy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import jp.hiroki19990625.shooting_game.SampleGame;

public class SimpleEnemy extends EnemyBase {
    public SimpleEnemy(Vector2 pos) {
        super(pos);
        health = SampleGame.getInstance().random.nextInt(3) + 1;
    }

    @Override
    public Texture getImage() {
        return getImageManager().getImage("simple_enemy");
    }
}

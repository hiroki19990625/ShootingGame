package jp.hiroki19990625.shooting_game.actor.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import jp.hiroki19990625.shooting_game.SampleGame;
import jp.hiroki19990625.shooting_game.actor.Actor;
import jp.hiroki19990625.shooting_game.actor.enemy.BossEnemy;

import java.util.Random;

public class EnemySpawner extends Actor {
    private final int SPAWN_MAX_TIME = 20;

    private Random random;
    private int spawnTime;

    @Override
    public void create() {
        random = SampleGame.getInstance().random;
        spawnTime = random.nextInt(10);

        getActorManager().addActor(new BossEnemy(new Vector2(150, 300)));
    }

    @Override
    public void render() {
        /*if (spawnTime >= SPAWN_MAX_TIME) {
            EnemyBase enemy = new SimpleEnemy(new Vector2(getRandomX(), Gdx.graphics.getHeight()));
            getActorManager().addActor(enemy);

            spawnTime = random.nextInt(20);
        }

        spawnTime++;*/
    }

    @Override
    public void batchRender(SpriteBatch batch) {

    }

    @Override
    public void dispose() {

    }

    private int getRandomX() {
        return random.nextInt(Gdx.graphics.getWidth() - 32);
    }
}

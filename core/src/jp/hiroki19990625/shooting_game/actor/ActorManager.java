package jp.hiroki19990625.shooting_game.actor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ActorManager {
    ConcurrentHashMap<Integer, Actor> actors = new ConcurrentHashMap<>();

    public void addActor(Actor actor) {
        actors.put(actor.hashCode(), actor);
    }

    public void removeActor(int hash) {
        Actor actor = actors.remove(hash);
        if (actor != null)
            actor.dispose();
    }

    public Actor getActor(int hash) {
        return actors.get(hash);
    }

    public void callRender() {
        for (Actor actor : actors.values()) {
            actor.render();
            actor.updateCollision(actors.values().stream().filter(ac -> {
                return ac.hashCode() != actor.hashCode();
            }).collect(Collectors.toList()));
        }
    }

    public void callBatchRender(SpriteBatch batch) {
        for (Actor actor : actors.values()) {
            actor.batchRender(batch);
        }
    }
}

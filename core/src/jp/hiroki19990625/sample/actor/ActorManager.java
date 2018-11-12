package jp.hiroki19990625.sample.actor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ActorManager {
    ConcurrentHashMap<Integer, Actor> actors = new ConcurrentHashMap<>();

    public void addActor(Actor actor) {
        actors.put(actor.hashCode(), actor);
    }

    public void removeActor(int hash) {
        Actor actor = actors.remove(hash);
        actor.dispose();
    }

    public Actor getActor(int hash) {
        return actors.get(hash);
    }

    public void callRender() {
        for (Actor actor : actors.values()) {
            actor.render();
        }
    }

    public void callBatchRender(SpriteBatch batch) {
        for (Actor actor : actors.values()) {
            actor.batchRender(batch);
        }
    }
}

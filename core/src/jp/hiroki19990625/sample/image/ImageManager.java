package jp.hiroki19990625.sample.image;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class ImageManager {
    HashMap<String, Texture> imgs = new HashMap<>();

    public ImageManager() {
        loadImage("player.png", "player");
        loadImage("beem.png", "beem");
        loadImage("simple_enemy.png", "simple_enemy");
    }

    public void loadImage(String path) {
        imgs.put(path, new Texture(path));
    }

    public void loadImage(String path, String name) {
        imgs.put(name, new Texture(path));
    }

    public void loadImage(String key, Texture value) {
        imgs.put(key, value);
    }

    public Texture getImage(String path) {
        return imgs.get(path);
    }
}

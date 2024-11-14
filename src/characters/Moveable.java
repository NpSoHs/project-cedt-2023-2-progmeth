package characters;

import javafx.scene.input.KeyCode;

import java.util.Set;

public interface Moveable {
    void moveCharacter(Set<KeyCode> pressedKeys, int characterSpeed, int[][] map, int blockSize);
}

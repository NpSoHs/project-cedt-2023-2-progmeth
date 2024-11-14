package characters;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.image.ImageView;

import java.util.Set;

public class Salad extends Character {
    public Salad(int initialX, int initialY, int[][] map, int blockSize) {
        super(new ImageView(new Image("/salad.png")), 40, 40, initialX, initialY, map, blockSize, new Image("/salad.png"), new Image("/freezeSalad.png"));
    }

    @Override
    public void moveCharacter(Set<KeyCode> pressedKeys, int characterSpeed, int[][] map, int blockSize) {
        for (KeyCode keyCode : pressedKeys) {
            int newX = getPositionX();
            int newY = getPositionY();
            switch (keyCode) {
                case W:
                    newY -= characterSpeed;
                    break;
                case S:
                    newY += characterSpeed;
                    break;
                case A:
                    newX -= characterSpeed;
                    break;
                case D:
                    newX += characterSpeed;
                    break;
            }

            if (checkItemCollision(map, newX, newY, blockSize)) {
                return;
            }

            if (isFreeze()) {
                return;
            }

            setPositionX(newX);
            setPositionY(newY);
        }
    }

    @Override
    public String toString() {
        return "Salad";
    }
}

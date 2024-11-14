package characters;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.image.ImageView;

import java.util.Set;

public class Croissant extends Character {
    public Croissant(int initialX, int initialY, int[][] map, int blockSize) {
        super(new ImageView(new Image("/croissant.png")), 40, 40, initialX, initialY, map, blockSize, new Image("/croissant.png"), new Image("/freezeCroissant.png"));
    }

    public void moveCharacter(Set<KeyCode> pressedKeys, int characterSpeed, int[][] map, int blockSize) {
        for (KeyCode keyCode : pressedKeys) {
            int newX = getPositionX();
            int newY = getPositionY();
            switch (keyCode) {
                case UP:
                    newY -= characterSpeed;
                    break;
                case DOWN:
                    newY += characterSpeed;
                    break;
                case LEFT:
                    newX -= characterSpeed;
                    break;
                case RIGHT:
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
        return "Croissant";
    }
}

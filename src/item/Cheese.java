package item;

import characters.Character;
import javafx.scene.image.Image;

public class Cheese extends Item {
    public Cheese(int x, int y, int size, Image image) {
        super(x, y, size, image);
    }

    @Override
    public void useItem(Character character) {
        character.setSpeed(3);
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            character.setSpeed(1);
        }).start();
    }

}

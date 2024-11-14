package item;

import characters.Character;
import characters.Croissant;
import characters.Salad;
import javafx.scene.image.Image;

public class Flies extends Item {
    public Flies(int x, int y, int size, Image image) {
        super(x, y, size, image);
    }

    @Override
    public void useItem(Character character) {
        character.setPointToAdd(1);
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            character.setPointToAdd(2);
        }).start();
    }

}

package item;

import characters.Character;
import javafx.scene.image.Image;

public class BananaPeel extends Item {
    public BananaPeel(int x, int y, int size, Image image) {
        super(x, y, size, image);
    }


    @Override
    public void useItem(Character character) {
        character.setFreeze(true);
        System.out.println(character + " Freeze");
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            character.setFreeze(false);
            System.out.println("Freeze gone");
        }).start();
    }
}

package item;

import characters.Character;
import javafx.scene.image.Image;

public class Strawberry extends Item {
    public Strawberry(int x, int y, int size, Image image) {
        super(x, y, size, image);
    }

    @Override
    public void useItem(Character character) {
        character.setPointToAdd(character.getPointToAdd() * 2);
        character.setPointToMinus(character.getPointToMinus() * 2);
        System.out.println("Point *2 !");
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            character.setPointToAdd(character.getPointToAdd() / 2);
            character.setPointToMinus(character.getPointToMinus() / 2);
            System.out.println("Strawberry gone");
        }).start();
    }
}

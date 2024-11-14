package item;

import characters.Character;
import characters.Salad;
import javafx.scene.image.Image;


public class Vegetable extends Item {
    public Vegetable(int x, int y, int size, Image image) {
        super(x, y, size, image);
    }

    @Override
    public void useItem(Character character) {
        if (character instanceof Salad) {
            character.increaseTotalScore(character.getPointToAdd());
        } else {
            character.decreaseTotalScore(character.getPointToMinus());
        }
        System.out.println("score of " + character + " is " + character.getTotalScore());
    }
}


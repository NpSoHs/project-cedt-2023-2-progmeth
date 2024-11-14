package item;


import characters.Character;
import characters.Croissant;
import javafx.scene.image.Image;

public class Butter extends Item {
    public Butter(int x, int y, int size, Image image) {
        super(x, y, size, image);
    }

    @Override
    public void useItem(Character character) {
        if (character instanceof Croissant) {
            character.increaseTotalScore(character.getPointToAdd());
        } else {
            character.decreaseTotalScore(character.getPointToMinus());
        }
        System.out.println("score of " + character + " is " + character.getTotalScore());
    }
}

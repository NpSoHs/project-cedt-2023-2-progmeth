package item;

import characters.Character;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Item {
    protected int x;
    protected int y;
    protected int size;
    protected Image image;

    public Item(int x, int y, int size, Image image) {
        setX(x);
        setY(y);
        setSize(size);
        setImage(image);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public abstract void useItem(Character character);

}

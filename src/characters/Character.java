package characters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import java.util.Set;

import main.GameController;


public abstract class Character implements Moveable {
    private int positionX;
    private int positionY;
    private int blockSize;
    private double width;
    private double height;
    private int[][] map;
    private ImageView imageView;
    private Image baseImage;
    private Image freezeImage;
    private int speed;
    private int totalScore;
    private boolean isFreeze;
    private int pointToMinus;
    private int pointToAdd;


    public Character(ImageView imageView, double width, double height, int initialX, int initialY, int[][] map, int blockSize, Image baseImage, Image freezeImage) {
        setImageView(imageView);
        setWidth(width);
        setHeight(height);
        getImageView().setFitWidth(width);
        getImageView().setFitHeight(height);
        setPositionX(initialX);
        setPositionY(initialY);
        setMap(map);
        setBlockSize(blockSize);
        setTotalScore(0);
        setSpeed(1);
        setFreeze(false);
        setPointToAdd(2);
        setPointToMinus(2);
        setBaseImage(baseImage);
        setFreezeImage(freezeImage);
    }


    // เมทอดเพิ่มคะแนน
    public void increaseTotalScore(int increaseScore) {
        setTotalScore(getTotalScore() + increaseScore);
    }

    public void decreaseTotalScore(int decreaseScore) {
        setTotalScore(getTotalScore() - decreaseScore);
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }


    public void setBaseImage(Image baseImage) {
        this.baseImage = baseImage;
    }


    public void setFreezeImage(Image freezeImage) {
        this.freezeImage = freezeImage;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public void setPointToMinus(int pointToMinus) {
        this.pointToMinus = pointToMinus;
    }

    public void setPointToAdd(int pointToAdd) {
        this.pointToAdd = pointToAdd;
    }

    public int getPointToMinus() {
        return pointToMinus;
    }

    public int getPointToAdd() {
        return pointToAdd;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = Math.max(0, speed);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setTotalScore(int score) {
        this.totalScore = Math.max(0, score);
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    public boolean isFreeze() {
        return isFreeze;
    }

    public void setFreeze(boolean freeze) {
        isFreeze = freeze;
    }

    public boolean checkItemCollision(int[][] map, int x, int y, int blockSize) {
        int playerRow = y / blockSize;
        int playerCol = x / blockSize;
        for (int type = 1; type <= 7; type++) {
            for (int i = playerRow; i < (y + getHeight()) / blockSize; i++) {
                for (int j = playerCol; j < (x + getWidth()) / blockSize; j++) {
                    if (map[i][j] == type && type == 1) return true;

                    if (map[i][j] == type) {
                        GameController.getInstance().useItem(GameController.getInstance().checkTypeFood(type), this);
                        map[i][j] = 0;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public abstract void moveCharacter(Set<KeyCode> pressedKeys, int characterSpeed, int[][] map, int blockSize);

    public void render(GraphicsContext gc) {
        if (isFreeze) {
            setImageView(new ImageView(freezeImage));
        } else {
            setImageView(new ImageView(baseImage));
        }
        getImageView().setFitHeight(1);
        getImageView().setFitWidth(1);
        gc.drawImage(getImageView().getImage(), getPositionX(), getPositionY(), width, height);
    }
}


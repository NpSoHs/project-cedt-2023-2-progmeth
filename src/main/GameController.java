package main;

import Pane.GamePanel;
import characters.Character;
import characters.Croissant;
import characters.Salad;
import item.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import utils.Config;
import utils.Goto;

import java.util.HashSet;
import java.util.Set;

public class GameController {

    private static GameController instance;

    // Constants
    private final int BLOCK_SIZE = Config.BLOCK_SIZE;
    private final int N_BLOCKS = Config.N_BLOCKS;
    private final int SCREEN_SIZE = Config.SCREEN_SIZE;
    private final int MAP_ROW = N_BLOCKS;
    private final int MAP_COL = N_BLOCKS;

    // Map
    private final int[][] MAP = new int[MAP_ROW][MAP_COL];
    private boolean isEnd = false;
    private final short[] LEVELDATA = {
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 9, 9, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 9, 9, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 9, 9, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 9, 9, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 9, 9, 9, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 9, 9, 9, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 9, 9, 9, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 9, 9, 9, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    }; //1eit 2butter 3banana 4veg 5.strawberry 6.cheese

    // Characters and Items
    private Salad salad;
    private Croissant croissant;
    private Vegetable vegetable;
    private Butter butter;
    private Strawberry strawberry;
    private Cheese cheese;
    private Flies fly;
    private BananaPeel bananaPeel;
    private int vegInMap = 15;
    private int croissantInMap = 15;

    // Images
    private Image butterImage = new Image("/butter.png");
    private Image bananaImage = new Image("/banana.png");
    private Image strawberryImage = new Image("/strawberry.png");
    private Image cheeseImage = new Image("/cheese.png");
    private Image flyImage = new Image("/flies.png");
    private Image vegetableImage = new Image("/vegetable.png");
    private final Image background = new Image("/bg.png");
    private final Image eit = new Image("/brick.png");


    //Getter Setter
    public int getBLOCK_SIZE() {
        return BLOCK_SIZE;
    }

    public int getSCREEN_SIZE() {
        return SCREEN_SIZE;
    }

    public int getMAP_ROW() {
        return MAP_ROW;
    }

    public int getMAP_COL() {
        return MAP_COL;
    }

    public int[][] getMAP() {
        return MAP;
    }

    public Set<KeyCode> getPressedKeys() {
        return pressedKeys;
    }


    // Getter/Setter Character and Items
    public Salad getSalad() {
        return salad;
    }


    public Croissant getCroissant() {
        return croissant;
    }

    //  Getter/Setter Character Images and Item Images
    public Image getButterImage() {
        return butterImage;
    }


    public Image getStrawberryImage() {
        return strawberryImage;
    }


    public Image getBananaImage() {
        return bananaImage;
    }


    public Image getFlyImage() {
        return flyImage;
    }


    public Image getCheeseImage() {
        return cheeseImage;
    }


    public Image getVegImage() {
        return vegetableImage;
    }


    public Image getBackground() {
        return background;
    }

    public Image getEit() {
        return eit;
    }

    public short[] getLEVELDATA() {
        return LEVELDATA;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    Sound sound = new Sound();


    // Input handling
    private final Set<KeyCode> pressedKeys = new HashSet<>();

    // Singleton pattern
    public static GameController getInstance() {
        if (instance == null) instance = new GameController();
        return instance;
    }

    // Initialization
    private void initGame(Stage primaryStage) {
        setEnd(false);
        initMap();
        randomItem();
        initCharacters();
        primaryStage.show();
    }

    public void initGame() {
        setEnd(false);
        initMap();
        randomItem();
        initCharacters();
        GamePanel.updateCroissantScoreLabel(0);
        GamePanel.updateSaladScoreLabel(0);
    }

    // Input handling
    public void handleInput(KeyCode code) {
        if (code == KeyCode.SPACE) {
            initGame();
        } else {
            pressedKeys.add(code);
        }
    }

    // Map initialization
    private void initMap() {
        int count = 0;
        for (int row = 0; row < MAP_ROW; row++) {
            for (int col = 0; col < MAP_COL; col++) {
                MAP[row][col] = LEVELDATA[count];
                count++;
            }
        }
    }

    // Character initialization
    private void initCharacters() {
        salad = new Salad(2 * BLOCK_SIZE, 2 * BLOCK_SIZE, MAP, BLOCK_SIZE);
        croissant = new Croissant(17 * BLOCK_SIZE, 17 * BLOCK_SIZE, MAP, BLOCK_SIZE);
        vegetable = new Vegetable(5 * BLOCK_SIZE, 5 * BLOCK_SIZE, BLOCK_SIZE, vegetableImage);
        butter = new Butter(15 * BLOCK_SIZE, 15 * BLOCK_SIZE, BLOCK_SIZE, butterImage);
        bananaPeel = new BananaPeel(5 * BLOCK_SIZE, 5 * BLOCK_SIZE, BLOCK_SIZE, bananaImage);
        strawberry = new Strawberry(5 * BLOCK_SIZE, 5 * BLOCK_SIZE, BLOCK_SIZE, strawberryImage);
        cheese = new Cheese(5 * BLOCK_SIZE, 5 * BLOCK_SIZE, BLOCK_SIZE, cheeseImage);
        fly = new Flies(5 * BLOCK_SIZE, 5 * BLOCK_SIZE, BLOCK_SIZE, cheeseImage);
        vegInMap = 15;
        croissantInMap = 15;
    }

    // Item usage
    public void useItem(Item item, Character character) {
        if (item == null) return;
        item.useItem(character);
        if (item instanceof Butter) {
            croissantInMap--;
        } else if (item instanceof Vegetable) {
            vegInMap--;
        }

        if (vegInMap == 0 && croissantInMap == 0) {
            setEnd(true);
            Goto.popUpEnd(checkWinnerCharacter(), checkTie());
        }
        GamePanel.updateSaladScoreLabel(getSalad().getTotalScore());
        GamePanel.updateCroissantScoreLabel(getCroissant().getTotalScore());
    }

    private boolean checkTie() {
        return (croissant.getTotalScore() == salad.getTotalScore());
    }

    private Character checkWinnerCharacter() {
        if (croissant.getTotalScore() > salad.getTotalScore()) return croissant;
        return salad;
    }

    // Item type check
    public Item checkTypeFood(int typeFood) {
        System.out.println("type food is " + typeFood);
        if (typeFood == 2) {
            return butter;
        } else if (typeFood == 3) {
            return bananaPeel;
        } else if (typeFood == 4) {
            return vegetable;
        } else if (typeFood == 5) {
            return strawberry;
        } else if (typeFood == 6) {
            return cheese;
        } else if (typeFood == 7) {
            return fly;
        } else {
            return null;
        }
    }

    // Random item placement
    public void randomItem() {
        // Define item counts and types
        int butterCount = 15;
        int bananaPeelCount = 5;
        int vegetableCount = 15;
        int strawberryCount = 5;
        int cheeseCount = 5;
        int flyCount = 5;

        // Loop to place items randomly
        for (int i = 0; i < butterCount + bananaPeelCount + vegetableCount + strawberryCount + cheeseCount + flyCount; i++) {
            int randomRow, randomCol;

            do {
                // Generate random coordinates within map boundaries
                randomRow = (int) (Math.random() * MAP_ROW);
                randomCol = (int) (Math.random() * MAP_COL);

                // Check if the position is empty (0) and not a wall (1) or exit (9)
            } while (MAP[randomRow][randomCol] != 0);

            // Determine random item type
            if (i < butterCount) {
                MAP[randomRow][randomCol] = 2;
            } else if (i < butterCount + bananaPeelCount) {
                MAP[randomRow][randomCol] = 3;
            } else if (i < butterCount + bananaPeelCount + vegetableCount) {
                MAP[randomRow][randomCol] = 4;
            } else if (i < butterCount + bananaPeelCount + vegetableCount + strawberryCount) {
                MAP[randomRow][randomCol] = 5;
            } else if (i < butterCount + bananaPeelCount + vegetableCount + strawberryCount + cheeseCount) {
                MAP[randomRow][randomCol] = 6;
            } else {
                MAP[randomRow][randomCol] = 7;
            }

        }
    }

    // Update game state
    public boolean update() {
        if (isEnd()) return true;
        salad.moveCharacter(pressedKeys, salad.getSpeed(), MAP, BLOCK_SIZE);
        croissant.moveCharacter(pressedKeys, croissant.getSpeed(), MAP, BLOCK_SIZE);
        return false;
    }

    // Start game
    public void start(Stage primaryStage) {
        initGame(primaryStage);
    }


    public void clear() {
        instance = null;
        System.out.println("eiei");
    }

}
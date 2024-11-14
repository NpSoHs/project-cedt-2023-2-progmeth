package main;

import characters.Character;
import javafx.scene.canvas.GraphicsContext;

public class Renderer {

    public static void render(GraphicsContext gc, GameController gameController) {
        gc.clearRect(0, 0, gameController.getSCREEN_SIZE(), gameController.getSCREEN_SIZE());
        renderMap(gc, gameController);
        renderCharacters(gc, gameController);
//        renderScore(gc, gameController);
    }

    private static void renderMap(GraphicsContext gc, GameController gameController) {
        for (int row = 0; row < gameController.getMAP_ROW(); row++) {
            for (int col = 0; col < gameController.getMAP_COL(); col++) {
                int cellValue = gameController.getMAP()[row][col];
                switch (cellValue) {
                    case 1:
                        gc.drawImage(gameController.getEit(), col * gameController.getBLOCK_SIZE(), row * gameController.getBLOCK_SIZE(), gameController.getBLOCK_SIZE(), gameController.getBLOCK_SIZE());
                        break;
                    case 2:
                        gc.drawImage(gameController.getButterImage(), col * gameController.getBLOCK_SIZE(), row * gameController.getBLOCK_SIZE(), gameController.getBLOCK_SIZE(), gameController.getBLOCK_SIZE());
                        break;
                    case 3:
                        gc.drawImage(gameController.getBananaImage(), col * gameController.getBLOCK_SIZE(), row * gameController.getBLOCK_SIZE(), gameController.getBLOCK_SIZE(), gameController.getBLOCK_SIZE());
                        break;
                    case 4:
                        gc.drawImage(gameController.getVegImage(), col * gameController.getBLOCK_SIZE(), row * gameController.getBLOCK_SIZE(), gameController.getBLOCK_SIZE(), gameController.getBLOCK_SIZE());
                        break;
                    case 5:
                        gc.drawImage(gameController.getStrawberryImage(), col * gameController.getBLOCK_SIZE(), row * gameController.getBLOCK_SIZE(), gameController.getBLOCK_SIZE(), gameController.getBLOCK_SIZE());
                        break;
                    case 6:
                        gc.drawImage(gameController.getCheeseImage(), col * gameController.getBLOCK_SIZE(), row * gameController.getBLOCK_SIZE(), gameController.getBLOCK_SIZE(), gameController.getBLOCK_SIZE());
                        break;
                    case 7:
                        gc.drawImage(gameController.getFlyImage(), col * gameController.getBLOCK_SIZE(), row * gameController.getBLOCK_SIZE(), gameController.getBLOCK_SIZE(), gameController.getBLOCK_SIZE());

                    default:
                        break;
                }
            }
        }
    }

    private static void renderCharacters(GraphicsContext gc, GameController gameController) {
        renderCharacter(gc, gameController.getSalad());
        renderCharacter(gc, gameController.getCroissant());
        // เพิ่มตัวละครอื่นๆ ตามต้องการ
    }


    private static void renderCharacter(GraphicsContext gc, Character character) {
        character.render(gc);
    }
}

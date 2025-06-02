import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ChessBoardGenerator {
    public static void main(String[] args) {
        int tileSize = 50;
        int boardSize = 8;
        int imageSize = tileSize * boardSize;
        BufferedImage image = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_RGB);


        Graphics g = image.getGraphics();


        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
            }
        }
        g.dispose();

        try {
            File outputFile = new File("chessboard.png");
            ImageIO.write(image, "png", outputFile);
            System.out.println("Chessboard image saved as " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving the image: " + e.getMessage());
        }
    }
}

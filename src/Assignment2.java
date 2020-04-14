
import java.io.*;

public class Assignment2 {

    public static void main(String[] args) {

        try {
            FileInputStream yoda = new FileInputStream("yoda.raw");
            int x = 0;
            int y = 0;
            int w = 123;
            int h = 62;

            int[][] image = new int[h][w];
            int[][] enlarge = new int[h * 3][w * 3];

            int value;
            while ((value = yoda.read()) != -1) {
                if (y == 123) {
                    y = 0;
                    x++;
                }
                image[x][y] = value;
                y++;
            }

            for (int j = 0; j < image.length; j++) {
                for (int i = 0; i < image[j].length; i++) {
                    if (image[j][i] >= 0 && image[j][i] <= 25) {
                        enlarge[j * 3 + 0][i * 3 + 0] = 0;
                        enlarge[j * 3 + 0][i * 3 + 1] = 0;
                        enlarge[j * 3 + 0][i * 3 + 2] = 0;
                        enlarge[j * 3 + 1][i * 3 + 0] = 0;
                        enlarge[j * 3 + 1][i * 3 + 1] = 0;
                        enlarge[j * 3 + 1][i * 3 + 2] = 0;
                        enlarge[j * 3 + 2][i * 3 + 0] = 0;
                        enlarge[j * 3 + 2][i * 3 + 1] = 0;
                        enlarge[j * 3 + 2][i * 3 + 2] = 0;
                    }
                    if (image[j][i] >= 26 && image[j][i] <= 50) {
                        enlarge[j * 3 + 0][i * 3 + 0] = 0;
                        enlarge[j * 3 + 0][i * 3 + 1] = 0;
                        enlarge[j * 3 + 0][i * 3 + 2] = 0;
                        enlarge[j * 3 + 1][i * 3 + 0] = 0;
                        enlarge[j * 3 + 1][i * 3 + 1] = 0;
                        enlarge[j * 3 + 1][i * 3 + 2] = 0;
                        enlarge[j * 3 + 2][i * 3 + 0] = 0;
                        enlarge[j * 3 + 2][i * 3 + 1] = 0;
                        enlarge[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (image[j][i] >= 51 && image[j][i] <= 75) {
                        enlarge[j * 3 + 0][i * 3 + 0] = 255;
                        enlarge[j * 3 + 0][i * 3 + 1] = 0;
                        enlarge[j * 3 + 0][i * 3 + 2] = 0;
                        enlarge[j * 3 + 1][i * 3 + 0] = 0;
                        enlarge[j * 3 + 1][i * 3 + 1] = 0;
                        enlarge[j * 3 + 1][i * 3 + 2] = 0;
                        enlarge[j * 3 + 2][i * 3 + 0] = 0;
                        enlarge[j * 3 + 2][i * 3 + 1] = 0;
                        enlarge[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (image[j][i] >= 76 && image[j][i] <= 100) {
                        enlarge[j * 3 + 0][i * 3 + 0] = 255;
                        enlarge[j * 3 + 0][i * 3 + 1] = 0;
                        enlarge[j * 3 + 0][i * 3 + 2] = 255;
                        enlarge[j * 3 + 1][i * 3 + 0] = 0;
                        enlarge[j * 3 + 1][i * 3 + 1] = 0;
                        enlarge[j * 3 + 1][i * 3 + 2] = 0;
                        enlarge[j * 3 + 2][i * 3 + 0] = 0;
                        enlarge[j * 3 + 2][i * 3 + 1] = 0;
                        enlarge[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (image[j][i] >= 101 && image[j][i] <= 125) {
                        enlarge[j * 3 + 0][i * 3 + 0] = 255;
                        enlarge[j * 3 + 0][i * 3 + 1] = 0;
                        enlarge[j * 3 + 0][i * 3 + 2] = 255;
                        enlarge[j * 3 + 1][i * 3 + 0] = 0;
                        enlarge[j * 3 + 1][i * 3 + 1] = 0;
                        enlarge[j * 3 + 1][i * 3 + 2] = 0;
                        enlarge[j * 3 + 2][i * 3 + 0] = 255;
                        enlarge[j * 3 + 2][i * 3 + 1] = 0;
                        enlarge[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (image[j][i] >= 126 && image[j][i] <= 150) {
                        enlarge[j * 3 + 0][i * 3 + 0] = 255;
                        enlarge[j * 3 + 0][i * 3 + 1] = 0;
                        enlarge[j * 3 + 0][i * 3 + 2] = 255;
                        enlarge[j * 3 + 1][i * 3 + 0] = 0;
                        enlarge[j * 3 + 1][i * 3 + 1] = 0;
                        enlarge[j * 3 + 1][i * 3 + 2] = 0;
                        enlarge[j * 3 + 2][i * 3 + 0] = 255;
                        enlarge[j * 3 + 2][i * 3 + 1] = 255;
                        enlarge[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (image[j][i] >= 151 && image[j][i] <= 175) {
                        enlarge[j * 3 + 0][i * 3 + 0] = 255;
                        enlarge[j * 3 + 0][i * 3 + 1] = 0;
                        enlarge[j * 3 + 0][i * 3 + 2] = 255;
                        enlarge[j * 3 + 1][i * 3 + 0] = 255;
                        enlarge[j * 3 + 1][i * 3 + 1] = 0;
                        enlarge[j * 3 + 1][i * 3 + 2] = 0;
                        enlarge[j * 3 + 2][i * 3 + 0] = 255;
                        enlarge[j * 3 + 2][i * 3 + 1] = 255;
                        enlarge[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (image[j][i] >= 176 && image[j][i] <= 200) {
                        enlarge[j * 3 + 0][i * 3 + 0] = 255;
                        enlarge[j * 3 + 0][i * 3 + 1] = 255;
                        enlarge[j * 3 + 0][i * 3 + 2] = 255;
                        enlarge[j * 3 + 1][i * 3 + 0] = 255;
                        enlarge[j * 3 + 1][i * 3 + 1] = 0;
                        enlarge[j * 3 + 1][i * 3 + 2] = 0;
                        enlarge[j * 3 + 2][i * 3 + 0] = 255;
                        enlarge[j * 3 + 2][i * 3 + 1] = 255;
                        enlarge[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (image[j][i] >= 201 && image[j][i] <= 225) {
                        enlarge[j * 3 + 0][i * 3 + 0] = 255;
                        enlarge[j * 3 + 0][i * 3 + 1] = 255;
                        enlarge[j * 3 + 0][i * 3 + 2] = 255;
                        enlarge[j * 3 + 1][i * 3 + 0] = 255;
                        enlarge[j * 3 + 1][i * 3 + 1] = 0;
                        enlarge[j * 3 + 1][i * 3 + 2] = 255;
                        enlarge[j * 3 + 2][i * 3 + 0] = 255;
                        enlarge[j * 3 + 2][i * 3 + 1] = 255;
                        enlarge[j * 3 + 2][i * 3 + 2] = 255;
                    }
                    if (image[j][i] >= 226 && image[j][i] <= 255) {
                        enlarge[j * 3 + 0][i * 3 + 0] = 255;
                        enlarge[j * 3 + 0][i * 3 + 1] = 255;
                        enlarge[j * 3 + 0][i * 3 + 2] = 255;
                        enlarge[j * 3 + 1][i * 3 + 0] = 255;
                        enlarge[j * 3 + 1][i * 3 + 1] = 255;
                        enlarge[j * 3 + 1][i * 3 + 2] = 255;
                        enlarge[j * 3 + 2][i * 3 + 0] = 255;
                        enlarge[j * 3 + 2][i * 3 + 1] = 255;
                        enlarge[j * 3 + 2][i * 3 + 2] = 255;
                    }
                }
            }

            int c = 0;

            for (int i = 0; i < image.length; i++) {
                System.out.println("");
                for (int j = 0; j < image[i].length; j++) {
                    System.out.printf("%4s", image[i][j]);
                }
            }

            System.out.println("\n\n");
            for (int j = 0; j < enlarge.length; j++) {
                System.out.println("");
                for (int i = 0; i < enlarge[j].length; i++) {
                    System.out.printf("%4s", enlarge[j][i]);
                    c++;
                }
            }

            yoda.close();
        } catch (IOException ex) {
            System.out.println("File error!");
        }
    }
}

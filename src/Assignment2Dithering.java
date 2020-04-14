
import java.io.FileInputStream;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tan Meng Wee
 */
public class Assignment2Dithering {

    public static void main(String[] args) {

        try {
            FileInputStream yoda = new FileInputStream("yoda.raw");
            int[][] d1 = {{0, 128}, {192, 64}};
            int[][] d2 = {
                {0, 128, 32, 160},
                {192, 64, 224, 96},
                {48, 176, 16, 144},
                {240, 112, 208, 80}};

            int x = 0;
            int y = 0;

            int w = 123;
            int h = 62;
            int value;
            int[][] image = new int[h][w];
            int[][] image2 = new int[h][w];
            int[][] image3 = new int[h][w];
            
            while ((value = yoda.read()) != -1) {
                if (y == 123) {
                    y = 0;
                    x++;
                }
                image[x][y] = value;
                y++;
            }

            for (int i = 0; i < image.length; i++) {
                System.out.println("");
                for (int j = 0; j < image[i].length; j++) {
                    System.out.printf("%4s", image[i][j]);
                }
            }
            
             for (int i = 0; i < image.length; i++) {
               
                for (int j = 0; j < image[i].length; j++) {
                    if (image[i][j] > d1[i % 2][j % 2]) {
                        image2[i][j] = 255;
                    } else {
                        image2[i][j] = 0;
                    }
                   
                }
            }
              for (int i = 0; i < image2.length; i++) {
                System.out.println("");
                for (int j = 0; j < image2[i].length; j++) {
                   System.out.printf("%4s", image2[i][j]);
                }
            }
             
            for (int i = 0; i < image3.length; i++) {
                
                for (int j = 0; j < image3[i].length; j++) {
                    if (image[i][j] > d2[i % 4][j % 4]) {
                        image3[i][j] = 255;
                    } else {
                        image3[i][j] = 0;
                    }
                  
                }
            } 
             for (int i = 0; i < image3.length; i++) {
                System.out.println("");
                for (int j = 0; j < image3[i].length; j++) {
                      System.out.printf("%4s", image3[i][j]);
                }
            }

        } catch (IOException ex) {
            System.out.println("File error!");
        }
    }
}
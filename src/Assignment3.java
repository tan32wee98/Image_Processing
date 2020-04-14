
import java.io.*;
import java.text.DecimalFormat;

public class Assignment3 {

    public static void main(String[] args) {
        try {
            FileInputStream myInputFile = new FileInputStream("yoda.raw");
            int value;
            int[] size = new int[myInputFile.available()];
            int[] pixelSize = new int[256];
            int[] sum = new int[256];
            int sum1 = 0;;
            double[] normalized = new double[256];
            double[] mul = new double[256];
            int[] map = new int[256];

            int c = 0;
            int m = 0;
            while ((value = myInputFile.read()) != -1) {
                size[c++] = value;
            }

            for (int i = 0; i < pixelSize.length; i++) {
                m = 1;
                for (int j = 0; j < size.length; j++) {
                    if (size[j] == i) {
                        pixelSize[i] = m++;
                    }
                }
            }
            for (int i = 0; i < pixelSize.length; i++) {
                sum[i] = sum1 += pixelSize[i];
            }
            DecimalFormat df = new DecimalFormat("0.00");
            for (int i = 0; i < sum.length; i++) {
                normalized[i] = sum[i] / 1.0 / sum1;
            }
            DecimalFormat df1 = new DecimalFormat("0");
            for (int i = 0; i < normalized.length; i++) {
                mul[i] = normalized[i] * 255.0;
                mul[i] = Math.round(mul[i]);
            }
         
            for (int j = 0; j < mul.length; j++) {
                map[(int) (mul[j])] += pixelSize[j];
            }
            String t = "\t\t";
            System.out.print("---------------------------------");
            System.out.print("Histogram-qualized values");
            System.out.println("---------------------------------");
            System.out.println("Gray-level\t\tNo of Pixel\tRun Sum\t\tNormalized\t"
                    + "Multiply7\tMap");
            System.out.println("----------------------------------------------"
                    + "---------------------------------------------");
            for (int i = 0; i < pixelSize.length; i++) {
                System.out.printf("Gray-level%4d:", i);
                System.out.println(t + pixelSize[i] + t + sum[i] + t
                        + df.format(normalized[i]) + t + (int) (mul[i])
                        + t + map[i]);
            }
            myInputFile.close();
        } catch (IOException ex) {
            System.out.println("File error!");
        }
    }
}


import java.io.*;

public class Assignment1 {

    public static void main(String[] args) {
        int total;
        int count = 1; 
        int j = 0;
        try {
            FileInputStream myFile = new FileInputStream("yoda.tif");
            String[] a = new String[myFile.available()];

            while ((total = myFile.read()) != -1) {
                a[j++] = Integer.toHexString(total);
            }
            for (int i = 0; i < a.length; i++) {
                if (a[i].length() == 1) {
                    a[i] = 0 + a[i];
                }
            }

            System.out.println("File name\t:yoda.tif\n");
          
            String order = a[1] + a[0];
            String version = a[3] + a[2];
            String offset = a[7] + a[6] + a[5] + a[4];

            System.out.println("Header Info-----------------------------");
            System.out.println("Byte order\t:" + order);
            System.out.println("Version\t\t:" + version.replaceFirst("^0+(?!$)", ""));
            System.out.println("Offset\t\t:" + offset.replaceFirst("^0+(?!$)", ""));
            System.out.println("");
          
            String m = a[9] + a[8];
            int m1 = Integer.parseInt(m, 16);
            int totalDE = m1 * 12;
            int sizeIFD = totalDE + 2;
            int offset1 = Integer.parseInt(a[8 + sizeIFD + 6 - 1] + a[8 + sizeIFD + 5 - 1]);

            System.out.print("-----------------------------");
            System.out.println("IFD Data-------------------------------");
            System.out.println("Total DE\t\t:" + totalDE);
            System.out.println("Size of IFD\t\t:" + sizeIFD);
            System.out.println("Consecutive Offset IFD\t:" + offset1);
            System.out.println("");
            
            String[] arrDE = new String[totalDE];
            int u = 0; 

            for (int i = 10; i < totalDE + 10; i++) {
                arrDE[u++] = a[i];
            }
            String[] arrTag = new String[m1];
            String[] arrType = new String[m1];
            String[] arrLength = new String[m1];
            String[] arrValue = new String[m1];
            String type = "";
            String tag = "";
            int indexStripOffsets = 0;

            for (int i = 0; i < m1; i++) {
                arrTag[i] = arrDE[1 + 12 * i] + arrDE[0 + 12 * i];
                arrType[i] = arrDE[3 + 12 * i] + arrDE[2 + 12 * i];
                arrLength[i] = arrDE[7 + 12 * i] + arrDE[6 + 12 * i] + arrDE[5 + 12 * i] + arrDE[4 + 12 * i];
                arrValue[i] = arrDE[11 + 12 * i] + arrDE[10 + 12 * i] + arrDE[9 + 12 * i] + arrDE[8 + 12 * i];
            }

            for (int i = 0; i < m1; i++) {
                if (Integer.parseInt(arrTag[i], 16) == 273) {
                    indexStripOffsets = i;
                }
            }


            System.out.print("-----------------------------");
            System.out.println("Data Entry-----------------------------");
            System.out.println("Tag					Type		Count	Value");
            System.out.println("");

            for (int i = 0; i < arrTag.length; i++) {
                switch (Integer.parseInt(arrTag[i], 16)) {
                    case 254:
                        tag = " (New sub file type)\t\t\t";
                        break;
                    case 256:
                        tag = " (Image width)\t\t\t";
                        break;
                    case 257:
                        tag = " (Image height)\t\t\t";
                        break;
                    case 258:
                        tag = " (Bits per sample)\t\t\t";
                        break;
                    case 259:
                        tag = " (Compression)\t\t\t";
                        break;
                    case 262:
                        tag = " (Photometric interpretation)\t";
                        break;
                    case 273:
                        tag = " (Strip offsets)\t\t\t";
                        break;
                    case 277:
                        tag = " (Samples per pixel)\t\t\t";
                        break;
                    case 278:
                        tag = " (Rows per strip)\t\t\t";
                        break;
                    case 279:
                        tag = " (Strip byte counts)\t\t\t";
                        break;
                    case 282:
                        tag = " (X resolution)\t\t\t";
                        break;
                    case 283:
                        tag = " (Y resolution)\t\t\t";
                        break;
                    case 296:
                        tag = " (Resolution unit)\t\t\t";
                        break;
                    default:
                        tag = " (unknown)\t\t\t\t";
                        break;
                }
                switch (Integer.parseInt(arrType[i], 16)) {
                    case 3:
                        type = "(SHORT)\t";
                        break;
                    case 4:
                        type = "(LONG)\t\t";
                        break;
                    case 5:
                        type = "(RATIONAL)\t";
                        break;
                }
                System.out.println(arrTag[i].replaceFirst("^0+(?!$)", "")
                        + tag + arrType[i].replaceFirst("^0+(?!$)", "") + type
                        + arrLength[i].replaceFirst("^0+(?!$)", "") + "\t"
                        + Integer.parseInt(arrValue[i].replaceFirst("^0+(?!$)", ""), 16));
            }

            System.out.println("");
            System.out.print("-----------------------------");
            System.out.println("Image  Data-----------------------------");
            for (int i = Integer.parseInt(arrValue[indexStripOffsets], 16); i < a.length; i++) {
                System.out.printf("%3s", a[i]);
                if (count % 8 == 0) {
                    System.out.print(" ");
                }
                if (count % 16 == 0) {
                    System.out.println(" ");
                }
                count++;
            }
            myFile.close();

        } catch (IOException ex) {
            System.out.println("File error");
        }

    }
}

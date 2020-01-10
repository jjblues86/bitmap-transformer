package bitmap.transformer;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Bitmap {

        BufferedImage image = null;
        File file = null;
        String outputPath;

        public Bitmap(String inputPath, String outputPath){
            //this allows us to read the image
            file = new File("./assets/" + inputPath);
            try{
                image = ImageIO.read(file);

            } catch (IOException e) {
                System.out.println("e = " + e);
            }
            this.outputPath = outputPath;

        }

        // got this inspiration from https://www.dyclassroom.com/image-processing-project/how-to-convert-a-color-image-into-sepia-image
        public void greyScale(){

            //this allows us to get the image height and width
            int height = image.getHeight();
            int width = image.getWidth();

            //this allows us to convert to greyscale
            int i, j;
            for(i = 0; i < height; i++){
                for(j = 0; j < width; j++){
                    int pixel = image.getRGB(i,j);

                    int alpha = (pixel>>24)&0xff;
                    int red = (pixel>>16)&0xff;
                    int green = (pixel>>8)&0xff;
                    int blue = pixel&0xff;

                    //calculating the average
                    int average = (red + green + blue)/3;

                    //replacing the RGB to the average value
                    pixel = (alpha<<24) | (average<<16) | (average<<8) | average;
                    image.setRGB(i,j,pixel);

                }
            }
        }

    public void pixiLate(){

        //this allows us to get the image height and width
        int height = image.getHeight();
        int width = image.getWidth();

        //this allows us to convert to greyscale
        int i, j;
        for(i = 0; i < height; i++){
            for(j = 0; j < width; j++){
                int pixel = image.getRGB(i,j);

                int alpha = (pixel>>15)&0xff;
                int red = (pixel>>50)&0xff;
                int green = (pixel>>6)&0xff;
                int blue = pixel&0xff;

                //calculating the average
                int average = (red + green + blue)/3;

                //replacing the RGB to the average value
                pixel = (alpha<<22) | (average<<10) | (average<<6) | average;
                image.setRGB(i,j,pixel);

            }
        }
    }

        public void border() {
            //this allows us to get the image height and width
            int height = image.getHeight();
            int width = image.getWidth();
            int borderWidth = 10;

            //this allows us to add a border to the image
            int i, j;
            for (i = 0; i < height; i++) {
                for (j = 0; j < width; j++) {
                    if(i < borderWidth || (i >= height - borderWidth)){
                        image.setRGB(i,j,220);
                    }
                    if(j < borderWidth || (j >= height - borderWidth)){
                        image.setRGB(i,j,220);

                    }

                }

            }
        }

        //increase the size
//    public void increaseSize(){
//            BufferedImage image1 = new BufferedImage()
//
//    }

        //this allows us to save the image
    public void save() throws IOException {
            ImageIO.write(image, "bmp", new File("./assets/" + outputPath));
    }
}

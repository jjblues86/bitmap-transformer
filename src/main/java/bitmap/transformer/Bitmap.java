package bitmap.transformer;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Bitmap {

        BufferedImage image = null;
        File file = null;

        public Bitmap(){
            //this allows us to read the image
            file = new File("./assets/mario.bmp");
            try{
                image = ImageIO.read(file);

            } catch (IOException e) {
                System.out.println("e = " + e);
            }

        }


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

                }
            }
        }

    public void save() throws IOException {
            ImageIO.write(image, "bmp", new File("./assets/mariotransform.bmp"));
    }
}

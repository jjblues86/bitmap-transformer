/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import java.io.IOException;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

        public static void main(String[] args) {
            Bitmap bmp = new Bitmap(args[0], args[1]);
            bmp.greyScale();
            bmp.border();
            bmp.pixiLate();

        try {
            bmp.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package xxl.mathematica.image

import org.junit.Test

import javax.imageio.ImageIO
import java.awt.image.BufferedImage

class ImageCollageTest extends GroovyTestCase {
    @Test
    void file() {
        InputStream is = this.getClass().getResourceAsStream("/1.png")
        if (is == null) {
            System.out.println("not exist.")
        } else {
            System.out.println("exist.")
        }
    }

    @Test
    void collage() throws IOException {
        BufferedImage[] origins = [
                ImageIO.read(this.getClass().getResourceAsStream("/1.png")),
                ImageIO.read(this.getClass().getResourceAsStream("/3.png"))
        ]
        BufferedImage dest = ImageCollage.imageCollage(origins)
        System.out.println(ImageIO.write(dest, "png", new File("dest.png")))
    }
}
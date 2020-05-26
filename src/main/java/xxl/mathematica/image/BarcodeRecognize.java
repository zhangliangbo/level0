package xxl.mathematica.image;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 条形码识别
 */
public class BarcodeRecognize {
  /**
   * 条形码识别
   *
   * @param filePath 条形码文件
   * @return
   */
  public static String barcodeRecognize(String filePath) {
    try {
      File file = new File(filePath);
      BufferedImage bufferedImage = ImageIO.read(file);
      BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
      Map hints = new HashMap();
      hints.put(EncodeHintType.CHARACTER_SET, "UTF8");
      Result result = new MultiFormatReader().decode(bitmap, hints);
      return result.getText();
    } catch (NotFoundException | IOException e) {
      return null;
    }
  }
}

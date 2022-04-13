package xxl.tesseract;

import lombok.extern.slf4j.Slf4j;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.leptonica.PIX;
import org.bytedeco.leptonica.global.lept;
import org.bytedeco.tesseract.TessBaseAPI;

/**
 * @author zhangliangbo
 * @since 2022/4/12
 */
@Slf4j
public class Basic {
    public static void main(String[] args) {
        BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();
        int init = api.Init("D:\\github\\tessdata", "chi_sim");
        if (init != 0) {
            return;
        }
        PIX pix = lept.pixRead("D:\\word.jpg");
        api.SetImage(pix);

        outText = api.GetUTF8Text();
        log.info("OCR output:\n{}", outText.getString());

        api.End();
        api.close();
        outText.close();
        lept.pixDestroy(pix);
    }
}

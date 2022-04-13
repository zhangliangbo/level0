package xxl.tesseract;

import lombok.extern.slf4j.Slf4j;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.leptonica.BOX;
import org.bytedeco.leptonica.BOXA;
import org.bytedeco.leptonica.PIX;
import org.bytedeco.leptonica.global.lept;
import org.bytedeco.tesseract.TessBaseAPI;
import org.bytedeco.tesseract.global.tesseract;

/**
 * @author zhangliangbo
 * @since 2022/4/13
 */
@Slf4j
public class GetComponentImages {
    public static void main(String[] args) {
        PIX image = lept.pixRead("D:\\phototest.tif");
        TessBaseAPI api = new TessBaseAPI();
        api.Init("D:\\github\\tessdata", "eng");
        api.SetImage(image);
        BOXA boxes = api.GetComponentImages(tesseract.RIL_TEXTLINE, true, null, (IntPointer) null);
        log.info("Found {} textline image components.\n", boxes.n());
        for (int i = 0; i < boxes.n(); i++) {
            BOX box = lept.boxaGetBox(boxes, i, lept.L_CLONE);
            api.SetRectangle(box.x(), box.y(), box.w(), box.h());
            BytePointer ocrResult = api.GetUTF8Text();
            int conf = api.MeanTextConf();
            log.info("Box[{}]: x={}, y={}, w={}, h={}, confidence: {}, text: {}",
                    i, box.x(), box.y(), box.w(), box.h(), conf, ocrResult.getString());
            lept.boxDestroy(box);
            ocrResult.close();
        }
        api.close();
    }
}

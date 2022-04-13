package xxl.tesseract;

import lombok.extern.slf4j.Slf4j;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.leptonica.PIX;
import org.bytedeco.leptonica.global.lept;
import org.bytedeco.tesseract.ETEXT_DESC;
import org.bytedeco.tesseract.ResultIterator;
import org.bytedeco.tesseract.TessBaseAPI;
import org.bytedeco.tesseract.global.tesseract;

/**
 * @author zhangliangbo
 * @since 2022/4/13
 */
@Slf4j
public class ResultIter {
    public static void main(String[] args) {
        PIX image = lept.pixRead("D:\\phototest.tif");
        TessBaseAPI api = new TessBaseAPI();
        api.Init("D:\\github\\tessdata", "eng");
        api.SetImage(image);
        ETEXT_DESC etextDesc = tesseract.TessMonitorCreate();
        api.Recognize(etextDesc);
        ResultIterator ri = api.GetIterator();
        int level = tesseract.RIL_WORD;
        if (ri != null) {
            do {
                BytePointer word = ri.GetUTF8Text(level);
                float conf = ri.Confidence(level);
                int[] x1 = new int[1];
                int[] y1 = new int[1];
                int[] x2 = new int[1];
                int[] y2 = new int[1];
                ri.BoundingBox(level, x1, y1, x2, y2);
                log.info("word: '{}' conf: {}; BoundingBox: {},{},{},{};",
                        word.getString(), conf, x1, y1, x2, y2);
                word.close();
            } while (ri.Next(level));
            ri.close();
        }
        etextDesc.close();
        api.close();
    }
}

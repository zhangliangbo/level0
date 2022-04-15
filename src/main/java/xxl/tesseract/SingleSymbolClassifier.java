package xxl.tesseract;

import lombok.extern.slf4j.Slf4j;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.leptonica.PIX;
import org.bytedeco.leptonica.global.lept;
import org.bytedeco.tesseract.ChoiceIterator;
import org.bytedeco.tesseract.ResultIterator;
import org.bytedeco.tesseract.TessBaseAPI;
import org.bytedeco.tesseract.global.tesseract;

/**
 * @author zhangliangbo
 * @since 2022/4/15
 */
@Slf4j
public class SingleSymbolClassifier {
    public static void main(String[] args) {
        PIX image = lept.pixRead("D:/phototest.tif");
        TessBaseAPI api = new TessBaseAPI();
        api.Init("D:\\github\\tessdata", "eng");
        api.SetImage(image);
        api.SetVariable("save_blob_choices", "T");
        api.SetRectangle(37, 228, 548, 31);
        api.Recognize(null);

        ResultIterator ri = api.GetIterator();
        int level = tesseract.RIL_SYMBOL;
        if (ri != null) {
            do {
                BytePointer symbol = ri.GetUTF8Text(level);
                float conf = ri.Confidence(level);
                if (symbol != null) {
                    log.info("symbol {}, conf: {}", symbol.getString(), conf);
                    boolean indent = false;
                    ChoiceIterator ci = new ChoiceIterator(ri);
                    do {
                        if (indent) {
                            log.info("\t\t ");
                        }
                        log.info("\t- ");
                        BytePointer choice = ci.GetUTF8Text();
                        log.info("{} conf: {}\n", choice.getString(), ci.Confidence());
                        choice.close();
                        indent = true;
                    } while (ci.Next());
                    ci.close();
                    symbol.close();
                }
                log.info("---------------------------------------------\n");
            } while ((ri.Next(level)));

            ri.close();
        }

        lept.pixDestroy(image);
        image.close();

        api.close();
    }
}

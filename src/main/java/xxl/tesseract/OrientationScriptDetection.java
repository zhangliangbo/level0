package xxl.tesseract;


import lombok.extern.slf4j.Slf4j;
import org.bytedeco.leptonica.PIX;
import org.bytedeco.leptonica.global.lept;
import org.bytedeco.tesseract.ETEXT_DESC;
import org.bytedeco.tesseract.PageIterator;
import org.bytedeco.tesseract.TessBaseAPI;
import org.bytedeco.tesseract.global.tesseract;

/**
 * @author zhangliangbo
 * @since 2022/4/14
 */
@Slf4j
public class OrientationScriptDetection {
    public static void main(String[] args) {
        String inputFile = "D:/eurotext.tif";
        int[] orientation = new int[1];
        int[] direction = new int[1];
        int[] order = new int[1];
        float[] deskewAngle = new float[1];

        PIX image = lept.pixRead(inputFile);
        TessBaseAPI api = new TessBaseAPI();
        api.Init("D:\\github\\tessdata", "eng");
        api.SetPageSegMode(tesseract.PSM_AUTO_OSD);
        api.SetImage(image);
        ETEXT_DESC etextDesc = tesseract.TessMonitorCreate();
        api.Recognize(etextDesc);

        PageIterator it = api.AnalyseLayout();
        it.Orientation(orientation, direction, order, deskewAngle);
        log.info("Orientation: {};\nWritingDirection: {}\nTextlineOrder: {}\nDeskew angle: {}\n",
                orientation, direction, order, deskewAngle);

        tesseract.TessPageIteratorDelete(it);
        it.close();

        tesseract.TessMonitorDelete(etextDesc);
        etextDesc.close();

        api.close();

        lept.pixDestroy(image);
        image.close();
    }
}

package xxl.mathematica.image;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 条形码图像
 */
public class BarcodeImage {

    /**
     * 二维码像素点
     *
     * @param content
     * @param format
     * @param width
     * @param height
     * @return
     */
    public static int[] barcodePixel(String content, BarcodeFormat format, int width, int height) {
        BitMatrix matrix = getMatrix(null, content, format, width, height);
        if (matrix == null) {
            return null;
        }
        int[] pixels = new int[width * height];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (matrix.get(w, h)) {
                    pixels[h * width + w] = 0xff000000;
                } else {
                    pixels[h * width + w] = 0xffffffff;
                }
            }
        }
        return pixels;
    }

    /**
     * 宽和高一致
     *
     * @param content
     * @param format
     * @param size    长或宽
     * @return
     */
    public static int[] barcodePixel(String content, BarcodeFormat format, int size) {
        return barcodePixel(content, format, size, size);
    }

    /**
     * 默认QR
     *
     * @param content 内容
     * @param size
     * @return
     */
    public static int[] barcodePixel(String content, int size) {
        return barcodePixel(content, BarcodeFormat.QR_CODE, size);
    }

    /**
     * 默认大小500
     *
     * @param content
     * @return
     */
    public static int[] barcodePixel(String content) {
        return barcodePixel(content, 500);
    }

    /**
     * 生成二维码
     *
     * @param content
     * @param format
     * @param width
     * @param height
     * @return
     */
    public static String barcodeImage(String encoding, String content, BarcodeFormat format, int width, int height, String outPath) {
        BitMatrix bitMatrix = getMatrix(encoding, content, format, width, height);
        if (bitMatrix == null) {
            return null;
        }
        Path file = new File(outPath).toPath();
        try {
            MatrixToImageWriter.writeToPath(bitMatrix, outPath.substring(1 + outPath.lastIndexOf(".")), file);
            return outPath;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 宽和高一致
     *
     * @param content
     * @param format
     * @param size    长或宽
     * @param outPath
     * @return
     */
    public static String barcodeImage(String encoding, String content, BarcodeFormat format, int size, String outPath) {
        return barcodeImage(encoding, content, format, size, size, outPath);
    }

    /**
     * 默认QR
     *
     * @param content 内容
     * @param size
     * @param outPath
     * @return
     */
    public static String barcodeImage(String encoding, String content, int size, String outPath) {
        return barcodeImage(encoding, content, BarcodeFormat.QR_CODE, size, outPath);
    }

    /**
     * null(默认编码ISO-8859-1)
     *
     * @param content 内容
     * @param size
     * @param outPath
     * @return
     */
    public static String barcodeImage(String content, int size, String outPath) {
        return barcodeImage(null, content, size, outPath);
    }

    /**
     * 使用临时文件创建
     *
     * @param content
     * @param size
     * @return
     */
    public static String barcodeImage(String content, int size) {
        try {
            return barcodeImage(content, size, File.createTempFile(BarcodeImage.class.getName(), ".png").getAbsolutePath());
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 默认大小500
     *
     * @param content
     * @return
     */
    public static String barcodeImage(String content) {
        return barcodeImage(content, 500);
    }

    private static BitMatrix getMatrix(String encoding, String content, BarcodeFormat format, int width, int height) {
        Map<EncodeHintType, Object> hints = new HashMap<>(1);
        hints.put(EncodeHintType.MARGIN, 0);
        if (Objects.nonNull(encoding)) {
            hints.put(EncodeHintType.CHARACTER_SET, encoding);
        }
        try {
            return new MultiFormatWriter().encode(content, format, width, height, hints);
        } catch (WriterException e) {
            return null;
        }
    }

}

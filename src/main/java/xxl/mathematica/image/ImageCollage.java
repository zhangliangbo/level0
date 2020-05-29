package xxl.mathematica.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageCollage {
    /**
     * 把多个宽度相同的图像拼接成一个图像，按照顺序纵向排列
     *
     * @param origins 多个宽度相同的图像，此处必须宽度相同
     * @return 目标图像
     */
    public static BufferedImage imageCollage(BufferedImage[] origins) {
        //为null直接返回null
        if (origins == null) {
            return null;
        }
        //获取需要拼接的图片长度
        int len = origins.length;
        //判断长度是否大于0
        if (len < 1) {
            return null;
        }
        int[][] imageArrays = new int[len][];
        for (int i = 0; i < len; i++) {
            //读取图像
            int width = origins[i].getWidth();
            int height = origins[i].getHeight();
            // 从图片中读取RGB 像素
            imageArrays[i] = new int[width * height];
            imageArrays[i] = origins[i].getRGB(0, 0, width, height, imageArrays[i], 0, width);
        }
        int dst_height = 0;
        int dst_width = origins[0].getWidth();
        //合成图片像素
        for (BufferedImage image : origins) {
            dst_width = Math.max(dst_width, image.getWidth());
            dst_height += image.getHeight();
        }
        //合成后的图片
        if (dst_height < 1) {
            return null;
        }
        // 生成新图片
        try {
            BufferedImage imageDest = new BufferedImage(dst_width, dst_height,
                    BufferedImage.TYPE_INT_RGB);
            int height_i = 0;
            for (int i = 0; i < origins.length; i++) {
                imageDest.setRGB(0, height_i, dst_width, origins[i].getHeight(),
                        imageArrays[i], 0, dst_width);
                height_i += origins[i].getHeight();
            }
            return imageDest;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Java拼接多张图片
     *
     * @param origins 原始图片
     * @param type    图片格式
     * @param dstPic  目标图片
     * @return
     */
    public static boolean imageCollage(String[] origins, String type, String dstPic) {
        //为null直接返回null
        if (origins == null) {
            return false;
        }
        //获取需要拼接的图片长度
        int len = origins.length;
        //判断长度是否大于0
        if (len < 1) {
            return false;
        }
        //读取图像
        BufferedImage[] images = new BufferedImage[len];
        for (int i = 0; i < len; i++) {
            try {
                images[i] = ImageIO.read(new File(origins[i]));
            } catch (Exception e) {
                return false;
            }
        }
        BufferedImage imageDest = imageCollage(images);//核心算法
        if (imageDest == null) {
            return false;
        } else {
            try {
                File outFile = new File(dstPic);
                return ImageIO.write(imageDest, type, outFile);// 写图片 ，输出到硬盘
            } catch (IOException e) {
                return false;
            }
        }
    }
}

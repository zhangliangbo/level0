package xxl.mathematica.test;

import lombok.*;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * GB2312中文字符
 *
 * @author zhangliangbo
 * @since 2020/11/24
 **/

public class GB2312 {
    public static void main(String[] args) throws IOException {
//        chinese("C:\\Users\\zhang\\Desktop\\GB2312.txt", Charset.forName("GB2312"));
        chinese2();
    }

    public static void chinese(String fileName, Charset charset) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(fileName)))) {
            bos.write("\r\r说明,共有94个区,前缀A1-FE,每区94个字符位置(最多可存储8836个字符):\r\r\r".getBytes(charset));
            // 打印特殊字符区
            bos.write("(01-09区,前缀A1-A9,每区94个字符位置)特殊字符区:\r".getBytes(charset));
            printTitle(bos, charset);
            byte[] b = new byte[3];
            for (int i = 0xA1; i <= 0xA9; i++) {
                b[0] = (byte) i;
                bos.write(("\r" + Integer.toHexString(i).toUpperCase() + "\t").getBytes(charset));
                for (int j = 0xA1; j <= 0xFE; j++) {
                    b[1] = (byte) j;
                    bos.write(b, 0, 2);
                    if (j != 0xFE) {
                        bos.write(".\t".getBytes(charset));
                    }
                }
            }

            bos.write("\r\r(10-15区,前缀AA-AF,共6个区,每区94个字符位置)未分配:\r".getBytes(charset));

            // 打印一级汉字区
            bos.write("\r\r(16-55区,前缀B0-D7,共40个区,每区94个字符位置)一级汉字区,按拼音排序:\r".getBytes(charset));
            printTitle(bos, charset);
            for (int i = 0xB0; i <= 0xD7; i++) {
                b[0] = (byte) i;
                bos.write(("\r" + Integer.toHexString(i).toUpperCase() + "\t").getBytes(charset));
                for (int j = 0xA1; j <= 0xFE; j++) {
                    b[1] = (byte) j;
                    bos.write(b, 0, 2);
                    if (j != 0xFE) {
                        bos.write(".\t".getBytes(charset));
                    }
                }
            }

            // 打印二级汉字区
            bos.write("\r\r(56-87区,前缀D8-F7,共32个区,每区94个字符位置)二级汉字区,按笔画排序:\r".getBytes(charset));
            printTitle(bos, charset);
            for (int i = 0xD8; i <= 0xF7; i++) {
                b[0] = (byte) i;
                bos.write(("\r" + Integer.toHexString(i).toUpperCase() + "\t").getBytes(charset));
                for (int j = 0xA1; j <= 0xFE; j++) {
                    b[1] = (byte) j;
                    bos.write(b, 0, 2);
                    if (j != 0xFE) {
                        bos.write(".\t".getBytes(charset));
                    }
                }
            }

            bos.write("\r\r(88-94区,前缀F8-FE,共7个区,每区94个字符位置)未分配:\r".getBytes(charset));

            bos.write("\r\r存储位置与区位码转化:存储位置=(区位码高位+0xA0)*0x100+(区位码低位+0xA0)\r".getBytes(charset));

        }
    }

    /**
     * 方法描述：打印标题
     *
     * @param os 字节流
     * @throws UnsupportedEncodingException 不支持的字符集
     * @throws IOException                  IO异常
     */
    public static void printTitle(OutputStream os, Charset charset) throws UnsupportedEncodingException, IOException {
        os.write(("cd\tA1\tA2\tA3\tA4\tA5\tA6\tA7\tA8\tA9\tAA\tAB\tAC\tAD\tAE\tAF\t"
                + "B0\tB1\tB2\tB3\tB4\tB5\tB6\tB7\tB8\tB9\tBA\tBB\tBC\tBD\tBE\tBF\t"
                + "C0\tC1\tC2\tC3\tC4\tC5\tC6\tC7\tC8\tC9\tCA\tCB\tCC\tCD\tCE\tCF\t"
                + "D0\tD1\tD2\tD3\tD4\tD5\tD6\tD7\tD8\tD9\tDA\tDB\tDC\tDD\tDE\tDF\t"
                + "E0\tE1\tE2\tE3\tE4\tE5\tE6\tE7\tE8\tE9\tEA\tEB\tEC\tED\tEE\tEF\t"
                + "F0\tF1\tF2\tF3\tF4\tF5\tF6\tF7\tF8\tF9\tFA\tFB\tFC\tFD\tFE").getBytes(charset));
    }

    public static List<String> chinese2() throws IOException {
        List<String> res = new ArrayList<>();
        FileOutputStream file = new FileOutputStream("C:\\Users\\zhang\\Desktop\\GB2312.txt");
        //遍历gb2312汉字编码分区
        for (int i = 0xB0; i <= 0xF7; i++) {
            //遍历每个分区中的汉字
            for (int j = 0xA1; j < 0xFF; j++) {
                byte[] bytes = new byte[2];
                bytes[0] = (byte) i;
                bytes[1] = (byte) j;
                String s = new String(bytes, "gb2312");
                res.add(s);
                System.err.print(s);
                System.err.print("\t");
                file.write(s.getBytes("gb2312"));
                file.write("\t".getBytes("gb2312"));
            }
            System.err.println();
            file.write("\n".getBytes("gb2312"));
        }
        return res;
    }

}

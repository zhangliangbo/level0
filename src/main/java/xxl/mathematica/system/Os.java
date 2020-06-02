package xxl.mathematica.system;

import org.apache.commons.lang3.ArchUtils;

/**
 * 操作系统信息
 */
public class Os {
    public static String arch() {
        return ArchUtils.getProcessor().getArch().getLabel();
    }

    public static String type() {
        return ArchUtils.getProcessor().getType().name();
    }

    public static void main(String[] args) {
        System.err.println(arch());
        System.err.println(type());
    }
}

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

    private static final String osName = System.getProperty("os.name").toLowerCase();

    public static boolean isLinux() {
        return osName.contains("linux");
    }

    public static boolean isMacOS() {
        return osName.contains("mac") && osName.indexOf("os") > 0 && !osName.contains("x");
    }

    public static boolean isMacOSX() {
        return osName.contains("mac") && osName.indexOf("os") > 0 && osName.indexOf("x") > 0;
    }

    public static boolean isWindows() {
        return osName.contains("windows");
    }

    public static boolean isOS2() {
        return osName.contains("os/2");
    }

    public static boolean isSolaris() {
        return osName.contains("solaris");
    }

    public static boolean isSunOS() {
        return osName.contains("sunos");
    }

    public static boolean isMPEiX() {
        return osName.contains("mpe/ix");
    }

    public static boolean isHPUX() {
        return osName.contains("hp-ux");
    }

    public static boolean isAix() {
        return osName.contains("aix");
    }

    public static boolean isOS390() {
        return osName.contains("os/390");
    }

    public static boolean isFreeBSD() {
        return osName.contains("freebsd");
    }

    public static boolean isIrix() {
        return osName.contains("irix");
    }

    public static boolean isDigitalUnix() {
        return osName.contains("digital") && osName.indexOf("unix") > 0;
    }

    public static boolean isNetWare() {
        return osName.contains("netware");
    }

    public static boolean isOSF1() {
        return osName.contains("osf1");
    }

    public static boolean isOpenVMS() {
        return osName.contains("openvms");
    }

    public static void main(String[] args) {
        System.err.println(arch());
        System.err.println(type());
        System.err.println(isWindows());
    }
}

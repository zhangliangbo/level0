package xxl;

import org.apache.poi.sl.draw.geom.IAdjustableShape;

import java.net.InetAddress;
import java.net.NetworkInterface;

public class Main {


    public static void main(String[] args) throws Exception {
        try {
            //设置IP地址网段
            String ips = "192.168.8.";
            String ip;
            //遍历IP地址
            for (int i = 1; i < 255; i++) {
                ip = ips + i;
                System.out.println(ip);
                InetAddress remote = InetAddress.getByName(ip);
                boolean status = remote.isReachable(1);

                if (status) {
                    NetworkInterface interfac = NetworkInterface.getByInetAddress(remote);
                    if (interfac != null) {
                        byte[] mac = interfac.getHardwareAddress();
                        if (mac != null) {
                            System.out.println("have mac");
                            System.out.println(io.vavr.collection.List.ofAll(mac).map(x -> String.format("%02X", x)).mkString());
                        }
                    }
                    System.out.println("IP地址为:" + ip + "\t\t" + remote.getHostName() + "\t\t是否可用: " + (status ? "可用" : "不可用"));
                }
            }
        } catch (java.io.IOException uhe) {
            System.out.println("Unable to find: " + uhe.getLocalizedMessage());
        }
    }
}

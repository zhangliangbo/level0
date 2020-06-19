package xxl;

import xxl.mathematica.Rule;
import xxl.mathematica.external.External;
import xxl.mathematica.network.PingTime;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class Main {


    public static void main(String[] args) throws Exception {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface e = interfaces.nextElement();

            if (!e.isVirtual() && !e.isLoopback()&& e.isUp() ) {
                System.err.println("=" + e.getDisplayName());
                Enumeration<InetAddress> inetAddresses = e.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    if (inetAddress instanceof Inet4Address) {
                        System.err.println("==" + inetAddress.getHostAddress());
                    }
                }
                System.err.println("------------------");
            }
        }
        Rule<Integer, byte[]> rule = External.runProcess("arp -a");
        System.err.println(new String(rule.getValue(), "GBK"));
    }
}

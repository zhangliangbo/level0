package xxl.mathematica.network;

import io.vavr.control.Try;

import java.net.InetAddress;

/**
 * 获取域名的IP
 */
public class HostLookup {
    /**
     * 获取IP地址
     *
     * @param domain
     * @return
     */
    public static String hostLookup(String domain) {
        return Try.ofCallable(() -> InetAddress.getByName(domain).getHostAddress()).getOrNull();
    }
}

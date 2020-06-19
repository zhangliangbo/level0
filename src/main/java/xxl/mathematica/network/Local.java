package xxl.mathematica.network;

import io.vavr.control.Try;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 * 本机网络信息
 */
public class Local {
    /**
     * 所有网口信息
     *
     * @return
     */
    public static List<String> networkInterfaceNames() {
        return Try.ofCallable(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                List<String> res = new ArrayList<>();
                Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
                while (interfaces.hasMoreElements()) {
                    NetworkInterface e = interfaces.nextElement();
                    if (!e.isVirtual() && !e.isLoopback() && e.isUp()) {
                        res.add(e.getDisplayName());
                    }
                }
                return res;
            }
        }).get();
    }

    /**
     * 所有网口信息
     *
     * @return
     */
    public static List<String> ipv4s() {
        return Try.ofCallable(() -> {
            List<String> res = new ArrayList<>();
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface e = interfaces.nextElement();
                if (!e.isVirtual() && !e.isLoopback() && e.isUp()) {
                    Enumeration<InetAddress> inetAddresses = e.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = inetAddresses.nextElement();
                        if (inetAddress instanceof Inet4Address) {
                            res.add(inetAddress.getHostAddress());
                        }
                    }
                }
            }
            return res;
        }).get();
    }

    /**
     * 所有网口信息
     *
     * @return
     */
    public static List<String> ipv6s() {
        return Try.ofCallable(() -> {
            List<String> res = new ArrayList<>();
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface e = interfaces.nextElement();
                if (!e.isVirtual() && !e.isLoopback() && e.isUp()) {
                    Enumeration<InetAddress> inetAddresses = e.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = inetAddresses.nextElement();
                        if (inetAddress instanceof Inet6Address) {
                            res.add(inetAddress.getHostAddress());
                        }
                    }
                }
            }
            return res;
        }).get();
    }

    /**
     * 所有网口信息
     *
     * @return
     */
    public static List<String> macs() {
        return Try.ofCallable(() -> {
            List<String> res = new ArrayList<>();
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface e = interfaces.nextElement();
                byte[] mac = e.getHardwareAddress();
                if (mac == null) {
                    continue;
                }
                res.add(io.vavr.collection.List.ofAll(mac)
                        .map(new Function<Byte, String>() {
                            @Override
                            public String apply(Byte aByte) {
                                return String.format("%02X", aByte);
                            }
                        })
                        .mkString("-"));
            }
            return res;
        }).get();
    }

    /**
     * name mac ipv4 ipv6
     *
     * @return
     */
    public static List<Map<String, String>> all() {
        return Try.ofCallable(new Callable<List<Map<String, String>>>() {
            @Override
            public List<Map<String, String>> call() throws Exception {
                List<Map<String, String>> res = new ArrayList<>();
                Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
                while (interfaces.hasMoreElements()) {
                    Map<String, String> map = new HashMap<>();
                    NetworkInterface e = interfaces.nextElement();
                    if (!e.isVirtual() && !e.isLoopback() && e.isUp()) {
                        map.put("name", e.getDisplayName());
                        map.put("mac", io.vavr.collection.List.ofAll(e.getHardwareAddress())
                                .map(new Function<Byte, String>() {
                                    @Override
                                    public String apply(Byte aByte) {
                                        return String.format("%02X", aByte);
                                    }
                                })
                                .mkString("-"));
                        Enumeration<InetAddress> inetAddresses = e.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress inetAddress = inetAddresses.nextElement();
                            if (inetAddress instanceof Inet6Address) {
                                map.put("ipv6", inetAddress.getHostAddress());
                                res.add(map);
                            } else if (inetAddress instanceof Inet4Address) {
                                map.put("ipv4", inetAddress.getHostAddress());
                                res.add(map);
                            }
                        }
                    }
                }
                return res;
            }
        }).get();
    }
}

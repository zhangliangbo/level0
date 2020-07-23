package xxl.mathematica.network;

import io.vavr.control.Try;

import java.net.InetSocketAddress;
import java.net.Socket;

public class Telnet {
    /**
     * 查看主机端口是否可用（能够正常连接断开）
     *
     * @param host
     * @param port
     * @return
     */
    public static boolean telnet(String host, int port) {
        return Try.ofCallable(() -> {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), 30000);
            socket.close();
            return true;
        }).getOrElse(false);
    }
}

package xxl;

import xxl.mathematica.network.PingTime;

public class Main {


    public static void main(String[] args) throws Exception {
        String url = "www.baidu.com";
        if (args.length > 0) {
            url = args[0];
        }
        System.out.println(PingTime.pingTime(url));
    }
}

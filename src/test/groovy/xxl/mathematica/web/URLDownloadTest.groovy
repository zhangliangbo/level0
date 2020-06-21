package xxl.mathematica.web

import java.util.function.Consumer

class URLDownloadTest extends GroovyTestCase {
    void testUrlDownload() {
        println(URLDownload.urlDownload(
                "https://shop.yuyi666.cn/quilt/mongo/download/5eeefc5c3d583a3c8a4dd757",
                "D:\\www.pdf",
                new Consumer<Float>() {
                    @Override
                    void accept(Float aFloat) {
                        System.out.println(aFloat)
                    }
                }
        ))
    }
}

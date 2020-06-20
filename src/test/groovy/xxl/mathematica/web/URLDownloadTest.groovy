package xxl.mathematica.web

import java.util.function.Consumer

class URLDownloadTest extends GroovyTestCase {
    void testUrlDownload() {
        println(URLDownload.urlDownload(
                "https://jcenter.bintray.com/io/vavr/vavr/0.10.3/vavr-0.10.3.jar",
                "D:\\www.jar",
                new Consumer<Float>() {
                    @Override
                    void accept(Float aFloat) {
                        System.err.println(aFloat)
                    }
                }
        ))
    }
}

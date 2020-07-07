package xxl.mathematica.web

import java.util.function.BiConsumer

class JarDownloadTest extends GroovyTestCase {
    void testJarDownload() {
        println(JarDownload.jarDownload("io.netty:netty-all:4.1.50.Final", "D:\\.gradle\\caches\\modules-2\\files-2.1", new BiConsumer<String, Float>() {
            @Override
            void accept(String s, Float aFloat) {
                System.out.println(s + "\t" + aFloat)
            }
        }))
    }
}

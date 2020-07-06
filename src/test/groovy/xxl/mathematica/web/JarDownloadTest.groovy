package xxl.mathematica.web

import java.util.function.BiConsumer

class JarDownloadTest extends GroovyTestCase {
    void testJarDownload() {
        JarDownload.jarDownload("org.apache.commons:commons-lang3:3.10", "C:\\Users\\zhang\\Desktop\\a", new BiConsumer<String, Float>() {
            @Override
            void accept(String s, Float aFloat) {
                System.err.println(s)
                System.err.println(aFloat)
            }
        })
    }
}

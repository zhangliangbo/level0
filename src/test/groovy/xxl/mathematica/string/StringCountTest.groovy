package xxl.mathematica.string

import xxl.mathematica.io.Import

class StringCountTest extends GroovyTestCase {
    void testStringCount() {
        String file = Import.importText("D:\\xxlun\\xxlun\\netlogo\\20190921\\netlogo-vue\\src\\components\\Ask.vue")
        println(StringCount.stringCount(file, "\n"))
    }

    void test1() {
        println(StringCount.stringCount("\n\n\n\n\n\n\n\n\n\n", "\n"))
    }
}

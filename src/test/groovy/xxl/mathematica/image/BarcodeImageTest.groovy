package xxl.mathematica.image

class BarcodeImageTest extends GroovyTestCase {
    void testBarcodeImage() {
        String file = "C:\\Users\\EDZ\\Desktop\\b\\null.png"
        println(BarcodeImage.barcodeImage(null, "K9GBMiYZ", 500, file))
    }

}

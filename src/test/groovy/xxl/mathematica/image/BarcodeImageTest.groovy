package xxl.mathematica.image

class BarcodeImageTest extends GroovyTestCase {
    void testBarcodeImage() {
        String file = "C:\\Users\\EDZ\\Desktop\\tree.jpg"
        println(BarcodeImage.barcodeImage("hello world", 500, file))
        ShowImage.showImage(file)
    }

}

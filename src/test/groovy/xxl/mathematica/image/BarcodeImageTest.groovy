package xxl.mathematica.image

class BarcodeImageTest extends GroovyTestCase {
    void testBarcodeImage() {
        String file = "C:\\Users\\zhang\\Desktop\\hello.png"
        println(BarcodeImage.barcodeImage("hello world", 500, file))
        ShowImage.showImage(file)
    }

}

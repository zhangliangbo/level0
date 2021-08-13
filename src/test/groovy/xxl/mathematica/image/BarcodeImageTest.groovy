package xxl.mathematica.image

class BarcodeImageTest extends GroovyTestCase {
    void testBarcodeImage() {
        String file = "C:\\Users\\EDZ\\Desktop\\tree.jpg"
        println(BarcodeImage.barcodeImage("J6U5hMra", 500, file))
        ShowImage.showImage(file)
    }

}

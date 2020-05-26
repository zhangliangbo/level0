package xxl.mathematica.io

import xxl.mathematica.external.Pojo

class ExportTest extends GroovyTestCase {
    void testExportXlsx() {
        println(Export.exportExcel("C:\\Users\\Admin\\Desktop\\helloworld.xlsx", true, [[new Pojo("zlb", 18, "男")]]))
    }

    void testExportWord() {
        List<Object> content = new ArrayList<>()
        content.add("tabfdsafffffffffle1")
        content.add([["1adddddffd", "2dafffffff", "3fffffffffffa"], ["4ssssssss", "5ggggggg", "6eeeeeee"], ["7ttttttt", "8bbbbbbbbb", "9sssssssssss"]] as String[][])
        content.add("table2")
        content.add([["1fdgfdgd", "ffasfsdfa2", "3fasfdsfasf"], ["4fsafdsafsf", "5fsadfafa", "6fsafdfa"], ["7dsfsdfafdsa", "8fasfsdfa", "9fdasfdsafdsfa"]] as String[][])
        content.add("table3")
        content.add([["1bbbbrfasrfe", "2yrtyrtrewer", "3mmmmmmmmmmm"], ["4rrrwwrwr", "5qqqqqqqqqqq", "6ooooooooooo"], ["7pppppppp", "8eeeeee", "9llllllllllll"]] as String[][])
        println(Export.exportWord("C:\\Users\\Admin\\Desktop\\helloworld.doc", content))
    }
}


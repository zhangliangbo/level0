package xxl.mathematica.time

class DateListTest extends GroovyTestCase {
    void testDateList() {
        println(DateList.dateList("2020-06-01 12:00:00", "yyyy-MM-dd HH:mm:ss"))
    }
}

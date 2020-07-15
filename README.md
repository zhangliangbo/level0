# mathematica的简单java实现，一个兴趣项目，不做商业用途
# java编码，groovy测试
# gradle地址
```
implementation 'io.github.zhangliangbo:level0:1.0.0'
```
# maven地址
```
<dependency>
  <groupId>io.github.zhangliangbo</groupId>
  <artifactId>level0</artifactId>
  <version>1.0.0</version>
</dependency>
```
# 列表
## Append 列表末尾添加元素
```
void testAppend() {
    println(Append.append(["a", "b", "c", "d"], "tail"))
}

[a, b, c, d, tail]
```
## Prepend 列表起始添加元素
```
void testPrepend() {
    println(Prepend.prepend(["a", "b", "c", "d"], "head"))
}

[head, a, b, c, d]
```
## Insert 给定位置插入元素
```
void testInsert() {
    println(Insert.insert(["a", "b", "c", "d"], "x", 1))
}

[a, x, b, c, d]
```
## Delete 给定位置删除元素
```
void testDelete() {
    println(Delete.delete(["a", "b", "c", "d"], [1, 3]))
}

[a, c]
```
## Range 根据起始，结束和步长生成范围
```
void testRange() {
    println(Range.range(1, 10, 2))
    println(Range.range('a' as char, 'z' as char))
}

[1, 3, 5, 7, 9]
[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y]
```
## Subdivide 把一个范围等分划分为n等份
```
void testSubdivide() {
    println(Subdivide.subdivide(0D, 10D, 3))
}

[0.0, 3.3333333333333335, 6.666666666666667, 10.0]
```
## Take 获取列表给定范围的元素
```
void testTake() {
    def list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    println(Take.take(list, 1, 7, 2))
    println(Take.take(list, 0, list.size()))
}

[2, 4, 6]
[1, 2, 3, 4, 5, 6, 7, 8, 9]
```
## Drop 删除给定范围的元素
```
void testDrop() {
    def list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    println(Drop.drop(list, 3))
    println(Drop.drop(list, 1, 7, 2))
    println(Drop.drop(list, 0, list.size()))
}

[4, 5, 6, 7, 8, 9]
[1, 3, 5, 7, 8, 9]
[]
```
## Position 获取给定元素在列表的位置
```
def list = ["a", "b", "c", "d"]
println(Position.position(list, "a"))
println(Position.position(list, "b"))
println(Position.position(list, new Predicate<String>() {
    @Override
    boolean test(String t) {
        return t.equals("c")
    }
}))

[0]
[1]
[2]
```
## Extract 提取给定位置的元素
```
void testExtract() {
    println(Extract.extract(["a", "b", "c", "d"], [0, 1]))
}

[a, b]
```
## Count 列表元素个数
```
void testCount() {
    println(Count.count([1, 2, 3, 4, 5, 6, 7, 8, 9, 8], 8))
    println(Count.count([1, 2, 3, 4, 5, 6, 7, 8, 9, 8], 2))
}

2
1
```
## Select 选择元素
```
void testSelect() {
    println(Select.select([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0], new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t > 5
        }
    }))
    println(Select.select([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0], new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t <= 5
        }
    }))
}

[6, 7, 8, 9, 8, 7, 6]
[0, 1, 2, 3, 4, 5, 5, 4, 3, 2, 1, 0]
```
## SelectFirst 选择第一个元素
```
void testSelectFirst() {
    println(SelectFirst.selectFirst([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t > 5;
        }
    }))
    println(SelectFirst.selectFirst([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t <= 5;
        }
    }))
}

6
0
```
## TakeWhile 选择元素直到第一个不满足
```
void testTakeWhile() {
    println(TakeWhile.takeWhile([0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0], new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t > 3
        }
    }))
    println(TakeWhile.takeWhile([0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0], new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t <= 3
        }
    }))
}

[]
[0, 1, 2, 3]
```
## Array 函数作用于范围，生成列表
```
void testArray() {
    println(Array.array(new Function<Integer, Character>() {
        @Override
        Character apply(Integer integer) {
            return integer as char
        }
    }, 26, 97))
}

[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
```
## Table 生成二维列表
```
void testTable() {
    println(Table.table(new Function<Integer, String>() {
        @Override
        String apply(Integer t) {
            return "index" + t
        }
    }, Range.range(10)))

    println(Table.table(new BiFunction<Integer, Integer, String>() {
        @Override
        String apply(Integer f, Integer s) {
            return "(" + f + "," + s + ")"
        }
    }, Range.range(10), Range.range(10)))
}

[index0, index1, index2, index3, index4, index5, index6, index7, index8, index9]
[[(0,0), (0,1), (0,2)], [(1,0), (1,1), (1,2)], [(2,0), (2,1), (2,2)]]
```
## Reverse 反向排序
```
void testReverse() {
    println(Reverse.reverse(["a", "b", "c", "d"]))
}

[d, c, b, a]
```
## Join 连接两个列表
```
void testJoin() {
    println(Join.join([1, 2, 3], [4, 5, 6]))
}

[1, 2, 3, 4, 5, 6]
```
## Intersection 给出两个列表的有序交集
```
void testIntersection() {
    println(Intersection.intersection([1, 1, 2, 3], [3, 1, 4]))
}

[1, 3]
```
## Union 给出两个列表的有序并集
```
void testUnion() {
    println(Union.union(["a", "b", "a", "c"], ["d", "a", "e", "b"]))
}

[a, b, c, d, e]
```
## Complement 给出一个列表相对于另外一个列表的补集
```
void testComplement() {
    println(Complement.complement([1, 2, 3, 4, 5], [1, 2]))
}

[3, 4, 5]
```
## Sort 排序一个列表
```
void testSort() {
    def list = [6, 4, 7, 3, 9, 4, 6, 8, 1, 2, 3]
    println(Sort.sort(list))
}

[1, 2, 3, 3, 4, 4, 6, 6, 7, 8, 9]
```
# 字典操作
## Association 根据规则来生成字典
```

```
## GroupBy 对列表进行分组
```
void testGroupBy() {
    println(GroupBy.groupBy([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0], new Function<Integer, String>() {
        @Override
        String apply(Integer v) {
            return String.valueOf(v)
        }
    }))
}

[0:[0, 0], 1:[1, 1], 2:[2, 2], 3:[3, 3], 4:[4, 4], 5:[5, 5], 6:[6, 6], 7:[7, 7], 8:[8, 8], 9:[9]]
```
# 字符串操作
## StringCases 字符串匹配
```
void testStringCases() {
    println(StringCases.stringCases("the cat in the hat", "a.*e"))  //默认第0个组
    println(StringCases.stringCases("the cat in the hat", "a(.*)e", 1)) //选择第1个组
    println(StringCases.stringCases("abcdabcdcd", "abc|cd"))
}

[at in the]
[t in th]
[abc, abc, cd]
```
## StringRiffle 分隔符连接字符串
```
void testStringRiffle() {
    System.out.println(StringRiffle.stringRiffle(Arrays.asList("zlb", "hwj", "dsx"), "|"))
}

zlb|hwj|dsx
```
## StringSplit 分隔符分割字符串
```
void testStringSplit() {
    println(StringSplit.stringSplit("a-b:c-d:e-f-g", ":", "-"))
}

[a, b, c, d, e, f, g]
```
## StringContainsQ 字符串是否包含其他字符串
```
void testStringContainQ() {
    println(StringContainsQ.stringContainsQ("abcdefghijk", "abc"))
    println(StringContainsQ.stringContainsQ("abcdefghijk", "abcc"))
}

true
false
```
## StringCount 字符串包含子字符串数量
```
void testStringCount() {
    println(StringCount.stringCount("abc11abc22abc33abc44abc55", "abc"))
}

5
```
## StringJoin 连接字符串
```
void testStringJoin() {
    println(StringJoin.stringJoin(["a", "b", "c", "d", "e", "f", "g", "h"]))
}

abcdefgh
```
## StringRepeat 重复字符串
```
void testStringRepeat() {
    System.out.println(StringRepeat.stringRepeat("<a>", 10))
}

<a><a><a><a><a><a><a><a><a><a>
```
# 逻辑
## AllTrue 是否所有元素都为真
```
void testAllTrue() {
    def list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    println(AllTrue.allTrue(list, new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t < 10
        }
    }))
    println(AllTrue.allTrue(list, new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t < 9
        }
    }))
}

true
false
```
## AnyTrue 是否有一个元素为真
```
void testAnyTrue() {
    def list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    println(AnyTrue.anyTrue(list, new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t > 1
        }
    }))
    println(AnyTrue.anyTrue(list, new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t > 8
        }
    }))
    println(AllTrue.allTrue(list, new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t > 9
        }
    }))
}

true
true
false
```
## NoneTrue 是否没有一个元素为真
```
void testNoneTrue() {
    def list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    println(NoneTrue.noneTrue(list, new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t > 1
        }
    }))
    println(NoneTrue.noneTrue(list, new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t > 8
        }
    }))
    println(NoneTrue.noneTrue(list, new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t > 9
        }
    }))
}

false
false
true
```
## And 逻辑与
```
void testAnd() {
    println(And.and(1 > 0, 2 < 3, 5 < 6, true))
    println(And.and(1 > 0, 2 > 3, 5 < 6, true))
}

true
false
```
## Or 逻辑或
```
void testOr() {
    println(or(1 > 0, 0 > 1, 1 + 1 == 2))
    println(or(1 + 1 == 2, 2 + 2 == 4))
    println(or(1 + 1 == 3, 2 + 2 == 3))
}

true
true
false
```
## Not 逻辑非
```
void testNot() throws Exception {
    println(Not.not(1 + 1 == 2))
    println(Not.not(Not.not(1 + 1 == 2)))//双重否定等于肯定
}

false
true
```
# 断言
## MemberQ 列表是否存在元素
```
void testMemberQ() {
    println(MemberQ.memberQ([1, 2, 3, 4, 5], 5))
    println(MemberQ.memberQ([1, 2, 3, 4, 5], 6))
}

true
false
```
## FreeQ 列表是否不存在元素
```
void testFreeQ(){
    println(FreeQ.freeQ([1, 2, 3, 4, 5], 5))
    println(FreeQ.freeQ([1, 2, 3, 4, 5], 6))
}

false
true
```
## EvenQ 是否为偶数
```
void testEvenQ() {
    println(EvenQ.evenQ(2))
    println(EvenQ.evenQ(3))
    println(EvenQ.evenQ(4))
}

true
false
true
```
## OddQ 是否为奇数
```
void testOddQ() {
    println(OddQ.oddQ(2))
    println(OddQ.oddQ(3))
    println(OddQ.oddQ(4))
}

false
true
false
```
## PrimerQ 是否为素数
```
void testPrimerQ() {
    println(PrimerQ.primerQ(2))
    println(PrimerQ.primerQ(3))
    println(PrimerQ.primerQ(4))
}

true
true
false
```
# 时间
## DateList 字符串转时间
```
void testDateList() {
    println(DateList.dateList("2020-06-01 12:00:00", "yyyy-MM-dd HH:mm:ss"))
}

Mon Jun 01 12:00:00 CST 2020
```
## DateString 时间转字符串
```
void testDateString() {
    println(DateString.dateString(new Date(),"yyyy-MM-dd HH:mm:ss"))
}

2020-06-11 09:08:16
```
# 随机
## RandomSample 不重复随机采样
```
void testRandomSample() {
    println(RandomSample.randomSample(Range.range(10), 4))
}

[7, 0, 4, 8]

void testRandomSample() {
    println(RandomSample.randomSample(Range.range(10), 11))
}

[1, 2, 9, 3, 5, 4, 0, 8, 6, 7]
```
## RandomInteger 伪随机整数
```
void testRandomInteger() throws Exception {
    println(RandomInteger.randomInteger(0, 10, 10))
}

[6, 3, 1, 9, 3, 5, 7, 8, 4, 3]
```
## RandomChoice 伪随机选择
```
void testRandomChoice() {
    println(RandomChoice.randomChoice(["A", "B", "C", "D"], 10))
}

[A, A, C, C, A, B, C, A, C, D]
```
# 网络请求
## URLDownload 下载网络文件
```
void testUrlDownload() {
    println(URLDownload.urlDownload(
            "https://repo1.maven.org/maven2/io/netty/netty-all/4.1.50.Final/netty-all-4.1.50.Final.jar",
            "D:\\",
            new Consumer<Float>() {
                @Override
                void accept(Float aFloat) {
                    System.err.println(aFloat)
                }
            }
    ))
}

99.94338
99.96768
99.97693
100.0
D:\netty-all-4.1.50.Final.jar
```

## JarDownload 下载Jar包（可以查看进度）
```
void testJarDownload() {
    println(JarDownload.jarDownload("io.netty:netty-all:4.1.50.Final", "C:\\Users\\Admin\\Desktop\\a", new BiConsumer<String, Float>() {
        @Override
        void accept(String s, Float aFloat) {
            System.out.println(s + "\t" + aFloat)
        }
    }))
}

C:\Users\Admin\Desktop\a\io\netty\netty-all\4.1.50.Final（默认返回目录，下挂三个sha1文件夹）
```
# 数学分析
## NIntegrate 求一元函数积分
```
void testNIntegrate() {
    Function<Double, Double> f = new Function<Double, Double>() {
        @Override
        Double apply(Double aDouble) {
            return Math.sin(Math.sin(aDouble))
        }
    };
    println(NIntegrate.nIntegrate(f, 0, 2, IntegrationMethod.IterativeLegendreGauss))
    println(NIntegrate.nIntegrate(f, 0, 2, IntegrationMethod.MidPoint))
    println(NIntegrate.nIntegrate(f, 0, 2, IntegrationMethod.Romberg))
    println(NIntegrate.nIntegrate(f, 0, 2, IntegrationMethod.Simpson))
    println(NIntegrate.nIntegrate(f, 0, 2, IntegrationMethod.Trapezoid))
}

1.2470560538570927
1.2470567278907687
1.2470560580690107
1.2470560656862713
1.2470556590870487
```
# 文件操作
## Export 导出数据
```
public class Pojo {

    @ExcelColumnName(value = "名称", order = 2)   //用于选择要导出的字段
    private String name;

    @ExcelColumnName(value = "年龄", order = 1)
    private int age;

    @ExcelColumnName(value = "性别", order = 3)
    private String sex;

}
```
### 导出数据到excel（默认jxl，兼容android，注解@ExcelColumnName用来选择字段）
```
void testExportXlsx() {
    println(Export.exportExcel(IExcel.JXL, "D:\\helloworld.xlsx", false, [[new Pojo("zlb", 18, "男")]]))
}

（文件内容）
年龄	名称	性别
18	zlb	男
```
### 导出数据到word（标题，表格，标题，表格，。。。）
```
void testExportWord() {
    List<Object> content = new ArrayList<>()
    content.add("table 1")
    content.add([["c1", "c2", "c3"], ["aaa", "aa", "a"], ["aaa", "bbb", "ccc"]] as String[][])
    content.add("table2")
    content.add([["c1", "c2", "c3"], ["aaa", "bbb", "ccc"], ["aaa", "bbb", "ccc"]] as String[][])
    content.add("table3")
    content.add([["c1", "c2", "c3"], ["fff", "fff", "ff"], ["ggg", "ggg", "eee"]] as String[][])
    println(Export.exportWord("D:\\helloworld.doc", content))
}

（文件内容）
table 1
c1	c2	c3
aaa	aa	a
aaa	bbb	ccc
table2
c1	c2	c3
aaa	bbb	ccc
aaa	bbb	ccc
table3
c1	c2	c3
fff	fff	ff
ggg	ggg	eee
```
### 导出到为文本
```
void testExportText(){
    println(Export.exportText("D:\\a.txt","abcdefgh",false))
    println(Export.exportText("D:\\a.txt","123456789",true))
}

（文件内容）
abcdefgh123456789
```
## ImportString 导入字符串
### 导入XML为Map
```
void testImportStringXml() {
    Map map = ImportString.importXml("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<xmlBean>\n" +
            "    <name>xxl</name>\n" +
            "    <age>18</age>\n" +
            "    <goods>\n" +
            "        <name>child1</name>\n" +
            "        <weight>5</weight>\n" +
            "    </goods>\n" +
            "    <goods>\n" +
            "        <name>child2</name>\n" +
            "        <weight>10</weight>\n" +
            "    </goods>\n" +
            "</xmlBean>")
    println(map)
}

[name:xxl, goods:[[name:child1, weight:5], [name:child2, weight:10]], age:18]
```
### 导入XML为对象(配合注解@XmlRootElement，@XmlType，@XmlAccessorType，@XmlElement等注解)
```
void testImportString() {
    XmlBean xmlBean = ImportString.importXml("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<xmlBean>\n" +
            "    <name>xxl</name>\n" +
            "    <age>18</age>\n" +
            "    <goods>\n" +
            "        <name>child1</name>\n" +
            "        <weight>5</weight>\n" +
            "    </goods>\n" +
            "    <goods>\n" +
            "        <name>child2</name>\n" +
            "        <weight>10</weight>\n" +
            "    </goods>\n" +
            "</xmlBean>", XmlBean.class)
    println(xmlBean)
}

XmlBean{name='xxl', age=18, state=12, goods=[XmlBeanChild{name='child1', weight=5}, XmlBeanChild{name='child2', weight=10}]}
```
### 导入json为对象
```
void testImportStringObject() {
    Hello hello = ImportString.importJsonObject("{\"name\":\"zlb\",\"age\":111,\"info\":\"some info\",\"number\":1}", Hello.class)
    println(hello)
}

Hello{name='zlb', age=111, info='some info', number=1}
```
### 导入json为Map(值为Object)
```
void testImportStringJson() {
    def map = ImportString.importJsonMapObject("{\n" +
            "    \"status\": \"0000\",\n" +
            "    \"message\": \"success\",\n" +
            "    \"data\": {\n" +
            "        \"title\": {\n" +
            "            \"id\": \"001\",\n" +
            "            \"name\" : \"白菜\"\n" +
            "        },\n" +
            "        \"content\": [\n" +
            "            {\n" +
            "                \"id\": \"001\",\n" +
            "                \"value\":\"你好 白菜\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"002\",\n" +
            "                 \"value\":\"你好 萝卜\" \n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}\n")
    println(map)
}

[status:0000, message:success, data:[title:[id:001, name:白菜], content:[[id:001, value:你好 白菜], [id:002, value:你好 萝卜]]]]
```
### 导入json为Map(只包含第一层的基本类型，不包含复合类型)
```
void testImportStringMapString(){
    def map = ImportString.importJsonMapString("{\n" +
            "    \"status\": \"0000\",\n" +
            "    \"message\": \"success\",\n" +
            "    \"data\": {\n" +
            "        \"title\": {\n" +
            "            \"id\": \"001\",\n" +
            "            \"name\" : \"白菜\"\n" +
            "        },\n" +
            "        \"content\": [\n" +
            "            {\n" +
            "                \"id\": \"001\",\n" +
            "                \"value\":\"你好 白菜\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"002\",\n" +
            "                 \"value\":\"你好 萝卜\" \n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}\n")
    println(map)
}

[message:success, status:0000]
```
## ExportString 导出字符串
### 对象转json
```
void testExportStringJson() {
    Hello hello = new Hello()
    hello.setName("zlb")
    hello.setAge(111)
    hello.setInfo("some info")
    hello.setNumber(1)
    println(ExportString.exportStringJson(hello))
}

{"name":"zlb","age":111,"info":"some info","number":1}
```
### 对象转xml
```
@XmlRootElement
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlBean {

    @XmlElement
    public int age;
    @XmlElement
    public List<XmlBeanChild> goods;
    @XmlElement
    public String name;

    @Override
    public String toString() {
        return "XmlBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", goods=" + goods +
                '}';
    }
}

@XmlType
public class XmlBeanChild {

    @XmlElement
    public String name;

    @XmlElement
    public int weight;

    @Override
    public String toString() {
        return "XmlBeanChild{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}

void testExportStringXml() {
    XmlBean xmlBean = new XmlBean()
    xmlBean.name = "xxl"
    xmlBean.age = 18
    XmlBeanChild c1 = new XmlBeanChild();
    c1.name = "child1"
    c1.weight = 5
    XmlBeanChild c2 = new XmlBeanChild();
    c2.name = "child2"
    c2.weight = 10
    xmlBean.goods = [c1, c2]
    println(ExportString.exportStringXml(xmlBean))
}

<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xmlBean>
    <age>18</age>
    <goods>
        <name>child1</name>
        <weight>5</weight>
    </goods>
    <goods>
        <name>child2</name>
        <weight>10</weight>
    </goods>
    <name>xxl</name>
</xmlBean>

```
## DeleteFile 删除文件
```
void testDeleteFile() {
    println(DeleteFile.deleteFile("C:\\Users\\Admin\\Desktop\\a\\org\\apache\\commons\\commons-lang3\\3.10\\commons-lang3-3.10.jar"))
}

true
```
## CopyFile 复制文件
```
void testCopyFile() {
    println(CopyFile.copyFile("C:\\a.jar","D:\\b.jar"))
}

D:\b.jar
```
## FileExistsQ
```
void testFileExistsQ() {
    println(FileExistsQ.fileExistsQ("C:\\a\\b\\c\\d"))
}

false
```
## FileBaseName 无后缀的文件名
```
void testFileBaseName() throws Exception {
    println(FileBaseName.fileBaseName("first"))
    println(FileBaseName.fileBaseName("second.tar.gz"))
    println(FileBaseName.fileBaseName("three."))
    println(FileBaseName.fileBaseName("four.txt"))
    println(FileBaseName.fileBaseName("C:\\Users\\zhang\\Rdrnss\\Code\\Flavors\\app\\release\\five.txt"))
}

first
second.tar
three
four
five
```
## FileExtension 文件后缀名
```
void testFileExtension() throws Exception {
    println(FileExtension.fileExtension("file.txt"))
    println(FileExtension.fileExtension("file.tar.gz"))
    println(FileExtension.fileExtension("C:\\file\\file\\file.tar.gz"))
    println(FileExtension.fileExtension("C:\\file\\file\\file.txt"))
}

txt
gz
gz
txt
```
## FileNameTake 文件名提取
```
void testFileNameTake() {
    println(FileNameTake.fileNameTake("D:\\a\\b\\c\\d\\e\\f\\g\\h", -1))//后1个
    println(FileNameTake.fileNameTake("D:\\a\\b\\c\\d\\e\\f\\g\\h", 1))//前1个
    println(FileNameTake.fileNameTake("D:\\a\\b\\c\\d\\e\\f\\g\\h", 1, 4))//从0开始的索引
}

h
D:
a\b\c
```
## DirectoryName 目录名
```
void testDirectoryName() throws Exception {
    println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 0))
    println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 1))
    println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 2))
    println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 3))
    println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 4))
    println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 5))
    println("dir:" + DirectoryName.directoryName("C:\\a\\b\\c\\d.txt", 6))
}

dir:C:\a\b\c\d.txt
dir:C:\a\b\c
dir:C:\a\b
dir:C:\a
dir:C:\
dir:null
dir:null
```
## ParentDirectory 父目录
```
void testParentDirectory() throws Exception {
    System.out.println(ParentDirectory.parentDirectory("C:\\Program Files\\abc.txt"))
    System.out.println(ParentDirectory.parentDirectory("C:\\Program Files"))
}

C:\Program Files
C:\
```
## FileNames 查找目录下的所有文件
```
void testFileNames() {
    println(FileNames.fileNames(".*doc", "C:\\Users\\Admin\\Downloads"))
}

[C:\Users\Admin\Downloads\6614839830876524544 (1).apk, C:\Users\Admin\Downloads\6614839830876524544 (2).apk, C:\Users\Admin\Downloads\6614839830876524544 (3).apk, C:\Users\Admin\Downloads\6614839830876524544 (4).apk, C:\Users\Admin\Downloads\6614839830876524544.apk, C:\Users\Admin\Downloads\6678970299108560896.apk, C:\Users\Admin\Downloads\app-rice-debug.apk]
```
# 网络
## HostLookup 根据域名查找IP地址
```
void testHostLookup() {
    println(HostLookup.hostLookup("www.baidu.com"))
}

14.215.177.38
```
## PingTime ping时间(支持window和linux)
```
void testPingTime() {
    System.err.println(PingTime.pingTime("www.baidu.com"))
}

24.0
```
## Telnet 主机端口是否打开
```
void testTelnet() {
    println(Telnet.telnet("www.baidu.com",80))
    println(Telnet.telnet("www.baidu.com",8000))
}

true
false
```
# 外部程序
## External 运行外部程序
### 运行外部程序，返回状态码和应答
```
void testRunProcess() {
    def rule = External.runProcess("git help")
    println(rule.key + "\n" + new String(rule.value))
}


0
usage: git [--version] [--help] [-C <path>] [-c <name>=<value>]
           [--exec-path[=<path>]] [--html-path] [--man-path] [--info-path]
           [-p | --paginate | -P | --no-pager] [--no-replace-objects] [--bare]
           [--git-dir=<path>] [--work-tree=<path>] [--namespace=<name>]
           <command> [<args>]
```
### 运行外部程序，只返回状态码
```
void testRun() {
    println(External.run('git --help'))
}

0
```
### 发送电子邮件（邮件服务器要开启相应的服务才行）
```
void testSendMail() {
    println(External.sendMail("forbidden@aliyun.com", "附件", "<img src=\"https://himg2.huanqiucdn.cn/attachment2010/2019/1101/20191101072831653.jpg\"/>", [new File("C:\\Users\\zhang\\Desktop\\shu.jpg")], "someone@qq.com", "smtp.aliyun.com", "forbidden@aliyun.com", "forbidden"))
}

（邮件id）
```
# 密码
## BaseDecode 解密（base64）
```
void testBaseEncode() {
    byte[] bytes = BaseEncode.baseEncode("hello world".getBytes())
    println(new String(bytes))
}

aGVsbG8gd29ybGQ=
```
## BaseDecode 加密(base64)
```
void testBaseDecode() {
    def bytes = BaseDecode.baseDecode("aGVsbG8gd29ybGQ=".getBytes())
    println(new String(bytes))
}

hello world
```
## Hash 哈希
```
支持的方法
MD2("MD2"), MD5("MD5"), SHA1("SHA-1"), SHA224("SHA-224"), SHA256("SHA-256"), SHA384("SHA-384"), SHA512("SHA-512"), SHA3224("SHA3-224"), SHA3256("SHA3-256"), SHA3384("SHA3-384"), SHA3512("SHA3-512");
```
### 哈希字节数组
```
void testByteArray() {
    println(Hash.encodeHexString(Hash.hashByteArray("hello world".getBytes(), Hash.Algorithm.MD5)))
}

5eb63bbbe01eeed093cb22bb8f5acdc3
```
### 哈希字节缓冲
```
void testByteBuffer() {
    println(Hash.encodeHexString(Hash.hashByteBuffer(ByteBuffer.wrap("hello world".getBytes()), Hash.Algorithm.MD5)))
}

5eb63bbbe01eeed093cb22bb8f5acdc3
```
### 哈希字符串
```
void testHashString() {
    println(Hash.encodeHexString(Hash.hashString("hello world", Hash.Algorithm.MD5)))
}

5eb63bbbe01eeed093cb22bb8f5acdc3
```
### 哈希文件
```
void testHashFile() {
    println(Hash.encodeHexString(Hash.hashFile("D:\\hhh.txt", Hash.Algorithm.MD5))) //文件里面的内容是'hello world'
}

5eb63bbbe01eeed093cb22bb8f5acdc3
```
### 哈希流
```
void testHashStream() {
    def stream = new FileInputStream("D:\\hhh.txt")
    println(Hash.encodeHexString(Hash.hashStream(stream, Hash.Algorithm.MD5)))
    stream.close()
}

5eb63bbbe01eeed093cb22bb8f5acdc3
```
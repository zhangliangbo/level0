# mathematica的简单java实现，一个兴趣项目，不做商业用途
# java编码，groovy测试
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
    println(Select.select([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t > 5;
        }
    }))
    println(Select.select([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], new Predicate<Integer>() {
        @Override
        boolean test(Integer t) {
            return t <= 5;
        }
    }))
}

[6, 7, 8, 9]
[0, 1, 2, 3, 4, 5]
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
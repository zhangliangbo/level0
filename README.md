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
## Array 函数作用于范围，生成列表
## Table 生成二维列表
## Reverse 反向排序
## Join 连接两个列表
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
# 逻辑
## AllTrue 是否所有元素都为真
## AnyTrue 是否有一个元素为真
## NoneTrue 是否没有一个元素为真
## And 逻辑与
## Or 逻辑或
## Not 逻辑非
# 断言
## MemberQ 列表是否存在元素
## FreeQ 列表是否不存在元素
## EvenQ 是否为偶数
## OddQ 是否为奇数
## PrimerQ 是否为素数
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
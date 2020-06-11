# mathematica的简单java实现，一个兴趣项目，不做商业用途
# java编码，groovy测试
# 列表
## Append 列表末尾添加元素
## Prepend 列表起始添加元素
## Insert 给定位置插入元素
## Delete 给定位置删除元素
## Range 根据起始，结束和步长生成范围
## Take 获取列表给定范围的元素
## Drop 删除给定范围的元素
## Position 获取给定元素在列表的位置
## Extract 提取给定位置的元素
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
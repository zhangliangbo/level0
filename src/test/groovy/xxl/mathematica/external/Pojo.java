package xxl.mathematica.external;

import com.alibaba.excel.annotation.ExcelProperty;
import xxl.mathematica.io.excel.ExcelColumnName;

public class Pojo {

    @ExcelProperty(value = "名称", order = 0)
    @ExcelColumnName(value = "名称", order = 2)
    private String name;

    @ExcelProperty(value = "年龄", order = 1)
    @ExcelColumnName(value = "年龄", order = 1)
    private int age;

    @ExcelProperty(value = "性别", order = 2)
    @ExcelColumnName(value = "性别", order = 3)
    private String sex;

    public Pojo() {
    }

    public Pojo(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

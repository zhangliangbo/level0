package xxl.mathematica.external;

import xxl.mathematica.io.excel.ExcelColumnName;

public class Pojo {

    @ExcelColumnName(value = "名称", order = 2)
    private String name;

    @ExcelColumnName(value = "年龄", order = 1)
    private int age;

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

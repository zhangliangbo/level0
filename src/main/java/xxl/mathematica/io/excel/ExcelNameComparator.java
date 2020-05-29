package xxl.mathematica.io.excel;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * excel名称比较器
 */
final class ExcelNameComparator implements Comparator<Field> {

    private ExcelNameComparator() {

    }

    public static ExcelNameComparator getInstance() {
        return Holder.comparator;
    }

    @Override
    public int compare(Field o1, Field o2) {
        int order1 = o1.isAnnotationPresent(ExcelColumnName.class) ? o1.getAnnotation(ExcelColumnName.class).order() : 0;
        int order2 = o2.isAnnotationPresent(ExcelColumnName.class) ? o2.getAnnotation(ExcelColumnName.class).order() : 0;
        return order1 - order2;
    }

    private static class Holder {
        static ExcelNameComparator comparator = new ExcelNameComparator();
    }

}

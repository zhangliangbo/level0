package xxl.mathematica.io.excel;

import java.lang.reflect.Field;

public abstract class AbsExcel implements IExcel {
    /**
     * 指定Excel实现
     *
     * @param method
     * @return
     */
    public static IExcel getExcelImpl(int method) {
        switch (method) {
            case IExcel.POI:
                return PoiExcel.getInstance();
            case IExcel.JXL:
                return JxlExcel.getInstance();
            default:
                throw new IllegalArgumentException("no such implementation");
        }
    }

    public static void setNumber(Object obj, Field field, double value) throws IllegalAccessException {
        if (field.getType() == Byte.class || field.getType() == byte.class) {
            field.setByte(obj, (byte) value);
        } else if (field.getType() == Short.class || field.getType() == short.class) {
            field.setShort(obj, (short) value);
        } else if (field.getType() == Integer.class || field.getType() == int.class) {
            field.setInt(obj, (int) value);
        } else if (field.getType() == Long.class || field.getType() == long.class) {
            field.setLong(obj, (long) value);
        } else if (field.getType() == Float.class || field.getType() == float.class) {
            field.setFloat(obj, (float) value);
        } else {
            field.setDouble(obj, value);
        }
    }
}

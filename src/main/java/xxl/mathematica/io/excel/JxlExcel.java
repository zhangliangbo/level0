package xxl.mathematica.io.excel;

import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import xxl.mathematica.First;
import xxl.mathematica.Select;
import xxl.mathematica.list.Position;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * jxl实现，可用于android
 */
final class JxlExcel implements IExcel {

    private JxlExcel() {

    }

    public static JxlExcel getInstance() {
        return Holder.jxlExcel;
    }

    @Override
    public boolean exportExcel(String file, boolean withAnnotationQ, List<List<Object>> sheets) throws Exception {
        WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
        for (int k = 0; k < sheets.size(); k++) {
            List<Object> list = sheets.get(k);
            WritableSheet sheet = workbook.createSheet("Sheet" + (k + 1), k);
            if (list.size() > 0) {
                for (int i = 0; i < list.size() + 1; i++) {
                    if (i == 0) {
                        Object object = list.get(0);
                        if (object != null) {
                            Field[] fields = object.getClass().getDeclaredFields();
                            if (withAnnotationQ) {
                                fields = Select.select(Arrays.asList(fields), t -> t.isAnnotationPresent(ExcelColumnName.class)).toArray(new Field[0]);
                            }
                            Arrays.sort(fields, ExcelNameComparator.getInstance());
                            for (int j = 0; j < fields.length; j++) {
                                if (fields[j].isAnnotationPresent(ExcelColumnName.class)) {
                                    sheet.addCell(new Label(j, i, fields[j].getAnnotation(ExcelColumnName.class).value()));
                                } else {
                                    if (!withAnnotationQ) {
                                        sheet.addCell(new Label(j, i, "Column" + (j + 1)));
                                    }
                                }
                            }
                        }
                    } else {
                        Object object = list.get(i - 1);
                        if (object != null) {
                            Field[] fields = object.getClass().getDeclaredFields();
                            if (withAnnotationQ) {
                                fields = Select.select(Arrays.asList(fields), t -> t.isAnnotationPresent(ExcelColumnName.class)).toArray(new Field[0]);
                            }
                            Arrays.sort(fields, ExcelNameComparator.getInstance());
                            for (int j = 0; j < fields.length; j++) {
                                if (fields[j].isAnnotationPresent(ExcelColumnName.class) || !withAnnotationQ) {
                                    if (!fields[j].isAccessible()) {
                                        fields[j].setAccessible(true);
                                    }
                                    String value = fields[j].get(object) == null ? "" : fields[j].get(object).toString();
                                    //确定单元格类型
                                    Class<?> cls = fields[j].getType();
                                    if (cls.isPrimitive()) {
                                        if (cls == boolean.class || cls == Boolean.class) {
                                            sheet.addCell(new jxl.write.Boolean(j, i, Boolean.parseBoolean(value)));
                                        } else if (cls == char.class || cls == Character.class) {
                                            sheet.addCell(new jxl.write.Label(j, i, value));
                                        } else {
                                            sheet.addCell(new jxl.write.Number(j, i, Double.parseDouble(value)));
                                        }
                                    } else {
                                        sheet.addCell(new Label(j, i, value));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        workbook.write();
        workbook.close();
        return true;
    }

    @Override
    public List<List<String[]>> importExcel(String file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        Workbook rwb = Workbook.getWorkbook(fis);
        Sheet[] sheet = rwb.getSheets();
        List<List<String[]>> sheetList = new ArrayList<>();
        for (int i = 0; i < sheet.length; i++) {
            Sheet rs = rwb.getSheet(i);
            List<String[]> rowList = new ArrayList<>();
            for (int j = 0; j < rs.getRows(); j++) {
                Cell[] cells = rs.getRow(j);
                String[] columnArray = new String[cells.length];
                for (int k = 0; k < cells.length; k++) {
                    columnArray[k] = cells[k].getContents();
                }
                rowList.add(columnArray);
            }
            sheetList.add(rowList);
        }
        fis.close();
        return sheetList;
    }

    @Override
    public <T> List<List<T>> importExcel(String file, Class<T> cls) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        Workbook rwb = Workbook.getWorkbook(fis);
        Sheet[] sheets = rwb.getSheets();
        List<List<T>> sheetList = new ArrayList<>();
        for (int i = 0; i < sheets.length; i++) {
            Sheet rs = rwb.getSheet(i);
            //拿到表头，后续需要查找字段索引
            List<String> columnNames = new ArrayList<>();
            Cell[] heads = rs.getRow(0);
            for (Cell cell : heads) {
                columnNames.add(cell.getContents());
            }
            //处理数据
            List<T> rowList = new ArrayList<>();
            for (int j = 1; j < rs.getRows(); j++) {
                Cell[] cells = rs.getRow(j);
                T obj = cls.newInstance();
                //首先要排序字段，保证一一对应
                Field[] fields = Select.select(Arrays.asList(obj.getClass().getDeclaredFields()), t -> t.isAnnotationPresent(ExcelColumnName.class)).toArray(new Field[0]);
                for (Field field : fields) {
                    String columnName = field.getAnnotation(ExcelColumnName.class).value();
                    int columnIndex = First.first(Position.position(columnNames, columnName), -1);
                    if (columnIndex > -1) {
                        if (!field.isAccessible()) {
                            field.setAccessible(true);
                        }
                        Cell cell = cells[columnIndex];
                        CellType type = cell.getType();
                        if (CellType.BOOLEAN.equals(type)) {
                            field.setBoolean(obj, ((BooleanCell) cell).getValue());
                        } else if (CellType.NUMBER.equals(type)) {
                            double value = ((NumberCell) cell).getValue();
                            AbsExcel.setNumber(obj, field, value);
                        } else {
                            field.set(obj, cell.getContents());
                        }
                    } else {
                        throw new Exception("未找到名称为" + columnName + "的列");
                    }
                }
                rowList.add(obj);
            }
            sheetList.add(rowList);
        }
        fis.close();
        return sheetList;
    }

    private static class Holder {
        static JxlExcel jxlExcel = new JxlExcel();
    }
}

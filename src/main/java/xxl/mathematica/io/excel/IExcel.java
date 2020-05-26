package xxl.mathematica.io.excel;

import java.util.List;

public interface IExcel {
    /**
     * poi实现
     */
    int POI = 1;
    /**
     * jxl实现
     */
    int JXL = 2;

    /**
     * 导出excel
     *
     * @param file            excel文件
     * @param withAnnotationQ 是否有注解
     * @param sheets          表格
     * @return
     */
    boolean exportExcel(String file, boolean withAnnotationQ, List<List<Object>> sheets) throws Exception;

    /**
     * 导入excel为文本
     *
     * @param file excel文件
     * @return
     * @throws Exception
     */
    List<List<String[]>> importExcel(String file) throws Exception;

    /**
     * 导入excel为对象
     *
     * @param file
     * @param cls  必须提供无参构造函数，否则无法初始化对象
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> List<List<T>> importExcel(String file, Class<T> cls) throws Exception;
}

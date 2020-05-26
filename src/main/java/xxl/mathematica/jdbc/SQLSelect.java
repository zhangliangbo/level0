package xxl.mathematica.jdbc;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.behavior.ICacheAccess;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 选择数据
 */
public class SQLSelect {

    private static final ICacheAccess<DataSource, QueryRunner> cache = JCS.getInstance("xxl.mathematica.jdbc");

    /**
     * 获取查询Runner
     *
     * @param source
     * @return
     */
    private static QueryRunner getRunner(DataSource source) {
        if (cache.get(source) == null) {
            cache.put(source, new QueryRunner(source));
        }
        return cache.get(source);
    }

    /**
     * 在数据源source执行sql
     *
     * @param source
     * @param sql
     * @return 列表表示集合，字典表示对象
     */
    public static List<Map<String, Object>> sqlSelect(DataSource source, String sql) {
        try {
            return getRunner(source).query(sql, rs -> {
                List<Map<String, Object>> list = new ArrayList<>();
                while (rs.next()) {
                    Map<String, Object> map = new HashMap<>();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        String name = rs.getMetaData().getColumnName(i);
                        Object value;
                        try {
                            value = rs.getObject(i);
                        } catch (Exception e) {
                            value = null;
                        }
                        map.put(name, value);
                    }
                    list.add(map);
                }
                return list;
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 在数据源source执行sql
     *
     * @param source
     * @param tableName 表名
     * @return 列表表示集合，字典表示对象
     */
    public static Map<String, String> sqlSelectMeta(DataSource source, String tableName) {
        try {
            return getRunner(source).query("select * from " + tableName + " limit 1", rs -> {
                Map<String, String> map = new HashMap<>();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String name = rs.getMetaData().getColumnName(i);
                    String type = rs.getMetaData().getColumnTypeName(i);
                    map.put(name, type);
                }
                return map;
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 在数据源source执行sql
     *
     * @param source
     * @param sql    表名
     * @return 列表表示集合，字典表示对象
     */
    public static int sqlUpdate(DataSource source, String sql) {
        try {
            return getRunner(source).update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

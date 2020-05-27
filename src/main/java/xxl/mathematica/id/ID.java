package xxl.mathematica.id;

import com.relops.snowflake.Snowflake;

import java.util.HashMap;
import java.util.Map;

/**
 * 唯一的ID字符串
 */
public class ID {

    private static final Map<Integer, Snowflake> snowflakeMap = new HashMap<>();

    /**
     * 雪花算法ID
     *
     * @param node
     * @return
     */
    public static String snowflake(int node) {
        Snowflake sf = snowflakeMap.get(node);
        if (sf == null) {
            sf = new Snowflake(node);
            snowflakeMap.put(node, sf);
        }
        return String.valueOf(sf.next());
    }
}

package xxl.mathematica.cache;

import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.behavior.ICacheAccess;
import org.apache.commons.jcs.engine.ElementAttributes;
import org.apache.commons.jcs.engine.behavior.IElementAttributes;

/**
 * @author zhangliangbo
 * @since 2020/9/6
 **/
public class Cache {
    private static final ICacheAccess<String, Object> iCacheAccess = JCS.getInstance("default");

    /**
     * 获取值
     *
     * @param key 键
     * @return 值
     */
    public static Object get(String key) {
        return iCacheAccess.get(key);
    }

    /**
     * 放入值
     *
     * @param key   键
     * @param value 值
     */
    public static void put(String key, Object value) {
        iCacheAccess.put(key, value);
    }

    /**
     * 放入值，带有效期
     *
     * @param key     键
     * @param value   值
     * @param seconds 有效期
     */
    public static void put(String key, Object value, long seconds) {
        IElementAttributes attributes = new ElementAttributes();
        attributes.setMaxLife(seconds);
        iCacheAccess.put(key, value, attributes);
    }

    /**
     * 键不存在时放置
     *
     * @param key   键
     * @param value 值
     */
    public static void putNX(String key, Object value) {
        iCacheAccess.putSafe(key, value);
    }

    /**
     * 清空缓存
     */
    public static void clear() {
        iCacheAccess.clear();
    }

    /**
     * 移除键
     *
     * @param key 键
     */
    public static void remove(String key) {
        iCacheAccess.remove(key);
    }
}

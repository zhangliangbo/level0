package xxl.mathematica.cache;

import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.behavior.ICacheAccess;
import org.apache.commons.jcs.engine.behavior.ICacheElement;

import java.util.Map;

/**
 * @author zhangliangbo
 * @since 2020/9/6
 **/
public class Cache {
    private static final ICacheAccess<String, Object> I_CACHE_ACCESS = JCS.getInstance("default");

    /**
     * 获取值
     *
     * @param key 键
     * @return 值
     */
    public static Object get(String key) {
        return I_CACHE_ACCESS.get(key);
    }

    /**
     * 获取最大空闲时间（超过最大空闲时间，值会被移除）
     * 单位：s
     * 默认值参考cache.ccf
     *
     * @param key 键
     * @return 值
     */
    public static long idleTime(String key) {
        return I_CACHE_ACCESS.getCacheElement(key).getElementAttributes().getIdleTime();
    }

    /**
     * 获取最大生存时间（超过最大生存空间，值会被移除，即使在最大空闲时间内被刷新）
     * 单位：s
     * 默认值参考cache.ccf
     *
     * @param key 键
     * @return 值
     */
    public static long maxLife(String key) {
        return I_CACHE_ACCESS.getCacheElement(key).getElementAttributes().getMaxLife();
    }

    /**
     * 匹配正则表达式的键值对
     *
     * @return 键值对
     */
    public static Map<String, Object> match(String pattern) {
        return I_CACHE_ACCESS.getMatching(pattern);
    }

    /**
     * 放入值
     *
     * @param key   键
     * @param value 值
     */
    public static void put(String key, Object value) {
        I_CACHE_ACCESS.put(key, value);
    }

    /**
     * 放入值，带有效期
     *
     * @param key         键
     * @param value       值
     * @param idleSeconds 有效期
     */
    public static void put(String key, Object value, long idleSeconds) {
        I_CACHE_ACCESS.put(key, value);
        ICacheElement<String, Object> element = I_CACHE_ACCESS.getCacheElement(key);
        element.getElementAttributes().setIdleTime(idleSeconds);
    }

    /**
     * 键不存在时放置
     *
     * @param key   键
     * @param value 值
     */
    public static void putNx(String key, Object value) {
        I_CACHE_ACCESS.putSafe(key, value);
    }

    /**
     * 清空缓存
     */
    public static void clear() {
        I_CACHE_ACCESS.clear();
    }

    /**
     * 移除键
     *
     * @param key 键
     */
    public static void remove(String key) {
        I_CACHE_ACCESS.remove(key);
    }

    /**
     * 获取缓存的大小
     *
     * @return 缓存大小
     */
    public static int size() {
        return I_CACHE_ACCESS.getMatching(".*").size();
    }

    /**
     * 获取缓存的容量
     *
     * @return 缓存容量
     */
    public static int capacity() {
        return I_CACHE_ACCESS.getCacheAttributes().getMaxObjects();
    }
}

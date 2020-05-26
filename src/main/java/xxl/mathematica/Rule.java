package xxl.mathematica;

/**
 * 规则
 *
 * @param <K>
 * @param <V>
 */
public class Rule<K, V> {

    private K key;
    private V value;

    public Rule(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    /**
     * 创建一个规则
     *
     * @param k
     * @param v
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Rule<K, V> valueOf(K k, V v) {
        return new Rule<>(k, v);
    }
}

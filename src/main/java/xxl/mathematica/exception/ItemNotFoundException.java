package xxl.mathematica.exception;

/**
 * 未找到结果异常
 */

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(String param) {
        super("can not find item that meet " + param);
    }
}

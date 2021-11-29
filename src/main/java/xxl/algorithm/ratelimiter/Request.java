package xxl.algorithm.ratelimiter;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangliangbo
 * @since 2021/11/14
 **/

@ToString
@Slf4j
public class Request {
    private final int data;

    public Request(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}

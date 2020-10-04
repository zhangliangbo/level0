package xxl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 1000000; i++) {
            log.info("the number is {}", i);
            Thread.sleep(10);
        }
    }

}

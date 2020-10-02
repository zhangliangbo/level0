package xxl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) throws Exception {
        Integer one = new Integer(1);
        Integer two = new Integer(1);
        log.info("{}", one == two);
    }

}

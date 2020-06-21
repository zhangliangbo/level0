package xxl.mathematica.io;

import io.vavr.control.Try;

import java.util.concurrent.Callable;

/**
 * 提取文件名
 */
public class FileNameTake {
    public static String fileNameTake(String file, int s, int e) {
        return Try.ofCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        }).getOrNull();
    }
}

package xxl.mathematica.exception;

/**
 * 达到计算的最大步数异常
 */

public class MaxStepException extends Exception {

    public MaxStepException(int max) {
        super("evaluate times have more the default max times " + max);
    }

    public MaxStepException(String string) {
        super(string);
    }
}

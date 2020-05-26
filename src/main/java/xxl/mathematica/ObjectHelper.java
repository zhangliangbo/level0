package xxl.mathematica;

import java.util.List;

/**
 * 对象助手
 */

public class ObjectHelper {
    public static void requireAscend(int min, int max, String minParam, String maxParam) {
        if (min > max) {
            throw new IllegalArgumentException(minParam + "can not be greater than " + maxParam);
        }
    }

    public static void requireAscend(double min, double max, String minParam, String maxParam) {
        if (min > max) {
            throw new IllegalArgumentException(minParam + "can not be greater than " + maxParam);
        }
    }

    public static <T> void requireLengthNotLessThan(List<T> list, int size, String param) {
        if (list.size() < size) {
            throw new IllegalArgumentException(param + " 's size must not be less than " + size);
        }
    }

    public static <T> void requireLengthNotLessThan(T[] array, int length, String param) {
        if (array.length < length) {
            throw new IllegalArgumentException(param + " 's size must not be less than " + length);
        }
    }

    public static int requireNonNegative(int value, String param) {
        if (value < 0) {
            throw new IllegalArgumentException(param + " >= 0 required but it was " + value);
        } else {
            return value;
        }
    }

    public static float requireNonNegative(float value, String param) {
        if (value < 0f) {
            throw new IllegalArgumentException(param + " >= 0 required but it was " + value);
        } else {
            return value;
        }
    }

    public static double requireNonNegative(double value, String param) {
        if (value < 0D) {
            throw new IllegalArgumentException(param + " >= 0 required but it was " + value);
        } else {
            return value;
        }
    }

    public static long requireNonNegative(long value, String param) {
        if (value < 0L) {
            throw new IllegalArgumentException(param + " >= 0 required but it was " + value);
        } else {
            return value;
        }
    }

    public static void requireNonNegative(Number... numbers) {
        if (numbers != null) {
            for (Number n : numbers) {
                if (n.intValue() < 0) {
                    throw new IllegalArgumentException("parameter can not be negative");
                }
            }
        }
    }

    /**
     * 如果对象为空，则抛出异常
     */
    public static void requireNonNull(Object... objects) {
        if (objects != null) {
            for (Object o : objects) {
                if (o == null) {
                    throw new IllegalArgumentException("parameter is null");
                }
            }
        }
    }

    public static int requireNonZero(int value, String param) {
        if (value == 0) {
            throw new IllegalArgumentException(param + " != 0 required but it was " + value);
        } else {
            return value;
        }
    }

    public static void requirePositive(Number... numbers) {
        if (numbers != null) {
            for (Number n : numbers) {
                if (n.intValue() <= 0) {
                    throw new IllegalArgumentException("parameter is not positive");
                }
            }
        }
    }

    public static int verifyPositive(int value, String paramName) {
        if (value <= 0) {
            throw new IllegalArgumentException(paramName + " > 0 required but it was " + value);
        } else {
            return value;
        }
    }

    public static long verifyPositive(long value, String paramName) {
        if (value <= 0L) {
            throw new IllegalArgumentException(paramName + " > 0 required but it was " + value);
        } else {
            return value;
        }
    }
}

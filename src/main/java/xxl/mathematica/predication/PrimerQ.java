package xxl.mathematica.predication;

import io.vavr.control.Try;
import org.apache.commons.math3.primes.Primes;

/**
 * 素数判定
 */

public class PrimerQ {
    /**
     * 是否为素数
     *
     * @param number
     * @return
     */
    public static boolean primerQ(int number) {
        return Try.ofCallable(() -> Primes.isPrime(number)).get();
    }
}

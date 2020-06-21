package xxl.mathematica.analysis;

import io.vavr.control.Try;
import org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator;
import xxl.mathematica.function.Function;

/**
 * 数值积分
 */
public class NIntegrate {
    /**
     * 数值积分
     *
     * @param f
     * @param min
     * @param max
     * @return
     */
    public static double nIntegrate(Function<Double, Double> f, double min, double max) {
        return nIntegrate(f, min, max, IntegrationMethod.MidPoint);
    }

    /**
     * 数值积分
     *
     * @param f
     * @param min
     * @param max
     * @return
     */
    public static double nIntegrate(Function<Double, Double> f, double min, double max, IntegrationMethod method) {
        return Try.ofCallable(() -> method.getIntegrator().integrate(BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT,
                f::apply,
                min,
                max)).get();
    }
}

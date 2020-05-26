package xxl.mathematica.analysis;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator;
import xxl.mathematica.ObjectHelper;
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
        ObjectHelper.requireNonNull(f, method);
        ObjectHelper.requireAscend(min, max, "min", "max");
        return method.getIntegrator().integrate(BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT,
                new UnivariateFunction() {
                    @Override
                    public double value(double x) {
                        return f.apply(x);
                    }
                },
                min,
                max);
    }
}

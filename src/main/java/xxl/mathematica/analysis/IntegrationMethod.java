package xxl.mathematica.analysis;

import org.apache.commons.math3.analysis.integration.*;

/**
 * 积分方法
 */
public enum IntegrationMethod {

    IterativeLegendreGauss(new IterativeLegendreGaussIntegrator(2,
            BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT,
            BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT)),
    MidPoint(new MidPointIntegrator()),
    Romberg(new RombergIntegrator()),
    Simpson(new SimpsonIntegrator()),
    Trapezoid(new TrapezoidIntegrator());

    private final UnivariateIntegrator integrator;

    IntegrationMethod(UnivariateIntegrator integrator) {
        this.integrator = integrator;
    }

    public UnivariateIntegrator getIntegrator() {
        return integrator;
    }
}

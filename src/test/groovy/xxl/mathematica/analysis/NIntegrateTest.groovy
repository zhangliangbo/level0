package xxl.mathematica.analysis

import org.apache.commons.math3.analysis.UnivariateFunction
import org.apache.commons.math3.analysis.integration.gauss.GaussIntegratorFactory
import xxl.mathematica.function.Function

class NIntegrateTest extends GroovyTestCase {
    void testNIntegrate() {
        println(NIntegrate.nIntegrate(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return Math.sin(Math.sin(aDouble))
            }
        }, 0, 2, IntegrationMethod.IterativeLegendreGauss))
        GaussIntegratorFactory factory = new GaussIntegratorFactory();
        println(factory.legendre(100, 0, 2).integrate(new UnivariateFunction() {
            @Override
            double value(double x) {
                return Math.sin(Math.sin(x))
            }
        }))
        println(NIntegrate.nIntegrate(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return Math.sin(Math.sin(aDouble))
            }
        }, 0, 2, IntegrationMethod.MidPoint))
        println(NIntegrate.nIntegrate(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return Math.sin(Math.sin(aDouble))
            }
        }, 0, 2, IntegrationMethod.Romberg))
        println(NIntegrate.nIntegrate(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return Math.sin(Math.sin(aDouble))
            }
        }, 0, 2, IntegrationMethod.Simpson))
        println(NIntegrate.nIntegrate(new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return Math.sin(Math.sin(aDouble))
            }
        }, 0, 2, IntegrationMethod.Trapezoid))
    }
}

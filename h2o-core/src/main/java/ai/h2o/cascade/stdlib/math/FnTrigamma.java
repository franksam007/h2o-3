package ai.h2o.cascade.stdlib.math;

import ai.h2o.cascade.core.GhostFrame;
import org.apache.commons.math3.special.Gamma;

/**
 * Trigamma function
 */
@SuppressWarnings("unused")  // loaded from StandardLibrary
public class FnTrigamma extends FnUniOp {

  public double apply(double x) {
    return x == x? Gamma.trigamma(x) : Double.NaN;
  }

  public GhostFrame apply(GhostFrame frame) {
    return new NumericUniOpFrame(frame, TRIGAMMA);
  }


  private static TrigammaSpec TRIGAMMA = new TrigammaSpec();
  private static class TrigammaSpec extends UniOpSpec {
    public TrigammaSpec() {}
    @Override public String name() { return "trigamma"; }
    @Override public double apply(double x) { return x == x? Gamma.trigamma(x) : Double.NaN; }
  }
}
package de.gaalop.tba.maxima;

import de.gaalop.dfg.Expression;
import de.gaalop.tba.cfgImport.optimization.maxima.MaximaOptimizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author christian
 */
public class Maxima {

    public Maxima() {
    }

    private void test(String str) {
        try {
            Expression expr = MaximaOptimizer.getExpressionFromMaximaOutput(str);

            System.out.println(str + " -> "+expr);

        } catch (RecognitionException ex) {
            Logger.getLogger(Maxima.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



    @Test
    public void testFloatConstant() {
        System.out.print("FloatConstant ");
        test("5.0");
        test("-5.056");
        test("5e-10");
    }
  

}
package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }


    public void testTraceMatrix2x2() {
        Double[][] matrix = {{2D, 3D}, {4D, 5D}};
        Double traceMatrix = MatrixCalculator.traceMatrix(matrix);
        assertEquals(7.0, traceMatrix);
    }

    public void testTraceMatrix2x2Bad() {
        Double[][] matrix = {{2D, 3D, 3D}, {4D, 5D, 4D}};
        Double traceMatrix = MatrixCalculator.traceMatrix(matrix);
        assertNull(traceMatrix);
    }
}

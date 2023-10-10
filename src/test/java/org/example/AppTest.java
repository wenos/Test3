package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.junit.Assert.assertArrayEquals;

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

    public void testMatrixSubtraction() {
        Double[][] matrix1 = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };

        Double[][] matrix2 = {
                {9.0, 8.0, 7.0},
                {6.0, 5.0, 4.0},
                {3.0, 2.0, 1.0}
        };

        Double[][] expectedResult = {
                {-8.0, -6.0, -4.0},
                {-2.0, 0.0, 2.0},
                {4.0, 6.0, 8.0}
        };

        Double[][] result = MatrixCalculator.matrixSubtraction(matrix1, matrix2);

        assertArrayEquals(expectedResult, result);
    }

    public void testMatrixSubtractionBad() {
        Double[][] matrix1 = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };

        Double[][] matrix2 = {
                {9.0, 8.0},
                {6.0, 5.0}
        };

        Double[][] result = MatrixCalculator.matrixSubtraction(matrix1, matrix2);

        assertNull(result);
    }

}

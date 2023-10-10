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

    public void testMultiply() {
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{5, 6}, {7, 8}};

        int[][] expected = {{19, 22}, {43, 50}};
        int[][] result = MatrixCalculator.multiply(matrix1, matrix2);

        assertArrayEquals(expected, result);
    }

    public void testInvalidDimensions() {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{7, 8}, {9, 10}};

        MatrixCalculator.multiply(matrix1, matrix2);
    }

}

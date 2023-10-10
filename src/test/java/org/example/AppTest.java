package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;

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

    public void testAddMatrices() {
        Double[][] matrix1 = {
                {1D, 2D, 3D},
                {4D, 5D, 6D},
                {7D, 8D, 9D}};
        Double[][] matrix2 = {
                {1D, 2D, 3D},
                {4D, 5D, 6D},
                {7D, 8D, 9D}};
        Double[][] expectedResult = {
                {2D, 4D, 6D},
                {8D, 10D, 12D},
                {14D, 16D, 18D}
        };

        Double[][] result = MatrixCalculator.addMatrices(matrix1, matrix2);

        Assert.assertArrayEquals(expectedResult, result);
    }

    public void testAddMatricesWrongRowsCount() {
        Double[][] matrix1 = {
                {1D, 2D, 3D},
                {4D, 5D, 6D},
                {7D, 8D, 9D}};
        Double[][] matrix2 = {
                {1D, 2D, 3D},
                {4D, 5D, 6D}};

        Double[][] result = MatrixCalculator.addMatrices(matrix1, matrix2);

        assertNull(result);
    }

    public void testAddMatricesWrongColumnsCount() {
        Double[][] matrix1 = {
                {1D, 2D},
                {4D, 5D},
                {7D, 8D}};
        Double[][] matrix2 = {
                {1D, 2D, 3D},
                {4D, 5D, 6D},
                {7D, 8D, 9D}};

        Double[][] result = MatrixCalculator.addMatrices(matrix1, matrix2);

        assertNull(result);
    }
}

package lab0;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Variant9Test {
    @Test(dataProvider = "integerProvider")
    public void inputTest(int p1, int p3) {
        assertEquals(new Variant9().integerNumbersTask(p1), p3);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 348, 3 }, { 213, 2 }, { -718, -7 } };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeIntegerTest() {
        new Variant9().integerNumbersTask(-2);
    }

    @Test(dataProvider = "ifProvider")
    public void ifTest(double p1, double p2, double p3) {
        assertEquals(new Variant9().ifTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] { { 312.123, -421.32, -421.32 }, { 3.14, 2.71, 2.71 }, { 10.321, 100.321312, 10.321 } };
    }

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, boolean p3) {
        assertEquals(new Variant9().booleanTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 5, 1, true }, { 8, 7, true }, { -100, 100, false } };
    }

    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, int p2, String s) {
        assertEquals(new Variant9().caseTask(p1, p2), s);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { 21, 6, "22 6" }, { 31, 12, "1 1" }, {28, 2, "1 3"}, {31, 1, "1 2"} };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void switchErrorTest() {
        new Variant9().caseTask(100, 100);
    }

    @Test(dataProvider = "forProvider")
    public void forTest(int p1, int p2, int sum) {
        assertEquals(new Variant9().forTask(p1, p2), sum);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] { { 7, 9, 194}, { 1, 6, 91 } };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void forErrorTest() {
        new Variant9().caseTask(100, 1);
    }

    @Test(dataProvider = "whileProvider")
    public void whileTest(int p1, int p2) {
        assertEquals(new Variant9().whileTask(p1), p2);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 2, 1 }, { 3, 2 }, { 20, 3 }, { 100, 5 } };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void whileErrorTest() {
        new Variant9().whileTask(-100);
    }

    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int[] arr, String value) {
        assertEquals(new Variant9().arrayTask(arr), value);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { { new int[] { 10, 2, 3 }, "[ 2 10 ] count = 2" }, { new int[] { 1, 3, 5, 7, 9 }, "[ ] count = 0" },
                { new int[] { 4, 3, 5, -4, 9, 2, 10, 23, 123, -92, 100 }, "[ 100 -92 10 2 -4 4 ] count = 6" } };
    }

    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[][] input, String output) {
        assertEquals(new Variant9().twoDimensionArrayTask(input), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input = {{2, 3, 6, 9, -9},
                {34, 98, -9, 2, 1},
                {-4, 2, 1, 6, 1},
                {-98, 8, 1, 5, 3}};

        int[][] input2 = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};

        return new Object[][] { {input, "34 98 -9 2 1 \n-98 8 1 5 3 "}, { input2, "4 5 6 \n10 11 12 " } };
    }
}

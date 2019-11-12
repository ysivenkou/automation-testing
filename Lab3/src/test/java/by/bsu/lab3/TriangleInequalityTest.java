package by.bsu.lab3;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

public class TriangleInequalityTest {
    @Test
    public void oneZeroSide() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleInequality.isInequalityHolds(0.0, 6.0, 7.0);
        });
    }

    @Test
    public void moreThanOneZeroSide() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleInequality.isInequalityHolds(876.5, 0.0, 0.0);
        });
    }

    @Test
    public void oneNegativeSide() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleInequality.isInequalityHolds(-42.0, 6.0, 92.9);
        });
    }

    @Test
    public void moreThanOneNegativeSide() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleInequality.isInequalityHolds(-42.0, -6.0, -182.4);
        });
    }

    @Test
    public void oneMaxDoubleAndOneNegativeSide() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleInequality.isInequalityHolds(-42.0, 76, Double.MAX_VALUE);
        });
    }

    @Test
    public void oneSideIsMaxDouble() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleInequality.isInequalityHolds(133.7, Double.MAX_VALUE, 12.0);
        });
    }

    @Test
    public void sumOfTwoSidesEqualsThird() {
        assertFalse(TriangleInequality.isInequalityHolds(3.5, 3.5, 7.0));
    }

    @Test
    public void threeEqualSides() {
        assertTrue(TriangleInequality.isInequalityHolds(42.2, 42.2, 42.2));
    }

    @Test
    public void isoscelesTriangle() {
        assertTrue(TriangleInequality.isInequalityHolds(15.6, 3330.34, 3330.34));
    }

    @Test
    public void miscellaneousTriangle() {
        assertTrue(TriangleInequality.isInequalityHolds(30.0, 40.0, 50.0));
    }


    @Test
    public void nonexistentTriangle() {
        assertFalse(TriangleInequality.isInequalityHolds(90.7, 120.5, 28.4));
    }
}

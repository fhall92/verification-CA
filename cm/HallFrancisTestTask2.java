package cm;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HallFrancisTestTask2 {
    @Test
    public void successTest() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    //-------------------NormalRate and ReducedRate Tests--------------------

    @Test(expected = IllegalArgumentException.class)
    public void nullNormalRate() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = null;
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullReducedRate() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = null;

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeReducedRate() {
        Period periodA = new Period(5, 10);
        Period periodB = new Period(10, 15);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(-1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeNormalRate() {
        Period periodA = new Period(5, 10);
        Period periodB = new Period(10, 15);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(-5);
        BigDecimal reduced = new BigDecimal(5);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void normalRateLessThanReducedRate() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(5);
        BigDecimal reduced = new BigDecimal(10);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    //-------------------NormalPeriods and Reduced Periods Tests------------------
    @Test(expected = NullPointerException.class)
    public void nullNormalPeriods() {
        Period periodA = null;
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }


    @Test(expected = NullPointerException.class)
    public void nullReducedPeriods() {
        Period periodA = new Period(0, 7);
        Period periodB = null;
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void overlappingPeriods() {
        Period periodA = new Period(7, 12);
        Period periodB = new Period(4, 9);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void startHourGreaterThanEndHourNormal() {
        Period periodA = new Period(12, 5);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void startHourGreaterThanEndHourReduced() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(12, 5);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void startHourLessThanZeroNormal() {
        Period periodA = new Period(-3, 12);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void startHourLessThanZeroReduced() {
        Period periodA = new Period(4, 7);
        Period periodB = new Period(-3, 3);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void endHourGreaterThan24Normal() {
        Period periodA = new Period(13, 25);
        Period periodB = new Period(0, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void EndHourGreaterThan24Reduced() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 26);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    //----------------------Calculate() Tests----------------------------------------------
    @Test
    public void calculateBetweenNormalAndReduced() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
        Period periodStay = new Period(5, 10);

        assertEquals(testRate.calculate(periodStay), new BigDecimal(30));
    }

    @Test
    public void calculateBetweenNormalAndFree() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(12, 16);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
        Period periodStay = new Period(5, 10);

        assertEquals(testRate.calculate(periodStay), new BigDecimal(20));
    }

    @Test
    public void calculateBetweenReducedAndFree() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
        Period periodStay = new Period(9, 16);

        assertEquals(testRate.calculate(periodStay), new BigDecimal(15));
    }

    @Test
    public void calculateAllNormalRate() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
        Period periodStay = new Period(1, 4);

        assertEquals(testRate.calculate(periodStay), new BigDecimal(30));
    }

    @Test
    public void calculateAllReducedRate() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
        Period periodStay = new Period(9, 11);

        assertEquals(testRate.calculate(periodStay), new BigDecimal(10));
    }
    @Test
    public void calculateAllFreeRate() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
        Period periodStay = new Period(17, 21);

        assertEquals(testRate.calculate(periodStay), new BigDecimal(0));
    }

    @Test(expected = NullPointerException.class)
    public void calculateNullPeriod() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
        Period periodStay = null;

        assertEquals(testRate.calculate(periodStay), new BigDecimal(15));
    }

    //---------------------------------TASK TWO ADDITIONAL TESTS--------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void nullNormalPeriodsList() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = null;
        ArrayList<Period> reducedP = new ArrayList<Period>();
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullReducedPeriodsList() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = null;
        normalP.add(periodA);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test
    public void ValidPeriods() {
        Period periodN1 = new Period(0, 1);
        Period periodN2 = new Period(2,3);
        Period periodN3 = new Period(4,5);
        Period periodR1 = new Period(6, 7);
        Period periodR2 = new Period(8,9);
        Period periodR3 = new Period(10,11);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN1);
        normalP.add(periodN2);
        normalP.add(periodN3);
        reducedP.add(periodR1);
        reducedP.add(periodR2);
        reducedP.add(periodR3);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void OverlappingNormalPeriods() {
        Period periodN1 = new Period(0, 1);
        Period periodN2 = new Period(0,3);
        Period periodN3 = new Period(4,5);
        Period periodR1 = new Period(6, 7);
        Period periodR2 = new Period(8,9);
        Period periodR3 = new Period(10,11);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN1);
        normalP.add(periodN2);
        normalP.add(periodN3);
        reducedP.add(periodR1);
        reducedP.add(periodR2);
        reducedP.add(periodR3);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void OverlappingReducedPeriods() {
        Period periodN1 = new Period(0, 1);
        Period periodN2 = new Period(2,3);
        Period periodN3 = new Period(4,5);
        Period periodR1 = new Period(6, 7);
        Period periodR2 = new Period(6,9);
        Period periodR3 = new Period(10,11);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN1);
        normalP.add(periodN2);
        normalP.add(periodN3);
        reducedP.add(periodR1);
        reducedP.add(periodR2);
        reducedP.add(periodR3);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void OverlappingPeriodLists() {
        Period periodN1 = new Period(0, 1);
        Period periodN2 = new Period(2,3);
        Period periodN3 = new Period(4,5);
        Period periodR1 = new Period(0, 7);
        Period periodR2 = new Period(6,9);
        Period periodR3 = new Period(10,11);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN1);
        normalP.add(periodN2);
        normalP.add(periodN3);
        reducedP.add(periodR1);
        reducedP.add(periodR2);
        reducedP.add(periodR3);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void PeriodListsEqual() {
        Period periodN1 = new Period(0, 1);
        Period periodN2 = new Period(2,3);
        Period periodN3 = new Period(4,5);
        Period periodR1 = new Period(0,1);
        Period periodR2 = new Period(2,3);
        Period periodR3 = new Period(4,5);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN1);
        normalP.add(periodN2);
        normalP.add(periodN3);
        reducedP.add(periodR1);
        reducedP.add(periodR2);
        reducedP.add(periodR3);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(10);
        BigDecimal reduced = new BigDecimal(5);

        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }
}

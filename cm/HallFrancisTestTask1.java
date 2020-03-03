package cm;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HallFrancisTestTask1 {
    //Success Test
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

    @Test(expected = NullPointerException.class)
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

    @Test(expected = NullPointerException.class)
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

        assertEquals(testRate.calculate(periodStay, kind), new BigDecimal(45));
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

        assertEquals(testRate.calculate(periodStay, kind), new BigDecimal(30));
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

        assertEquals(testRate.calculate(periodStay, kind), new BigDecimal(20));
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

        assertEquals(testRate.calculate(periodStay, kind), new BigDecimal(40));
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

        assertEquals(testRate.calculate(periodStay, kind), new BigDecimal(15));
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

        assertEquals(testRate.calculate(periodStay, kind), new BigDecimal(0));
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

        assertEquals(testRate.calculate(periodStay, kind), new BigDecimal(15));
    }

}
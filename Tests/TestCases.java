import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestCases {

    private AP1 ap1 = new AP1();

    @Before
    public void setUp() throws Exception {
        System.out.println("Setting it up!");
    }

    @Test
    public void testHasOne() {
        System.out.println("Running: hasOne");
        assertEquals(ap1.hasOne(10), true);
        assertEquals(ap1.hasOne(22), false);
        assertEquals(ap1.hasOne(220), false);
        assertEquals(ap1.hasOne(212), true);
        assertEquals(ap1.hasOne(1), true);
        assertEquals(ap1.hasOne(9), false);
        assertEquals(ap1.hasOne(211112), true);
        assertEquals(ap1.hasOne(121121), true);
        assertEquals(ap1.hasOne(222222), false);
        assertEquals(ap1.hasOne(56156), true);
        assertEquals(ap1.hasOne(56556), false);
    }

    @Test
    public void testDividesSelf() {
        assertEquals(ap1.dividesSelf(128), true);
        assertEquals(ap1.dividesSelf(12), true);
        assertEquals(ap1.dividesSelf(120), false);
        assertEquals(ap1.dividesSelf(122), true);
        assertEquals(ap1.dividesSelf(13), false);
        assertEquals(ap1.dividesSelf(32), false);
        assertEquals(ap1.dividesSelf(22), true);
        assertEquals(ap1.dividesSelf(42), false);
        assertEquals(ap1.dividesSelf(212), true);
        assertEquals(ap1.dividesSelf(213), false);
        assertEquals(ap1.dividesSelf(162), true);
    }

    @Test
    public void testCopyEvens() {

    } // TODO Finish this test case

    @Test
    public void testMatchUp() {
        System.out.println("Running: matchUp");
        String[] a = {"aa", "bb", "cc"};
        String[] b = {"aaa", "xx", "bb"};
        assertEquals(ap1.matchUp(a, b), 1);
    }

    @Test
    public void testCommonTwo() {
        System.out.println("Running: commonTwo");
        String[] a1 = {"a", "c", "x"};
        String[] a2 = {"b", "c", "d", "x"};
        String[] b1 = {"a", "c", "x"};
        String[] b2 = {"a", "b", "c", "x", "z"};
        String[] c1 = {"a", "a", "b", "b", "c"};
        String[] c2 = {"a", "b", "b", "b", "c"};

        //assertEquals(ap1.commonTwo(a1, a2), 2);
        //assertEquals(ap1.commonTwo(b1, b2), 3);
        assertEquals(ap1.commonTwo(c1, c2), 3);
    }

    @Test
    public void testWithoutString() {
        System.out.println("Running: withoutString");
        String s1 = "Hello there";
        String s2 = "llo";
        String a1 = "He there";
        String s3 = "e";
        String a2 = "Hllo thr";
        String s4 = "xyzzy";
        String a4 = "xzz";

        assertEquals(a1, ap1.withoutString(s1, s2));
        assertEquals(a2, ap1.withoutString(s1, s3));
        assertEquals(a4, ap1.withoutString(s4, "Y"));
    }

    @Test
    public void testCountYZ() {
        System.out.println("Running: countYZ");
        String test1 = "fez day";
        String test2 = "day yak";
        String test3 = "ay fyyyz";
        String test4 = "y2bz";

        assertEquals(2, ap1.countYZ(test1));
        assertEquals(1, ap1.countYZ(test2));
        assertEquals(2, ap1.countYZ(test3));
        assertEquals(2, ap1.countYZ(test4));
    }

    @Test
    public void testEqualIsNot() {
        System.out.println("Running: equalIsNot");
        String test1 = "This is not";
        String test2 = "This is notnot";
        String test3 = "noisxxnotyynotxisi";
        String test4 = "isisnotnot";
        String test5 = "isnotis";
    }

    @Test
    public void testGHappy() {
        System.out.println("Running: gHappy");

        String test1 = "xxgggxyz";
        String test2 = "xxgggxyg";

        assertEquals(true, ap1.gHappy(test1));
        assertEquals(false, ap1.gHappy(test2));

    }

    @Test
    public void testCountTriple() {
        System.out.println("Testing: countTriple");

        String test1 = "abcXXXabc";
        String test2 = "xxxabyyyycd";
        String test3 = "222abyyycdXXX";

        assertEquals(1, ap1.countTriple(test1));
        assertEquals(3, ap1.countTriple(test2));
        assertEquals(3, ap1.countTriple(test3));
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Running: tearDown");
        ap1 = null;
        assertNull(ap1);
    }

}

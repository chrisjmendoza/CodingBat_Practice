import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestCases {

    private AP1 ap1 = new AP1();
    private Recursion1 r1 = new Recursion1();
    private String2 string2 = new String2();
    private String3 string3 = new String3();

    @Before
    public void setUp() throws Exception {
        System.out.println("Setting it up!");
    }

    @Test
    public void testAP1HasOne() {
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
    public void testAP1DividesSelf() {
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
    public void testAP1CopyEvens() {

    } // TODO Finish this test case

    @Test
    public void testAP1MatchUp() {
        System.out.println("Running: matchUp");
        String[] a = {"aa", "bb", "cc"};
        String[] b = {"aaa", "xx", "bb"};
        assertEquals(ap1.matchUp(a, b), 1);
    }

    @Test
    public void testAP1CommonTwo() {
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
    public void testString3CountYZ() {
        System.out.println("Running: countYZ");
        String test1 = "fez day";
        String test2 = "day yak";
        String test3 = "ay fyyyz";
        String test4 = "y2bz";

        assertEquals(2, string3.countYZ(test1));
        assertEquals(1, string3.countYZ(test2));
        assertEquals(2, string3.countYZ(test3));
        assertEquals(2, string3.countYZ(test4));
    }

    @Test
    public void testString3WithoutString() {
        System.out.println("Running: withoutString");
        String s1 = "Hello there";
        String s2 = "llo";
        String a1 = "He there";
        String s3 = "e";
        String a2 = "Hllo thr";
        String s4 = "xyzzy";
        String a4 = "xzz";

        assertEquals(a1, string3.withoutString(s1, s2));
        assertEquals(a2, string3.withoutString(s1, s3));
        assertEquals(a4, string3.withoutString(s4, "Y"));
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

        assertEquals(true, string3.gHappy(test1));
        assertEquals(false, string3.gHappy(test2));

    }

    @Test
    public void testCountTriple() {
        System.out.println("Testing: countTriple");

        String test1 = "abcXXXabc";
        String test2 = "xxxabyyyycd";
        String test3 = "222abyyycdXXX";

        assertEquals(1, string3.countTriple(test1));
        assertEquals(3, string3.countTriple(test2));
        assertEquals(3, string3.countTriple(test3));
    }

    @Test
    public void testSumDigits() {
        System.out.println("Testing: sumDigits");

        String test1 = "aa1bc2d3";

        assertEquals(6, string3.sumDigits(test1));
    }

    @Test
    public void testSameEnds() {
        System.out.println("Testing: sameEnds");

        String test1 = "abXYab";
        String test2 = "xavaXYZjava";

        assertEquals("ab", string3.sameEnds(test1));
        assertEquals("", string3.sameEnds(test2));
    }

    @Test
    public void testMaxBlock() {
        System.out.println("Testing: maxBlock");

        String test1 = "hoopla";
        String test2 = "xyzz";

        assertEquals(2, string3.maxBlock(test1));
        assertEquals(2, string3.maxBlock(test2));
    }

    @Test
    public void testSumNumbers() {
        System.out.println("Testing: sumNumbers");

        String test1 = "abc123xyz";
        String test2 = "aa11b33";
        String test3 = "a22bbb3";

        assertEquals(123, string3.sumNumbers(test1));
        assertEquals(44, string3.sumNumbers(test2));
        assertEquals(25, string3.sumNumbers(test3));
    }

    @Test
    public void testNotReplace() {
        System.out.println("Testing: notReplace");

        String test1 = "is test";
        String test2 = "is-is";
        String test3 = "This is isabell";

        assertEquals("is not test", string3.notReplace(test1));
        assertEquals("is not-is not", string3.notReplace(test2));
        assertEquals("This is not isabell", string3.notReplace(test3));
    }
    @After
    public void tearDown() throws Exception {
        System.out.println("Running: tearDown");
        ap1 = null;
        assertNull(ap1);
    }

}

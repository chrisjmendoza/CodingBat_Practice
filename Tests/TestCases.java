import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
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

    @After
    public void tearDown() throws Exception {
        System.out.println("Running: tearDown");
        ap1 = null;
        assertNull(ap1);
    }

}

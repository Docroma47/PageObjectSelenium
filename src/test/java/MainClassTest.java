import org.junit.*;

public class MainClassTest {
    @Test
    public void test1() {
        Assert.assertNotEquals(10, 2 + 7 );

    }

    @Test
    public void test2() {
        Assert.assertTrue(1 + 1 == 2);

    }

    @Test
    public void test3() {
        Assert.assertFalse(1 + 2 == 2);

    }

    @Test
    public void test4() {
        Assert.assertEquals(10, 5 + 5);

    }

}

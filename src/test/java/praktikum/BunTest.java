package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "name={0}, price={1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"black bun", 100.0f},
                {"white bun", 200.0f}
        };
    }

    @Test
    public void getNameReturnsCorrectName() {
        Bun bun = new Bun(name, price);

        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        Bun bun = new Bun(name, price);

        assertEquals(price, bun.getPrice(), 0.001f);
    }
}
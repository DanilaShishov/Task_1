package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void valuesReturnsAllIngredientTypes() {
        IngredientType[] expectedTypes = {
                IngredientType.SAUCE,
                IngredientType.FILLING
        };

        assertArrayEquals(expectedTypes, IngredientType.values());
    }

    @Test
    public void valueOfReturnsSauceType() {
        assertEquals(
                IngredientType.SAUCE,
                IngredientType.valueOf("SAUCE")
        );
    }

    @Test
    public void valueOfReturnsFillingType() {
        assertEquals(
                IngredientType.FILLING,
                IngredientType.valueOf("FILLING")
        );
    }
}
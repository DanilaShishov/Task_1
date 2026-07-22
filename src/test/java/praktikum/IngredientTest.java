package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(
                IngredientType.SAUCE,
                "hot sauce",
                50.0f
        );
    }

    @Test
    public void getTypeReturnsCorrectType() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    @Test
    public void getNameReturnsCorrectName() {
        assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        assertEquals(50.0f, ingredient.getPrice(), 0.001f);
    }
}
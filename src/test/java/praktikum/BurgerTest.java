package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient firstIngredient;

    @Mock
    private Ingredient secondIngredient;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsSetsBun() {
        burger.setBuns(bun);

        assertSame(bun, burger.bun);
    }

    @Test
    public void addIngredientAddsIngredient() {
        burger.addIngredient(firstIngredient);

        assertEquals(1, burger.ingredients.size());
        assertSame(firstIngredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientRemovesIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertSame(secondIngredient, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientChangesIngredientPosition() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        burger.moveIngredient(0, 1);

        assertSame(secondIngredient, burger.ingredients.get(0));
        assertSame(firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceReturnsTotalBurgerPrice() {
        when(bun.getPrice()).thenReturn(100.0f);
        when(firstIngredient.getPrice()).thenReturn(50.0f);
        when(secondIngredient.getPrice()).thenReturn(25.0f);

        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        assertEquals(275.0f, burger.getPrice(), 0.001f);
    }

    @Test
    public void getReceiptReturnsCorrectReceipt() {
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(200.0f);

        when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(firstIngredient.getName()).thenReturn("hot sauce");
        when(firstIngredient.getPrice()).thenReturn(50.0f);

        when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(secondIngredient.getName()).thenReturn("cutlet");
        when(secondIngredient.getPrice()).thenReturn(100.0f);

        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        String expectedReceipt = String.format(
                "(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%nPrice: %f%n",
                "black bun",
                "sauce",
                "hot sauce",
                "filling",
                "cutlet",
                "black bun",
                550.0f
        );

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
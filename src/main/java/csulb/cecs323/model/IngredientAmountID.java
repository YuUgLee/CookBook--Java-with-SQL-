package csulb.cecs323.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public
class IngredientAmountID implements Serializable {

    private String ingredient;
    private int recipeAmount;


    /**
     * Default Constructor
     */
    public IngredientAmountID() {

    }

    /**
     * Constructor
     * @param r - amount of ingredient for recipe
     * @param i - type of ingredient
     */
    public IngredientAmountID(int r, String i) {
        this.recipeAmount = r;
        this.ingredient=i;

    }
}
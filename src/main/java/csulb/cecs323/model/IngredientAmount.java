package csulb.cecs323.model;
import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Zack.Hunter@student.csulb.edu
 * IngredientAmount represents how much of a given ingredient
 */
@Entity

public class IngredientAmount{

    /**
     * TO DO: Set Primary key and Foreign Keys
     */

    private float amount;
    private String units;
    @EmbeddedId
    private IngredientAmountID id;
    @MapsId("recipeAmount")
    @ManyToOne
    private Recipe recipe;

    @MapsId("ingredient")
    @ManyToOne
    private Ingredient ingredients;


    /**
     * Default Constructor
     */
    public IngredientAmount() {}

    /**
     * Constructor
     * @param amount - how much of an ingredient
     * @param units - units of an ingredient
     * @param ingredient - what kind of ingredient
     * @param recipe - the recipe
     */
    public IngredientAmount(float amount,String units, Ingredient ingredient, Recipe recipe){
        this.amount = amount;
        this.units = units;
        this.ingredients=ingredient;
        this.recipe = recipe;

    }

    /**
     * Sets the amount of ingredient
     * @param amount
     */
    public void setAmount(float amount) {this.amount = amount;}

    /**
     * Returns amount of ingredient
     * @return amount
     */
    public float getAmount() {return amount;}

    /**
     * Sets the units of ingredient
     * @param units
     */
    public void setUnits(String units) {this.units = units;}

    /**
     * Returns units of ingredient
     * @return units
     */
    public String getUnits() {return  units;}

    /**
     * Prints to string
     * @return string
     */
    @Override
    public String toString () {
    return "The recipe for " + recipe.getName() + " requires: " + amount + " " + units + " of ";
    }




}


package csulb.cecs323.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Author: Zack.Hunter@student.csulb.edu
 * Ingredient represents a single type of ingredient
 */
@Entity
public class Ingredient {

    /**
     * TO DO: Set Primary key and Foreign Keys
     */

//     Relationship with Ingredient Amount Association Class
    @OneToMany(mappedBy = "ingredients")
    private List<IngredientAmount> ingredientAmount ;

    // Relationship with Cuisine Class
    @ManyToMany
    @JoinTable(
            name = "cuisineIngredients",
            joinColumns = @JoinColumn(name = "name"),
            inverseJoinColumns = @JoinColumn(name = "cuisineId"))
    private List<Cuisine> cuisines  = new ArrayList<Cuisine>();

    @Id
    private String name;
    private String type;
    private String description;

    /**
     * Ingredient default constructor
     */
    public Ingredient() {}

    /**
     * This is the constructor with parameters for ingredient
     * @param name
     * @param type
     * @param description
     */
    public Ingredient(String name, String type, String description){
        this.name = name;
        this.type = type;
        this.description = description;
    }

    /**
     * This is the constructor with parameters for ingredient with cuisine parameter
     * @param name
     * @param type
     * @param description
     */
    public Ingredient(String name, String type, String description, Cuisine cuisine){
        this.name = name;
        this.type = type;
        this.description = description;
        cuisines.add(cuisine);
    }

    /**
     * Sets the name of the ingredient.
     * @param name
     */
    public void setName(String name) {this.name = name;}

    /**
     * Gets the name of the ingredient
     * @return name
     */
    public String getName() {return name;}

    /**
     * Sets the ingredient type
     * @param type
     */
    public void setType(String type) {this.type = type;}

    /**
     * Gets the ingredient type.
     * @return type
     */
    public String getType() {return type;}

    /**
     * Sets the description of the ingredient.
     * @param description
     */
    public void setDescription(String description) {this.description = description;}

    /**
     * Gets the description of the ingredient.
     * @return description
     */
    public String getDescription() {return description;}

    /**
     * Gets the ingredient amount list.
     * @return
     */
    public List<IngredientAmount> getIngredientAmount() {
        return ingredientAmount;
    }

    /**
     * Sets the ingredient amount list.
     * @param ingredientAmount
     */
    public void setIngredientAmount(List<IngredientAmount> ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    /**
     * Gets the cuisines list.
     * @return
     */
    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    /**
     * Sets the cuisines list.
     * @param cuisines
     */
    public void setCuisines(List<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

    /**
     * Prints to string
     * @return string
     */
    @Override
    public String toString () {
    return " This " + type + " ingredient is known as a " + name + ": " + description;
    }
}

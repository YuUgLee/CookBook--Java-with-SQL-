package csulb.cecs323.model;

import javax.persistence.*;
import java.time.Duration;

/**
 * @Author XanMikhailYakov.Balayan@student.csulb.edu
 * This is a class that handles steps on how to do each recipe.
 */

@Entity
public class Step {
    @EmbeddedId
    public StepID id;
    @MapsId("recipeId")
    @ManyToOne
    private Recipe recipes;


    @MapsId("orderNumber")
    @ManyToOne(cascade = CascadeType.ALL)
    private OrderNumber orderNumber;
    @Column (nullable = false, length = 200)
    private String description;

    private Duration time;

    /**
     * This is the default constructor of the Step class.
     */
    public Step(){}

    /**
     * This is the constructor for the Step class.
     * @param orderNumber
     * @param description
     * @param time
     * @param recipes
     */
    public Step(OrderNumber orderNumber, String description, Duration time, Recipe recipes){
        setOrderNumber(orderNumber);
        setDescription(description);
        setTime(time);
        setRecipes(recipes);
    }

    /**
     * Method to set the order number.
     * @param orderNumber
     */
    public void setOrderNumber(OrderNumber orderNumber) {
        this.orderNumber = orderNumber;
    }
    /**
     * Method to set the recipe.
     * @param recipes
     */
    public void setRecipes(Recipe recipes){
        this.recipes = recipes;
    }

    /**
     * Method to set the description.
     * @param description
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Method to set the time.
     * @param time
     */
    public void setTime(Duration time){
        this.time = time;
    }

    /**
     * Method to get the order number.
     * @return orderNumber
     */
    public OrderNumber getOrderNumber() {
        return orderNumber;
    }

    /**
     * Method to get the description.
     * @return description
     */
    public String getDescription(){
        return description;
    }

    /**
     * Method to get the time.
     * @return time
     */
    public Duration getTime(){
        return time;
    }

    /**
     * Method to get the recipe.
     * @return recipes
     */
    public Recipe getRecipes() {
        return recipes;
    }
}

package csulb.cecs323.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
class StepID implements Serializable {

    private int orderNumber;


    private int recipeId;


    /**
     * Default Constructor
     */
    public StepID() {

    }

    /**
     * Constructor
     * @param r - amount of ingredient for recipe
     * @param i - type of ingredient
     */
    public StepID(int r, int i) {
        this.orderNumber = r;
        this.recipeId =i;

    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int stepId) {
        this.orderNumber = stepId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeIdd) {
        this.recipeId = recipeIdd;
    }

}

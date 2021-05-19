package csulb.cecs323.model;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import java.time.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 * @Author XanMikhailYakov.Balayan@student.csulb.edu
 * This is a class that handles the information regarding the recipes of CookBook.
 */

@Entity
@CascadeOnDelete
@Table (uniqueConstraints = @UniqueConstraint(columnNames = {"cuisineId","chef","name"}))
public class Recipe {
    // Cuisine Relationship
    @ManyToOne
    @JoinColumn(name = "cuisineId", referencedColumnName = "cuisineId")
    private Cuisine cuisines;

//     Ingredient Relationship
    @OneToMany(mappedBy = "recipe")
    private List<IngredientAmount> ingredientAmounts = new ArrayList<>();

    // Chef Relationship
    @ManyToOne
    @JoinColumn(name = "chef", referencedColumnName = "username")
    private Chef chef;

     // Step Relationship
    @OneToMany(mappedBy = "recipes", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Step> steps = new ArrayList<>();

    // Review Relationship
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    // Surrogate Key for Recipe Class
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipeId", nullable = false)
    private int recipeId;

    @Column (nullable = false, length = 50)
    private String name;
    @Column (nullable = false, length = 200)
    private String description;

    private Duration prepTime;
    private Duration cookTime;
    private int difficultyRating;
    private int numberOfServings;

    /**
     * This is the default constructor of the Recipe Class.
     */
    public Recipe(){
            }

    /**
     * This is the constructor of the Recipe Class.
     * @param name
     * @param description
     * @param prepTime
     * @param cookTime
     * @param difficultyRating
     * @param numberOfServings
//     * @param chef
     * @param cuisine
     */
    public Recipe(String name, String description, Duration prepTime, Duration cookTime,
                  int difficultyRating, int numberOfServings, Chef chef, Cuisine cuisine){
        setName(name);
        setDescription(description);
        setPrepTime(prepTime);
        setCookTime(cookTime);
        setDifficultyRating(difficultyRating);
        setNumberOfServings(numberOfServings);
        this.chef = chef;
        this.cuisines = cuisine;

    }

    /**
     * This is a method that sets the name of the recipe.
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * This is a method that sets the description of the recipe.
     * @param description
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     *This is a method that sets the preparation time of the recipe.
     * @param prepTime
     */
    public void setPrepTime(Duration prepTime){
        this.prepTime = prepTime;
    }

    /**
     * This is a method that sets the cook time of the recipe.
     * @param cookTime
     */
    public void setCookTime(Duration cookTime){
        this.cookTime = cookTime;
    }

    /**
     * This is a method that sets the difficulty rating of the recipe.
     * @param difficultyRating
     */
    public void setDifficultyRating(int difficultyRating){
        this.difficultyRating = difficultyRating;
    }

    /**
     * This is a method that sets the number of servings of the recipe.
     * @param numberOfServings
     */
    public void setNumberOfServings(int numberOfServings){
        this.numberOfServings = numberOfServings;
    }

    /**
     * This is a method that sets the cuisine of the recipe.
     * @param cuisines
     */
    public void setCuisines(Cuisine cuisines){
        this.cuisines = cuisines;
    }

    /**
     * This is a method that sets the chef of the recipe.
     * @param chef
     */
    public void setChef(Chef chef){
        this.chef = chef;
    }

    /**
     * This gets the recipe id of the recipe.
     * @return recipeId
     */
    public int getRecipeId(){
        return recipeId;
    }

    /**
     * This gets the name of the recipe.
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * This gets the description of the recipe.
     * @return description
     */
    public String getDescription(){
        return description;
    }

    /**
     * This gets the preparation time of the recipe.
     * @return prepTime
     */
    public Duration getPrepTime(){
        return prepTime;
    }

    /**
     * This gets the cook time of the recipe.
     * @return cookTime
     */
    public Duration getCookTime(){
        return cookTime;
    }

    /**
     * This gets the difficulty rating of the recipe.
     * @return difficultyRating
     */
    public int getDifficultyRating(){
        return difficultyRating;
    }

    /**
     * This gets the number of servings of the recipe.
     * @return numberOfServings
     */
    public int getNumberOfServings(){
        return numberOfServings;
    }

    /**
     * This gets the chef of the recipe.
     * @return chef
     */
    public Chef getChef() {
        return chef;
    }

    /**
     * This gets the cuisine of the recipe.
     * @return cuisisnes
     */
    public Cuisine getCuisines() {
        return cuisines;
    }

    /*
     * This gets the ingredient amount list.
     * @return
     */
    public List<IngredientAmount> getIngredientAmounts() {
        return ingredientAmounts;
    }

    /*
     * This gets the steps list.
     * @return
     */
    public List<Step> getSteps() {
        return steps;
    }

    /*
     * This gets the reviews list.
     * @return
     */
    public List<Review> getReviews() {
        return reviews;
    }

    /*
     * This sets the ingredient amount list.
     * @param ingredientAmounts
     */
    public void setIngredientAmounts(List<IngredientAmount> ingredientAmounts) {
        this.ingredientAmounts = ingredientAmounts;
    }

    /*
     * This sets the steps list.
     * @param steps
     */
    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    /*
     * This sets the reviews list.
     * @param reviews
     */
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}

package csulb.cecs323.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

/**
 * Author: John.Bower@student.csulb.edu
 * Review class objects are food critic reviews for chef's recipes in our Database
 */
@Entity
public class Review {

    @Id
    @Column (nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;
    @Column(nullable = false)
    private LocalDate dateCompleted;
    private float rating;
    private String description;

    // Relationship with FoodCritic
    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "username")
    private FoodCritic reviewAuthor;

    // Relationship with Recipe
    @ManyToOne
    @JoinColumn(name = "recipeId", referencedColumnName = "recipeId")
    private Recipe recipe;

    // Relationship with past review
    //https://thorben-janssen.com/ultimate-guide-association-mappings-jpa-hibernate/#oneToOne
    // Recursive relationship source: https://www.youtube.com/watch?v=GV2tA3_uKBE
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "previousId")
    @JoinColumn(name = "previousId")
    private Review previous;
    @OneToOne
    private Review previousId;

    // Relationship with updated review
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "updateId")
    @JoinColumn(name = "updateId")
    private Review update;
    @OneToOne
    private Review updateId;
    /**
     * Default Constructor
     */
    public Review() {}

    /**
     * Constructor for the Review Class
//     * @param author
     * @param recipe
     * @param dateCompleted
     * @param rating
     * @param description
     */
    public Review(Recipe recipe, FoodCritic author, LocalDate dateCompleted, float rating, String description){
        this.recipe = recipe;
        this.reviewAuthor = author;
        this.dateCompleted = dateCompleted;
        this.rating = rating;
        this.description = description;
    }

    /**
     * Constructor to make a review update
     * @param previous
     * @param author
     * @param dateCompleted
     * @param rating
     * @param description
     */
    public Review(Review previous, FoodCritic author, LocalDate dateCompleted, float rating, String description) {
        this.previous = previous;
        this.recipe = previous.recipe;
        this.reviewAuthor = author;
        this.dateCompleted = dateCompleted;
        this.rating = rating;
        this.description = description;
        previous.addUpdate(this);
    }

    /**
     * Assigns values to Review object's update attribute
     * @param update
     */
    public void addUpdate(Review update){
        this.update = update;
    }

    /**
     * Returns reviewId
     * @return
     */
    public int getReviewId() {return reviewId;}

    /**
     * Sets dateCompleted
     * @param dateCompleted
     */
    public void setDateCompleted(LocalDate dateCompleted) {this.dateCompleted = dateCompleted;}

    /**
     * Returns dateCompleted
     * @return
     */
    public LocalDate getDateCompleted() {return dateCompleted;}

    /**
     * Sets the rating
     * @param rating
     */
    public void setRating(float rating) {this.rating = rating;}

    /**
     * Returns the rating
     * @return
     */
    public float getRating() {return  rating;}

    /**
     * Sets the description
     * @param description
     */
    public void setDescription(String description) {this.description = description;}

    /**
     * Returns description
     * @return
     */
    public String getDescription() {return description;}

    /**
     * Get's Food Critic
     * @return
     */
    public FoodCritic getReviewAuthor() {
        return reviewAuthor;
    }

    /**
     *Sets Food Critic
     * @param reviewAuthor
     */
    public void setReviewAuthor(FoodCritic reviewAuthor) {
        this.reviewAuthor = reviewAuthor;
    }

    /**
     *Gets Recipe
     * @return
     */
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     *Sets Recipe
     * @param recipe
     */
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    /**
     *Gets previous review
     * @return
     */
    public Review getPrevious() {
        return previous;
    }

    /**
     * Sets previous review
     * @param previous
     */
    public void setPrevious(Review previous) {
        this.previous = previous;
    }

    /**
     * Gets previous Id
     * @return
     */
    public Review getPreviousId() {
        return previousId;
    }

    /**
     * Sets previous Id
     * @param previousId
     */
    public void setPreviousId(Review previousId) {
        this.previousId = previousId;
    }

    /**
     * Gets Updates
     * @return
     */
    public Review getUpdate() {
        return update;
    }

    /**
     * Sets updates
     * @param update
     */
    public void setUpdate(Review update) {
        this.update = update;
    }

    /**
     * Gets update Id
     * @return
     */
    public Review getUpdateId() {
        return updateId;
    }

    /**
     * sets Update Id
     * @param updateId
     */
    public void setUpdateId(Review updateId) {
        this.updateId = updateId;
    }

    /**
     * To String method override
     * @return String
     */
    @Override
    public String toString () {
        return "Review of " + this.recipe.getName()
                + "created on " + this.dateCompleted;
    }

}

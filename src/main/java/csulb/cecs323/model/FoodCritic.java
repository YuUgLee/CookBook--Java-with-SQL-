package csulb.cecs323.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Author: John.Bower@student.csulb.edu
 * Food critics are users who author reviews of recipes
 */
@Entity(name = "FoodCritic")
@PrimaryKeyJoinColumn(referencedColumnName = "username")
public class FoodCritic extends User {

    private String currentPlatform;
    private int numberOfReviews;

    // relationship with review
    @OneToMany(mappedBy = "reviewAuthor")
    private List<Review> reviewAuthor = new ArrayList<>();

    // relationship to users who are followers
    // source: https://www.baeldung.com/jpa-many-to-many
    @ManyToMany(mappedBy = "followedCritics")
    Set<User> followers;

    /**
     * default constructor
     */
    public FoodCritic() {super(); this.currentPlatform = "not entered";}

    /**
     * Constructor of the FoodCritic Class
     * @param firstName
     * @param lastName
     * @param username
     * @param password
     * @param email
     * @param dateRegistered
     * @param currentPlatform
     */
    public FoodCritic(String firstName, String lastName, String username, String password,
                      String email, LocalDate dateRegistered, String currentPlatform) {
        super(firstName, lastName, username, password, email, dateRegistered);
        this.currentPlatform = currentPlatform;
    }

    /**
     * Constructor with user object as param
     * @param user
     * @param currentPlatform
     */
    public FoodCritic(User user, String currentPlatform) {this.currentPlatform = currentPlatform; }

    /**
     * Get number of reviews by Food Critic
     */
    public void numberReviews() {
        this.numberOfReviews += 1;
    }

    /**
     * Returns numberOfReviews of FoodCritic
     * @return numberOfReviews
     */
    public int getNumberOfReviews() {return numberOfReviews;}

    /**
     * Sets currentPlatform
     * @param currentPlatform - currentPlatform of FoodCritic
     */
    public void setName(String currentPlatform) {this.currentPlatform = currentPlatform;}

    /**
     * Returns currentPlatform of FoodCritic
     * @return currentPlatform
     */
    public String getCurrentPlatform() {return currentPlatform;}

    /**
     * Returns name of cuisine
     * @return name
     */

    /**
     * To String method override
     * @return "insert here"
     */
    @Override
    public String toString () {
        return super.getUsername() +": Food Critic with " + this.numberOfReviews + " reviews";
    }

}

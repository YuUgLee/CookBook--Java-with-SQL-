package csulb.cecs323.model;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.PrimaryKey;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
Author: Newton.Bao@student.csulb.edu
 */
@Entity(name = "Chef")
@CascadeOnDelete
@PrimaryKeyJoinColumn(referencedColumnName = "username")
public class Chef extends User{

    private int yearsOfExperience;

    // Relationship with Cuisine Class
    @ManyToMany
    @JoinTable(
            name = "chefCuisines",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "cuisineId"))
    private List<Cuisine> cuisines = new ArrayList<Cuisine>();

    //  Relationship to Recipe
    @OneToMany (mappedBy = "chef", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recipe> recipes = new ArrayList<Recipe>();

    /**
     * Default Constructor
     */
    public Chef() {}

//    /**
//     * Constructor
//     * @param yearsOfExperience - number of years in experience
//     */
//    public Chef(int yearsOfExperience, String username, Cuisine cuisine) {
//
//        this.yearsOfExperience = yearsOfExperience;
//        this.username = username;
//        cuisines.add(cuisine);
//    }

    /**
     * Constructor
     * @param firstName
     * @param lastName
     * @param username
     * @param password
     * @param email
     * @param dateRegistered
//     * @param cuisine
     */
    public Chef(String firstName, String lastName, String username, String password,
                String email, LocalDate dateRegistered, int yearsOfExperience, Cuisine cuisine) {
        super(firstName, lastName, username, password, email, dateRegistered);
        this.cuisines.add(cuisine);
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     * Add cuisine to Chef's list of cuisines - John
     * @param cuisine - Cuisine object to add
     */

    public void addCuisineToLIst(Cuisine cuisine) {cuisines.add(cuisine);}

    /**
     * Remove cuisine from Chef's list of cuisines - John
     * @param cuisine - Cuisine object to remove
     */
    public void removeCuisineFromList(Cuisine cuisine) {cuisines.remove(cuisine);}

    /**
     * Returns years of experience
     * @return this.yearsOfExperience
     */
    public int getYearsOfExperience(){
        return this.yearsOfExperience;
    }

    /**
     * Sets years of experience
     * @param experience years of experience
     */
    void setYearsOfExperience(int experience){
        this.yearsOfExperience = experience;
    }

    /**
     * Gets Cuisines
     * @return
     */
    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    /**
     * Sets Cuisines
     * @param cuisines
     */
    public void setCuisines(List<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

    /**
     * Gets Recipes
     * @return
     */

    public List<Recipe> getRecipes() {
        return recipes;
    }

    /**
     * Sets Recipe
     * @param recipes
     */
    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    /**
     * To String method override. This returns a descriptive summary of the object.
     * @return "insert here"
     */
    @Override
    public String toString () {
        return "Chef " + super.getUsername() + " has " + yearsOfExperience + " years of experience.";
    }
}

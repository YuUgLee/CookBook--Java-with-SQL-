package csulb.cecs323.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Zack.Hunter@student.csulb.edu
 * Ingredient Cuisine that a chef would make with ingredients
 */
@Entity
public class Cuisine {

    // Relationship with Chef -John
    @ManyToMany(mappedBy = "cuisines")
    private List<Chef> expertChef = new ArrayList<Chef>();

    // Relationship with Ingredient - John
    @ManyToMany(mappedBy = "cuisines")
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();

    // Relationship to Recipe
    @OneToMany (mappedBy = "cuisines")
    private List<Recipe> recipes = new ArrayList<Recipe>();

    // Surrogate Key for Cuisine Class
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cuisineId;
    private String name;
    private String region;
    private String religion;

/**
     * Default Constructor
     */
    public Cuisine() {}

    /**
     * Constructor
     * @param name - name of the cuisine
     * @param region - where the cuisine originates from
     * @param religion - any religious associations of the cuisine
     */
    public Cuisine(String name, String region, String religion){
        this.name = name;
        this.region = region;
        this.religion = religion;
    }

    /**
     * Returns id of cuisine
     * @return cuisineId
     */
    public int getCuisineId() {return cuisineId;}

    /**
     * Sets name
     * @param name - name of cuisine
     */
    public void setName(String name) {this.name = name;}

    /**
     * Returns name of cuisine
     * @return name
     */
    public String getName() {return name;}

    /**
     * Sets region
     * @param region - region of cuisine
     */
    public void setRegion(String region) {this.religion = region;}

    /**
     * Returns region of cuisine
     * @return region
     */
    public String getRegion() {return region;}

    /**
     * Sets religion
     * @param religion - religion of cuisine
     */
    public void setReligion(String religion) {this.religion = religion;}

    /**
     * Returns name of region
     * @return region
     */
    public String getReligion() {return religion;}

    /**
     * Prints to string
     * @return string
     */
    @Override
    public String toString() {
        if (religion.equals("")) {
            return name + " cuisine is from the " + region + " region.";
        }
        else
            return name + " cuisine is from the " + region + " region. It has associations with the " + religion + " religion.";
    }

}

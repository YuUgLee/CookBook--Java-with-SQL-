package csulb.cecs323.model;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
Author: Newton.Bao@student.csulb.edu
 */
@Entity
//@CascadeOnDelete
//@MappedSuperclass
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance( strategy = InheritanceType.JOINED )
// Mentioned in Piazza post @198
@Table (name = "Users")
public class User implements Serializable {

    private String firstName;
    private String lastName;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="username")
    private String username;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chefUser", referencedColumnName = "username")
    private Chef chef;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn (name = "followers", referencedColumnName = "followerUser")
    private User users;
    @OneToMany(mappedBy = "users")
    private List<User> followerUser = new ArrayList<User>();

    @ManyToMany
    @JoinTable(
            name="FOODCRITIC_FOLLOWED",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "username"))
    Set<FoodCritic> followedCritics;

    private String password;
    private String email;
    private LocalDate dateRegistered;

    /**
     * Default Constructor
     */
    public User() {}

    /**
     * Constructor of the User Class
     * @param firstName
     * @param lastName
     * @param username
     * @param password
     * @param email
     * @param dateRegistered
     */
    public User( String firstName, String lastName, String username, String password, String email, LocalDate dateRegistered) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.username=username;
        this.password=password;
        this.email=email;
        this.dateRegistered=dateRegistered;
    }

    /**
     * This is the constructor that deals with followers of food critics.
     * @param firstName
     * @param lastName
     * @param username
     * @param password
     * @param email
     * @param dateRegistered
     * @param following
     */
    public User(String firstName, String lastName, String username, String password, String email, LocalDate dateRegistered, User following){
        this.firstName = firstName;
        this.lastName=lastName;
        this.username=username;
        this.password=password;
        this.email=email;
        this.dateRegistered=dateRegistered;
        followerUser.add(following);
    }

    /**
     * Sets the follower of the user.
     * @param followerUser
     */
    public void setFollowerUser(List<User> followerUser) {
        this.followerUser = followerUser;
    }

    /**
     * gets the follower of the user
     * @return followerUser
     */
    public List<User> getFollowerUser() {
        return followerUser;
    }

    /**
     * Returns first name
     * @return this.firstname
     */

    public String getFirstName(){
        return this.firstName;
    }

    /**
     * Returns last name
     * @return this.lastname
     */

    public String getLastName(){
        return this.lastName;
    }

    /**
     * Returns username
     * @return this.username
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Returns password
     * @return this.password
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * Returns email
     * @return this.email
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * Returns dateRegistered
     * @return this.dateRegistered
     */

    public LocalDate getDateRegistered(){
        return this.dateRegistered;
    }

    /**
     * Sets first name
     * @param first first name desired to set to
     */
    void setFirstName(String first){
        this.firstName = first;
    }
    /**
     * Sets last name
     * @param last last name desired to set to
     */
    void setLastName(String last){
        this.lastName = last;
    }
    /**
     * Sets username
     * @param user username desired to set to
     */
    void setUsername(String user){
        this.username = user;
    }
    /**
     * Sets password
     * @param pass password desired to set to
     */
    void setPassword(String pass){
        this.password = pass;
    }
    /**
     * Sets email
     * @param email email desired to set to
     */
    void setEmail(String email){
        this.email = email;
    }
    /**
     * Sets date registered
     * @param datereg date registered desired to set to
     */
    void setDateRegistered(LocalDate datereg){
        this.dateRegistered = datereg;
    }

    /**
     * Gets Chef
     * @return
     */
    public Chef getChef() {
        return chef;
    }

    /**
     * Sets Chef
     * @param chef
     */
    public void setChef(Chef chef) {
        this.chef = chef;
    }

    /**
     * Gets User
     * @return
     */
    public User getUsers() {
        return users;
    }

    /**
     * Sets User
     * @param users
     */
    public void setUsers(User users) {
        this.users = users;
    }

    /**
     * Gets Followed Critics
     * @return
     */
    public Set<FoodCritic> getFollowedCritics() {
        return followedCritics;
    }

    /**
     * Sets Followed Critics
     * @param followedCritics
     */
    public void setFollowedCritics(Set<FoodCritic> followedCritics) {
        this.followedCritics = followedCritics;
    }

    /**
     * Prints to string
     * @return string
     */


    @Override
    public String toString () {
    return "This is " + firstName + " " + lastName + "'s account with username: " + username + ", password: "
            + password + ", email: " + email + ". They registerd on: " + dateRegistered;
    }
}
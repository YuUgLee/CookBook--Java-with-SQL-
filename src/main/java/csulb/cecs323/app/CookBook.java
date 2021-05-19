/** Cook Book Project
 * CECS 323-01 CSULB Spring 2021
 * Authors: John.Bower@student.csulb, XanMikhailYakov.Balayan@student.csulb.edu,
 * Zack.Hunter@student.csulb.edu, Newton.Bao@student.csulb.edu
 * Version 1.0
 * 5/7/21
 *
 */

package csulb.cecs323.app;

// Import all of the entity classes that we have written for this application.
import csulb.cecs323.model.*;
import java.time.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.Scanner;


/**
 * This class contains the main()
 * This application will persist objects in JPA to demonstrate our CookBook Database.
 */
public class CookBook {

    private EntityManager entityManager;

    private static final Logger LOGGER = Logger.getLogger(CookBook.class.getName());

    /**
     * The constructor for the CookBook class.  All that it does is stash the provided EntityManager
     * for use later in the application.
     *
     * @param manager The EntityManager that we will use.
     */
    public CookBook(EntityManager manager) {
        this.entityManager = manager;
    }

    public static void main(String[] Args) {

        LOGGER.fine("Creating EntityManagerFactory and EntityManager");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CookBook");
        EntityManager manager = factory.createEntityManager();
        // Create an instance of CookBook and store our new EntityManager as an instance variable.
        CookBook cookbook = new CookBook(manager);


        // Any changes to the database need to be done within a transaction.
        // See: https://en.wikibooks.org/wiki/Java_Persistence/Transactions

        LOGGER.fine("Begin of Transaction");
        EntityTransaction tx = manager.getTransaction();

        tx.begin();

        /**
         *      Create Some User, Chef and FoodCritic Objects to persist in our database
         */

        /**
         * Reference on Local Date parameter: https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
         */
        ArrayList<Recipe> recipes = new ArrayList<Recipe>();
        ArrayList<Review> reviews = new ArrayList<Review>();
        ArrayList <Step> steps = new ArrayList<Step>();
        ArrayList <OrderNumber> orderNumbers = new ArrayList<OrderNumber>();
        ArrayList<IngredientAmount> amounts = new ArrayList<IngredientAmount>();
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ArrayList<Cuisine> cuisines = new ArrayList<Cuisine>();
        ArrayList<Chef> chefs = new ArrayList<Chef>();
        ArrayList<FoodCritic> foodCritics = new ArrayList<FoodCritic>();
        ArrayList<User> users = new ArrayList<User>();

        //OrderNumber objects

        orderNumbers.add(new OrderNumber(1));
        orderNumbers.add(new OrderNumber(2));
        orderNumbers.add(new OrderNumber(3));
        orderNumbers.add(new OrderNumber(4));
        orderNumbers.add(new OrderNumber(5));
        orderNumbers.add(new OrderNumber(6));
        orderNumbers.add(new OrderNumber(7));
        orderNumbers.add(new OrderNumber(8));
        orderNumbers.add(new OrderNumber(9));
        orderNumbers.add(new OrderNumber(10));



        //Cuisine Objects
        cuisines.add(new Cuisine("Western", "USA South", ""));
        cuisines.add(new Cuisine("Mexican", "Mexico", "NULL"));
        cuisines.add(new Cuisine("Japanese", "East Asia", "Shinto"));
        cuisines.add(new Cuisine("Jewish", "Middle East", "Judaism"));
        cuisines.add(new Cuisine("Chinese", "East Asia", "Taoism"));
        cuisines.add(new Cuisine("Turkish", "Middle East", "Islam"));
        cuisines.add(new Cuisine("Filipino", "South East Asia", ""));
        cuisines.add(new Cuisine("Vietnamese", "South East Asian", "Buddhist"));
        cuisines.add(new Cuisine("Brazilian", "Latin America", ""));
        cuisines.add(new Cuisine("Mediterranean", "Mediterranean", ""));
        cuisines.add(new Cuisine("French", "Western Europe", ""));

        //Ingredient objects
        ingredients.add(new Ingredient("Peanut Butter", "Spread", "A smooth spread containing peanuts."));
        ingredients.add(new Ingredient("Strawberry Jam", "Spread", "A  spread containing jam flavored strawberry."));
        ingredients.add(new Ingredient("Tuna", "Seafood", "Fish of the mackerel family"));
        ingredients.add(new Ingredient("Mayonnaise", "Spread", "Thick dressing consisted of egg yolks, oil, and vinegar"));
        ingredients.add(new Ingredient("Bread", "Bakery", "Food made of yeast, flour, and water"));
        ingredients.add(new Ingredient("Lettuce", "Produce", "A cultivated plant with edible leaves"));
        ingredients.add(new Ingredient("Tomato", "Produce", "A red, pulpy fruit cooked as a vegetable"));
        ingredients.add(new Ingredient("Ground Beef", "Meat", "Beef that is cut into smaller pieces"));
        ingredients.add(new Ingredient("Tortilla", "Bakery", "A thin, flat pancake made from cornmeal or flour,"));
        ingredients.add(new Ingredient("Shredded Cheese", "Dairy", "Food made of milk"));
        ingredients.add(new Ingredient("Potato", "Produce", "Powdered spice cooked with poultry or beef"));
        ingredients.add(new Ingredient("Cooking Oil", "Oils", "Powdered spice cooked with poultry or beef"));
        ingredients.add(new Ingredient("Vinegar", "Oils", "A sour-tasting liquid containing acetic acid"));
        ingredients.add(new Ingredient("Carrots", "Produce", "An orange-colored root eaten as a vegetable"));
        ingredients.add(new Ingredient("Persian Cucumber", "Produce", "Thin-skinned, almost seedless cucumbers that have an extra crisp"));

        //Chef objects
        chefs.add(new Chef("Newton", "Bao", "YuUgLee", "yourmom", "inewton228@gmail.com", LocalDate.of(2021, 04, 13), 1, cuisines.get(0)));
        chefs.add(new Chef("Zack", "Hunter", "MeanBeans", "yourson", "zackisahottie@gmail.com", LocalDate.of(2021, 04, 13), 1, cuisines.get(0)));
        chefs.add(new Chef("Xan", "Balayan", "xanbalayan", "yourbrother", "xanbalayan@gmail.com", LocalDate.of(2021, 05, 05), 5, cuisines.get(6)));
        chefs.add(new Chef("Gordon", "Ramsay", "gr", "yousuck", "gramsay@gmail.com", LocalDate.of(2021,05,05), 20, cuisines.get(4)));
        chefs.add(new Chef("Chef", "Boyardee", "ravioli", "canned", "chefboyardee@yahoo.com", LocalDate.of(1967, 07, 05), 60, cuisines.get(9)));
        chefs.add(new Chef("Remy", "Ratatouille", "remyrat", "linguine", "remythebestchef@gusteaus.com", LocalDate.of(2012, 06, 03), 100,cuisines.get(10)));
        chefs.add(new Chef("Auguste", "Gusteau", "gusteau", "anyonecancook", "iamthebest@gusteaus.com", LocalDate.of(2002, 04, 24), 20,cuisines.get(5)));
        chefs.add(new Chef("Guy", "Fiery", "flavortown", "ohio", "guyfiery@fiery.com", LocalDate.of(2008,12,31), 30, cuisines.get(1)));
        chefs.add(new Chef("Iron Chef", "Morimoto", "morimotosan", "kamikaze", "morimotosan@ironchef.com", LocalDate.of(2005, 02, 24), 12, cuisines.get(2)));

        //Recipe Objects
        recipes.add(new Recipe("Peanut Butter and Jelly Sandwich", "This is a sandwich that consists of peanut butter and fruit preserves, either a jelly or jam, spread on 2 slices of bread.", Duration.ofMinutes(5), Duration.ofMinutes(0), 1, 1, chefs.get(0), cuisines.get(0)));
        recipes.add(new Recipe("Tuna Sandwich", "This is a sandwich that consists of tuna and mayonnaise spread on 2 slices of bread.", Duration.ofMinutes(5), Duration.ofMinutes(0), 2, 1, chefs.get(1), cuisines.get(0)));
        recipes.add(new Recipe("Beef Tacos", "A dish that contains a fried tortilla, folded and filled with seasoned meat, lettuce, and tomatoes", Duration.ofMinutes(5), Duration.ofMinutes(25), 2, 3, chefs.get(1), cuisines.get(1)));
        recipes.add(new Recipe("Japanese Potato Salad", "This side dish is served chilled. kewpie brand mayo recommended.", Duration.ofMinutes(30), Duration.ofMinutes(0), 2, 4, chefs.get(0), cuisines.get(2)));
        recipes.add(new Recipe("Classic French Fries", "These homemade fries will beat anything from a drive-through!", Duration.ofMinutes(15), Duration.ofMinutes(15), 3, 4, chefs.get(0), cuisines.get(0)));

        //Peanut Butter and Jelly Sandwich Steps
        steps.add(new Step(orderNumbers.get(0), "Grab your peanut butter and spread it on a slice of the sourdough bread.", Duration.ofMinutes(2), recipes.get(0)));
        steps.add(new Step(orderNumbers.get(1), "Grab your strawberry preserve and spread it on the other slice of bread.", Duration.ofMinutes(2), recipes.get(0)));
        steps.add(new Step(orderNumbers.get(2), "Put both slices of bread together to form the sandwich.", Duration.ofMinutes(1), recipes.get(0)));

        //Tuna Sandwich Steps
        steps.add(new Step(orderNumbers.get(0), "Open your can of tuna and put it on the bowl", Duration.ofMinutes(2), recipes.get(1)));
        steps.add(new Step(orderNumbers.get(1), "Mix in the mayonnaise with the tuna on the bowl", Duration.ofMinutes(2), recipes.get(1)));
        steps.add(new Step(orderNumbers.get(2), "Spread the mixed ingredients on the two slices of bread.", Duration.ofMinutes(1), recipes.get(1)));
        steps.add(new Step(orderNumbers.get(3), "Put both slices of bread together to form the sandwich.", Duration.ofMinutes(1), recipes.get(1)));

        //Beef Tacos Steps
        steps.add(new Step(orderNumbers.get(0), "Chop your lettuce and tomatoes", Duration.ofMinutes(3), recipes.get(2)));
        steps.add(new Step(orderNumbers.get(1), "Put your ground beef into a pot and cook until well done", Duration.ofMinutes(10), recipes.get(2)));
        steps.add(new Step(orderNumbers.get(2), "Warm your tortillas in a separate pan on low heat", Duration.ofMinutes(5), recipes.get(2)));
        steps.add(new Step(orderNumbers.get(3), "Add in 2/3 cup of water and our pour in your taco seasoning to mix. Continue to mix until majority of the water is evaporated.", Duration.ofMinutes(10), recipes.get(2)));
        steps.add(new Step(orderNumbers.get(4), "Place your cooked beef evenly among your tortillas", Duration.ofMinutes(1), recipes.get(2)));
        steps.add(new Step(orderNumbers.get(5), "Add in your toppings (Ex. Lettuce, Tomatoes, Cheese) and fold your tortillas into tacos.", Duration.ofMinutes(1), recipes.get(2)));

        // Japanese Potato Salad Steps
        steps.add(new Step(orderNumbers.get(0), "Boiled three peeled and rough chop potatoes.", Duration.ofMinutes(15), recipes.get(3)));
        steps.add(new Step(orderNumbers.get(1), "Drain boiled potatoes and mix with chopped carrots and persian cucumber. Mix with vinegar and mayo.", Duration.ofMinutes(5), recipes.get(3)));
        steps.add(new Step(orderNumbers.get(2), "Allow potato salad to chill in the refrigerator for at least 10 minutes", Duration.ofMinutes(10), recipes.get(3)));

        // French Fries Steps
        steps.add(new Step(orderNumbers.get(0), "Wash and peel three potatoes and cut into spears of equal thickness.", Duration.ofMinutes(10), recipes.get(4)));
        steps.add(new Step(orderNumbers.get(1), "Heat oil in pan to 325 F. Places fires in hot oil deep enough to submerge.", Duration.ofMinutes(15), recipes.get(4)));
        steps.add(new Step(orderNumbers.get(2), "Remove fries from oil carefully, and sprinkle with salt. Allow fries to cool enough before eating.", Duration.ofMinutes(5), recipes.get(4)));

        foodCritics.add(new FoodCritic("John", "Bower", "jbo", "yourdad", "johnbower@gmail.com", LocalDate.of(2021, 04, 19), "Foodstagram"));
        foodCritics.add(new FoodCritic("Anton", "Ego", "egoist", "ratatouille", "antonego@gmail.com", LocalDate.of(2003, 05, 31), "Foodstagram"));
        foodCritics.add(new FoodCritic("Chip", "Skylark", "sparkles", "shinyteeth", "singer@fairlyodd.com", LocalDate.parse("2013-01-11"), "Foodchat"));
        foodCritics.add(new FoodCritic("Remy", "Bucksaplenty", "money", "dollars", "moneyman@money.com", LocalDate.parse("2012-03-07"), "Foodadvisor"));
        //Ingredient amount objects

        //Peanut Butter and Sandwich
        amounts.add(new IngredientAmount(2, "tablespoon", ingredients.get(0), recipes.get(0)));
        amounts.add(new IngredientAmount(2, "tablespoon", ingredients.get(1), recipes.get(0)));
        amounts.add(new IngredientAmount(2, "slices", ingredients.get(4), recipes.get(0)));
        //Tuna Sandwich
        amounts.add(new IngredientAmount(74, "grams", ingredients.get(2), recipes.get(1)));
        amounts.add(new IngredientAmount(2, "tablespoon", ingredients.get(3), recipes.get(1)));
        amounts.add(new IngredientAmount(2, "slices", ingredients.get(4), recipes.get(1)));
        //Beef Tacos
        amounts.add(new IngredientAmount(1, "ounce", ingredients.get(5), recipes.get(2)));
        amounts.add(new IngredientAmount(1, "piece", ingredients.get(6), recipes.get(2)));
        amounts.add(new IngredientAmount(6, "ounces", ingredients.get(7), recipes.get(2)));
        amounts.add(new IngredientAmount(3, "pieces", ingredients.get(8), recipes.get(2)));
        amounts.add(new IngredientAmount(1, "ounce", ingredients.get(9), recipes.get(2)));
        amounts.add(new IngredientAmount(2, "tablespoon", ingredients.get(10), recipes.get(2)));
        //Japanese Potato Salad
        amounts.add(new IngredientAmount(3, "pieces", ingredients.get(10), recipes.get(3)));
        amounts.add(new IngredientAmount(2, "pieces", ingredients.get(13), recipes.get(3)));
        amounts.add(new IngredientAmount(1, "piece", ingredients.get(14), recipes.get(3)));
        amounts.add(new IngredientAmount(2, "tablespoon", ingredients.get(3), recipes.get(3)));
        amounts.add(new IngredientAmount(1, "tablespoon", ingredients.get(12), recipes.get(3)));
        //French Fries
        amounts.add(new IngredientAmount(3, "pieces", ingredients.get(10), recipes.get(4)));
        amounts.add(new IngredientAmount(1, "cup", ingredients.get(11), recipes.get(4)));

        //Review objects
        reviews.add(new Review(recipes.get(0), foodCritics.get(0), LocalDate.parse("2021-04-20"), 5, "Great for backpacking."));
        reviews.add(new Review(recipes.get(1), foodCritics.get(0), LocalDate.parse("2021-04-20"), 5, "Great for backpacking."));
        reviews.add(new Review(recipes.get(3), foodCritics.get(2), LocalDate.parse("2008-12-03"), 5, "It's really good! Would recommend!"));
        reviews.add(new Review(recipes.get(4), foodCritics.get(2), LocalDate.parse("2008-12-05"), 5, "I'm turning Japanese, turning Japanese, and I think so..."));
        reviews.add(new Review(recipes.get(2), foodCritics.get(2), LocalDate.parse("2008-12-07"), 5, "Remember me, when I go down you stomach. Remember me. Very good!"));
        reviews.add(new Review(recipes.get(3), foodCritics.get(3), LocalDate.parse("2008-12-03"), 1, "Not worth the bucks."));
        reviews.add(new Review(recipes.get(4), foodCritics.get(3), LocalDate.parse("2008-12-05"), 4, "Worth the bucks."));
        reviews.add(new Review(recipes.get(2), foodCritics.get(3), LocalDate.parse("2008-12-07"), 5, "Spend it all here!"));
        reviews.add(new Review(recipes.get(3), foodCritics.get(1), LocalDate.of(2007, 12 ,03), 3, "It's tolerable but not the best"));
        reviews.add(new Review(recipes.get(4), foodCritics.get(1), LocalDate.of(2007, 12 ,05), 3, "Gusteau's mantra of anyone can cook is not true. Some people cannot cook."));
        reviews.add(new Review(recipes.get(2), foodCritics.get(1), LocalDate.of(2007, 12 ,07), 3, "Too greasy but the marinade is good."));

        //User objects    
        users.add(new User("Linguine", "Gusteau", "skinnersucks", "remysucksimthechef", "linguine@gusteaus.com", LocalDate.parse("2012-06-02"), foodCritics.get(1)));
        users.add(new User("Spongebob", "Squarepants", "krabbypatty123", "imready", "s.squarepants@krustykrab.com", LocalDate.parse("2000-02-12"), foodCritics.get(2)));
        users.add(new User("Squidward", "Tentacles", "bestclarinetartist", "spongebobsucks", "s.tentpoles@krustykrab.com", LocalDate.parse("1998-02-12"), foodCritics.get(3)));
        users.add(new User("Colette", "Tatou", "bestrotisseur", "iamthesouschefnottherat", "colette@gusteaus.com", LocalDate.parse("2007-01-12"), foodCritics.get(1)));

        cookbook.createEntity(cuisines);
        cookbook.createEntity(orderNumbers);
        cookbook.createEntity(ingredients);
        cookbook.createEntity(chefs);
        cookbook.createEntity(foodCritics);
        cookbook.createEntity(recipes);
        cookbook.createEntity(amounts);
        cookbook.createEntity(reviews);
        cookbook.createEntity(steps);
        cookbook.createEntity(users);


        // Commit the changes so that the new data persists and is visible to other users.
        tx.commit();
        LOGGER.fine("End of Transaction");

        Scanner scnr = new Scanner(System.in);

        displayMenu(cuisines, chefs, ingredients, foodCritics);


    }   // End of the main method

    /**
     * User interface for the data base
     * @param cuisines
     * @param chefs
     * @param ingredients
     * @param foodCritics
     */
    public static void displayMenu (ArrayList cuisines, ArrayList chefs, ArrayList ingredients, ArrayList foodCritics) {

        int choice = 0;
        do {
            System.out.println("***** Cook Book Database Menu *****");
            System.out.println("Please select an option from 1 - 5 or press 0 to quit.");
            System.out.println("(1) Create a new recipe.");
            System.out.println("(2) Update an existing recipe.");
            System.out.println("(3) Provide food critics with followers.");
            System.out.println("(4) Remove an entity");
            System.out.println("(5) Execute SQL Queries");
            System.out.println("(0) Quit Program");

            Scanner scan = new Scanner(System.in);

            if (scan.hasNextInt() == true) {
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        addRecipe();
                        break;
                    case 2:
                        updateRecipe();
                        break;
                    case 3:
                        foodCriticsMenu();
                        break;
                    case 4:
                        removeChef();
                        break;
                    case 5:
                        runSQL();
                        break;
                    default:
                        System.out.println("Thank you for using the Group 6 CookBook database! Goodbye!");
                        break;
                }
            }
        } while (choice != 0);
    }

    /**
     * This is the addRecipe method of the CookBook class. This method asks the user information to add a recipe into the database
     */
    public static void addRecipe() {

        LOGGER.fine("Creating EntityManagerFactory and EntityManager");
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CookBook");
//        EntityManager manager = factory.createEntityManager();
//        LOGGER.fine("Begin of Adding a Recipe Transaction");
//        EntityTransaction tx = manager.getTransaction();
//
//        tx.begin();

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("CookBook");
        EntityManager em = managerFactory.createEntityManager();
        LOGGER.fine("Begin of Adding a Recipe Transaction");
        em.getTransaction().begin();


        Scanner scan = new Scanner(System.in);
        System.out.println("***** Adding a Recipe *****");

        // Data for the recipe
        System.out.println("What is the recipe name?");
        String recipeName = scan.nextLine();
        System.out.println("What is the recipe description?");
        String recipeDescription = scan.nextLine();
        System.out.println("What is the preparation time of this recipe? (in minutes)");
        int prepTime = scan.nextInt();
        System.out.println("What is the cook time of this recipe? (in minutes)");
        int cookTime = scan.nextInt();
        System.out.println("What is the level of difficulty for the recipe?");
        int difficulty = scan.nextInt();
        System.out.println("How many can this recipe serve?");
        int serving = scan.nextInt();


        // Lists out which cuisines are in the database for the user to choose
        System.out.println("Which cuisine is the new recipe a part of? Please choose the appropriate number.");
        // Query the Cuisines - @Author John.Bower@student.csulb.edu

//        Query query = em.createNativeQuery("SELECT CUISINE.name FROM CUISINE ORDER BY CUISINE.cuisineid");
        Query query = em.createQuery("SELECT c.name FROM Cuisine c ORDER BY c.cuisineId", Cuisine.class);
        Query query2 = em.createQuery("SELECT c.cuisineId FROM Cuisine c ORDER BY c.cuisineId", Cuisine.class);
        List<Cuisine> cuisineList = query.getResultList();
        List<Cuisine> cuisineList2 = query2.getResultList();
        // Iterates through the cuisines
        for(int i=0; i < cuisineList.size(); i++) {
            System.out.println(cuisineList2.get(i) + " " + cuisineList.get(i));
//            System.out.println(cuisineList.get(i+1) + cuisineList.get(i).getName());
        }
//        System.out.println("Cuisines: " + cuisineList);
//        String cuisineName = scan.next();
//        Cuisine cuisine = em.find(Cuisine.class, cuisineName);
        int cuisineIndex = scan.nextInt();
        Cuisine cuisine = em.find(Cuisine.class, cuisineIndex);
        System.out.println(cuisineList.get(cuisineIndex));
        System.out.println(cuisine);

        // Lists out which chefs are in the database for the user to choose
        System.out.println("Who is the chef that worked on the recipe?");
        // Chef Query - @Author John.Bower@student.csulb.edu
//        query = em.createNativeQuery("SELECT USERS.firstname || USERS.lastname AS \"Chefs Name\" FROM USERS WHERE USERS.yearsOfExperience IS NOT NULL");
        query = em.createQuery("SELECT c.username FROM Chef c",Chef.class);
        //
        List<Chef> chefList = query.getResultList();
        // Iterates through the chefs
//        for (int i = 0; i < chefList.size(); i++) {
//            System.out.println((i+1) + " " + chefList.get(i));
//        }
        System.out.println("Chefs: " + chefList);
        String chefUsername = scan.next();
        Chef chefUser = em.find(Chef.class, chefUsername);
        System.out.println(chefUser);
//        int chefIndex = scan.nextInt() - 1;
//        System.out.println(chefIndex);


        //Create Recipe entity
        Recipe recipe = new Recipe(recipeName, recipeDescription, Duration.ofMinutes(prepTime), Duration.ofMinutes(cookTime), difficulty, serving, chefUser, cuisine);
        em.persist(recipe);
//        tx.commit();
//        LOGGER.fine("Recipe Created");

        System.out.println(recipe.toString());

//        //Recipe Query - @Author John.Bower@student.csulb.edu
//        query = em.createNativeQuery("SELECT RECIPE.name FROM RECIPE");
//        List<Recipe> recipeList = query.getResultList();

        // Ingredients
        int response = 1;

        System.out.println("Do you want to add an ingredient or choose and existing ingredient? Choose 1 - yes, 0 - no");
        response = scan.nextInt();
        scan.nextLine();
        do {
            System.out.println("What is the name of the ingredient?");
            String name = scan.nextLine();
//            scan.nextLine();
            System.out.println("What is the type of the ingredient?");
            String type = scan.nextLine();
            System.out.println("What is the description of the ingredient?");
            String description = scan.nextLine();
            System.out.println("What is the amount of this ingredient?");
            float amount = scan.nextFloat();
            scan.nextLine();
            System.out.println("What is the unit of the amount?");
            String unit = scan.nextLine();
            //Create Ingredient entity
            Ingredient ingredient = new Ingredient(name, type, description, cuisine);
            em.persist(ingredient);
//                tx.commit();
            LOGGER.fine("Ingredient Created");
            //Ingredient Query - @Author John.Bower@student.csulb.edu
            query = em.createNativeQuery("SELECT INGREDIENT.name FROM INGREDIENT");
            List<Ingredient> ingredientList = query.getResultList();
            // Create Ingredient Amount entity
            IngredientAmount amounts = new IngredientAmount(amount, unit, ingredient, recipe);
            em.persist(amounts);
//                tx.commit();
            LOGGER.fine("Ingredient Amount Created");
            System.out.println("Do you want to add another ingredient? Choose 1 - yes, 0 - no");
            response = scan.nextInt();
            scan.nextLine();
        } while (response == 1);



        // Steps
        response = 1;

        
        int orderNum = 1;
        do {
            System.out.println("Adding Step to the Recipe...");
            System.out.println("What is the description of the step?");
            String stepDescription = scan.nextLine();
            System.out.println("How long will this step take?");
            int duration = scan.nextInt();

//            query = em.createQuery("SELECT odn.id FROM OrderNumber odn", OrderNumber.class);
            OrderNumber step = em.find(OrderNumber.class, orderNum);

            Step steps = new Step(step, stepDescription, Duration.ofMinutes(duration), recipe);
            em.persist(steps);
            //ingredients.add(new Ingredient(name, type, description, Cuisine cuisine))
            //amounts.add(new IngredientAmount(amount, unit, ingredients.lastIndexOf(), ));
            orderNum++;
            System.out.println("Do you want to add another step? Choose 1 - yes, 0 - no");
            response = scan.nextInt();
            scan.nextLine();
        } while (response == 1);

        System.out.println("Thank you! The new Recipe has been committed to the database.");
        em.getTransaction().commit();
        LOGGER.fine("Added a Recipe, it's ingredients, and steps Transaction");


    } // end of addRecipe method

    /**
     * This is the updateRecipe method of the CookBook class. This method asks the user information to update a recipe in the database.
     */
    public static void updateRecipe () {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("CookBook");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();
        Scanner sc = new Scanner(System.in);
        Query q = em.createNativeQuery("SELECT r.recipeId, r.name" +
                " FROM Recipe r ORDER BY r.recipeId");
        List<Object[]> case2= q.getResultList();
        for (Object[] c: case2){
            System.out.println("Recipe ID: " + c[0] + " Recipe Name: " + c[1]);
        }
        System.out.println("***** Update Recipe *****");
        System.out.println("Which recipe do you want to update?");
        int recipeName = sc.nextInt();
        Recipe recipeId = em.find(Recipe.class, recipeName);

        String response;
        System.out.println("Do you want to update the name? Y/N");
        response = sc.next();
        if (response.equals("Y")){
            sc.nextLine();
            System.out.print("What is the new name for the recipe?");
            String name = sc.nextLine();
            em.createQuery("UPDATE Recipe r " +
                    "SET r.name = :name "  + "WHERE r = :recipe")
                    .setParameter("name", name)
                    .setParameter("recipe", recipeId)
                    .executeUpdate();

        }
        System.out.println("Do you want to update the description? Y/N");
        response = sc.next();
        if (response.equals("Y")){
            sc.nextLine();
            System.out.print("What is the new description for the recipe?");
            String description = sc.nextLine();
            em.createQuery("UPDATE Recipe r " +
                    "SET r.description = :desc "  + "WHERE r = :recipe")
                    .setParameter("desc", description)
                    .setParameter("recipe", recipeId)
                    .executeUpdate();

        }
        System.out.println("Do you want to update the preparation time? Y/N");
        response = sc.next();
        if (response.equals("Y")){
            System.out.println("What is the new preparation time for the recipe? (in minutes)");
            int prepTime = sc.nextInt();
            Duration prep = Duration.ofMinutes(prepTime);
            em.createQuery("UPDATE Recipe r " +
                    "SET r.prepTime = :prep "  + "WHERE r = :recipe")
                    .setParameter("prep", prep)
                    .setParameter("recipe", recipeId)
                    .executeUpdate();

        }
        System.out.println("Do you want to update the cook time? Y/N");

        response = sc.next();
        if (response.equals("Y")){
            sc.nextLine();
            System.out.println("What is the new cook time for the recipe? (in minutes)");
            int cookTime = sc.nextInt();
            Duration cook = Duration.ofMinutes(cookTime);
            em.createQuery("UPDATE Recipe r " +
                    "SET r.cookTime = :cook "  + "WHERE r = :recipe")
                    .setParameter("cook", cook)
                    .setParameter("recipe", recipeId)
                    .executeUpdate();

        }
        System.out.println("Do you want to change the difficulty rating of the recipe? Y/N");

        response = sc.next();
        if (response.equals("Y")){
            sc.nextLine();
            System.out.println("What is the new difficulty rating for the recipe? ");
            int difficultyRating = sc.nextInt();
            em.createQuery("UPDATE Recipe r " +
                    "SET r.difficultyRating = :diff "  + "WHERE r = :recipe")
                    .setParameter("diff", difficultyRating)
                    .setParameter("recipe", recipeId)
                    .executeUpdate();

        }
        System.out.println("Do you want to change the number of servings? Y/N");

        response = sc.next();
        if (response.equals("Y")){
            sc.nextLine();
            System.out.println("What is the new number of servings for the recipe? ");
            int servings = sc.nextInt();
            em.createQuery("UPDATE Recipe r " +
                    "SET r.numberOfServings = :serve "  + "WHERE r = :recipe")
                    .setParameter("serve", servings)
                    .setParameter("recipe", recipeId)
                    .executeUpdate();

        }
        em.getTransaction().commit();
        System.out.println("Thank you! The changes have been committed to the database.");

        LOGGER.fine("End of Update Recipe Transaction");
    }

    /**
     * Removes a food critic from the database
     */
    public static void foodCriticsMenu() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("CookBook");
        EntityManager em = managerFactory.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT f from FoodCritic f",FoodCritic.class);
        List<Chef> fcList = query.getResultList();

        System.out.println("Food Critic(s): " + fcList);

        Scanner sc = new Scanner(System.in);
        String fcUsername = sc.next();
        FoodCritic fcUser = em.find(FoodCritic.class, fcUsername);
        System.out.println("Remove " + fcUser + " from database? (Y/N)");
        String userConfirmation = sc.next();
        System.out.println(userConfirmation);
        userConfirmation.toLowerCase();
        if (userConfirmation.contains("y")) {
            fcUser = em.find(FoodCritic.class, fcUsername);
            em.createQuery("DELETE FROM Review rv " +
                    "WHERE rv.reviewAuthor.username "  + "IN (SELECT fc.username " +
                    "FROM FoodCritic fc WHERE fc.username = :user)")
                    .setParameter("user", fcUsername)
                    .executeUpdate();
            em.createQuery("DELETE FROM FoodCritic fc WHERE fc.username = :user")
                    .setParameter("user", fcUsername)
                    .executeUpdate();

        } else if (userConfirmation == "n") {
            System.out.println("Removal canceled");
        }

        System.out.println(fcUser.getUsername() + " has been removed!");
        em.getTransaction().commit();
        em.close();
        managerFactory.close();
    }

    /**
     * Removes a Chef entity from database
     */
    public static void removeChef() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("CookBook");
        EntityManager em = managerFactory.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT c.username from Chef c",Chef.class);
        List<Chef> chefList = query.getResultList();

        System.out.println("Chefs: " + chefList);

        Scanner sc = new Scanner(System.in);
        String chefUsername = sc.next();
        Chef chefUser = em.find(Chef.class, chefUsername);
            System.out.println("Remove " + chefUsername + " from database? (Y/N)");
            String userConfirmation = sc.next();
            System.out.println(userConfirmation);
            userConfirmation.toLowerCase();
            if (userConfirmation.contains("y")) {
                chefUser = em.find(Chef.class, chefUsername);
                em.createQuery("DELETE FROM Step s " +
                                "WHERE s.id.recipeId IN (SELECT r.recipeId " +
                        "FROM Recipe r WHERE r.chef = :user)")
                        .setParameter("user", chefUser)
                        .executeUpdate();
                em.createQuery("DELETE FROM IngredientAmount i " +
                        "WHERE i.id.recipeAmount IN (SELECT r.recipeId " +
                        "FROM Recipe r WHERE r.chef = :user)")
                        .setParameter("user", chefUser)
                        .executeUpdate();
                em.createQuery("DELETE FROM Review rv " +
                        "WHERE rv.recipe.recipeId "  + "IN (SELECT r.recipeId " +
                        "FROM Recipe r WHERE r.chef = :user)")
                        .setParameter("user", chefUser)
                        .executeUpdate();
                em.createQuery("DELETE FROM Recipe r WHERE r.chef = :user")
                        .setParameter("user", chefUser)
                        .executeUpdate();
                em.createQuery("DELETE FROM Chef c WHERE c = :user")
                        .setParameter("user", chefUser)
                        .executeUpdate();
                System.out.println(chefUsername + " has been removed!");

            } else if (userConfirmation == "n") {
                System.out.println("Removal canceled");
            }

            System.out.println(chefUser.getUsername());
            em.getTransaction().commit();
        em.close();
        managerFactory.close();
    }


    public static void searchDB() {
        System.out.println("To Do: Finish searchDB");
    }


    /**
     * Runs the SQL statements
     */
    public static void runSQL() {
        Scanner scan = new Scanner(System.in);
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("CookBook");
        EntityManager em = managerFactory.createEntityManager();

        em.getTransaction().begin();


        int answer = 1;
        do {
            System.out.println("***** Execute SQL Menu *****");
            System.out.println("Which SQL statements do you want to run? Please select from the indices below or 0 to quit the SQL Menu.");
            System.out.println("(1) Display chefs, their years of experience, and the amount of recipes they know that do not use potatoes (at least than 2)" +
                    " and have a difficulty rating of at least 2");
            System.out.println("(2) Displays each recipe, the recipe's chef, and the amount of steps for that recipe");
            System.out.println("(3) Displays the username of a food critic(s) that have the least amount of reviews," +
                    " as well as the recipe's that they have reviewed, the rating from their review, and the description of the review");
            System.out.println("(4) Show all cuisines with the name of the chef with the most years of experience who is expert in that cuisine.");
            System.out.println("(5) Select all the recipes that will take less than 30 minutes to cook and prepare except for recipes that require" +
                    " more than 2 liters of milk or 1 gallon of milk (there isn't a lot of milk left)");
            System.out.println("(6) Displays the name of all chefs and the amount of recipes that they created");
            System.out.println("(0) Quit SQL Menu");
            answer = scan.nextInt();
            switch (answer){
                case 1:

                    Query q = em.createNativeQuery("SELECT c.username, u.firstName, u.lastName, c.yearsOfExperience, COUNT(r.recipeId)" +
                            " FROM Chef c INNER JOIN Recipe r ON c.username = r.chef INNER JOIN Users u ON c.username = u.username" +
                            " WHERE r.recipeId NOT IN (SELECT r2.recipeId FROM recipe r2 INNER JOIN ingredientAmount ia ON ia.recipe_recipeid = r2.recipeId" +
                            " WHERE ia.ingredients_name = 'Potato')" +
                            " AND r.difficultyRating >= 2" +
                            " GROUP BY c.username, u.firstName, u.lastName, c.yearsOfExperience" +
                            " HAVING COUNT(r.recipeId) >= 2");
                    List<Object[]> case1= q.getResultList();
                    for (Object[] c: case1){
                        System.out.println( "Username: " + c[0] + " First Name: " + c[1] + " Last Name: " + c[2] + " Experience(Years): " + c[3] + " Number of Recipes: " +c[4]);
                    }

                    break;
                case 2:
                    q = em.createNativeQuery("SELECT r.recipeId, r.name, u.firstName, u.lastName , COUNT(s.orderNumber_id)" +
                            " FROM Recipe r LEFT OUTER JOIN Step s ON r.recipeId = s.recipes_recipeid" +
                            " INNER JOIN Chef c ON r.chef = c.username" +
                            " INNER JOIN Users u ON c.username = u.username" +
                            " GROUP BY r.recipeId,r.name,u.firstName,u.lastName");
                    List<Object[]> case2= q.getResultList();
                    for (Object[] c: case2){
                        System.out.println("Recipe ID: " + c[0] + " Recipe Name: " + c[1] + " First Name: " + c[2] + " Last Name: " +c[3] + "Number of Steps: " +c[4]);
                    }
                    break;
                case 3:
                    q = em.createNativeQuery("SELECT fc1.username,rec.name,rev.rating,rev.description" +
                            " FROM Users u1 INNER JOIN FoodCritic fc1 ON u1.username = fc1.username" +
                            " INNER JOIN Review rev ON rev.author = fc1.username" +
                            " INNER JOIN Recipe rec ON rev.recipeId = rec.recipeId" +
                            " WHERE fc1.numberOfReviews = (SELECT MIN(fc2.numberOfReviews)" +
                            " FROM foodcritic fc2)");
                    List<Object[]> case3= q.getResultList();
                    for (Object[] c: case3){
                        System.out.println("Username: " + c[0] + " Recipe Name: " + c[1] + " Rating: " + c[2] + " Description: " +c[3]);
                    }
                    break;
                case 4:
                    q = em.createNativeQuery("SELECT DISTINCT COALESCE(c.username, 'None' ), cuisine.name " +
                            " FROM cuisine LEFT OUTER JOIN ChefCuisines c ON cuisine.cuisineId = c.cuisineId" +
                            " WHERE EXISTS" +
                            " (SELECT MAX(yearsOfExperience)" +
                            " FROM Chef c2" +
                            " INNER JOIN Recipe r ON c2.username = r.chef)");
                    List<Object[]> case4= q.getResultList();
                    for (Object[] c: case4){
                        System.out.println("Username: " + c[0] + " Cuisine Name: " + c[1]);
                    }
                    break;
                case 5:
                    q = em.createNativeQuery("SELECT r.name, r.prepTime, r.cookTime FROM Recipe r" +
                            " WHERE (r.prepTime + r.cookTime) < 30" +
                            " EXCEPT" +
                            " SELECT r.name, r.prepTime, r.cookTime" +
                            " FROM Recipe r INNER JOIN ingredientAmount ia ON r.recipeId = ia.recipe_recipeid" +
                            " WHERE ia.ingredients_name like 'milk' and ((ia.units = 'liters' and ia.amount > 2) or (ia.units = 'gallons' and ia.amount > 1))");
                    List<Object[]> case5= q.getResultList();
                    for (Object[] c: case5){
                        System.out.println("Recipe name: " + c[0] + " Cook Time: " + c[1] + " Prep Time: " + c[2]);
                    }
                    break;
                case 6:
                    q = em.createNativeQuery("SELECT c.username, u.firstname, u.lastname, COUNT(r.recipeId) FROM Chef c" +
                            " INNER JOIN Users u ON u.username = c.username" +
                            " INNER JOIN Recipe r ON c.username = r.chef" +
                            " GROUP by c.username,u.firstName,u.lastName");
                    List<Object[]> case6 = q.getResultList();
                    for (Object[] c: case6){
                        System.out.println("Username: " + c[0] + " First Name:" + c[1] + " Last Name:" + c[2] + " Number of Recipes: " +c[3]);
                    }
                    break;
                default:
                    System.out.println("Invalid input, try again.");
                    break;
            }
        } while (answer != 0);

    }

    public <E> void createEntity(List<E> entities) {
        for (E next : entities) {
            LOGGER.info("Persisting: " + next);
            // Use the CarClub entityManager instance variable to get our EntityManager.
            this.entityManager.persist(next);
        }

        // The auto generated ID (if present) is not passed in to the constructor since JPA will
        // generate a value.  So the previous for loop will not show a value for the ID.  But
        // now that the Entity has been persisted, JPA has generated the ID and filled that in.
        for (E next : entities) {
            LOGGER.info("Persisted object after flush (non-null id): " + next);
        }

    }
}

/**
 *  To Do:
 *      Create functions that will generate some objects into our database
 *          ex)   public void createRecipes();
 *                  public void createReviews();
 */

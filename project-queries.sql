-- Display chefs, their years of experience, and the amount of recipes they know that do not use potato (at least than 2)
-- and have a difficulty rating of at least 2
-- (my girlfriend hates potato but loves fancy food (higher difficulty rating) from good chefs)
SELECT c.username, u.firstName, u.lastName, c.yearsOfExperience, COUNT(r.recipeId)
                            FROM Chef c INNER JOIN Recipe r ON c.username = r.chef INNER JOIN Users u ON c.username = u.username
                            WHERE r.recipeId NOT IN (SELECT r2.recipeId FROM recipe r2 INNER JOIN ingredientAmount ia ON ia.recipe_recipeid = r2.recipeId
                            INNER JOIN Ingredient i ON i.name = ia.ingredients_name
                            WHERE i.name = 'Potato')
                            AND r.difficultyRating >= 2
                            GROUP BY c.username, u.firstName, u.lastName, c.yearsOfExperience
                            HAVING COUNT(r.recipeId) >= 2;


-- displays each recipe, the recipe's chef, and the amount of steps for that recipe
SELECT r.recipeId, r.name, u.firstName, u.lastName , COUNT(s.orderNumber_id)
                            FROM Recipe r LEFT OUTER JOIN Step s ON r.recipeId = s.recipes_recipeid
                            INNER JOIN Chef c ON r.chef = c.username
                            INNER JOIN Users u ON c.username = u.username
                            GROUP BY r.recipeId,r.name,u.firstName,u.lastName;

-- displays the username of a food critic(s) that have the least amount of reviews,
-- as well as the recipe's that they have reviewed, the rating from their review, and the description of the review
SELECT fc1.username,rec.name,rev.rating,rev.description
                            FROM Users u1 INNER JOIN FoodCritic fc1 ON u1.username = fc1.username
                            INNER JOIN Review rev ON rev.author = fc1.username
                            INNER JOIN Recipe rec ON rev.recipeId = rec.recipeId
                            WHERE fc1.numberOfReviews = (SELECT MIN(fc2.numberOfReviews)
                            FROM foodcritic fc2);


-- Show all cuisines with the name of the chef with the most years of experience who is expert in that cuisine.
SELECT DISTINCT COALESCE(c.username, 'None'), cuisine.name
                            FROM cuisine LEFT OUTER JOIN ChefCuisines c ON cuisine.cuisineId = c.cuisineId
                            WHERE EXISTS
                            (SELECT MAX(yearsOfExperience)
                            FROM Chef c2
                            INNER JOIN Recipe r ON c2.username = r.chef);

-- select all the recipes that will take less than 30 minutes to cook and prepare except for recipes that require
-- more than 2 liters of milk or 1 gallon of milk (there isn't a lot of milk left)
SELECT r.name, r.prepTime, r.cookTime FROM Recipe r
                            WHERE (r.prepTime + r.cookTime) < 30
                            EXCEPT
                            SELECT r.name, r.prepTime, r.cookTime
                            FROM Recipe r INNER JOIN ingredientAmount ia ON r.recipeId = ia.recipe_recipeid
                            WHERE ia.ingredients_name like 'milk' and ((ia.units = 'liters' and ia.amount > 2) or (ia.units = 'gallons' and ia.amount > 1));



-- displays the name of all chefs and the amount of recipes that they created
SELECT c.username, u.firstname, u.lastname, COUNT(r.recipeId) FROM Chef c
                            INNER JOIN Users u ON u.username = c.username
                            INNER JOIN Recipe r ON c.username = r.chef 
                            GROUP by c.username,u.firstName,u.lastName;
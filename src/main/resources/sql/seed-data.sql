INSERT INTO Cuisine (name, region, religion) VALUES ('Filipino', 'South East Asia', '')
INSERT INTO Cuisine (name, region, religion) VALUES ('Vietnamese', 'South East Asian', 'Buddhist')
INSERT INTO Cuisine (name, region, religion) VALUES ('Brazilian', 'Latin America', '')
INSERT INTO Cuisine (name, region, religion) VALUES ('Mediterranean', 'Mediterranean', '')
INSERT INTO Cuisine (name, region, religion) VALUES ('French', 'Western Europe', '')


INSERT INTO Chef (firstName, lastName, username, password, email, dateRegistered, yearsOfExperience, cuisine) VALUES ('Xan', 'Balayan', 'xanbalayan', 'yourbrother', 'xanbalayan@gmail.com', '2021-05-05', 5, 'Filipino')
INSERT INTO Chef (firstName, lastName, username, password, email, dateRegistered, yearsOfExperience, cuisine) VALUES ('Gordon', 'Ramsay', 'gr', 'yousuck', 'gramsay@gmail.com', '2020-05-05', 20, 'Western')
INSERT INTO Chef (firstName, lastName, username, password, email, dateRegistered, yearsOfExperience, cuisine) VALUES ('Chef', 'Boyardee', 'ravioli', 'canned', 'chefboyardee@yahoo.com', '1967-07-08', 60, 'Italian')
INSERT INTO Chef (firstName, lastName, username, password, email, dateRegistered, yearsOfExperience, cuisine) VALUES ('Remy', 'Ratatouille', 'remyrat', 'linguine', 'remythebestchef@gusteaus.com', '2012-06-03', 100,'French')
INSERT INTO Chef (firstName, lastName, username, password, email, dateRegistered, yearsOfExperience, cuisine) VALUES ('Auguste', 'Gusteau', 'gusteau', 'anyonecancook', 'iamthebest@gusteaus.com', '2002-04-24', 20, 'French')
INSERT INTO Chef (firstName, lastName, username, password, email, dateRegistered, yearsOfExperience, cuisine) VALUES ('Linguine', 'Gusteau', 'skinnersucks', 'remysucksimthechef', 'linguine@gusteaus.com', '2012-06-02', 1, 'French')
INSERT INTO Chef (firstName, lastName, username, password, email, dateRegistered, yearsOfExperience, cuisine) VALUES ('Guy', 'Fiery', 'flavortown', 'ohio', 'guyfiery@fiery.com', '2008-12-31', 30, 'Western')
INSERT INTO Chef (firstName, lastName, username, password, email, dateRegistered, yearsOfExperience, cuisine) VALUES ('Iron Chef', 'Morimoto', 'morimotosan', 'kamikaze', 'morimotosan@ironchef.com', '2005-02-24', 12, 'Japanese')
INSERT INTO Chef (firstName, lastName, username, password, email, dateRegistered, yearsOfExperience, cuisine) VALUES ('Colette', 'Tatou', 'bestrotisseur', 'iamthesouschefnottherat', 'colette@gusteaus.com', '2007-01-12', 12, 'French')
INSERT INTO Chef (firstName, lastName, username, password, email, dateRegistered, yearsOfExperience, cuisine) VALUES ('Spongebob', 'Squarepants', 'krabbypatty123', 'imready', 's.squarepants@krustykrab.com', '2000-02-12', 20, 'Western')
INSERT INTO Chef (firstName, lastName, username, password, email, dateRegistered, yearsOfExperience, cuisine) VALUES ('Squidward', 'Tentacles', 'bestclarinetartist', 'spongebobsucks', 's.tentpoles@krustykrab.com', '1998-02-12', 2, 'Western')


INSERT INTO FoodCritic (firstName, lastName, username, password, email, date_registered, currentPlatform) VALUES ('Chip', 'Skylark', 'sparkles', 'shinyteeth', 'singer@fairlyodd.com', '2013-01-11', 'Foodchat')
INSERT INTO FoodCritic (firstName, lastName, username, password, email, date_registered, currentPlatform) VALUES ('Anton', 'Ego', 'egoist', 'ratatouille', 'antonego@gmail.com', '2003-05-31', 'Foodstagram')
INSERT INTO FoodCritic (firstName, lastName, username, password, email, date_registered, currentPlatform) VALUES ('Remy', 'Bucksaplenty', 'money', 'dollars', 'moneyman@money.com', '2012-03-07', 'Foodadvisor')



INSERT INTO Review (recipe, author, dateCompleted, rating, description) VALUES ('Classic French Fries', 'egoist', '2007-12-03', 3, 'Gusteau''s mantra of anyone can cook is not true. Some people cannot cook.')
INSERT INTO Review (recipe, author, dateCompleted, rating, description) VALUES ('Japanese Potato Salad', 'egoist', '2007-12-05', 3, 'It''s tolerable but not the best')
INSERT INTO Review (recipe, author, dateCompleted, rating, description) VALUES ('Beef Tacos', 'egoist', '2007-12-07', 3, 'Too greasy but the marinade is good.')
INSERT INTO Review (recipe, author, dateCompleted, rating, description) VALUES ('Classic French Fries', 'sparkles', '2008-12-03', 5, 'It''s really good! Would recommend!')
INSERT INTO Review (recipe, author, dateCompleted, rating, description) VALUES ('Japanese Potato Salad', 'sparkles', '2008-12-05', 5, 'I''m turning Japanese, turning Japanese, and I think so...')
INSERT INTO Review (recipe, author, dateCompleted, rating, description) VALUES ('Beef Tacos', 'sparkles', '2008-12-07', 5, 'Remember me, when I go down you stomach. Remember me. Very good!')
INSERT INTO Review (recipe, author, dateCompleted, rating, description) VALUES ('Classic French Fries', 'money', '2008-12-03', 1, 'Not worth the bucks.')
INSERT INTO Review (recipe, author, dateCompleted, rating, description) VALUES ('Japanese Potato Salad', 'money', '2008-12-05', 4, 'Worth the bucks.')
INSERT INTO Review (recipe, author, dateCompleted, rating, description) VALUES ('Beef Tacos', 'money', '2008-12-07', 5, 'Spend it all here!')

-- INSERT INTO Users (firstName, lastName, username, password, email, date_registered, following) VALUES
-- ('');
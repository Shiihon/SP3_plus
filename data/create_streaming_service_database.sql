CREATE DATABASE IF NOT EXISTS `streaming_service` DEFAULT CHARACTER SET utf8mb4;
USE streaming_service;
SET FOREIGN_KEY_CHECKS=0; 
DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS series;
DROP TABLE IF EXISTS users;
SET FOREIGN_KEY_CHECKS=1;


CREATE TABLE `streaming_service`.`movies` (
  `movieID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(96) NOT NULL,
  `year` INT NOT NULL,
  `genre` VARCHAR(256) NOT NULL,
  `rating` FLOAT NOT NULL,
  PRIMARY KEY (`movieID`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);


CREATE TABLE `streaming_service`.`series` (
  `seriesID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(96) NOT NULL,
  `startYear` INT NOT NULL,
  `endYear` INT NULL,
  `genre` VARCHAR(256) NOT NULL,
  `rating` FLOAT NULL,
  `seasons` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`seriesID`));


CREATE TABLE `streaming_service`.`users` (
  `userID` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(32) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`userID`));




INSERT INTO movies (name, year, genre, rating) VALUES ("The Godfather", 1972, "Crime, Drama", 9.2);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Shawshank Redemption", 1994, "Drama", 9.3);
INSERT INTO movies (name, year, genre, rating) VALUES ("Schindler's List", 1993, "Biography, Drama, History", 8.9);
INSERT INTO movies (name, year, genre, rating) VALUES ("Raging Bull", 1980, "Biography, Drama, Sport", 8.2);
INSERT INTO movies (name, year, genre, rating) VALUES ("Casablanca", 1942, "Drama, Romance, War", 8.5);
INSERT INTO movies (name, year, genre, rating) VALUES ("Citizen Kane", 1941, "Drama, Mystery", 8.4);
INSERT INTO movies (name, year, genre, rating) VALUES ("Gone With The Wind", 1939, "Drama, History, Romance", 8.2);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Wizard Of Oz", 1939, "Adventure, Family, Fantasy", 8.0);
INSERT INTO movies (name, year, genre, rating) VALUES ("One Flew Over The Cuckoo's Nest", 1975, "Drama", 8.7);
INSERT INTO movies (name, year, genre, rating) VALUES ("Lawrence Of Arabia", 1962, "Adventure, Biography, Drama", 8.3);
INSERT INTO movies (name, year, genre, rating) VALUES ("Vertigo", 1958, "Mystery, Romance, Thriller", 8.3);
INSERT INTO movies (name, year, genre, rating) VALUES ("Psycho", 1960, "Horror, Mystery, Thriller", 8.5);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Godfather part II", 1974, "Crime, Drama", 9);
INSERT INTO movies (name, year, genre, rating) VALUES ("On The Waterfront", 1954, "Crime, Drama, Thriller", 8.2);
INSERT INTO movies (name, year, genre, rating) VALUES ("Sunset Boulevard", 1950, "Drama, Film-Noir", 8.4);
INSERT INTO movies (name, year, genre, rating) VALUES ("Forrest Gump", 1994, "Drama, Romance", 8.8);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Sound Of Music", 1965, "Biography, Drama, Family, Musical", 8.0);
INSERT INTO movies (name, year, genre, rating) VALUES ("12 Angry Men", 1957, "Crime, Drama", 8.9);
INSERT INTO movies (name, year, genre, rating) VALUES ("West Side Story", 1961, "Crime, Drama", 7.6);
INSERT INTO movies (name, year, genre, rating) VALUES ("Star Wars", 1977, "Action, Adventure, Family", 8.6);
INSERT INTO movies (name, year, genre, rating) VALUES ("2001 A Space Odyssey", 1968, "Adventure, Sci-fi", 8.3);
INSERT INTO movies (name, year, genre, rating) VALUES ("ET", 1982, "Family, Sci-fi", 7.9);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Silence Of The Lambs", 1991, "Crime, Drama, Thriller", 8.6);
INSERT INTO movies (name, year, genre, rating) VALUES ("Chinatown", 1974, "Drama, Mystery, Thriller", 8.2);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Bridge Over The River Kwai", 1957, "Adventure, Drama, War", 8.2);
INSERT INTO movies (name, year, genre, rating) VALUES ("Singin' In The Rain", 1952, "Comedy, Musical, Romance", 8.3);
INSERT INTO movies (name, year, genre, rating) VALUES ("It's A Wonderful Life", 1946, "Drama, Family, Fantasy", 8.6);
INSERT INTO movies (name, year, genre, rating) VALUES ("Dr. Strangelove Or How I Learned To Stop Worrying And Love The Bomb", 1964, "Comedy, War", 8.4);
INSERT INTO movies (name, year, genre, rating) VALUES ("Some Like It Hot", 1959, "Comedy, Romance", 8.2);
INSERT INTO movies (name, year, genre, rating) VALUES ("Ben Hur", 1959, "Adventure, Drama, History", 8.1);
INSERT INTO movies (name, year, genre, rating) VALUES ("Apocalypse Now", 1979, "Drama, War", 8.5);
INSERT INTO movies (name, year, genre, rating) VALUES ("Amadeus", 1984, "Biography, Drama, History", 8.3);
INSERT INTO movies (name, year, genre, rating) VALUES ("Lord Of The Rings - The Return Of The King", 2003, "Action, Adventure, Drama", 8.9);
INSERT INTO movies (name, year, genre, rating) VALUES ("Gladiator", 2000, "Action, Adventure, Drama", 8.5);
INSERT INTO movies (name, year, genre, rating) VALUES ("Titanic", 1997, "Drama, Romance", 7.8);
INSERT INTO movies (name, year, genre, rating) VALUES ("From Here To Eternity", 1953, "Drama, Romance, War", 7.7);
INSERT INTO movies (name, year, genre, rating) VALUES ("Saving Private Ryan", 1998, "Drama, War", 8.6);
INSERT INTO movies (name, year, genre, rating) VALUES ("Unforgiven", 1992, "Drama, Western", 8.2);
INSERT INTO movies (name, year, genre, rating) VALUES ("Raiders Of The Lost Ark", 1981, "Action, Adventure", 8.5);
INSERT INTO movies (name, year, genre, rating) VALUES ("Rocky", 1976, "Drama, Sport", 8.1);
INSERT INTO movies (name, year, genre, rating) VALUES ("A Streetcar Named Desire", 1951, "Drama", 8.0);
INSERT INTO movies (name, year, genre, rating) VALUES ("A Philadelphia Story", 1940, "Comedy, Romance", 8.0);
INSERT INTO movies (name, year, genre, rating) VALUES ("To Kill A Mockingbird", 1962, "Crime, Drama", 8.3);
INSERT INTO movies (name, year, genre, rating) VALUES ("An American In Paris", 1951, "Drama, Musical, Romance", 7.2);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Best Years Of Our Lives", 1946, "Drama, Romance, War", 8.1);
INSERT INTO movies (name, year, genre, rating) VALUES ("My Fair Lady", 1964, "Drama, Family, Musical", 7.9);
INSERT INTO movies (name, year, genre, rating) VALUES ("A Clockwork Orange", 1971, "Crime, Drama, Sci-fi", 8.3);
INSERT INTO movies (name, year, genre, rating) VALUES ("Doctor Zhivago", 1965, "Drama, Romance, War", 8.0);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Searchers", 1956, "Adventure, Drama, Western", 8.0);
INSERT INTO movies (name, year, genre, rating) VALUES ("Jaws", 1975, "Adventure, Drama, Thriller", 8.0);
INSERT INTO movies (name, year, genre, rating) VALUES ("Patton", 1970, "Biography, Drama, War", 8.0);
INSERT INTO movies (name, year, genre, rating) VALUES ("Butch Cassidy And The Sundance Kid", 1969, "Biography, Crime, Drama", 8.1);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Treasure Of The Sierra Madre", 1948, "Adventure, Drama, Western", 8.3);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Good, The Bad And The Ugly", 1966, "Western", 8.9);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Apartment", 1960, "Comedy, Drama, Romance", 8.3);
INSERT INTO movies (name, year, genre, rating) VALUES ("Platoon", 1986, "Drama, War", 8.1);
INSERT INTO movies (name, year, genre, rating) VALUES ("High Noon", 1952, "Action, Drama, Thriller", 8.0);
INSERT INTO movies (name, year, genre, rating) VALUES ("Braveheart", 1995, "Biography, Drama, History", 8.4);
INSERT INTO movies (name, year, genre, rating) VALUES ("Dances With Wolves", 1990, "Adventure, Drama, Western", 8.0);
INSERT INTO movies (name, year, genre, rating) VALUES ("Jurassic Park", 1993, "Adventure, Sci-fi, Thriller", 8.1);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Exorcist", 1973, "Horror", 8.0);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Pianist", 2002, "Biography, Drama, Music", 8.5);
INSERT INTO movies (name, year, genre, rating) VALUES ("Goodfellas", 1990, "Crime, Drama", 8.7);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Deer Hunter", 1978, "Drama, War", 8.1);
INSERT INTO movies (name, year, genre, rating) VALUES ("All Quiet On The Western Front", 1930, "Drama, War", 8.1);
INSERT INTO movies (name, year, genre, rating) VALUES ("Bonny And Clyde", 1967, "Action, Biography, Crime", 7.9);
INSERT INTO movies (name, year, genre, rating) VALUES ("The French Connection", 1971, "Action, Crime, Drama", 7.8);
INSERT INTO movies (name, year, genre, rating) VALUES ("City Lights", 1931, "Comedy, Drama, Romance", 8.5);
INSERT INTO movies (name, year, genre, rating) VALUES ("It Happened One Night", 1934, "Comedy, Romance", 8.1);
INSERT INTO movies (name, year, genre, rating) VALUES ("A Place In The Sun", 1951, "Drama, Romance", 7.8);
INSERT INTO movies (name, year, genre, rating) VALUES ("Midnight Cowboy", 1969, "Drama", 7.9);
INSERT INTO movies (name, year, genre, rating) VALUES ("Mr Smith Goes To Washington", 1939, "Comedy, Drama", 8.2);
INSERT INTO movies (name, year, genre, rating) VALUES ("Rain Man", 1988, "Drama", 8.0);
INSERT INTO movies (name, year, genre, rating) VALUES ("Annie Hall", 1977, "Comedy, Romance", 8.0);
INSERT INTO movies (name, year, genre, rating) VALUES ("Fargo", 1996, "Crime, Drama, Thriller", 8.1);
INSERT INTO movies (name, year, genre, rating) VALUES ("Giant", 1956, "Drama, Western", 7.7);
INSERT INTO movies (name, year, genre, rating) VALUES ("Shane", 1953, "Drama, Western", 7.7);
INSERT INTO movies (name, year, genre, rating) VALUES ("Grapes Of Wrath", 1940, "Drama, History", 8.1);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Green Mile", 1999, "Crime, Drama, Fantasy", 8.5);
INSERT INTO movies (name, year, genre, rating) VALUES ("Close Encounters", 1977, "Drama, Sci-fi", 7.7);
INSERT INTO movies (name, year, genre, rating) VALUES ("Nashville", 1975, "Comedy, Drama, Music", 7.8);
INSERT INTO movies (name, year, genre, rating) VALUES ("Network", 1976, "Drama", 8.1);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Graduate", 1967, "Comedy, Drama, Romance", 8.0);
INSERT INTO movies (name, year, genre, rating) VALUES ("American Graffiti", 1973, "Comedy, Drama", 7.5);
INSERT INTO movies (name, year, genre, rating) VALUES ("Pulp Fiction", 1994, "Crime, Drama", 8.9);
INSERT INTO movies (name, year, genre, rating) VALUES ("Terms of Endearment", 1983, "Comedy, Drama", 7.4);
INSERT INTO movies (name, year, genre, rating) VALUES ("Good Will Hunting", 1997, "Drama, Romance", 8.3);
INSERT INTO movies (name, year, genre, rating) VALUES ("The African Queen", 1951, "Adventure, Drama, Romance", 7.9);
INSERT INTO movies (name, year, genre, rating) VALUES ("Stagecoach", 1939, "Adventure, Western", 7.9);
INSERT INTO movies (name, year, genre, rating) VALUES ("Mutiny On The Bounty", 1935, "Adventure, Biography, Drama", 7.8);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Great Dictator", 1940, "Comedy, Drama, War", 8.5);
INSERT INTO movies (name, year, genre, rating) VALUES ("Double Indemnity", 1944, "Crime, Drama, Film-Noir", 8.3);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Maltese Falcon", 1941, "Film-Noir, Mystery", 8.1);
INSERT INTO movies (name, year, genre, rating) VALUES ("Wuthering Heights", 1939, "Drama, Romance", 7.7);
INSERT INTO movies (name, year, genre, rating) VALUES ("Taxi Driver", 1976, "Crime, Drama", 8.3);
INSERT INTO movies (name, year, genre, rating) VALUES ("Rear Window", 1954, "Mystery, Thriller", 8.5);
INSERT INTO movies (name, year, genre, rating) VALUES ("The Third Man", 1949, "Film-Noir, Mystery, Thriller", 8.2);
INSERT INTO movies (name, year, genre, rating) VALUES ("Rebel Without A Cause", 1955, "Drama", 7.8);
INSERT INTO movies (name, year, genre, rating) VALUES ("North By Northwest", 1959, "Adventure, Mystery, Thriller", 8.3);
INSERT INTO movies (name, year, genre, rating) VALUES ("Yankee Doodle Dandy", 1942, "Biography, Drama, Musical", 7.7);




INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Twin Peaks", 1990, 1991, "Crime, Drama, Mystery", 8.8, "1-8, 2-22");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Sopranos", 1999, 2007, "Crime, Drama", 9.2, "1-13, 2-13, 3-13, 4-13, 5-13, 6-21");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Game Of Thrones", 2011, null, "Action, Adventure, Drama", 9.5, "1-10, 2-10, 3-10, 4-10, 5-10, 6-10, 7-7");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Breaking Bad", 2008, 2013, "Crime, Drama, Thriller", 9.5, "1-7, 2-13, 3-13, 4-13, 5-16");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Larry Sanders Show", 1992, 1998, "Comedy", 8.3, "1-13, 2-18, 3-17, 4-17, 5-13, 6-12");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Curb Your Enthusiasm", 2000, null, "Comedy", 8.7, "1-10, 2-10, 3-10, 4-10, 5-10, 6-10, 7-10, 8-10, 9-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Lost", 2004, 2010, "Adventure, Drama, Fantasy", 8.4, "1-25, 2-24, 3-23, 4-14, 5-17, 6-18");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Louie", 2010, 2015, "Comedy, Drama", 8.6, "1-13, 2-13, 3-13, 4-14, 5-8");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Cheers", 1982, 1993, "Comedy, Drama", 7.8, "1-22, 2-22, 3-25, 4-26, 5-26, 6-25, 7-22, 8-26, 9-27, 10-26, 11-28");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Scener ur ett ?ktenskap", 1973, null, "Drama", 8.5, "1-6");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Buffy The Vampire Slayer", 1996, 2003, "Action, Drama, Fantasy", 8.2, "1-12, 2-22, 3-22, 4-22, 5-22, 6-22, 7-22");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Shield", 2002, 2008, "Crime, Drama, Thriller", 8.7, "1-13, 2-13, 3-15, 4-13, 5-11, 6-10, 7-13");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Deadwood", 2004, 2006, "Crime, Drama, History", 8.7, "1-12, 2-12, 3-12");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Marvelous Mrs Maisel", 2017, null, "Comedy, Drama", 8.7, "1-8");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Horace and Pete's", 2016, null, "Comedy, Drama", 8.6, "1-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Top Of The Lake", 2013, null, "Crime, Drama, Mystery", 7.5, "1-7, 2-6");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Simpsons", 1989, null, "Animation, Comedy", 8.7, "1-13, 2-22, 3-24, 4-22, 5-22, 6-25, 7-25, 8-25, 9-25, 10-23, 11-22, 12-21, 13-22, 14-22, 15-22, 16-21, 17-22, 18-22, 19-20, 20-21, 21-23, 22-22, 23-22, 24-22, 25-22, 26-22, 27-22, 28-22, 29-21");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Walking Dead", 2010, null, "Drama, Horror, Sci-fi", 8.4, "1-6, 2-13, 3-16, 4-16, 5-16, 6-16, 7-16, 8-16, 9-16");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Wire", 2001, 2008, "Crime, Drama, Thriller", 9.3, "1-13, 2-12, 3-12, 4-13, 5-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Welt Am Draht", 1973, null, "Crime, Mystery, Sci-fi", 7.9, "1-2");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("House Of Cards", 2013, 2018, "Drama", 8.9, "1-13, 2-13, 3-13, 4-13, 5-13, 6-8");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Fargo", 2014, null, "Crime, Drama, Thriller", 9.0, "1-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Angel", 1999, 2004, "Action, Drama, Fantasy", 8.0, "1-22, 2-22, 3-22, 4-22, 5-22");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("V", 1984, 1985, "Action, Adventure, Sci-fi", 7.3, "1-13");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Jessica Jones", 2015, null, "Action, Crime, Drama", 8.1, "1-13, 2-13");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Daredevil", 2015, null, "Action, Crime, Drama", 8.7, "1-13, 2-13, 3-13");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Seinfeld", 1989, 1998, "Comedy", 8.9, "1-5, 2-12, 3-23, 4-24, 5-22, 6-24, 7-24, 8-22, 9-24");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Slings And Arrows", 2003, 2006, "Comedy", 8.5, "1-6, 2-6, 3-6");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("I Claudius", 1976, null, "Biography, Drama, History", 8.9, "1-12");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Rome", 2005, 2007, "Action, Drama, History", 8.8, "1-12, 2-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Ray Donovan", 2013, null, "Crime, Drama", 8.3, "1-12, 2-12, 3-12, 4-12, 5-12, 6-12");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Better Call Saul", 2015, null, "Crime, Drama", 8.7, "1-10, 2-10, 3-10, 4-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Honeymooners", 1955, 1956, "Comedy, Family", 8.7, "1-39");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Spaced", 1999, 2001, "Action, Comedy", 8.6, "1-7, 2-7");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Twilight Zone", 1959, 1964, "Fantasy, Horror, Mystery", 9.0, "1-36, 2-29, 3-37, 4-18, 5-36");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Fraiser", 1993, 2004, "Comedy", 8.1, "1-24, 2-24, 3-24, 4-24, 5-24, 6-24, 7-24, 8-24, 9-24, 10-24, 11-24");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Alfred Hitchcock Presents", 1955, 1962, "Crime, Drama, Mystery", 8.6, "1-39, 2-39, 3-39, 4-36, 5-38, 6-38, 7-38");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("I Love Lucy", 1951, 1957, "Comedy, Family", 8.3, "1-35, 2-31, 3-31, 4-30, 5-26, 6-27");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("24", 2001, 2010, "Action, Crime, Drama", 8.4, "1-24, 2-24, 3-24, 4-24, 5-24, 6-24,7-24, 8-24");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Americans", 2013, 2018, "Crime, Drama, Mystery", 8.4, "1-13, 2-13, 3-13, 4-13, 5-13, 6-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Girls", 2012, 2017, "Comedy, Drama", 7.3, "1-10, 2-10, 3-12, 4-10, 5-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Mad Men", 2007, 2015, "Drama", 8.6, "1-13, 2-13, 3-13, 4-13, 5-13, 6-13, 7-14");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Northern Exposure", 1990, 1995, "Comedy, Drama, Fantasy", 8.3, "1-8, 2-7, 3-23, 4-25, 5-24, 6-23");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Star Trek", 1966, 1969, "Action, Adventure, Sci-fi", 8.3, "1-29, 2-26, 3-24");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Big Little Lies", 2017, null, "Crime, Drama, Mystery", 8.6, "1-7");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Firefly", 2002, 2003, "Adventure, Drama, Sci-fi", 9.0, "1-14");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Spartacus", 2010, 2013, "Action, Adventure, Biography", 8.5, "1-13, 2-10, 3-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Mr Show With Bob And David", 1995, 1998, "Comedy", 8.3, "1-4, 2-6, 3-10, 4-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Homeland", 2011, null, "Crime, Drama, Mystery", 8.3, "1-12, 2-12, 3-12, 4-12, 5-12, 6-12, 7-12");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Show Me A Hero", 2015, null, "Drama, History", 8.1, "1-6");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Crisis In Six Scenes", 2016, null, "Comedy", 6.6, "1-6");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Batman", 1966, 1968, "Action, Adventure, Comedy", 7.5, "1-34, 2-60, 3-26");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Luke Cage", 2016, 2018, "Action, Crime, Drama", 7.5, "1-13, 2-13");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("South Park", 1997, null, "Animation, Comedy", 8.7, "1-13, 2-18, 3-17, 4-17, 5-14, 6-17, 7-15, 8-14, 9-14, 10-14, 11-14, 12-14, 13-14, 14-14, 15-14, 16-14, 17-10, 18-10, 19-10, 20-10, 21-10, 22-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Band Of Brothers", 2001, null, "Action, Drama, History", 9.5, "1-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Married With Children", 1986, 1997, "Comedy", 8.1, "1-13, 2-22, 3-22, 4-23, 5-25, 6-26, 7-26, 8-26, 9-26, 10-26, 11-24");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Family Ties", 1982, 1989, "Comedy, Family", 7.2, "1-21, 2-22, 3-22, 4-22, 5-24, 6-24, 7-20");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Lonesome Dove", 1989, null, "Adventure, Drama, Western", 8.7, "1-4");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Pride And Prejudice", 1995, null, "Drama, Romance", 8.9, "1-6");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Flying Blind", 1992, 1993, "Comedy", 8.0, "1-22");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Battlestar Galactica", 2004, 2009, "Action, Adventure, Drama", 8.7, "1-13, 2-20, 3-20, 4-20");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Lucky Louie", 2006, 2007, "Comedy", 8.0, "1-13");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Dekalog", 1989, 1990, "Drama", 9.1, "1-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("It's Garry Shandling's Show", 1986, 1990, "Comedy", 7.6, "1-16, 2-17, 3-20, 4-19");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("On The Air", 1992, null, "Comedy", 7.4, "1-7");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("All In The Family", 1971, 1979, "Comedy, Drama", 7.4, "1-13, 2-24, 3-24, 4-24, 5-23, 6-24, 7-25, 8-24, 9-24");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Entourage", 2004, 2011, "Comedy, Drama", 8.5, "1-8, 2-14, 3-20, 4-12, 5-12, 6-12, 7-10, 8-8");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Ally McBeal", 1997, 2002, "Comedy, Drama, Fantasy", 6.8, "1-23, 2-23, 3-21, 4-23, 5-22");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Strain", 2014, 2017, "Drama, Horror, Thriller", 7.4, "1-13, 2-13, 3-10, 4-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Man In The High Castle", 2015, null, "Drama, Sci-fi, Thriller", 8.1, "1-10, 2-10, 3-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Sons Of Anarchy", 2008, 2014, "Crime, Drama, Thriller", 8.6, "1-13, 2-13, 3-13, 4-14, 5-13, 6-13, 7-13");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Punisher", 2017, null, "Action, Adventure, Crime", 8.6, "1-13");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Boardwalk Empire", 2010, 2014, "Crime, Drama, History", 8.6, "1-12, 2-12, 3-12, 4-12, 5-8");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Damages", 2007, 2012, "Crime, Drama, Mystery", 8.1, "1-13, 2-13, 3-13, 4-10, 5-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Banshee", 2013, 2016, "Action, Crime, Drama", 8.4, "1-10, 2-10, 3-10, 4-8");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Planet Earth", 2006, null, "Documentary", 9.4, "1-11");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Freaks And Geeks", 1999, 2000, "Comedy, Drama", 8.8, "1-18");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Way We Live Now", 2001, null, "Drama, Romance", 7.7, "1-4");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Justified", 2010, 2015, "Action, Crime, Drama", 8.6, "1-13, 2-13, 3-13, 4-13, 5-13, 6-13");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Arrested Development", 2003, null, "Comedy", 8.9, "1-22, 2-18, 3-13, 4-22, 5-16");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Stranger Things", 2016, null, "Drama, Fantasy, Horror", 8.9, "1-8, 2-9");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Night Court", 1984, 1992, "Comedy", 7.7, "1-13, 2-22, 3-22, 4-22, 5-22, 6-22, 7-24, 8-24, 9-22");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Revenge", 2011, 2015, "Drama, Mystery, Thriller", 7.9, "1-22, 2-22, 3-22, 4-23");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Da Ali G Show", 2003, 2004, "Comedy, Talk-show", 8.0, "1-6, 2-6, 3-6");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Sex & The City", 1998, 2004, "Comedy, Drama, Romance", 7.1, "1-12, 2-18, 3-18, 4-18, 5-8, 6-20");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Tyrant", 2014, 2016, "Action, Drama, Thriller", 7.8, "1-10, 2-12, 3-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Billions", 2016, null, "Drama", 8.4, "1-12, 2-12, 3-12");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Shameless", 2011, null, "Comedy, Drama", 8.7, "1-12, 2-12, 3-12, 4-12, 5-12, 6-12, 7-12, 8-12, 9-7");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Smallville", 2001, 2011, "Adventure, Drama, Romance", 7.5, "1-21, 2-23, 3-22, 4-22, 5-22, 6-22, 7-20, 8-22, 9-21, 10-22");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Defenders", 2017, null, "Action, Adventure, Crime", 7.5, "1-8");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("House", 2004, 2012, "Drama, Mystery", 8.8, "1-22, 2-24, 3-24, 4-16, 5-24, 6-21, 7-23, 8-22");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Fear The Walking Dead", 2015, null, "Drama, Horror, Sci-fi", 7.0, "1-6, 2-15, 3-16, 4-16");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("True Blood", 2008, 2014, "Drama, Fantasy, Mystery", 7.9, "1-12, 2-12, 3-12, 4-12, 5-12, 6-10, 7-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("GLOW", 2017, null, "Comedy, Drama, Sport", 8.2, "1-10, 2-10");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Doctor Thorne", 2016, null, "Drama", 7.3, "1-3");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("The Civil War", 1990, null, "Documentary, History, War", 9.1, "1-9");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Person Of Interest", 2011, 2016, "Action, Crime, Drama", 8.4, "1-23, 2-22, 3-23, 4-22, 5-13");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Californication", 2007, 2014, "Comedy, Drama", 8.3, "1-12, 2-12, 3-12, 4-12, 5-12, 6-12, 7-12");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Three's Company", 1976, 1984, "Comedy", 7.6, "1-6, 2-25, 3-22, 4-25, 5-22, 6-28, 7-22, 8-22");
INSERT INTO series (name, startYear, endYear, genre, rating, seasons) VALUES ("Dexter", 2006, 2013, "Crime, Drama, Mystery", 8.7, "1-12, 2-12, 3-12, 4-12, 5-12, 6-12, 7-12,8-12");




INSERT INTO users (userName, password) VALUES ("Nadia", "123Hest");
INSERT INTO users (userName, password) VALUES ("Sinan", "Farther");
INSERT INTO users (userName, password) VALUES ("Sander", "ØVV");
INSERT INTO users (userName, password) VALUES ("Victor", "Water");

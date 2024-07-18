Objective: 

Develop a menu-based console application to assess your proficiency in Core Java, MySQL, and JDBC. The application will simulate a sports tournament management system, allowing users to manage teams, players, and matches.


Functionalities:

1.	Team Management:
  o	Add a new team
  o	View team details
  o	Update team information
  o	Delete a team

2.	Player Management:
  o	Add a new player
  o	View player details
  o	Update player information
  o	Delete a player

3.	Match Management:
  o	Schedule a new match
  o	View match details
  o	Update match information
  o	Record match results


Database Schema:

•	Team Table:
  o	team_id (Primary Key)
  o	name
  o	coach
  o	captain
  o	total_players

•	Player Table:
  o	player_id (Primary Key)
  o	name
  o	age
  o	team_id (Foreign Key references Team Table)
  o	position

•	Match Table:
  o	match_id (Primary Key)
  o	team1_id (Foreign Key references Team Table)
  o	team2_id (Foreign Key references Team Table)
  o	match_date
  o	venue
  o	result


Requirements:

  •	Develop a menu-based console application using Core Java.
  •	Use JDBC for interactions with the MySQL database.
  •	Implement menu options for managing teams, players, and matches.
  •	Ensure that the application updates the total_players in the Team table appropriately after a player is added or deleted.
  •	Record match results and update the result field in the Match table.
  •	Handle exceptions effectively and provide user-friendly error messages.
  •	Ensure the application code is clean, well-documented, and follows standard coding conventions.

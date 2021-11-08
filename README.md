# Lab 5

## Task
1. The task is performed on the basis of the designed database model in laboratory works No. 1 and the developed script in No. 3.  
2. The database must be deployed using SQL-script.  
3. The Java client is created in the form of Maven project with MySQL connection.  
4. The structure of the project is created on the basis of MVC-pattern. Where  the model must contain both a Database Access Layer and a Business Logic Layer. The implementation of the Database Access layer is based on the DAO pattern using Hibernate.  
5. User Interface Layer is implemented in the form of a console menu. Thus, the Program should provide work with data in a DB by means of JDBC:  
    - output of data from tables;  
    - insert data into the table;  
    - delete data from the table;  
    - update data in tables.  
6. Connect the following plugins to Maven: 
    - Find FindBugs plugin that performs automatic checking code quality and search for potential errors in the code
    - PMD plugin  
    - Checkstyle plugin - checks compliance with the code convention  
8. The implemented project should be uploaded to GitHub.  

When finished, run the mvn site command and view the results in the target / site folder.  
The code should fix any errors detected by the FindBugs, PMD, and Checkstyle plug-ins (except for errors related to the lack of comments).  

## Database description (from lab1)
iTunes. Create a scheme of relational database, that will permit saving the info about songs, genres, price, download count, authors, albums, music labels, user profiles and songs downloaded by the users.

## Architecture
The Application is divided into 3 layers:
 - Data Access Layer
 - Business Layer
 - User Interface Layer

Data Access Layer classes are located in the `com.maxrt.db` package. They use jdbc with mysql connector to retrieve data from `itunes` database.  
Business Layer is implemented within the `com.maxrt.data.controller`. It handles interfacing with DAOs & some user interaction. 
User Interface Layer is defined in the `com.maxrt.console` package. It uses `CommandProcessor` to get user input & call one of the predefined commands, such as `help` or `get`. Commands themselves are defined extending `Command` class.  

The App can be easily extended with new tables - just create corresponding model & dao classes. Examples can be found in `com.maxrt.db.model` & `command.maxrt.db.dao` packages.  
Migration to new DB is relatively easy too - you'll just need to write new model & dao classes for new DB.  

## How To Run
 - Clone the repo
 - `cd db_labs && git checkout lab5`
 - `mvn compile packge`
 - `java -cp target/lab5-VERSION-jar-with-dependencies.jar com.maxrt.App`
 
Note: replace `VERSION` in jar file name with the project version

## Usage
Upon running the `.jar` file, you'll be presented with a command prompt.  
You can get list of available commands by typing `help`, or get help for particular command by typing `help COMMAND_NAME`.  
Commands list:
 - `exit` - Exits the shell. Usage: `exit`
 - `help` - Gets help. Usage: `help [COMMAND]`
 - `list` - Lists all tables. Usage: `list`
 - `get` - Gets data from the table. Usage: `get TABLE [ID]`
 - `update` - Updates the record. Usage: `update TABLE ID `
 - `new` - Creates new record. Usage: `new TABLE`
 - `delete` - Deletes the record. Usage: `delete TABLE ID`

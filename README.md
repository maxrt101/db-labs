# Lab 7

## Task
According to the variant of the task (see the table) to implement the database without foreign keys, to fill the tables with data, to create the specified stored software constructions (stored procedures, user functions, triggers) and to check their functionality and correctness of their work. MS SQL Server or MySQL (student choice).

## Variant 20
Database of employees of the KSA department.
### STORED PROCEDURES
1. Ensure parameterized insertion of new values in the table Disciplines.
2. Output the data from the M: M link table between the Employees and Disciplines tables, replacing the numeric values with real names. As an additional option to provide the ability to filter data for the names of the table Employees, ie we can display either all or something specific.
3. Using the cursor, to ensure the dynamic creation of 2 tables with names containing the time stamp, the structure of the tables is identical to the structure of the table Disciplines. Then randomly copy the tapes of the Discipline table to one or another additional table. Restarting the procedure again creates new similar tables, in which data from the Discipline table will be randomly scattered again.
### CUSTOM FUNCTIONS
1. For the Disciplines table write the function as the AVG column will search for the semester number. Then make the data sample (SELECT) less than the average value using this function.
2. Write a function that extracts by key between the tables Academic title and Employees the value of the field Title Academic title. Then sample all data (SELECT) from the Employees table using this function.
### TRIGGERS
1. Ensure the integrity of values for the database structure.
2. Value Employees -> Work experience cannot be greater than the difference between the current date and date of birth + 15 years;

## Scripts overview
`clear.sql` - Truncates all of the tables in DB
`create.sql` - Creates empty tables
`triggers.sql` - Creates triggers to emulate `FOREIGN KEY` & `UNIQUE`
`populate.sql` - Populates the tables with dummy values
`procedures.sql` - Contains the definitions of the procedures from the task
`functions.sql` - Contains the definitions of the functions from the task

## How to run
 - Clone the repo
 - `cd db_labs && git checkout lab7`
 - Run scripts under sql/ through any way that suits you (mysql prompt, mysql workbench etc)


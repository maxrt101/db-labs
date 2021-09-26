# Lab 2 (Variant 20)
## Task:
1. DB "Firm received. recyclables ". Display information about the issuance of money at the point of reception No. 2 of the Outcome table. Sort the output in ascending order by the out column.
2. DB "Ships". Find all: ships whose class names end with the letter 'o'.
3. DB "Comp. firm". Find laptop manufacturers with a processor no higher than 500 MHz. Output: maker.
4. DB "Comp. firm". Find manufacturers that produce both PCs and laptops (use the ANY keyword). Print maker.
5. DB "Comp. firm". Find PC makers that produce laptops at 500 MHz and below. Print: maker.
6. DB "Ships". From the Battles table, print the dates in the following format: year.number_month.day, for example, 2001.02.21 (without time format).
7. DB "Ships". Specify battles in which at least two ships of the same country took part (Select a country through the Ships table, and do not take into account ship names for the Outcomes table that are not in the Ships table). Display: the name of the battle, country, number of ships.
8. DB "Ships". Enter the name, country and number of guns of ships that were damaged in battle. Display: ship, country, numGuns. (Hint: use subqueries as computational columns)
9. DB "Comp. firm". For the Product table, get the final set in the form of a table with maker, printer columns, in which for each manufacturer it is necessary to indicate whether it produces ('yes') or not ('no') the appropriate type of product. In the first case ('yes'), additionally indicate in parentheses the total number of available (ie in the Printer table) products, for example, 'yes (2)'. (Hint: use subqueries as compute columns and CASE statement)
10. DB "Comp. firm". Find the average price of PCs and laptops manufactured by the manufacturer 'A'. Output: one total average price. (Hint: use the UNION operator)

## How to run:
 - Clone the repo
 - `cd db_labs && git checkout lab2`
 - Run scripts under `sql/` through any way that suits you (mysql prompt, mysql workbench etc)


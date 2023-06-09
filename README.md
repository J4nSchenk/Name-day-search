# Name-day-search
Name day search application using Spring boot and PostgreSQL database


------------------HOW TO USE----------------------------

To search for name statistics use a GET request on http://localhost:8080/allnames
  Gives you a JSON file containing the Name and SearchCount of all names

To search for specirfic name use a GET request on http://localhost:8080/name/{name}
  Gives you a JSON file containing the Id, Name, NameDay and SearchCount of the name you searched

To add a name use a POST request on http://localhost:8080/nameday with JSON containing the nameday and the name, example: {"date": "24-06","name": "Jan"} 
  Creates a name in the database with unique id and searchcount 0

To delete a name from the database use a DELETE request on http://localhost:8080/delete/{name you want to delete}
  Deletes with a confirmation "Names deleted:{name}"


Current searchable names:
  "Jan"
  "Tomáš"
  "Ondra"
  "Lukáš"
  
 

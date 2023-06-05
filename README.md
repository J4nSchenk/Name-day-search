# Name-day-search
Name day search application using Spring boot


------------------HOW TO USE----------------------------

To search for name statistics use a GET request on http://localhost:8080/allnames
  Gives you a JSON file containing the Name and SearchCount of all names

To search for specirfic name use a GET request on http://localhost:8080/name/{spcific_name}
  Gives you a JSON file containing the Id, Name, NameDay and SearchCount of the name you searched

Current searchable names:
  "Jan"
  "Tomáš"
  "Ondra"
  "Lukáš"
  
 

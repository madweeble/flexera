# Technical Test

## Flexera Engineering Candidate Technical Test

#### Test Instructions

> Create a web API that allows you to add, update and remove people from a data store.

### Instructions

As I was informed that the front end element was not required, I worked only on the backend process.
I did however add a simple html file (index.html) to list all records (GET), and to delete a record.  Due
 to time constraints, I have not implemented the functionality to add a new record (POST).  To access the
  results, throughout, I have used simple *curl* commands:

* `curl -X GET localhost:8080/app/people`
* `curl -X GET localhost:8080/app/people?sortBy=name`
* `curl -X GET localhost:8080/app/people?sortBy=email`
* `curl -X GET localhost:8080/app/people/<name>`
* `curl -X POST localhost:8080/app/people/add -d '{"name":"<name>","age":"<age>","balance":
"<balance>","email":"<email>","address":"<address>"}' -H "Content-Type: application/json"`
* `curl -X DELETE localhost:8080/app/people/delete/<name>`

#### Endpoints:
* /app/people
* /app/people?sortBy=name|email
* /app/people/{name}
* /app/people/add
* /app/people/delete/{name}

For example,
> `curl -X GET http://localhost:8080/app/people`

will return a list of all people in the database.  Whereas,

> `curl -X GET http://localhost:8080/app/people/steve%20rogers`

will return a list of people with the name "Steve Rogers" only.

The **.../create** method will take a JSON formatted string and add that person to the database.
Duplicate *names* are allowed, provided at least one other field is unique.  If a record matching *all*
fields already exists, a duplicate will not be added.

The **.../delete/{name}** method takes a single name and deletes that person from the database.

### REST API

I have written the REST API in Java using SpringBoot.  I have added some enhancements, but there is room
 for the project to grow.  At present I have only added the capability for a single person to be added at
  a time.  However, given more time, this could be modified to parse multiple people.

### Data Store

Initially I developed and tested the project using the in-memory **h2** database.  Using the Spring
 framework, this can be easily switched to a production database.  Once most of the work was complete, I
  created a MySQL database locally and added the properties to the application.properties file to finish
  testing.  To switch between data sources, comment out the jdbc properties for h2, or comment in (and 
  modify as needed) to use MySQL or another database.
